/**
 * 
 */
package dropbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class DropboxBot {
	/**
	 * One Very Important User (VIU) has a Very Confidential Document (VCD)
	 * stored in his Dropbox account. He doesn't let anyone see the VCD,
	 * especially his roommates who often have free access to his mobile devices
	 * and laptop.
	 * 
	 * Launching the Dropbox mobile app on the VIU's tablet requires a
	 * four-digit passcode. To ensure the confidentiality of the stored
	 * information, the device is locked out of Dropbox after 10 consecutive
	 * failed passcode attempts.
	 * 
	 * Despite this security, our VIU doesn't trust anyone and is a little
	 * paranoid that someone might bypass the passcode. As a precaution, he has
	 * asked you to implement a function that checks to see if 10 or more
	 * consecutive failed passcode attempts were made.
	 * 
	 * Example
	 * 
	 * For passcode = "1111", attempts = ["1111", "9999", "9999", "9999",
	 * "9999", "9999", "9999", "9999", "9999", "9999", "9999", "1111"] the
	 * answer is incorrectPasscodeAttempts(passcode, attempts) = true.
	 * 
	 * For passcode = "1111", attempts = [] the answer is
	 * incorrectPasscodeAttempts(passcode, attempts) = false.
	 * 
	 * [input] string passcode
	 * 
	 * String consisting of exactly 4 digits representing the correct passcode.
	 * [input] array.string attempts
	 * 
	 * Array representing the passcode attempts in the order they were made.
	 * Each element of attempts is a string consisting of exactly 4 digits.
	 * [output] boolean
	 * 
	 * true if 10 or more consecutive failed passcode attempts were made, false
	 * otherwise.
	 * 
	 * @param passcode
	 * @param attempts
	 * @return
	 */
	boolean incorrectPasscodeAttempts(String passcode, String[] attempts) {
		int c = 0;
		for (int i = 0; i < attempts.length; i++) {
			if (passcode.equals(attempts[i])) {
				c = 0;
			} else {
				c++;
				if (c >= 10) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * In its effort to push the limits of file compression, Dropbox recently
	 * developed a lossless compression algorithm for H.264 and JPEG files.
	 * Since you are thinking about applying for a job at Dropbox, you decided
	 * to experiment with simple lossless compression as part of your interview
	 * prep.
	 * 
	 * One of the most widely known approaches in the field of compression
	 * algorithms is sliding window compression. It works as follows:
	 * 
	 * Consider characters one by one. Let the current character index be i.
	 * Take the last width characters before the current one (i.e. s[i - width,
	 * i - 1], where s[i, j] means the substring of s from index i to index j,
	 * both inclusive), and call it the window. Find such startIndex and length
	 * that s[i, i + length - 1] = s[startIndex, startIndex + length - 1] and
	 * s[startIndex, startIndex + length - 1] is contained within the window. If
	 * there are several such pairs, choose the one with the largest length. If
	 * there still remains more than one option, choose the one with the
	 * smallest startIndex. If the search was successful, append
	 * "(startIndex,length)" to the result and move to the index i + length.
	 * Otherwise, append the current character to the result and move on to the
	 * next one. Given a string, apply sliding window compression to it.
	 * 
	 * Example
	 * 
	 * For inputString = "abacabadabacaba" and width = 7 the answer is
	 * 
	 * losslessDataCompression(inputString, width) =
	 * "ab(0,1)c(0,3)d(4,3)c(8,3)".
	 * 
	 * Step 1: i = 0, inputString[i] = 'a', window = "". 'a' is not contained
	 * within the window, so it is appended to the result. Step 2: i = 1,
	 * inputString[i] = 'b', window = "a". 'b' is not contained within the
	 * window, so it is appended to the result. Step 3: i = 2, inputString[i] =
	 * 'a', window = "ab". 'a' can be found in the window. 'a' in the window
	 * corresponds to the inputString[0], so (0,1) representing the substring
	 * "a" is appended to the result. Step 4: i = 3, inputString[i] = 'c',
	 * window = "aba". The same situation as in the first two steps. Step 5: i =
	 * 4, inputString[i] = 'a', window = "abac". Consider startIndex = 0, length
	 * = 3. inputString[startIndex, startIndex + length - 1] = "aba" and it is
	 * contained within the window, inputString[i, i + length - 1] = "aba".
	 * Therefore, "(0,3)" should be added to the result. i += length.
	 * 
	 * Step 6: i = 7, inputString[i] = 'd', window = inputString[0, 6] =
	 * "abacaba". The same situation as in the first two steps. Step 7: i = 8,
	 * inputString[i] = 'a', window = inputString[1, 7] = "bacabad". Consider
	 * length = 3 again. inputString[i, i + b - 1] = "aba", window[3, 5] =
	 * "aba", and it corresponds to inputString[4, 6] since inputString[0, 2] is
	 * no longer within the window. So, "(4,3)" should be appended. i += length.
	 * Step 8: i = 11, inputString[i] = 'c', window = "abadaba". The same
	 * situation as at the first two steps. Step 9: i = 12, inputString[i] =
	 * 'a', window = "badabac". length = 3, inputString[i, i + length - 1] =
	 * "aba", window[3, 5] = "aba", and it corresponds to inputString[8, 10].
	 * So, "(8,3)" should be appended. i += length.
	 * 
	 * For inputString = "abacabadabacaba" and width = 8 the answer is
	 * 
	 * losslessDataCompression(inputString, width) = "ab(0,1)c(0,3)d(0,7)".
	 * 
	 * In both of the above examples the resulting "compressed" string becomes
	 * even longer than the initial one. In fact, sliding window compression
	 * proves to be efficient for longer inputs. E.g.:
	 * 
	 * For inputString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa" and width = 12 the
	 * answer is
	 * 
	 * losslessDataCompression(inputString, width) =
	 * "a(0,1)(0,2)(0,4)(0,8)(4,12)". In the last example the resulting string
	 * is one character shorter than the input one. It is the shortest possible
	 * example of the efficient work of sliding window compression. If the input
	 * contained even more letters 'a', then the effect of this approach would
	 * be even more considerable.
	 * 
	 * [input] string inputString
	 * 
	 * A non-empty string of lowercase letters. [input] integer width
	 * 
	 * A positive integer. [output] string
	 * 
	 * Compressed inputString.
	 * 
	 * @param inputString
	 * @param width
	 * @return
	 */
	String losslessDataCompression(String inputString, int width) {
		String w = "";
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if (!w.contains("" + inputString.charAt(i))) {
				w += ch;
			} else {
				String s = "";
				if (i > width) {
					s = inputString.substring(i - width, i + width);
				} else {
					s = inputString.substring(0, i - 1);
				}
				if (s.contains("" + ch)) {
					w += "(0," + (i - 1) + ")";
				} else {
					int f = inputString.indexOf(ch);
					if (f > -1) {
						w += "(" + f + "," + 1 + ")";
					}
				}
			}
		}
		return null;
	}

	/**
	 * To set user expectations during file uploads, Dropbox indicates how long
	 * a file will take to transfer with its upload time estimator.
	 * 
	 * Your goal is to implement a particular type of a upload time estimator.
	 * Suppose that several clients are uploading files to Dropbox at the same
	 * given moment. The ith client uploads a file of sizesi megabytes. For a
	 * single file, upload speed is V megabytes per second, but if there are
	 * several files uploading at the same time then uploads occur
	 * simultaneously in parallel threads. For each thread the upload speed
	 * equals V / n, where n is the number of currently active threads.
	 * 
	 * Given each file's size and its upload start time, determine the upload
	 * end times.
	 * 
	 * Example
	 * 
	 * For sizes = [21, 10], uploadingStart = [100, 105] and V = 2
	 * 
	 * the answer is loadTimeEstimator(sizes, uploadingStart, V) = [116, 115].
	 * 
	 * During the first 5 seconds only the first file is uploading at a speed of
	 * 2 MB/sec. Thus, when the second file upload begins, 10 MBs of the first
	 * file will already have been uploaded. For the next 10 seconds both files
	 * upload simultaneously with a speed of 1 MB/sec each. After this point (15
	 * seconds since the first file started uploading) the second file is
	 * uploaded successfully, and only 1 MB of the first file remains to be
	 * transferred. It takes 0.5 more seconds to finish uploading the first
	 * file. Rounding 115.5 up, we obtain 116. [input] array.integer sizes
	 * 
	 * Array of positive integers. sizes[i] equals the size of the ith file in
	 * megabytes. [input] array.integer uploadingStart
	 * 
	 * Array of positive integers of the same length as sizes. uploadingStart[i]
	 * represents the number of seconds that will pass from the current moment
	 * before uploading of the ith file starts. [input] integer V
	 * 
	 * A positive integer. [output] array.integer
	 * 
	 * The ith element of the result should be equal to the number of seconds
	 * that will pass from the current moment before uploading of the ith file
	 * finishes. If the upload takes a non-integer number of seconds, round it
	 * up.
	 * 
	 * @param sizes
	 * @param uploadingStart
	 * @param V
	 * @return
	 */
	int[] loadTimeEstimator(int[] sizes, int[] uploadingStart, int V) {
		// It keeps track file upload time. Actual results are in this array.
		int[] r = new int[sizes.length];
		System.arraycopy(uploadingStart, 0, r, 0, uploadingStart.length);

		// Remaining file size.
		int[] rfs = new int[sizes.length];
		System.arraycopy(sizes, 0, rfs, 0, sizes.length);

		// Arranging files according to their uploading start time.
		int[] ts = new int[uploadingStart.length];
		System.arraycopy(uploadingStart, 0, ts, 0, uploadingStart.length);

		Arrays.sort(ts);

		// contain indexes currently uploading files.
		List<Integer> currentFiles = new ArrayList<Integer>();

		// no of file uploading now.
		int fu = 0;

		int updatedTime = 0;
		// download amount
		double da = 0.00d;
		double as = 0.00d;
		
		for (int i = 0; i < ts.length; i++) {
			// TODO if there are multiple file upload starts at same time.
			int index = Arrays.binarySearch(uploadingStart, ts[i]);

			if (index > -1) {
				currentFiles.add(index);
				fu++;
			}
			// actual download speed
			as = V / fu;

			if (i + 1 < ts.length) {
				int gap = ts[i + 1] - ts[i];
				// during this gap file upload speed will remain same.
				// total download amount in this period.
				da = as * gap;
				updatedTime = ts[i + 1];
			} else {
				// No more files. This upload speed will remain same till file
				// upload value remains same.
				da = as;
				updatedTime++;
			}

			// if file is uploaded then remove its index from currentFiles.
			// rfs[<file index>] == 0
			for (int j = 0; j < currentFiles.size(); j++) {
				if (rfs[currentFiles.get(j)] == 0) {
					// file upload completed. decrement file upload count.
					fu--;
				} else {
					int k = currentFiles.get(j);
					if (da > 0) {
						if (da < rfs[currentFiles.get(j)]) {
							rfs[k] -= da;
							r[k] = updatedTime;
						} else {
							r[k] += (rfs[k] / as);
						}
					}
				}
			}

		}

		// Still there are some files yet to be uploaded completely.
		while (fu > 0) {
			for (int i = 0; i < rfs.length; i++) {
				if (rfs[i] > 0) {
					rfs[i] -= as;
					r[i]++;
				} else {
					// file upload completed reduce file upload count
					fu--;
					// adjust download speed
					if (fu == 0) {
						break;
					}
					as = V /fu;
				}
			}
		}

		return r;
	}
}
