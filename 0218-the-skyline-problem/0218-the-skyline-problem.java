class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] building : buildings) {
            events.add(new int[]{building[0], -building[2]});
            events.add(new int[]{building[1], building[2]});
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);

        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;

        for (int[] event : events) {
            int x = event[0];
            int height = event[1];

            if (height < 0) {
                maxHeap.add(-height);
            } else {
                maxHeap.remove(height);
            }

            int currHeight = maxHeap.peek();

            if (currHeight != prevHeight) {
                result.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}