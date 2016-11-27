/**
 * Created by Nikhil on 11/26/16.
 */

import java.util.*;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * Return: [1,1],[1,1]
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3
 * Return: [1,3],[2,3]
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]L
 */
public class FindKPairswithSmallestSums {
    class Pairs {
        int x;
        int y;

        Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pairs> priorityQueue = new PriorityQueue<Pairs>(k, new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return (o2.x+o2.y)-(o1.x+o1.y);
            }

        });
        for (int row = 0; row < nums1.length; row++) {
            for (int col = 0; col < nums2.length; col++) {
                priorityQueue.add(new Pairs(nums1[row], nums2[col]));
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }

            }
        }
        List<int[]> result = new ArrayList<>(k);
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            Pairs temp = (Pairs) it.next();
            int[] point = {temp.x, temp.y};
            result.add(0, point);
        }

        return result;
    }
}


