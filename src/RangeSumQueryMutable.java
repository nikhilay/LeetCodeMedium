/**
 * Created by Nikhil on 12/20/16.
 */

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */
public class RangeSumQueryMutable {
    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;


        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
        }
    }

    SegmentTreeNode root;

    public RangeSumQueryMutable(int[] nums) {
        root = buildSegmnetTree(nums, 0, nums.length - 1);

    }

    private SegmentTreeNode buildSegmnetTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode n = new SegmentTreeNode(start, end);
        if (start == end) {
            n.sum = nums[start];
        } else {

            int mid = start + (end - start) / 2;
            n.left = buildSegmnetTree(nums, start, mid);
            n.right = buildSegmnetTree(nums, mid + 1, end);
            n.sum = n.left.sum + n.right.sum;
        }
        return n;
    }

    void update(int i, int val) {

        updateSegmentTree(root, i, val);

    }

    private void updateSegmentTree(SegmentTreeNode node, int pos, int value) {
        if (node.start == pos && node.end == pos) {
            node.sum = value;
            return;SM
        }
        int mid = node.start + (node.end - node.start) / 2;

        if (pos <= mid) {
            updateSegmentTree(node.left, pos, value);
        } else {
            updateSegmentTree(node.right, pos, value);
        }
        node.sum = (node.left==null?0:node.left.sum) + (node.right==null?0:node.right.sum);
    }

    public int sumRange(int i, int j) {
        return findSumRange(root, i, j);

    }

    private int findSumRange(SegmentTreeNode node, int qstart, int qend) {
        if (node.start == qstart && node.end == qend) return node.sum;
        int mid = node.start + (node.end - node.start) / 2;
        if (qend <= mid) {
            return findSumRange(node.left, qstart, qend);
        } else if (qstart > mid) {
            return findSumRange(node.right, qstart, qend);
        } else {
            return findSumRange(node.left, qstart, mid) + findSumRange(node.right, mid + 1, qend);
        }

    }
}
