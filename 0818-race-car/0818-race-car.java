class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 1, 0});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int position = state[0];
            int speed = state[1];
            int steps = state[2];

            if (position == target) {
                return steps;
            }

            int nextPosition = position + speed;
            int nextSpeed = speed * 2;
            String accelerateState = nextPosition + "," + nextSpeed;

            if (Math.abs(nextPosition) <= 2 * target &&
                !visited.contains(accelerateState)) {
                visited.add(accelerateState);
                queue.offer(new int[]{nextPosition, nextSpeed, steps + 1});
            }

            int reverseSpeed = speed > 0 ? -1 : 1;
            String reverseState = position + "," + reverseSpeed;

            if (!visited.contains(reverseState)) {
                visited.add(reverseState);
                queue.offer(new int[]{position, reverseSpeed, steps + 1});
            }
        }

        return -1;
    }
}