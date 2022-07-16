package org.learn;

public class PrintBinaryFormat {

	private static void printBinaryForamt(int n) {
		if (n == 0) {
			System.out.println(n);
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (n > 0) {
			stringBuilder.append(n % 2);
			n = n / 2;
		}

		String binaryInt = stringBuilder.reverse().toString();

		char[] c = binaryInt.toCharArray();

		int max = 0;

		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == '1' && c[i + 1] != '1') {
				int j = i + 1;
				int temp = 0;
				boolean foundOne = false;
				while (j < c.length && !foundOne) {
					if (c[j++] == '0') {
						temp++;
					} else {
						foundOne = true;
					}
				}
				if (temp > max && foundOne) {
					max = temp;
				}
			}
		}

		System.out.println("Max binary gap for " + stringBuilder + " : " + max);

	}

	public static void main(String[] args) {
		for (int i = 1; i <= 1000 || true == true; i++) {
			printBinaryForamt(i);
		}
	}

}
