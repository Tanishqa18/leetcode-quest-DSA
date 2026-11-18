
import java.util.*;

class Solution {
    int[] parent;
    int[] size;

    public int largestComponentSize(int[] nums) {
        int n = nums.length;

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    if (map.containsKey(factor)) {
                        union(i, map.get(factor));
                    } else {
                        map.put(factor, i);
                    }

                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }

            if (num > 1) {
                if (map.containsKey(num)) {
                    union(i, map.get(num));
                } else {
                    map.put(num, i);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, size[find(i)]);
        }

        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        parent[rootY] = rootX;
        size[rootX] += size[rootY];
    }
}
