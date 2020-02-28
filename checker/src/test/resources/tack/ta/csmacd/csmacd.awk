#!/usr/bin/awk -f 
## #############################################################
## Generates CSMA/CD n 
## Carrier Sense, Multiple-Access with Collision Detection 
## #############################################################
## writes files
##  csma_input_XX.ta
##  csma_input_XX.q
##  
##  where XX is a two-digit decimal for n
## #############################################################
## 
## #############################################################
## 
## 
## Synopsis:
##  Benchmarks for Uppaal
## #############################################################
## @FILE:    genCSMA_CD.awk
## @PLACE:   BRICS AArhus; host:harald
## @FORMAT:  awk
## @AUTHOR:  M. Oliver M'o'ller     <omoeller@brics.dk>
## @BEGUN:   Wed Sep 19 11:45:25 2001
## @VERSION: Wed Sep 19 13:33:21 2001
## #############################################################
## 


## ###################################################################
## [1] Disclaimer
## ###################################################################

function disclaimer(i, OUT){
    #ret=time[1];
    #ret=time["second"];
    #ret = strftime("%a %b %d %H:%M:%S %Z %Y");
    print "// ------------------------------------------------------------ "  > OUT;
    print "// CSMA/CD " i > OUT;
    print "// Carrier Sense, Multiple-Access with Collision Detection " > OUT;
    print "// " > OUT;
    print "// automatically generated by script genCSMA_CD.awk "  > OUT;
    print "// M. Oliver Moeller <omoeller@brics.dk> "  > OUT;
    print "// Wed Sep 19 11:48:20 2001 "  > OUT;
    print "// ------------------------------------------------------------ "  > OUT;
}


function constants(i, OUT){
#    print "const   SA      20; " > OUT; 
#    print "const   td      0; " > OUT; 
#    print "const   TRTT    " (20+i*50)";  " > OUT; 
#    print "" > OUT; 
}

function collision(i, OUT){
    ORS="" ;
    print "\nprocess P0 {\n" > OUT;
    print "clock x,z; \n" > OUT;
    print "state bus_idle, bus_active, \n" > OUT;
    term=", ";
    for(v = 1; v <= i; v++){
	if(v == i){ term = "; "; };
	print "bus_collision" v "{ x" > OUT;
	if (v == 1){
	    print " < 26 }"  term "\n" > OUT; }
	else {
	    print " <= 0 }"  term "\n" > OUT; }
    }
    print "init  bus_idle; \n" > OUT;
    print "trans \n" > OUT;
    print "bus_idle -> bus_active { sync begin?; assign x:= 0; }, \n" > OUT;
    print "bus_active -> bus_idle { sync end?; assign x:= 0; }, \n" > OUT;
    print "bus_active -> bus_active { guard x >= 26; sync busy!; }, \n" > OUT;
    print "bus_active -> bus_collision1 { guard x < 26; sync begin?; assign x:= 0,z:= 0; },\n" > OUT;
    print "bus_collision1 -> bus_collision2 { guard x < 26; sync cd1!; assign x:= 0; }, \n" > OUT;
    for(v = 2; v < i; v++){
		w = v+1;
		print "bus_collision" v " -> bus_collision" w " { sync cd" v "!; assign x:= 0; }, \n" > OUT;
		
    }
    print "bus_collision" i " -> bus_idle { guard z<1; sync cd" i"!; assign x:= 0; }; \n" > OUT;
    print "}\n\n" > OUT;
    ORS="\n";

}

function process(i, OUT){
    print "process P" i " { " > OUT;
    print "clock x,z; " > OUT;
    print "state sender_wait, sender_transm{ x<= 808}, sender_retry{x < 52}; " > OUT;
    print "init sender_wait; " > OUT;
    print "trans " > OUT;
    print "sender_wait -> sender_transm { sync begin!; assign x:= 0; }, " > OUT;
    print "sender_wait -> sender_wait { sync cd" i "?; assign x:= 0; }, " > OUT;
    print "sender_wait -> sender_retry { sync cd" i "?; assign x:= 0; }, " > OUT;
    print "sender_wait -> sender_retry { sync busy?; assign x:= 0; }, " > OUT;
    print "sender_transm -> sender_wait { guard x == 808; sync end !; assign x:= 0; },  " > OUT;
    print "sender_transm -> sender_retry { guard x < 52; sync cd"i " ?; assign x:= 0; }, " > OUT;
    print "sender_retry -> sender_transm { guard x < 52, z>1; sync begin!; assign x:= 0; }, " > OUT;
    print "sender_retry -> sender_retry { guard x < 52; sync cd" i "?; assign x:= 0; };  " > OUT;
    print "}\n\n\n" > OUT;
}

function systemdef(i, OUT){
    ORS="" ;
    print "system P0, " > OUT;
    for(v = 1; v <= i; v++){
	print "P" v  > OUT;
	if(v < i){ print ", "  > OUT; }
    }
    print ";\n"  > OUT;
    print "\n"  > OUT;
    ORS="\n";
}


function property(i, OUT){
    print "G_ee 0 1 (! (&& (P1_sender_transm)  (P2_sender_transm)))" > OUT;
} 

BEGIN {
  if(ARGC!=2) {
    print "wrong number of arguments" | "cat 1>&2";
    exit(1);
  }
 N = ARGV[1] + 0;

 print "** " N    ;
  if(N<=0) {
    print "*** non valid `N' (use option -vN=# )" | "cat 1>&2"
    exit 1
  }
#  printf "%02d\n", N;
## -- set output names ------------------------------------------
  if( N >= 10 ) { 
      OUTPUT_Q =("csma_input_" N ".q"); 
      OUTPUT_TA=("csma_input_" N ".ta"); }
  else {
      OUTPUT_Q =("csma_input_0" N ".q");
      OUTPUT_TA=("csma_input_0" N ".ta"); }
## -- generate .ta ---------------------------------------------------------
  disclaimer(N, OUTPUT_TA);
  constants(N, OUTPUT_TA);
  collision(N, OUTPUT_TA);
  for(v = 1; v <= N; v++){
      process(v, OUTPUT_TA);
  }
  systemdef(N,OUTPUT_TA);
## -- generate .q ----------------------------------------------------------
  property(N, OUTPUT_Q);
## -------------------------------------------------------------------------
  close(OUTPUT_TA);
  close(OUTPUT_Q);
}
