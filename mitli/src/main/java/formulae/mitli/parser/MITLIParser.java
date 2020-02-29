// Generated from MITLI.g4 by ANTLR 4.4

package formulae.mitli.parser;

import java.util.HashMap;
import formulae.*;
import formulae.mitli.*;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import formulae.mitli.atoms.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MITLIParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, OP=2, LPAR=3, RPAR=4, LBRA=5, RBRA=6, TRUE=7, FALSE=8, NEG_OP=9, 
		AND_OP=10, OR_OP=11, IMPL_OP=12, IFF_OP=13, F_OP=14, F_inf_OP=15, G_OP=16, 
		G_inf_OP=17, P_OP=18, H_OP=19, UNTIL_OP=20, SINCE_OP=21, RELEASE_OP=22, 
		TRIGGER_OP=23, COUNT_OP=24, LOGIC=25, COLON=26, SEMI=27, INT=28, REAL=29, 
		ID=30, NEWLINE=31, WS=32, COMMENT=33;
	public static final String[] tokenNames = {
		"<INVALID>", "':def'", "OP", "'('", "')'", "'['", "']'", "'true'", "'false'", 
		"'!'", "'&&'", "'||'", "'->'", "'<->'", "F_OP", "F_inf_OP", "G_OP", "G_inf_OP", 
		"P_OP", "H_OP", "'U'", "'S'", "'R'", "'T'", "'C'", "LOGIC", "':'", "';'", 
		"INT", "REAL", "ID", "NEWLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_mitli = 0, RULE_logic = 1, RULE_declaration = 2, RULE_fmla = 3, RULE_conjuncts_list = 4;
	public static final String[] ruleNames = {
		"mitli", "logic", "declaration", "fmla", "conjuncts_list"
	};

	@Override
	public String getGrammarFileName() { return "MITLI.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MITLIParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MitliContext extends ParserRuleContext {
		public MITLIFormula formula;
		public FmlaContext fmla;
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
		}
		public MitliContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mitli; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterMitli(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitMitli(this);
		}
	}

	public final MitliContext mitli() throws RecognitionException {
		MitliContext _localctx = new MitliContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mitli);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); ((MitliContext)_localctx).fmla = fmla();

						 	((MitliContext)_localctx).formula = ((MitliContext)_localctx).fmla.r;
						 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public String s;
		public Token LOGIC;
		public TerminalNode LOGIC() { return getToken(MITLIParser.LOGIC, 0); }
		public TerminalNode COLON() { return getToken(MITLIParser.COLON, 0); }
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitLogic(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_logic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); match(COLON);
			setState(14); ((LogicContext)_localctx).LOGIC = match(LOGIC);
			 ((LogicContext)_localctx).s =  new String((((LogicContext)_localctx).LOGIC!=null?((LogicContext)_localctx).LOGIC.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Token s;
		public TerminalNode ID() { return getToken(MITLIParser.ID, 0); }
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MITLIParser.NEWLINE, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(24);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(17); match(T__0);
				setState(18); ((DeclarationContext)_localctx).s = match(ID);
				setState(19); fmla();

							
							 
				setState(21); match(NEWLINE);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FmlaContext extends ParserRuleContext {
		public MITLIFormula r;
		public FmlaContext fmla;
		public Token ID;
		public Token OP;
		public Token INT;
		public Token REAL;
		public FmlaContext f1;
		public Conjuncts_listContext conjuncts_list;
		public FmlaContext f2;
		public Token F_OP;
		public Token a;
		public Token b;
		public Token F_inf_OP;
		public Token G_OP;
		public Token G_inf_OP;
		public Token P_OP;
		public Token H_OP;
		public TerminalNode REAL() { return getToken(MITLIParser.REAL, 0); }
		public Conjuncts_listContext conjuncts_list() {
			return getRuleContext(Conjuncts_listContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(MITLIParser.FALSE, 0); }
		public TerminalNode IMPL_OP() { return getToken(MITLIParser.IMPL_OP, 0); }
		public List<TerminalNode> INT() { return getTokens(MITLIParser.INT); }
		public TerminalNode UNTIL_OP() { return getToken(MITLIParser.UNTIL_OP, 0); }
		public FmlaContext fmla(int i) {
			return getRuleContext(FmlaContext.class,i);
		}
		public TerminalNode INT(int i) {
			return getToken(MITLIParser.INT, i);
		}
		public TerminalNode RPAR(int i) {
			return getToken(MITLIParser.RPAR, i);
		}
		public TerminalNode ID() { return getToken(MITLIParser.ID, 0); }
		public TerminalNode H_OP() { return getToken(MITLIParser.H_OP, 0); }
		public TerminalNode LPAR(int i) {
			return getToken(MITLIParser.LPAR, i);
		}
		public TerminalNode OR_OP() { return getToken(MITLIParser.OR_OP, 0); }
		public TerminalNode F_inf_OP() { return getToken(MITLIParser.F_inf_OP, 0); }
		public TerminalNode G_OP() { return getToken(MITLIParser.G_OP, 0); }
		public TerminalNode P_OP() { return getToken(MITLIParser.P_OP, 0); }
		public List<FmlaContext> fmla() {
			return getRuleContexts(FmlaContext.class);
		}
		public TerminalNode OP() { return getToken(MITLIParser.OP, 0); }
		public TerminalNode F_OP() { return getToken(MITLIParser.F_OP, 0); }
		public TerminalNode TRUE() { return getToken(MITLIParser.TRUE, 0); }
		public TerminalNode AND_OP() { return getToken(MITLIParser.AND_OP, 0); }
		public List<TerminalNode> LPAR() { return getTokens(MITLIParser.LPAR); }
		public TerminalNode IFF_OP() { return getToken(MITLIParser.IFF_OP, 0); }
		public TerminalNode SINCE_OP() { return getToken(MITLIParser.SINCE_OP, 0); }
		public TerminalNode RELEASE_OP() { return getToken(MITLIParser.RELEASE_OP, 0); }
		public TerminalNode G_inf_OP() { return getToken(MITLIParser.G_inf_OP, 0); }
		public TerminalNode NEG_OP() { return getToken(MITLIParser.NEG_OP, 0); }
		public List<TerminalNode> RPAR() { return getTokens(MITLIParser.RPAR); }
		public FmlaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fmla; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterFmla(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitFmla(this);
		}
	}

	public final FmlaContext fmla() throws RecognitionException {
		FmlaContext _localctx = new FmlaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fmla);
		try {
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26); match(LPAR);
				setState(27); ((FmlaContext)_localctx).fmla = fmla();

						((FmlaContext)_localctx).r = _localctx.r;
					
				setState(29); match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); match(TRUE);

							MITLIFormula f = new MITLITrue();
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33); match(FALSE);

							MITLIFormula f = new MITLINegation(new MITLITrue());
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35); ((FmlaContext)_localctx).ID = match(ID);
					
							
								MITLIFormula f = new MITLIPropositionalAtom((((FmlaContext)_localctx).ID!=null?((FmlaContext)_localctx).ID.getText():null));
								
								((FmlaContext)_localctx).r =  f;
							
						
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(37); ((FmlaContext)_localctx).ID = match(ID);
				setState(38); ((FmlaContext)_localctx).OP = match(OP);
				setState(39); ((FmlaContext)_localctx).INT = match(INT);

							MITLIFormula f = new MITLIRelationalAtom((((FmlaContext)_localctx).ID!=null?((FmlaContext)_localctx).ID.getText():null), (((FmlaContext)_localctx).OP!=null?((FmlaContext)_localctx).OP.getText():null), Integer.parseInt((((FmlaContext)_localctx).INT!=null?((FmlaContext)_localctx).INT.getText():null)));
								
								((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41); ((FmlaContext)_localctx).ID = match(ID);
				setState(42); ((FmlaContext)_localctx).OP = match(OP);
				setState(43); ((FmlaContext)_localctx).REAL = match(REAL);

							MITLIFormula f = new MITLIRelationalAtom((((FmlaContext)_localctx).ID!=null?((FmlaContext)_localctx).ID.getText():null), (((FmlaContext)_localctx).OP!=null?((FmlaContext)_localctx).OP.getText():null), Float.parseFloat((((FmlaContext)_localctx).REAL!=null?((FmlaContext)_localctx).REAL.getText():null)));
								
								((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(45); match(NEG_OP);
				setState(46); match(LPAR);
				setState(47); ((FmlaContext)_localctx).f1 = fmla();
				setState(48); match(RPAR);
					
							MITLIFormula f = MITLIFormula.not((MITLIFormula) ((FmlaContext)_localctx).f1.r);
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(51); match(AND_OP);
				setState(52); ((FmlaContext)_localctx).conjuncts_list = conjuncts_list();
					
							MITLIFormula f = null;
							MITLIFormula[] arr = null;
							
							
								arr = new MITLIFormula[((FmlaContext)_localctx).conjuncts_list.l.size()];

								int i = 0;
								for (MITLIFormula fm: ((FmlaContext)_localctx).conjuncts_list.l)
									arr[i++] = fm;
							
								f = MITLIFormula.and((MITLIFormula[]) arr);
							
									
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(55); match(OR_OP);
				setState(56); ((FmlaContext)_localctx).conjuncts_list = conjuncts_list();
					
							MITLIFormula f = null;
							MITLIFormula[] arr = null;
							
								arr = new MITLIFormula[((FmlaContext)_localctx).conjuncts_list.l.size()];

								int i = 0;
								for (MITLIFormula fm: ((FmlaContext)_localctx).conjuncts_list.l)
									arr[i++] = fm;
							
								f = MITLIFormula.or((MITLIFormula[]) arr);
							
								
							((FmlaContext)_localctx).r =  f;	
						
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(59); match(IMPL_OP);
				setState(60); match(LPAR);
				setState(61); ((FmlaContext)_localctx).f1 = fmla();
				setState(62); match(RPAR);
				setState(63); match(LPAR);
				setState(64); ((FmlaContext)_localctx).f2 = fmla();
				setState(65); match(RPAR);
					
							MITLIFormula f = MITLIFormula.implies((MITLIFormula) ((FmlaContext)_localctx).f1.r, (MITLIFormula)((FmlaContext)_localctx).f2.r);	
								
							((FmlaContext)_localctx).r =  f;	
						
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(68); match(IFF_OP);
				setState(69); match(LPAR);
				setState(70); ((FmlaContext)_localctx).f1 = fmla();
				setState(71); match(RPAR);
				setState(72); match(LPAR);
				setState(73); ((FmlaContext)_localctx).f2 = fmla();
				setState(74); match(RPAR);
					
							MITLIFormula f = MITLIFormula.iff((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
								
							((FmlaContext)_localctx).r =  f;		
						
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(77); ((FmlaContext)_localctx).F_OP = match(F_OP);
				setState(78); ((FmlaContext)_localctx).a = match(INT);
				setState(79); ((FmlaContext)_localctx).b = match(INT);
				setState(80); match(LPAR);
				setState(81); ((FmlaContext)_localctx).f1 = fmla();
				setState(82); match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).F_OP!=null?((FmlaContext)_localctx).F_OP.getText():null));
							
								if (s.compareTo("F_ei") == 0){
									f = MITLIFormula.F((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), true, Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), false); 
								}
								if( s.compareTo("F_ii") == 0){
									f = MITLIFormula.F((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), false,Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), false); 
								}
								if(s.compareTo("F_ee")==0){
									f = MITLIFormula.F((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), true, Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), true); 
								}
								if(s.compareTo("F_ie")==0){
									f = MITLIFormula.F((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), false, Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), true);
								}
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(85); ((FmlaContext)_localctx).F_inf_OP = match(F_inf_OP);
				setState(86); ((FmlaContext)_localctx).a = match(INT);
				setState(87); match(LPAR);
				setState(88); ((FmlaContext)_localctx).f1 = fmla();
				setState(89); match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).F_inf_OP!=null?((FmlaContext)_localctx).F_inf_OP.getText():null));
							
							
								if (s.compareTo("F_e+") == 0){
									f = MITLIFormula.F_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)));  
								}
								if(s.compareTo("F_i+") == 0){
									f = 
										MITLIFormula.or(((FmlaContext)_localctx).f1.r,
										MITLIFormula.F_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null))));  	
								}
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(92); ((FmlaContext)_localctx).G_OP = match(G_OP);
				setState(93); ((FmlaContext)_localctx).a = match(INT);
				setState(94); ((FmlaContext)_localctx).b = match(INT);
				setState(95); match(LPAR);
				setState(96); ((FmlaContext)_localctx).f1 = fmla();
				setState(97); match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).G_OP!=null?((FmlaContext)_localctx).G_OP.getText():null));
							
							
								if (s.compareTo("G_ei") == 0){
									f = MITLIFormula.G((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), true, Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), false); 
								}
								if( s.compareTo("G_ii") == 0){
									f = MITLIFormula.G((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), false,Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), false); 
								}
								if(s.compareTo("G_ee")==0){
									f = MITLIFormula.G((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), true, Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), true); 
								}
								if(s.compareTo("G_ie")==0){
									f = MITLIFormula.G((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), false, Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null)), true);
								}
								
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(100); ((FmlaContext)_localctx).G_inf_OP = match(G_inf_OP);
				setState(101); ((FmlaContext)_localctx).a = match(INT);
				setState(102); match(LPAR);
				setState(103); ((FmlaContext)_localctx).f1 = fmla();
				setState(104); match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).G_inf_OP!=null?((FmlaContext)_localctx).G_inf_OP.getText():null));
							
							if (s.compareTo("G_e+") == 0){
								f = MITLIFormula.G_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)));  
							}
							if(s.compareTo("G_i+") == 0){
								f = 
									MITLIFormula.and(((FmlaContext)_localctx).f1.r,
									MITLIFormula.G_inf((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null))));  	
							}
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(107); ((FmlaContext)_localctx).P_OP = match(P_OP);
				setState(108); ((FmlaContext)_localctx).a = match(INT);
				setState(109); ((FmlaContext)_localctx).b = match(INT);
				setState(110); match(LPAR);
				setState(111); ((FmlaContext)_localctx).f1 = fmla();
				setState(112); match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).P_OP!=null?((FmlaContext)_localctx).P_OP.getText():null));
							
							
							if (s.compareTo("P_ie") == 0 || s.compareTo("P_ii") == 0)
									f = MITLIFormula.P((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(115); ((FmlaContext)_localctx).H_OP = match(H_OP);
				setState(116); ((FmlaContext)_localctx).a = match(INT);
				setState(117); ((FmlaContext)_localctx).b = match(INT);
				setState(118); match(LPAR);
				setState(119); ((FmlaContext)_localctx).f1 = fmla();
				setState(120); match(RPAR);
					
							MITLIFormula f = null;
							String s = String.valueOf((((FmlaContext)_localctx).H_OP!=null?((FmlaContext)_localctx).H_OP.getText():null));
								if (s.compareTo("H_ei") == 0 || s.compareTo("H_ii") == 0)
									f = MITLIFormula.H((MITLIFormula)((FmlaContext)_localctx).f1.r, Integer.valueOf((((FmlaContext)_localctx).a!=null?((FmlaContext)_localctx).a.getText():null)), Integer.valueOf((((FmlaContext)_localctx).b!=null?((FmlaContext)_localctx).b.getText():null))); 
							
								 
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(123); match(UNTIL_OP);
				setState(124); match(LPAR);
				setState(125); ((FmlaContext)_localctx).f1 = fmla();
				setState(126); match(RPAR);
				setState(127); match(LPAR);
				setState(128); ((FmlaContext)_localctx).f2 = fmla();
				setState(129); match(RPAR);

							MITLIFormula f = null;
								f = MITLIFormula.U((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
								
								
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(132); match(SINCE_OP);
				setState(133); match(LPAR);
				setState(134); ((FmlaContext)_localctx).f1 = fmla();
				setState(135); ((FmlaContext)_localctx).f2 = fmla();
				setState(136); match(RPAR);

							MITLIFormula f = null;
								f = MITLIFormula.S((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
							 	
							((FmlaContext)_localctx).r =  f; 	
						
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(139); match(RELEASE_OP);
				setState(140); match(LPAR);
				setState(141); ((FmlaContext)_localctx).f1 = fmla();
				setState(142); ((FmlaContext)_localctx).f2 = fmla();
				setState(143); match(RPAR);

							MITLIFormula f = null;
							 	f = MITLIFormula.R((MITLIFormula)((FmlaContext)_localctx).f1.r,(MITLIFormula)((FmlaContext)_localctx).f2.r);
							 	
							((FmlaContext)_localctx).r =  f;
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conjuncts_listContext extends ParserRuleContext {
		public List<MITLIFormula> l;
		public FmlaContext fmla;
		public Conjuncts_listContext conjuncts_list;
		public FmlaContext fmla() {
			return getRuleContext(FmlaContext.class,0);
		}
		public Conjuncts_listContext conjuncts_list() {
			return getRuleContext(Conjuncts_listContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(MITLIParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MITLIParser.RPAR, 0); }
		public Conjuncts_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjuncts_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).enterConjuncts_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MITLIListener ) ((MITLIListener)listener).exitConjuncts_list(this);
		}
	}

	public final Conjuncts_listContext conjuncts_list() throws RecognitionException {
		Conjuncts_listContext _localctx = new Conjuncts_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_conjuncts_list);
		((Conjuncts_listContext)_localctx).l =  new ArrayList<MITLIFormula>();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(LPAR);
			setState(149); ((Conjuncts_listContext)_localctx).fmla = fmla();

				 	_localctx.l.add(((Conjuncts_listContext)_localctx).fmla.r);
				 
			setState(151); match(RPAR);
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(152); ((Conjuncts_listContext)_localctx).conjuncts_list = conjuncts_list();

							_localctx.l.addAll(_localctx.l);
							
				}
				break;
			case 2:
				{
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u00a1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4\33\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u0095\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009f"+
		"\n\6\3\6\2\2\7\2\4\6\b\n\2\2\u00b0\2\f\3\2\2\2\4\17\3\2\2\2\6\32\3\2\2"+
		"\2\b\u0094\3\2\2\2\n\u0096\3\2\2\2\f\r\5\b\5\2\r\16\b\2\1\2\16\3\3\2\2"+
		"\2\17\20\7\34\2\2\20\21\7\33\2\2\21\22\b\3\1\2\22\5\3\2\2\2\23\24\7\3"+
		"\2\2\24\25\7 \2\2\25\26\5\b\5\2\26\27\b\4\1\2\27\30\7!\2\2\30\33\3\2\2"+
		"\2\31\33\7!\2\2\32\23\3\2\2\2\32\31\3\2\2\2\33\7\3\2\2\2\34\35\7\5\2\2"+
		"\35\36\5\b\5\2\36\37\b\5\1\2\37 \7\6\2\2 \u0095\3\2\2\2!\"\7\t\2\2\"\u0095"+
		"\b\5\1\2#$\7\n\2\2$\u0095\b\5\1\2%&\7 \2\2&\u0095\b\5\1\2\'(\7 \2\2()"+
		"\7\4\2\2)*\7\36\2\2*\u0095\b\5\1\2+,\7 \2\2,-\7\4\2\2-.\7\37\2\2.\u0095"+
		"\b\5\1\2/\60\7\13\2\2\60\61\7\5\2\2\61\62\5\b\5\2\62\63\7\6\2\2\63\64"+
		"\b\5\1\2\64\u0095\3\2\2\2\65\66\7\f\2\2\66\67\5\n\6\2\678\b\5\1\28\u0095"+
		"\3\2\2\29:\7\r\2\2:;\5\n\6\2;<\b\5\1\2<\u0095\3\2\2\2=>\7\16\2\2>?\7\5"+
		"\2\2?@\5\b\5\2@A\7\6\2\2AB\7\5\2\2BC\5\b\5\2CD\7\6\2\2DE\b\5\1\2E\u0095"+
		"\3\2\2\2FG\7\17\2\2GH\7\5\2\2HI\5\b\5\2IJ\7\6\2\2JK\7\5\2\2KL\5\b\5\2"+
		"LM\7\6\2\2MN\b\5\1\2N\u0095\3\2\2\2OP\7\20\2\2PQ\7\36\2\2QR\7\36\2\2R"+
		"S\7\5\2\2ST\5\b\5\2TU\7\6\2\2UV\b\5\1\2V\u0095\3\2\2\2WX\7\21\2\2XY\7"+
		"\36\2\2YZ\7\5\2\2Z[\5\b\5\2[\\\7\6\2\2\\]\b\5\1\2]\u0095\3\2\2\2^_\7\22"+
		"\2\2_`\7\36\2\2`a\7\36\2\2ab\7\5\2\2bc\5\b\5\2cd\7\6\2\2de\b\5\1\2e\u0095"+
		"\3\2\2\2fg\7\23\2\2gh\7\36\2\2hi\7\5\2\2ij\5\b\5\2jk\7\6\2\2kl\b\5\1\2"+
		"l\u0095\3\2\2\2mn\7\24\2\2no\7\36\2\2op\7\36\2\2pq\7\5\2\2qr\5\b\5\2r"+
		"s\7\6\2\2st\b\5\1\2t\u0095\3\2\2\2uv\7\25\2\2vw\7\36\2\2wx\7\36\2\2xy"+
		"\7\5\2\2yz\5\b\5\2z{\7\6\2\2{|\b\5\1\2|\u0095\3\2\2\2}~\7\26\2\2~\177"+
		"\7\5\2\2\177\u0080\5\b\5\2\u0080\u0081\7\6\2\2\u0081\u0082\7\5\2\2\u0082"+
		"\u0083\5\b\5\2\u0083\u0084\7\6\2\2\u0084\u0085\b\5\1\2\u0085\u0095\3\2"+
		"\2\2\u0086\u0087\7\27\2\2\u0087\u0088\7\5\2\2\u0088\u0089\5\b\5\2\u0089"+
		"\u008a\5\b\5\2\u008a\u008b\7\6\2\2\u008b\u008c\b\5\1\2\u008c\u0095\3\2"+
		"\2\2\u008d\u008e\7\30\2\2\u008e\u008f\7\5\2\2\u008f\u0090\5\b\5\2\u0090"+
		"\u0091\5\b\5\2\u0091\u0092\7\6\2\2\u0092\u0093\b\5\1\2\u0093\u0095\3\2"+
		"\2\2\u0094\34\3\2\2\2\u0094!\3\2\2\2\u0094#\3\2\2\2\u0094%\3\2\2\2\u0094"+
		"\'\3\2\2\2\u0094+\3\2\2\2\u0094/\3\2\2\2\u0094\65\3\2\2\2\u00949\3\2\2"+
		"\2\u0094=\3\2\2\2\u0094F\3\2\2\2\u0094O\3\2\2\2\u0094W\3\2\2\2\u0094^"+
		"\3\2\2\2\u0094f\3\2\2\2\u0094m\3\2\2\2\u0094u\3\2\2\2\u0094}\3\2\2\2\u0094"+
		"\u0086\3\2\2\2\u0094\u008d\3\2\2\2\u0095\t\3\2\2\2\u0096\u0097\7\5\2\2"+
		"\u0097\u0098\5\b\5\2\u0098\u0099\b\6\1\2\u0099\u009e\7\6\2\2\u009a\u009b"+
		"\5\n\6\2\u009b\u009c\b\6\1\2\u009c\u009f\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009a\3\2\2\2\u009e\u009d\3\2\2\2\u009f\13\3\2\2\2\5\32\u0094\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}