/**
 * Name: Bolu Peng
 * PennID: 16847239
 * Statement: I finished this assignment all by myself
 */
package cipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarTest {

	@Test
	public void testEncipher() {
		String textOne = "Posting Date: June 25, 2008 [EBook #11]";
		String encodedTextOne = "Utxynsl Ifyj: Ozsj 25, 2008 [JGttp #11]";
		assertTrue(Caesar.encipher(5, textOne).equals(encodedTextOne));
		String textTwo = "*** START OF THIS PROJECT GUTENBERG EBOOK ALICE’S ADVENTURES IN WONDERLAND ***       ";
		String encodedTextTwo = "*** ABIZB WN BPQA XZWRMKB OCBMVJMZO MJWWS ITQKM’A ILDMVBCZMA QV EWVLMZTIVL ***       ";
		assertTrue(Caesar.encipher(8, textTwo).equals(encodedTextTwo));
		// Only encipher characters between 'a'-'z' and 'A'-'Z';
		String textThree = " 97345432759023457 @#@$%%@@$$";
		String encodedTextThree = " 97345432759023457 @#@$%%@@$$";
		assertTrue(Caesar.encipher(12, textThree).equals(encodedTextThree));
		String textFour = "Posting Date: June 25, 2008 [EBook #11]";
		String encodedTextFour = "Lkopejc Zwpa: Fqja 25, 2008 [AXkkg #11]";
		assertTrue(Caesar.encipher(-4, textFour).equals(encodedTextFour));
		String textFive = "*** START OF THIS PROJECT GUTENBERG EBOOK ALICE’S ADVENTURES IN WONDERLAND ***       ";
		String encodedTextFive = "*** JKRIK FW KYZJ GIFAVTK XLKVESVIX VSFFB RCZTV’J RUMVEKLIVJ ZE NFEUVICREU ***       ";
		assertTrue(Caesar.encipher(-9, textFive).equals(encodedTextFive));
		String textSix = " 97345432759023457 @#@$%%@@$$";
		String encodedTextSix = " 97345432759023457 @#@$%%@@$$";
		assertTrue(Caesar.encipher(-14, textSix).equals(encodedTextSix));
	}
	
	@Test
	public void testDecipher() {
		String textOne = "Zvokco, Wk’kw, sc drsc Xog Jokvkxn yb Kecdbkvsk?’ (kxn cro dbson dy mebdcoi kc cro czyuo--pkxmi MEBDCOISXQ kc iye’bo pkvvsxq drbyeqr dro ksb! Ny iye drsxu iye myevn wkxkqo sd?)";
		String decipheredTextOne = "Please, Ma’am, is this New Zealand or Australia?’ (and she tried to curtsey as she spoke--fancy CURTSEYING as you’re falling through the air! Do you think you could manage it?)";
		assertTrue(Caesar.decipher(10, textOne).equals(decipheredTextOne));
		String textTwo = "‘Lwpi p rjgxdjh uttaxcv!’ hpxs Paxrt; ‘X bjhi qt hwjiixcv je axzt p itathrdet.’";
		String decipheredTextTwo = "‘What a curious feeling!’ said Alice; ‘I must be shutting up like a telescope.’";
		assertTrue(Caesar.decipher(15, textTwo).equals(decipheredTextTwo));
		// Only decipher characters between 'a'-'z' and 'A'-'Z';
		String textThree = "  ****37984710&%#@#$*(! ";
		String encodedTextThree = "  ****37984710&%#@#$*(! ";
		assertTrue(Caesar.decipher(7, textThree).equals(encodedTextThree));
		String textFour = "Xtmiam, Ui’iu, qa bpqa Vme Hmitivl wz Icabzitqi?’ (ivl apm bzqml bw kczbamg ia apm axwsm--nivkg KCZBAMGQVO ia gwc’zm nittqvo bpzwcop bpm iqz! Lw gwc bpqvs gwc kwctl uiviom qb?)";
		String decipheredTextFour = "Please, Ma’am, is this New Zealand or Australia?’ (and she tried to curtsey as she spoke--fancy CURTSEYING as you’re falling through the air! Do you think you could manage it?)";
		assertTrue(Caesar.decipher(-18, textFour).equals(decipheredTextFour));
		String textFive = "‘Vgzs z btqhntr eddkhmf!’ rzhc Zkhbd; ‘H ltrs ad rgtsshmf to khjd z sdkdrbnod.’";
		String decipheredTextFive = "‘What a curious feeling!’ said Alice; ‘I must be shutting up like a telescope.’";
		assertTrue(Caesar.decipher(-1, textFive).equals(decipheredTextFive));
		String textSix = "  ****37984710&%#@#$*(! ";
		String encodedTextSix = "  ****37984710&%#@#$*(! ";
		assertTrue(Caesar.decipher(3, textSix).equals(encodedTextSix));
	}

}
