package codility1;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		System.out.println("result:" + solution2("form", "from"));
	}

	////////////////////////////////////////////////////////////////////////////

	final static String solution2(String S, String T) {

		final boolean isSValid = Pattern.compile("[a-z]").matcher(S).find();
		System.out.println(isSValid);
		final boolean isTValid = Pattern.compile("[a-z]").matcher(T).find();
		System.out.println(isTValid);

		final int sizeDifference = Math.abs(S.length() - T.length());
		System.out.println(sizeDifference);
		if (sizeDifference > 1 || !isSValid || !isTValid || S.length() < 1 || S.length() > 100 || T.length() < 1
				|| T.length() > 100) {

			return "IMPOSSIBLE";
		}

		if (S.compareTo(T) == 0) {
			return "NOTHING";
		}

		final String alphabet = "abcdefghijklmnopqrstuvwxyz";

		final String candidateB = new StringBuilder(alphabet.substring(0, 1)).append("ola").toString();
		System.out.println("cb:" + candidateB);

		for (int i = 0; i < S.length() - 1; i++) {
			for (int j = 0; j < alphabet.length(); j++) {
				String candidateT;
				// start of string
				if (i == 0) {
					System.out.println(alphabet.charAt(j));
					candidateT = new StringBuilder(alphabet.substring(j, j + 1)).append(S).toString();
					System.out.println("A i/j/candidate-" + i + "/" + j + "/" + candidateT);
				}
				// end of string
				else if (i == S.length()) {
					candidateT = new StringBuilder(S).append(alphabet.substring(j, j + 1)).toString();
					System.out.println("B i/j/candidate-" + i + "/" + j + "/" + candidateT);
				}
				// middle of string
				else {
					candidateT = new StringBuilder(S.substring(0, i)).append(alphabet.substring(j, j + 1))
							.append(S.substring(i, S.length())).toString();
					System.out.println("C i/j/candidate-" + i + "/" + j + "/" + candidateT);
				}

				if (T.compareTo(candidateT) == 0) {
					System.out.println("T vs candidateT-" + T + "/" + candidateT);
					return "INSERT " + alphabet.charAt(j);
				}
			}
		}

		////////////////////////////////////////////////////////////////////////////

		for (int i = 0; i < S.length() - 1; i++) {
			final String candidateDEL = new StringBuilder(S).deleteCharAt(i).toString();
			if (T.compareTo(candidateDEL) == 0) {
				return "DELETE " + S.charAt(i);
			}

		}

		final String result = "";
		return result;
	}

	////////////////////////////////////////////////////////////////////////////

	final static String SPACE = " ";

	public static String Solution(String s) {
		if (s.length() < 1 || s.length() > 200000) {
			return "";
		}

		final boolean isValid = Pattern.compile("[^a-z]").matcher(s).find();
		if (!isValid) {
			return "";
		}

		final String[] tempString = s.split(SPACE);
		final StringBuilder sBuilder = new StringBuilder();
		for (final String element : tempString) {
			sBuilder.append(new StringBuilder(element).reverse()).append(SPACE);
		}
		final String h = sBuilder.toString().trim();

		return h;
	}

}
