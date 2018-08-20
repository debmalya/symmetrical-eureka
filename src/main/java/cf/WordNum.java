package cf;

public class WordNum {

	int word2Num(String str) {
		str = str.toLowerCase();
		str = str.replace("million", "million,");
		str = str.replace("thousand", "thousand,");
		String[] arr  = str.split(",");
		int num = 0;
		for (String e:arr){
			num += word2Num1(e);
		}
		return num;
	}

	int word2Num1(String str) {
		String[] arr = str.toLowerCase().split("\\s");
		int num = 0;
		for (String e : arr) {
			String[] ea = e.split("-");
			for (String ea1 : ea) {
				num = eachWord(ea1, num);
				System.out.println(num);
			}

		}
		return num;
	}

	public int eachWord(String each, int num) {

		switch (each) {
		case "one":
			return num + 1;
		case "two":
			return num + 2;
		case "three":
			return num + 3;
		case "four":
			return num + 4;
		case "five":
			return num + 5;
		case "six":
			return num + 6;
		case "seven":
			return num + 7;
		case "eight":
			return num + 8;
		case "nine":
			return num + 9;
		case "ten":
			return num + 10;
		case "eleven":
			return num + 11;
		case "twelve":
			return num + 12;
		case "thirteen":
			return num + 13;
		case "fourteen":
			return num + 14;
		case "fifteen":
			return num + 15;
		case "sixteen":
			return num + 16;
		case "seventeen":
			return num + 17;
		case "eighteen":
			return num + 18;
		case "nineteen":
			return num + 19;
		case "twenty":
			return num + 20;
		case "thirty":
			return num + 30;
		case "forty":
			return num + 40;
		case "fifty":
			return num + 50;
		case "sixty":
			return num + 60;
		case "seventy":
			return num + 70;
		case "eighty":
			return num + 80;
		case "ninety":
			return num + 90;
		case "hundred":
			return num * 100;
		case "thousand":
			return num * 1000;
		case "million":
			return num * 1000000;
		case "billion":
			return num * 1000000000;

		default:
			return num;
		}
	}
}
