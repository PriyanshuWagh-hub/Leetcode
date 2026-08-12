class Solution {
    public long maxPairStrength(int[] nums) {

        long max = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                long gcd = gcd(nums[i], nums[j]);

                long strength = (long) nums[i] * nums[j] / (gcd * gcd);

                max = Math.max(max, strength);
            }
        }

        return max;
    }

    public long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}