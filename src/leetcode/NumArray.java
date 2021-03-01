package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/1 20:18
 */
public class NumArray {

    int[] arr;

    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
    }

    // 因为sumRange()方法要调用无数次，为了降低时间复杂度，就必须将其时间复杂度为O（1）—— 也就意味着必须在初始化里面进行计算和
    public int sumRange(int i, int j) {
        return arr[j + 1] - arr[i];
    }
}
