/**
 * Created by Nikhil on 11/19/16.
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

/**
 * Inspired from https://github.com/coder-pft/Algorithms-in-Java/commit/479a42fdbbf4303d89beef8df9e270a29580110d
 */
public class ContainedWithMostWater {
    public int maxArea(int[] height) {
        int l = height.length;
        int low = 0;
        int high = l - 1;
        int max = 0;
        while (low < high) {
            int lowHeight = height[low] < height[high] ? height[low] : height[high];
            max = Math.max(max, lowHeight * (high - low));
            if (height[low] < height[high]) {
                while (low < high && height[low] <= lowHeight) low++;
            } else {
                while (high > low && height[high] <= lowHeight) high--;
            }
        }
        return max;

    }
}
