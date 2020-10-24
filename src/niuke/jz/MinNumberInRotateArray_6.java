package niuke.jz;

import org.junit.Test;

public class MinNumberInRotateArray_6 {

    int[] numbers = { 1, 1, 0, 1, 1, 1, 1};

    @Test
    public void minNumberInRotateArray() {
        // 特殊情况判断
        if (numbers == null || numbers.length <= 0) {
            System.out.println(0);
        }
        // 定义双指针
        int left = 0;
        int right = numbers.length - 1;
        int indexMid = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                indexMid = right;
                break;
            }
            indexMid = (left + right) / 2;
            if (numbers[left] == numbers[indexMid] && numbers[left] == numbers[right]) {
                System.out.println(minInOrder(numbers, left, right));
            }
            if (numbers[indexMid] >= numbers[left]) {
                left = indexMid;
            } else if (numbers[indexMid] <= numbers[right]) {
                right = indexMid;
            }
        }
        System.out.println(numbers[indexMid]);
    }


    public int minInOrder(int[] numbers, int index1, int index2) {
        int res = numbers[index1];
        for (int i = index1; i < index2; i++) {
            if (numbers[index1] < res) {
                res = numbers[index1];
            }
        }
        return res;
    }
}
