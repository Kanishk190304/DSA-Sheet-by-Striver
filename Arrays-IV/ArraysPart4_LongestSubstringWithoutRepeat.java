package ArraysPart4;

import java.util.HashMap;
import java.util.Scanner;

public class ArraysPart4_LongestSubstringWithoutRepeat {
    // Function to find the length of the longest substring without repeating characters
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // To store characters and their last seen index
        int maxLen = 0;

        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                // Move the left pointer to avoid duplicate characters
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right); // Update the character's last seen index
            maxLen = Math.max(maxLen, right - left + 1); // Update max length
            right++;
        }
        return maxLen;
    }

    // Main function to take user input and test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        ArraysPart4_LongestSubstringWithoutRepeat solution = new ArraysPart4_LongestSubstringWithoutRepeat();
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
