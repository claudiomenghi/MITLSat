FROM ubuntu:16.04

ENV DEBIAN_FRONTEND=noninteractive

ENTRYPOINT ["entrypoint.sh"]
# install git
RUN apt-get update  && apt-get install -y dialog apt-utils && apt-get install -y software-properties-common python-software-properties && apt-get install -y gradle && apt-get install -y time && apt-get install -y sbcl
RUN apt-get install -y git && apt-get -y install z3  && apt-get -y install vim


#RUN add-apt-repository ppa:webupd8team/java
#RUN add-apt-repository ppa:linuxuprising/java
#`RUN apt-get update 
#RUN echo "oracle-java11-installer shared/accepted-oracle-license-v1-1 select true" |  debconf-set-selections
#RUN apt-get update && apt-get install -y oracle-java11-installer 
#RUN apt install oracle-java11-set-default
RUN  apt install -y default-jdk   

WORKDIR usr/local/
RUN git clone https://github.com/fm-polimi/zot.git
WORKDIR ./zot
RUN git fetch --all
RUN git checkout cltloc-reset
WORKDIR ../../../

RUN mkdir workspace
WORKDIR workspace/
RUN git clone https://github.com/claudiomenghi/MITLSat.git


WORKDIR MITLSat/checker/
#RUN git fetch
#RUN git checkout cltloc-reset
RUN gradle fatJar
WORKDIR ../../


RUN  mv /workspace/MITLSat/checker/build/libs/checker-all.jar /workspace/tack.jar

ADD fischer fischer
ADD solver.txt solver.txt
ADD scalabilityScripts/runTack.sh  runTack.sh
ADD scalabilityScripts/scalability.sh  scalability.sh
ADD run_zot.sh run_zot.sh
COPY entrypoint.sh /usr/local/bin/
