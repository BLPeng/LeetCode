/**
 * Name:Bolu Peng
 * PennID:16847239
 * Statement:I accomplished this assignment all by myself
 */
package madLib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MadLib {
	
	//Declare variables for constructor and method play() and ask()
	private String raw;
	private List<String> brackets = new ArrayList<String>();
	private List<String> container;
	
	//Constructor
	public MadLib(List<String> container){
		this.container = container;
	}
	
	/**
	 * Read from the file 
	 * Store every line of the file into an ArrayList
	 */
	public List<String> readFile(String fileName){
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String text = bufferedReader.readLine();
			while (text!=null){
				container.add(text);
				text = bufferedReader.readLine();
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return container;
	}
	
	/**
	 * Extract the content in between the brackets
	 * Store the content in an ArrayList
	 */
	public List<String> bracket(List<String> textContainer){
		for (int i=0; i<textContainer.size(); i++){
			for (int j=0; j<textContainer.get(i).length(); j++){
				if (textContainer.get(i).charAt(j)=='['){
					int right=j;
					while (textContainer.get(i).charAt(right)!=']'){
						right++;
					}
					brackets.add(textContainer.get(i).substring(j+1,right));
				}
			}
		}
		//Return brackets in order to test method
		return brackets; 
	}
	
	/**
	 * Display the prompt on computer. If the content of a bracket starts with a vowel, print "an" in front of it, else print "a"
	 * If people input nothing, ask people to input repeatedly
	 * Store what people input into an ArrayList
	 */
	public List<String> play(){
		Scanner input = new Scanner(System.in);
		List<String> typedContent = new ArrayList<String>();
		String vowel = "AEIOUaeiou";
		System.out.println("Fill in the blanks to get an exciting story!");
		for (int i=0; i<brackets.size(); i++){
			String prompt = "Enter" + " "+ (vowel.contains(brackets.get(i).charAt(0)+"") ? "an" : "a") +" " + brackets.get(i)+""+": ";
			System.out.print(prompt);
			raw = input.nextLine();
			while (raw.length()==0){
				System.out.print(prompt);
				raw = input.nextLine();
			}
			String content = ask();
			typedContent.add(content);
		}
	    input.close();
		return typedContent;
	}
	
	/**
	 * Extract the content from the input
	 * Organize the content in a right format
	 */
	public String ask(){
		String trim = raw.trim();
		if (trim.length()==0) return " ";
		String[] temp = trim.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<temp.length; i++){
			if (i!=temp.length-1){
				sb.append(temp[i]).append(" ");
			}else{
				sb.append(temp[i]);
			}
		}
		return sb.toString();		
	}
	
	/**
	 * Replace the content together with the brackets in the original file with what people typed in
	 * Store the filled file in an ArrayList
	 */
	public List<String> replaceContent(List<String> textContainer, List<String> typedContent){
		int count=0;
		List<String> filledStory = new ArrayList<String>();
		for (int i=0; i<textContainer.size(); i++){
			String originalText = textContainer.get(i);
			for (int j=0; j<originalText.length();){
				if (originalText.charAt(j)=='['){
					int right=j;
					while (originalText.charAt(right)!=']'){
						right++;
					}
					String replaced = typedContent.get(count++);
					String partial = originalText.substring(j, right+1).replace(originalText.substring(j, right+1), replaced);
					originalText = originalText.substring(0,j) + partial + originalText.substring(right+1,originalText.length());
					j+=partial.length();
				}else{
					j++;
				}
			}
			filledStory.add(originalText);
		}
		return filledStory;
	}
	
	public static void main(String[] args){
		MadLib madLib = new MadLib(new ArrayList<String>());
		//Read content in an ArrayList
		List<String> textContainer = madLib.readFile("/Users/bolupeng/Desktop/story.txt");
		madLib.bracket(textContainer);
		//Store what people typed in into an ArrayList
		List<String> typedContent = madLib.play();
		//Replace the original file with what people typed in
		List<String> filledStory = madLib.replaceContent(textContainer, typedContent);
		//Print the filled file on console
		System.out.println();
		for (int i=0; i<filledStory.size(); i++){
			System.out.println(filledStory.get(i));
		}
	}
}
