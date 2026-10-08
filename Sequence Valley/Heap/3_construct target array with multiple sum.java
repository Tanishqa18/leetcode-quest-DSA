class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> maxheap =
            new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int num : target) {
            maxheap.add((long) num);
            sum += num;
        }

        while (true) {
            long largest = maxheap.poll();

            if (largest == 1) {
                return true;
            }

            long rest = sum - largest;

            if (rest == 0) {
                return false;
            }

            if (rest == 1) {
                return true;
            }

            if (largest <= rest) {
                return false;
            }

            long previous = largest % rest;

            if (previous == 0) {
                return false;
            }

            sum = rest + previous;
            maxheap.add(previous);
        }
    }
}
