package niuke.面经;

import org.junit.Test;

public class Merge_22 {

    int[] A = new int[8];
    int[] B = new int[2];
    int m = 2;
    int n = 2;

    /**
     * 题目：给出两个有序的整数数组 A和 B，请将数组 B合并到数组 A中，变成一个有序的数组
     * 注意：可以假设 A数组有足够的空间存放 B数组的元素， AB和 中初始的元素数目分别为m和 n
     * 思路分析：
     * 1.双指针法 —— 左指针指向A数组尾部，右指针指向B数组尾部
     * 2.循环用数组下标遍历数组
     *      如果左指针所指向的A数组的值 >= 右指针所指向的B数组的值，将左指针所指向的A数组的值转移至A数组的最末尾,再进行 左指针前移操作
     *      如果左指针所指向的A数组的值 < 右指针所指向的B数组的值，将右指针所指向的B数组的值转移至A数组的最末尾，再进行右指针前移操作
     */
    @Test
    public void merge() {
        // 1.双指针法 —— 左指针指向A数组尾部，右指针指向B数组的尾部，
        int left = m - 1;
        int right = n - 1;
        int index = n + m - 1;
        // 让左指针的值 与 右指针的值进行比较，
        while (left >= 0 && right >= 0) {
            // 如果 左 > 右，将左边的数移至新数组的最末尾
            if (A[left] >= B[right]) {
                A[index--] = A[left--];
            } else {
                // 如果 右 > 左，将右边的数移至新数组的末尾
                A[index--] = B[right--];
            }
        }
        // 若此时B数组还未遍历完，则直接加在数组前面
        while(right >= 0) {
            A[index--] = B[right--];
        }
        // 输出A数组
        for (int val : A) {
            System.out.println(val);
        }
    }
}
