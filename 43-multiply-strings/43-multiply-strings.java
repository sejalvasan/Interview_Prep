class Solution {
    public String multiply(String num1, String num2) {
  	int[] ans = new int[num1.length() + num2.length()];

		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {

				int idx1 = i + j;
				int idx2 = i + j + 1; //carry

				int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

				val = val + ans[idx2];

				int quo = val / 10;
				int rem = val % 10;

				ans[idx2] = rem;
				ans[idx1] += quo;

			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ans.length; i++) {
			if (sb.length() == 0 && ans[i] == 0) { //trailing zeroes
				continue;
			}

			sb.append(ans[i]);
		}

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();

	}

}