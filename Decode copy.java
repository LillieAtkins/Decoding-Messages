
import java.util.Arrays;

public class Decode {
	
	private int[] frequency = new int[26], frequency_sorted = new int[26];
	private char[] letter_frequency = {'e','t','a','o','i','n','s','h','r','d','l','u','c','m','f','w','y','p','v','b','g','k','q','j','x','z'}, frequency_letter_array = new char[26], alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private int ASCII; //named this as the it is the index based on a letter's ascii number 
	private String decoded;
	
	public Decode() {
	}

	/*
	 * This code takes in a message object and then iterates through every character in the message object and if the 
	 * character is a letter it finds the index that corresponds to that letter and increments that index in the 
	 * frequency array. It then copies the frequency array into the frequency sorted array and sorts that array.
	 */
	public void countFrequency(Message mes) {
		for(int i = 0; i < mes.messageLength(); i++) {
			char ch = mes.messageCharAt(i);
			if(Character.isLetter(ch)) {
				ASCII = ch-97; //ascii number to index for adding to frequency array
				this.frequency[ASCII]++;
			}
		}
		for(int x = 0; x < this.frequency_sorted.length; x++) { //copying the frequency array to frequency_sorted
			this.frequency_sorted[x] = this.frequency[x];
		}
		Arrays.sort(this.frequency_sorted);
	}
	
	/*
	 * This method takes in a message object and sets the decoded variable in the decode class equal to the encoded
	 * message of the message class. It then iterates through every character of the message if the character is
	 * a letter then it finds the index of that letter in the frequency_letter_array and calls replaceCharAt to 
	 * replace the character with the corresponding decoded letter. At the end, it sets the decoded message in the
	 * message class equal to the decoded message from the decode class.
	 */
	public void decoded_message(Message mes) {
		this.decoded = mes.getEncoded();
		for(int i=0; i<mes.messageLength(); i++) {
			char ch = mes.messageCharAt(i);
			if(Character.isLetter(ch)) {
				int index = 0; 
				while(ch != this.frequency_letter_array[index]) {
					index++; 
				}
				replaceCharAt(i, letter_frequency[25-index]); //25-index because one is in increasing order and the other is in decreasing order (as explained in the readme file)
			}
		}
		mes.setDecoded(this.decoded);
	}
	
	/*
	 * This method takes in nothing and returns a character array with the letters of the alphabet sorted into 
	 * ascending order of frequency. 
	 */
	public char[] makeLetterFrequencyArray() {
		for(int index = 0; index<this.frequency.length; index++) {
			for(int j = 0; j< this.frequency_sorted.length; j++) {
				if(this.frequency[index] == this.frequency_sorted[j]) {   //finds index that is equal to the frequency_sorted_array
					if(this.frequency_letter_array[j]==0) { //check if the space is blank 
						this.frequency_letter_array[j] = this.alphabet[index]; //add the letter from the alphabet (use index as this is in the same order as the frequency array) to the same index as the frequency_sorted_array
						break; //this moves it out of the inner once it fills a spot in the array for a letter
					}
				}
			}
		}
		return frequency_letter_array;
	}
	
	/*
	 * This method takes in an integer and a character. It will replace the specific character in the string and set
	 * the decode message from the decode class equal to this new string with the new character. It does not return 
	 * anything.
	 */
	public void replaceCharAt(int old_char_index, char new_char) { //the if/else conditions are so that there are no indexing errors
			
			if(old_char_index == this.decoded.length()-1) {
				this.decoded = this.decoded.substring(0, old_char_index) + new_char;
			} 
			else if (old_char_index == 0) {
				this.decoded = new_char + this.decoded.substring(old_char_index+1); //or you can use a stringbuilder type
			}
			else {
				this.decoded =  this.decoded.substring(0, old_char_index) + new_char + this.decoded.substring(old_char_index+1);
			}
		}
		
}
