class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n * 2, result);
        return result;
    }

    public void generate(String current, int totalLength, List<String> result) {

        // Base case
        if (current.length() == totalLength) {
            if (isValid(current)) {
                result.add(current);
            }
            return;
        }

        // Add '('
        generate(current + "(", totalLength, result);

        // Add ')'
        generate(current + ")", totalLength, result);
    }

    public boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                count++;
            else
                count--;

            if (count < 0)
                return false;
        }

        return count == 0;
    }
}