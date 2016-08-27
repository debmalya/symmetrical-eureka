package amazed;

public class StringUtil {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Implement an algorithm to determine if a string has all unique characters
	 * What if you can not use additional data structures?
	 * 
	 * Assume : charset is ASCII
	 * 
	 * @param value
	 * @return
	 */
	public boolean isUnique(String value) {
		value = value.toLowerCase();
		boolean[] r = new boolean[256];
		for (int i = 0; i < value.length(); i++) {
			if (r[value.charAt(i) - 'a']) {
				return false;
			}
			r[value.charAt(i) - 'a'] = true;
		}
		return true;
	}

	public boolean isUnique0(String value) {
		value = value.toLowerCase();
		int[] r = new int[26];
		for (int i = 0; i < value.length(); i++) {
			if (r[value.charAt(i) - 'a'] > 0) {
				return false;
			}
			r[value.charAt(i) - 'a']++;
		}
		return true;
	}

	/**
	 * Design an algorithm and write code to remove the duplicate characters in
	 * a string without using any additional buffer NOTE: One or two additional
	 * variables are fine An extra copy of the array is not
	 * 
	 * @param str
	 * @return
	 */
	public String removeDuplicates(String str) {
		if (str != null) {
			char[] ch = str.toCharArray();
			boolean[] b = new boolean[256];
			int j = 0;
			for (int i = 0; i < ch.length; i++) {
				if (!b[ch[i]-'A']) {
					ch[j++] = str.charAt(i);
					b[ch[i]-'A'] = true;
				}
			}
			
			for (int i = j; i< ch.length; i++){
				ch[j] = ' ';
			}
			return new String(ch).trim();
		}
		return null;
	}
	
	public boolean isValid(String input){
		
		if (input != null)
			return input.matches("[a-z]*.");
		return false;
	}
}
