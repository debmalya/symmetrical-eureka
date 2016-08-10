/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author debmalyajash
 *
 */
public class Reviews {

	static Map<String, List<Reviewer>> passionWiseReviewList = new HashMap<>();

	static Map<Integer, Reviewer> reviewerMap = new HashMap<>();

	static long c1;

	static long c2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar l1 = Calendar.getInstance();
		l1.set(2016, Calendar.JUNE, 15, 12, 0, 0);
		c1 = l1.getTimeInMillis()/1000;
		
		Calendar l2 = Calendar.getInstance();
		l2.set(2016, Calendar.JULY, 15, 12, 0, 0);
		c2 = l2.getTimeInMillis()/1000;
		

		try (Scanner scanner = new Scanner(System.in)) {
			String[] nm = scanner.nextLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);

			String[] p = new String[n];
			String[] original = new String[n];
			for (int i = 0; i < n; i++) {
				p[i] = scanner.nextLine().trim().toLowerCase();
			}

			System.arraycopy(p, 0, original, 0, n);
			Arrays.sort(p);

			for (int i = 0; i < 2 * m; i += 2) {
				String[] rt = scanner.nextLine().split(" ");
				int r = Integer.parseInt(rt[0]);
				long t = 0L;

				t = Long.parseLong(rt[rt.length - 1]);

				Reviewer reviewer = reviewerMap.get(r);
				if (reviewer == null) {
					reviewer = new Reviewer(r);
				}
				Review review = new Review(scanner.nextLine(), p, t);
				reviewer.add(review);
			}

			for (int i = 0; i < n; i++) {
				List<Reviewer> reviewers = passionWiseReviewList.get(original[i]);
				if (reviewers == null) {
					System.out.println("-1");
				} else {
					Collections.sort(reviewers);
					System.out.println(reviewers.get(reviewers.size() - 1).id);
				}
			}
		}

	}

	static class Reviewer implements Comparable<Reviewer> {

		@Override
		public String toString() {
			return "Reviewer [id=" + id + ", reviewList=" + reviewList + ", score=" + score + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reviewer other = (Reviewer) obj;
			if (id != other.id)
				return false;
			return true;
		}

		/**
		 * @param r
		 * @param t
		 * @param nextLine
		 */
		public Reviewer(int r) {
			id = r;
		}

		/**
		 * @param review
		 */
		public void add(Review review) {
			
			int reviewScore = review.score;
			Set<Entry<String, Integer>> allReviews = review.passionCount.entrySet();
			Iterator<Entry<String, Integer>> reviewIterator = allReviews.iterator();
			while (reviewIterator.hasNext()) {
				Entry<String, Integer> nextEntry = reviewIterator.next();
				// e.g. food mentioned more than once.
				List<Reviewer> reviewers = passionWiseReviewList.get(nextEntry.getKey());
				if (reviewers == null) {
					reviewers = new ArrayList<>();
				}
				if (!reviewers.contains(this)) {
					reviewers.add(this);
				}
				passionWiseReviewList.put(nextEntry.getKey(), reviewers);

				if (nextEntry.getValue() > 1) {
					// If a reviewer has more than one review mentioning a specific
					// passion, their expertise score for that passion is the sum of the
					// scores for all their reviews mentioning that specific passion.
					// reviewScore += review.score * (nextEntry.getValue() - 1);
				}

			}
			score += reviewScore;
			reviewList.add(review);

		}

		int id;

		List<Review> reviewList = new ArrayList<>();
		int score = 0;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Reviewer o) {

			if (score > o.score) {
				return 1;
			} else if (score < o.score) {
				return -1;
			} else if (score == o.score) {
				if (id > o.id) {
					return -1;
				} else if (id < o.id) {
					return 1;
				}
			}
			return 0;
		}

	}

	static class Review {

		int score;
		String body;
		long timeStamp;
		Map<String, Integer> passionCount = new HashMap<>();

		public Review(String nextLine, String[] passions, long t) {

			body = nextLine.trim().toLowerCase();
			body = body.replace("!", "");

			if (body.length() >= 100) {
				score += 20;
			} else {
				score += 10;
			}
			timeStamp = t;
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(timeStamp);

			if (t >= c1 && t <= c2) {
				score += 20;
			} else {
				score += 10;
			}
			// if (t >= c1.getTimeInMillis() && t <= c2.getTimeInMillis()) {
			// score += 20;
			// } else {
			// score += 10;
			// }

			List<String> wordList = Arrays.asList(body.split(" "));

			// update passion count
			for (int i = 0; i < wordList.size(); i++) {
				String eachReviewWord = wordList.get(i);
				if (eachReviewWord.endsWith(",")) {
					eachReviewWord = eachReviewWord.substring(0, eachReviewWord.length() - 1);
				}
				if (Arrays.binarySearch(passions, eachReviewWord) > -1) {
					// found
					Integer count = passionCount.get(eachReviewWord);
					if (count == null) {
						count = 0;
					}
					count++;
					passionCount.put(eachReviewWord, count);
				}
			}

		}

		@Override
		public String toString() {
			return "Review [score=" + score + ", body=" + body + ", timeStamp=" + timeStamp + ", passionCount="
					+ passionCount + "]";
		}

	}

}
