import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, digits, 0, new StringBuilder(), mapping);

        return result;
    }

    private void backtrack(List<String> result,
                           String digits,
                           int index,
                           StringBuilder current,
                           String[] mapping) {

        // base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(result, digits, index + 1, current, mapping);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}