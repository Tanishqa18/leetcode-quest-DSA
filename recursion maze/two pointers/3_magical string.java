
class Solution {
    public int magicalString(int n) {
        if (n == 1) {
            return 1;
        }

        if (n <= 3) {
            return 1;
        }

        int[] s = new int[n];

        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int count = 1;
        int i = 2;
        int j = 3;
        int num = 1;

        while (j < n) {
            int repeat = s[i];

            for (int k = 0; k < repeat && j < n; k++) {
                s[j] = num;

                if (num == 1) {
                    count++;
                }

                j++;
            }

            num = 3 - num;
            i++;
        }

        return count;
    }
}
