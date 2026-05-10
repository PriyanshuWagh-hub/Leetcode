class Solution {
    public int reverse(int x) {

        String str = Integer.toString(x);
        String rev = "";

        int start = 0;

        // Handle negative numbers
        if (str.charAt(0) == '-') {
            rev = "-";
            start = 1;
        }

        // Reverse string manually
        for (int i = str.length() - 1; i >= start; i--) {
            rev += str.charAt(i);
        }

        // Convert back to integer
        try {
            return Integer.parseInt(rev);
        } catch (Exception e) {
            return 0; // overflow case
        }
    }
}