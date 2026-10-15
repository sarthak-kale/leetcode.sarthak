class Solution {
public int maxArea(int[] height) {
int maxwater = 0;
int left = 0;
int right = height.length - 1;
    while (left < right) {
        int width = right - left;

        int cheight = Math.min(height[left], height[right]);

        int area = width * cheight;

        maxwater = Math.max(maxwater, area);

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxwater;
}
}

