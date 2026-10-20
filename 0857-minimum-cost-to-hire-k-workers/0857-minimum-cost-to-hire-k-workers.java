class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int[][] workers = new int[n][2];

        for (int i = 0; i < n; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }

        Arrays.sort(workers, (a, b) -> 
            Double.compare((double) a[1] / a[0], (double) b[1] / b[0])
        );

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;

        for (int[] worker : workers) {
            int q = worker[0];
            int w = worker[1];

            totalQuality += q;
            maxHeap.offer(q);

            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                double ratio = (double) w / q;
                minCost = Math.min(minCost, totalQuality * ratio);
            }
        }

        return minCost;
    }
}