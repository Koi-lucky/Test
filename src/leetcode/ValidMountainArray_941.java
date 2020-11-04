package leetcode;

import org.junit.Test;

public class ValidMountainArray_941 {

/*    int[] A = {0,3,2,1};// true
    int[] A = {2,1}; // false*/
    int[] A = {0,1,2,1,2};// false

    @Test
    public void validMountainArray() {
        // 定义一个指针用于遍历数组
        int i = 0;
        // 先进行数组前半部分的【递增】判断
        while (i < A.length - 1) {
            // 判断是否后面那个数的值 > 前面那个数的值
            if (A[i] > A[ i + 1]) {
                break;
            } else if (A[i] == A[i + 1]) {
                System.out.println(false);
                return;
            }
            i++;
        }
        // 如果指针i此时指向数组的开头和数组的结尾，都是不正确的数组，直接返回，不再进行其他判断
        if (i == 0 || i == A.length - 1) {
            System.out.println(false);
            return;
        }
        // 最后进行数组后半部分的【递减】判断
        while (i < A.length - 1) {
            // 判断是否后面那个数的值 < 前面那个数的值
            if (A[i] <= A[ i + 1]) {
                System.out.println(false);
                return;
            }
            i++;
        }
        System.out.println(true);
    }
}
