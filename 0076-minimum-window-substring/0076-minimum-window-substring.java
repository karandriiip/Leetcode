class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency array to count characters in `t`
        int[] freq = new int[58]; // 58 to account for both uppercase and lowercase letters

        // Fill frequency array for characters in `t`
        for (char c : t.toCharArray()) {
            freq[c - 'A']++;
        }

        // Variables for the sliding window
        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        // Start sliding window
        while (right < s.length()) {
            char rightChar = s.charAt(right);

            // If character is needed, reduce its count
            if (freq[rightChar - 'A'] > 0) {
                count--;
            }

            // Decrement the frequency array for the current character
            freq[rightChar - 'A']--;
            right++;

            // When all characters from `t` are in the current window
            while (count == 0) {
                // Update result if the current window is smaller
                if (right - left < minLen) {
                    minLen = right - left;
                    result = s.substring(left, right);
                }

                char leftChar = s.charAt(left);

                // Restore the count in the frequency array
                freq[leftChar - 'A']++;

                // If the restored character was part of `t`, increment `count`
                if (freq[leftChar - 'A'] > 0) {
                    count++;
                }

                left++; // Shrink the window
            }
        }

        return result;
    }
}