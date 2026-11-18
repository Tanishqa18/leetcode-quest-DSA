
class Solution {
    int[] parent;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];

            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                result[i] = true;
                continue;
            }

            boolean valid = true;

            for (int[] r : restrictions) {
                int x = find(r[0]);
                int y = find(r[1]);

                if ((x == rootU && y == rootV) ||
                    (x == rootV && y == rootU)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                parent[rootU] = rootV;
                result[i] = true;
            }
        }

        return result;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}
