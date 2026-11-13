
class Solution {
    public int[] beautifulArray(int n) {
        int[] res = {1};

        while (res.length < n) {
            int[] temp = new int[Math.min(n, res.length * 2)];
            int index = 0;

            for (int x : res) {
                if (2 * x - 1 <= n) {
                    temp[index++] = 2 * x - 1;
                }
            }

            for (int x : res) {
                if (2 * x <= n) {
                    temp[index++] = 2 * x;
                }
            }

            res = temp;
        }

        return res;
    }
}
