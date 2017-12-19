/**
 * Name:Bolu Peng
 * PennID:16847239
 * Statement:I accomplished this assignment all by myself
 */
package madLib;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MadLibTest {

	@Test
	public void testBracket() {
		MadLib test = new MadLib(new ArrayList<String>());
		String temp = "I was, of course, [feeling]. Then after a few days of being happy, I got a call from the person who lost the wallet. He said he was really [feeling] with me for being honest. He was so grateful that he sent my family and me on a trip to [foreign country]";
		List<String> container = new ArrayList<String>();
		container.add(temp);
		List<String> brackets = test.bracket(container);
		assertTrue(brackets.get(0).equals("feeling"));
		assertTrue(brackets.get(1).equals("feeling"));
		assertTrue(brackets.get(2).equals("foreign country"));
	}
	
	@Test
	public void testReplace() {
		List<String> container = new ArrayList<String>();
		MadLib test = new MadLib(new ArrayList<String>());
		String temp = "I was, of course, [feeling]. Then after a few days of being happy, I got a call from the person who lost the wallet. He said he was really [feeling] with me for being honest. He was so grateful that he sent my family and me on a trip to [foreign country]";
		container.add(temp);
		String[] typed = {"happy","happy","France"};
		List<String> typedContent = new ArrayList<String>();
		for (int i=0; i<typed.length; i++){
			typedContent.add(typed[i]);
		}
		String result = "I was, of course, happy. Then after a few days of being happy, I got a call from the person who lost the wallet. He said he was really happy with me for being honest. He was so grateful that he sent my family and me on a trip to France";
		assertTrue(test.replaceContent(container, typedContent).get(0).equals(result));
	}
}
