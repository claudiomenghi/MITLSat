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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MITLILexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'"
	};
	public static final String[] ruleNames = {
		"T__0", "OP", "LPAR", "RPAR", "LBRA", "RBRA", "TRUE", "FALSE", "NEG_OP", 
		"AND_OP", "OR_OP", "IMPL_OP", "IFF_OP", "F_OP", "F_inf_OP", "G_OP", "G_inf_OP", 
		"P_OP", "H_OP", "UNTIL_OP", "SINCE_OP", "RELEASE_OP", "TRIGGER_OP", "COUNT_OP", 
		"LOGIC", "COLON", "SEMI", "INT", "ATOM", "REAL", "ATOMInit", "ID", "NEWLINE", 
		"WS", "COMMENT"
	};


	public MITLILexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MITLI.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 33: WS_action((RuleContext)_localctx, actionIndex); break;
		case 34: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u012a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3V\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u008a\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0094\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a6\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00b0\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c2\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u00d4\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u00f2\n\32\3\33\3\33\3\34\3\34\3\35\6\35\u00f9\n"+
		"\35\r\35\16\35\u00fa\3\36\3\36\3\37\7\37\u0100\n\37\f\37\16\37\u0103\13"+
		"\37\3\37\3\37\6\37\u0107\n\37\r\37\16\37\u0108\3 \3 \3!\3!\3!\3!\7!\u0111"+
		"\n!\f!\16!\u0114\13!\3\"\5\"\u0117\n\"\3\"\3\"\3#\6#\u011c\n#\r#\16#\u011d"+
		"\3#\3#\3$\3$\7$\u0124\n$\f$\16$\u0127\13$\3$\3$\2\2%\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\2=\37?\2A C!E\"G#\3\2"+
		"\b\4\2>>@@\3\2\62;\4\2C\\c|\4\2\60\60aa\4\2\13\f\"\"\4\2\f\f\17\17\u0144"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2=\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5U\3\2\2"+
		"\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21d\3\2\2"+
		"\2\23j\3\2\2\2\25l\3\2\2\2\27o\3\2\2\2\31r\3\2\2\2\33u\3\2\2\2\35\u0089"+
		"\3\2\2\2\37\u0093\3\2\2\2!\u00a5\3\2\2\2#\u00af\3\2\2\2%\u00c1\3\2\2\2"+
		"\'\u00d3\3\2\2\2)\u00d5\3\2\2\2+\u00d7\3\2\2\2-\u00d9\3\2\2\2/\u00db\3"+
		"\2\2\2\61\u00dd\3\2\2\2\63\u00f1\3\2\2\2\65\u00f3\3\2\2\2\67\u00f5\3\2"+
		"\2\29\u00f8\3\2\2\2;\u00fc\3\2\2\2=\u0101\3\2\2\2?\u010a\3\2\2\2A\u010c"+
		"\3\2\2\2C\u0116\3\2\2\2E\u011b\3\2\2\2G\u0121\3\2\2\2IJ\7<\2\2JK\7f\2"+
		"\2KL\7g\2\2LM\7h\2\2M\4\3\2\2\2NV\t\2\2\2OP\7?\2\2PV\7?\2\2QR\7>\2\2R"+
		"V\7?\2\2ST\7@\2\2TV\7?\2\2UN\3\2\2\2UO\3\2\2\2UQ\3\2\2\2US\3\2\2\2V\6"+
		"\3\2\2\2WX\7*\2\2X\b\3\2\2\2YZ\7+\2\2Z\n\3\2\2\2[\\\7]\2\2\\\f\3\2\2\2"+
		"]^\7_\2\2^\16\3\2\2\2_`\7v\2\2`a\7t\2\2ab\7w\2\2bc\7g\2\2c\20\3\2\2\2"+
		"de\7h\2\2ef\7c\2\2fg\7n\2\2gh\7u\2\2hi\7g\2\2i\22\3\2\2\2jk\7#\2\2k\24"+
		"\3\2\2\2lm\7(\2\2mn\7(\2\2n\26\3\2\2\2op\7~\2\2pq\7~\2\2q\30\3\2\2\2r"+
		"s\7/\2\2st\7@\2\2t\32\3\2\2\2uv\7>\2\2vw\7/\2\2wx\7@\2\2x\34\3\2\2\2y"+
		"z\7H\2\2z{\7a\2\2{|\7g\2\2|\u008a\7g\2\2}~\7H\2\2~\177\7a\2\2\177\u0080"+
		"\7g\2\2\u0080\u008a\7k\2\2\u0081\u0082\7H\2\2\u0082\u0083\7a\2\2\u0083"+
		"\u0084\7k\2\2\u0084\u008a\7k\2\2\u0085\u0086\7H\2\2\u0086\u0087\7a\2\2"+
		"\u0087\u0088\7k\2\2\u0088\u008a\7g\2\2\u0089y\3\2\2\2\u0089}\3\2\2\2\u0089"+
		"\u0081\3\2\2\2\u0089\u0085\3\2\2\2\u008a\36\3\2\2\2\u008b\u008c\7H\2\2"+
		"\u008c\u008d\7a\2\2\u008d\u008e\7g\2\2\u008e\u0094\7-\2\2\u008f\u0090"+
		"\7H\2\2\u0090\u0091\7a\2\2\u0091\u0092\7k\2\2\u0092\u0094\7-\2\2\u0093"+
		"\u008b\3\2\2\2\u0093\u008f\3\2\2\2\u0094 \3\2\2\2\u0095\u0096\7I\2\2\u0096"+
		"\u0097\7a\2\2\u0097\u0098\7g\2\2\u0098\u00a6\7g\2\2\u0099\u009a\7I\2\2"+
		"\u009a\u009b\7a\2\2\u009b\u009c\7g\2\2\u009c\u00a6\7k\2\2\u009d\u009e"+
		"\7I\2\2\u009e\u009f\7a\2\2\u009f\u00a0\7k\2\2\u00a0\u00a6\7k\2\2\u00a1"+
		"\u00a2\7I\2\2\u00a2\u00a3\7a\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a6\7g\2\2"+
		"\u00a5\u0095\3\2\2\2\u00a5\u0099\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u00a1"+
		"\3\2\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7I\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\u00b0\7-\2\2\u00ab\u00ac\7I\2\2\u00ac\u00ad\7a\2\2\u00ad"+
		"\u00ae\7k\2\2\u00ae\u00b0\7-\2\2\u00af\u00a7\3\2\2\2\u00af\u00ab\3\2\2"+
		"\2\u00b0$\3\2\2\2\u00b1\u00b2\7R\2\2\u00b2\u00b3\7a\2\2\u00b3\u00b4\7"+
		"g\2\2\u00b4\u00c2\7g\2\2\u00b5\u00b6\7R\2\2\u00b6\u00b7\7a\2\2\u00b7\u00b8"+
		"\7g\2\2\u00b8\u00c2\7k\2\2\u00b9\u00ba\7R\2\2\u00ba\u00bb\7a\2\2\u00bb"+
		"\u00bc\7k\2\2\u00bc\u00c2\7k\2\2\u00bd\u00be\7R\2\2\u00be\u00bf\7a\2\2"+
		"\u00bf\u00c0\7k\2\2\u00c0\u00c2\7g\2\2\u00c1\u00b1\3\2\2\2\u00c1\u00b5"+
		"\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c2&\3\2\2\2\u00c3"+
		"\u00c4\7J\2\2\u00c4\u00c5\7a\2\2\u00c5\u00c6\7g\2\2\u00c6\u00d4\7g\2\2"+
		"\u00c7\u00c8\7J\2\2\u00c8\u00c9\7a\2\2\u00c9\u00ca\7g\2\2\u00ca\u00d4"+
		"\7k\2\2\u00cb\u00cc\7J\2\2\u00cc\u00cd\7a\2\2\u00cd\u00ce\7k\2\2\u00ce"+
		"\u00d4\7k\2\2\u00cf\u00d0\7J\2\2\u00d0\u00d1\7a\2\2\u00d1\u00d2\7k\2\2"+
		"\u00d2\u00d4\7g\2\2\u00d3\u00c3\3\2\2\2\u00d3\u00c7\3\2\2\2\u00d3\u00cb"+
		"\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4(\3\2\2\2\u00d5\u00d6\7W\2\2\u00d6*"+
		"\3\2\2\2\u00d7\u00d8\7U\2\2\u00d8,\3\2\2\2\u00d9\u00da\7T\2\2\u00da.\3"+
		"\2\2\2\u00db\u00dc\7V\2\2\u00dc\60\3\2\2\2\u00dd\u00de\7E\2\2\u00de\62"+
		"\3\2\2\2\u00df\u00e0\7s\2\2\u00e0\u00e1\7v\2\2\u00e1\u00f2\7n\2\2\u00e2"+
		"\u00e3\7o\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7v\2\2\u00e5\u00f2\7n\2\2"+
		"\u00e6\u00e7\7s\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea"+
		"\7/\2\2\u00ea\u00f2\7k\2\2\u00eb\u00ec\7o\2\2\u00ec\u00ed\7k\2\2\u00ed"+
		"\u00ee\7v\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7/\2\2\u00f0\u00f2\7k\2\2"+
		"\u00f1\u00df\3\2\2\2\u00f1\u00e2\3\2\2\2\u00f1\u00e6\3\2\2\2\u00f1\u00eb"+
		"\3\2\2\2\u00f2\64\3\2\2\2\u00f3\u00f4\7<\2\2\u00f4\66\3\2\2\2\u00f5\u00f6"+
		"\7=\2\2\u00f68\3\2\2\2\u00f7\u00f9\4\62;\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb:\3\2\2\2\u00fc"+
		"\u00fd\4c|\2\u00fd<\3\2\2\2\u00fe\u0100\t\3\2\2\u00ff\u00fe\3\2\2\2\u0100"+
		"\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0104\u0106\7\60\2\2\u0105\u0107\t\3\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109>\3\2\2\2\u010a\u010b\t\4\2\2\u010b@\3\2\2\2\u010c\u0112\5?"+
		" \2\u010d\u0111\5? \2\u010e\u0111\59\35\2\u010f\u0111\t\5\2\2\u0110\u010d"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113B\3\2\2\2\u0114\u0112\3\2\2\2"+
		"\u0115\u0117\7\17\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0119\7\f\2\2\u0119D\3\2\2\2\u011a\u011c\t\6\2\2\u011b"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0120\b#\2\2\u0120F\3\2\2\2\u0121\u0125"+
		"\7%\2\2\u0122\u0124\n\7\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0128\u0129\b$\3\2\u0129H\3\2\2\2\23\2U\u0089\u0093\u00a5\u00af\u00c1"+
		"\u00d3\u00f1\u00fa\u0101\u0108\u0110\u0112\u0116\u011d\u0125\4\3#\2\3"+
		"$\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}