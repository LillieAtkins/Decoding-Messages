/*
 * I have neither given nor received any unauthorized aid on this assignment. --Lillie Atkins
 */

public class Message {

	private String encoded;
	private String decoded;
	
	/*
	 * This is a constructor that takes in a string and sets that string to the encoded data field. 
	 */
	public Message(String message) {
		this.encoded = message;
	}
	
	/*
	 * This is a setter that takes in a string and sets the encoded data field equal to that string.
	 */
	public void setEncoded(String message) {
		this.encoded = message;
	}
	
	/*
	 * This is a getter that returns this.encoded and takes in nothing.
	 */
	public String getEncoded() {
		return this.encoded;
	}
	
	/*
	 * This is a setter that takes in a string and sets that equal to this.decoded.
	 */
	public void setDecoded(String message) {
		this.decoded = message;
	}
	
	/*
	 * This is a getter that takes in nothing and returns this.decoded.
	 */
	public String getDecoded() {
		return this.decoded;
	}
	
	/*
	 * This method takes in nothing and returns the length of the encoded message (which is the same as the length of
	 * the decoded message).
	 */
	public int messageLength() {
		return this.encoded.length(); 
	}
	
	/*
	 * This method takes in an integer and returns the character at that index in the encoded message.
	 */
	public char messageCharAt(int index) {
		return this.encoded.charAt(index);
	}
	
	
}
