package amazed;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * We will be given a sentence. We have to reverse the string.
	 * (e.g. Input: I am a coder. OutpuT: Coder a am I)
	 * @param sentence
	 * @return
	 */
	public String reverse(String sentence){
		if (sentence != null) {
			StringBuilder sb = new StringBuilder();
			String[] words = sentence.split(" ");
			words[words.length - 1] = words[words.length - 1].substring(0, 1).toUpperCase() + words[words.length -1].substring(1,words[words.length -1].length());
			words[0] = words[0].toLowerCase();
			for (int i = words.length -1; i > -1; i--){
				sb.append(words[i]);
				sb.append(" ");
			}
			return sb.toString().trim();
		}
		return null;
	}
}
