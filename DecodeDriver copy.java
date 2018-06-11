/*
 * I have neither given nor received any unauthorized aid on this assignment. --Lillie Atkins
 */

import java.io.*;
import java.util.Scanner;

public class DecodeDriver {
	
	public static Decode decoder = new Decode(); //create a decoding object
	public static Scanner filereader;
	public static Message encoded_message;
	public static Message[] MessageArr = new Message[6];
	public static File message;
	public static String[] names = {"decoded0.txt", "decoded1.txt", "decoded2.txt", "decoded3.txt", "decoded4.txt", "decoded5.txt"};

	
	/*
	 * This code reads in files that are stores in args and then creates message objects for each these strings. It 
	 * then calls the decode class methods to decode these messages and prints these decoded messages out as well as
	 * writes them into files.
	 */
	public static void main(String[] args)throws IOException {
		for(int i = 0; i<MessageArr.length; i++) {
			message = new File(args[i]);
			filereader = new Scanner(message);        //points the scanner towards the file you want to read
			System.out.println("Reading and decoding messages in " + message + "...");
			String encoded = "";
			while(filereader.hasNextLine()) {
				encoded+= filereader.nextLine() + "\n"; //reads in each line adding it to the empty string created above and a new line so that the \n from the encoded file are matched in the decoded output
				encoded_message = new Message(encoded); 
			}
			MessageArr[i] = encoded_message;
			
			decoder.countFrequency(MessageArr[i]);
			decoder.makeLetterFrequencyArray();
			
			/*
			 * encoded0.txt is just random letters. encoded1.txt is the Declaration of Independence. encoded2.txt is
			 * Alice in Wonderland. encoded3.txt is Sherlock Holmes. encoded4.txt is Huckleberry Finn. encoded5.txt 
			 * is Pride and Prejudice.
			 */
			
			BufferedWriter out = new BufferedWriter(new FileWriter(names[i]));
			decoder.decoded_message(MessageArr[i]);
			System.out.print("Decoded Message:" + "\n" + MessageArr[i].getDecoded());
			out.write(MessageArr[i].getDecoded()); 
			System.out.println();   //to print new line between messages
			out.close();            //need to call for each file to update them
		}
		filereader.close();	
	}
	

}
