package com.algorithms.string;

/**
 * @author fanbo@imoran.net
 * @date 2021/3/28 5:17
 */
public class IsValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        for (; i < j; ++i, --j) {
            while (!isAlaphNums(s.charAt(i)) && i < j) {
                ++i;
            }
            while (!isAlaphNums(s.charAt(j)) && i < j) {
                --j;
            }
            System.out.println(s.charAt(i) + " --- " + s.charAt(j));
            if (!isEqualEgnoreCase(s.charAt(i), s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    private boolean isEqualEgnoreCase(char x, char y) {
        if (x >= 'A' && x <= 'Z') {
            x += 32;
        }
        if (y >= 'A' && y <= 'Z') {
            y += 32;
        }
        return x == y;
    }

    private boolean isAlaphNums(char x) {
        if ((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z') || (x >= '0' && x <= '9')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        IsValidPalindrome sln = new IsValidPalindrome();
        if (sln.isPalindrome(s1)) {
            System.out.println("equal...");
        } else {
            System.out.println("unequal...");
        }
    }
}
