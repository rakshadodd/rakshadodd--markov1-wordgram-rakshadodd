/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author YOUR-NAME
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram and initialize the private variables
	 * @param source is the source array
	 * @param start is the starting index
	 * @param size is the size of the array
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i=start ; i< start + size; i++) {
			myWords[i-start]= source[i];
		}
		// TODO: initialize myWords and ...
		myToString= null;
		myHash= 0;
		}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * 
	 * @return the length array myWords
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		if (this.length() != wg.length()) {
			return false;
		}
		for(int i=0 ; i < myWords.length; i ++) {
			if (!(wg.myWords[i].equals(myWords[i]))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		return this.toString().hashCode();
		
	}
	/**
	 * 
	 * @param last is last String of returned WordGram
	 * @return a WordGram object which contains items from myWords array
	 * shifted right by one index plus the last String
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for (int i= 1; i< wg.myWords.length ; i ++) {
			wg.myWords[i-1]= wg.myWords[i];
		}
		wg.myWords[myWords.length - 1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method	
		//for (String str : myWords) {
		myToString= String.join(" ", myWords);
		return myToString;
	}
}
