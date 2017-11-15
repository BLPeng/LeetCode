/**
 * Name: Bolu Peng
 * PennID: 16847239
 * Statement: I finished this assignment all by myself
 */
package cipher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Caesar {
	
	/**
	 * Encipher the 'a'-'z' and 'A'-'Z' characters by shifting their number of places
	 * If character+shift > 'z' or character+shift > 'Z', trace from 'a' or 'A' all over again 
	 */
	public static String encipher(int shift, String plainText){
		// Keep the absolute value of shift between 0 - 25
		int cut = shift%26;
		StringBuilder sb = new StringBuilder();
		if (cut==0) return plainText;
		else if (cut>0){
			for (int i=0; i<plainText.length(); i++){
				if (plainText.charAt(i)>='a' && plainText.charAt(i)<='z'){
					char temp = (char)(plainText.charAt(i)+cut)>'z' ? (char)((char)((plainText.charAt(i)+cut)-'z')+'a'-1) : (char)(plainText.charAt(i)+cut);
					sb.append(temp);
				}
				else if (plainText.charAt(i)>='A' && plainText.charAt(i)<='Z'){
					char temp = (char)(plainText.charAt(i)+cut)>'Z' ? (char)((char)((plainText.charAt(i)+cut)-'Z')+'A'-1) : (char)(plainText.charAt(i)+cut);
					sb.append(temp);
				}
				else{
					sb.append(plainText.charAt(i));
				}
			}
		}
		else{
			for (int i=0; i<plainText.length(); i++){
				if (plainText.charAt(i)>='a' && plainText.charAt(i)<='z'){
					char temp = (char)(plainText.charAt(i)+cut)<'a' ? (char)((char)((plainText.charAt(i)+cut)-'a')+'z'+1) : (char)(plainText.charAt(i)+cut);
					sb.append(temp);
				}
				else if (plainText.charAt(i)>='A' && plainText.charAt(i)<='Z'){
					char temp = (char)(plainText.charAt(i)+cut)<'A' ? (char)((char)((plainText.charAt(i)+cut)-'A')+'Z'+1) : (char)(plainText.charAt(i)+cut);
					sb.append(temp);
				}
				else{
					sb.append(plainText.charAt(i));
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Decipher the 'a'-'z' and 'A'-'Z' characters by shifting their number of places
	 * If character-shift < 'a' or character+shift < 'A', trace from 'z' or 'Z' all over again 
	 */
	public static String decipher(int shift, String cipheredText){
		// Keep the absolute value of shift between 0 - 25
		int cut = shift%26;
		StringBuilder sb = new StringBuilder();
		if (cut==0) return cipheredText;
		else if (cut>0){
			for (int i=0; i<cipheredText.length(); i++){
				if (cipheredText.charAt(i)>='a' && cipheredText.charAt(i)<='z'){
					char temp = (char)(cipheredText.charAt(i)-cut)<'a' ? (char)((char)((cipheredText.charAt(i)-cut)-'a')+'z'+1) : (char)(cipheredText.charAt(i)-cut);
					sb.append(temp);
				}
				else if (cipheredText.charAt(i)>='A' && cipheredText.charAt(i)<='Z'){
					char temp = (char)(cipheredText.charAt(i)-cut)<'A' ? (char)((char)((cipheredText.charAt(i)-cut)-'A')+'Z'+1) : (char)(cipheredText.charAt(i)-cut);
					sb.append(temp);
				}
				else{
					sb.append(cipheredText.charAt(i));
				}
			}
		}
		else{
			for (int i=0; i<cipheredText.length(); i++){
				if (cipheredText.charAt(i)>='a' && cipheredText.charAt(i)<='z'){
					char temp = (char)(cipheredText.charAt(i)-cut)>'z' ? (char)((char)((cipheredText.charAt(i)-cut)-'z')+'a'-1) : (char)(cipheredText.charAt(i)-cut);
					sb.append(temp);
				}
				else if (cipheredText.charAt(i)>='A' && cipheredText.charAt(i)<='Z'){
					char temp = (char)(cipheredText.charAt(i)-cut)>'Z' ? (char)((char)((cipheredText.charAt(i)-cut)-'Z')+'A'-1) : (char)(cipheredText.charAt(i)-cut);
					sb.append(temp);
				}
				else{
					sb.append(cipheredText.charAt(i));
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Read contents from original and decoded file
	 * Compare their contents with each other line by line, character by character
	 */
	public static boolean diff(String originalFile, String encDecFile){
		try{
			FileReader fileReaderOriginal = new FileReader(originalFile);
			FileReader fileReaderDecoded = new FileReader(encDecFile);
			BufferedReader bufferedReaderOriginal = new BufferedReader(fileReaderOriginal);
			BufferedReader bufferedReaderDecoded = new BufferedReader(fileReaderDecoded);
			String originalText = bufferedReaderOriginal.readLine();
			String decodedText = bufferedReaderDecoded.readLine();
			while (originalText!=null && decodedText!=null){
				originalText = bufferedReaderOriginal.readLine();
				decodedText = bufferedReaderDecoded.readLine();
				if ((originalText==null && decodedText!=null) || (originalText!=null && decodedText==null)) return false;
				if (originalText!=null && decodedText!=null && !originalText.equals(decodedText)) return false;
			}
			bufferedReaderOriginal.close();
			bufferedReaderDecoded.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Read contents from original file
	 * Encode the contents
	 */
	public static void encodeFile(String originalFile, List<String> container, int shift){
		try{
			FileReader fileReader = new FileReader(originalFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String originalText = bufferedReader.readLine();
			while (originalText!=null){
				String encipheredText = encipher(shift, originalText);
				// Use an ArrayList to store the encoded contents temporarily
				container.add(encipheredText+"\n");
				originalText = bufferedReader.readLine();
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Read contents from encoded file
	 * Decode the contents
	 */
	public static void decodeFile(String encodedFile, List<String> container, int shift){
		try{
			FileReader fileReader = new FileReader(encodedFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String encodedText = bufferedReader.readLine();
			while (encodedText!=null){
				String decipheredText = decipher(shift, encodedText);
				// Use an ArrayList to store the decoded contents temporarily
				container.add(decipheredText+"\n");
				encodedText = bufferedReader.readLine();
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	 // Write the content from the ArrayList to a new file
	public static void writeFile(String file, List<String> container){
		try{
			FileOutputStream fos = new FileOutputStream(file,true);
			PrintWriter pw = new PrintWriter(fos);
			for (int i=0; i<container.size(); i++){
				pw.print(container.get(i));
			}
			// Clear the ArrayList every time when finish writing
			container.clear();
			pw.flush();
			pw.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		//Initiate a default shift variable
		int shift = -26;
		// Create an ArrayList to store the content temporarily
		List<String> container = new ArrayList<String>();
		// Original file -> Encoded file
		encodeFile("/Users/bolupeng/Desktop/myBook.txt", container, shift);
		writeFile("/Users/bolupeng/Desktop/encBook.txt", container);
		// Encoded file -> Decoded file
		decodeFile("/Users/bolupeng/Desktop/encBook.txt", container, shift);
		writeFile("/Users/bolupeng/Desktop/decBook.txt", container);
		// Compare the original file with decoded file
		diff("/Users/bolupeng/Desktop/myBook.txt", "/Users/bolupeng/Desktop/decBook.txt");
	}
}
