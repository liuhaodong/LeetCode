package leetCode;

import java.util.HashMap;

public class RomanToNum {
	public int romanToInt(String s) {
		HashMap<Character, Integer> roman = new HashMap<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		int sum = 0;
		char last = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0) {
				last = s.charAt(i - 1);
			}
			String current = Character.toString(last) + s.charAt(i);
			if (current.equals("IV")) {
				sum += 3;
			} else if (current.equals("IX")) {
				sum += 8;
			} else if (current.equals("XL")) {
				sum += 30;
			} else if (current.equals("XC")) {
				sum += 80;
			} else if (current.equals("CD")) {
				sum += 300;
			} else if (current.equals("CM")) {
				sum += 800;
			} else {
				sum = sum + roman.get(s.charAt(i));
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new RomanToNum().romanToInt("MMXIV"));
	}
}
