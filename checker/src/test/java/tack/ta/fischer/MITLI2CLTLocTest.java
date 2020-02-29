/**
 * 
 */
package tack.ta.fischer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIAtom;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.parser.MITLILexer;
import formulae.mitli.parser.MITLIParser;
import tack.checker.SystemChecker;
import zotrunner.ZotException;

/**
 * @author Claudio1
 *
 */
public class MITLI2CLTLocTest {

	@Test
	public void test() throws FileNotFoundException, IOException, ZotException {
		
		String path = ClassLoader.getSystemResource("MITLFormula.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		
		new SystemChecker(formula, 10, 
				System.out).check(null);
	}

}
