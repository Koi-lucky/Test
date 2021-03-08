package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 17:05
 */
public class MinArray_11 {

    public static int minArray(int[] numbers) {
        // 二分查找 + 顺序查找（如果有多个相等的数）

        if (numbers.length <= 0) {
            return 0;
        }
        int left = 0,right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                return minNum(numbers,left,right);
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }

    // 编写一个函数 —— 当出现多个相等的数时，用于顺序查找
    public static int minNum(int[] numbers, int left, int right) {
        for (int i = left; i < right; i++) {
            if (numbers[i] < numbers[i + 1]) {
                return numbers[i];
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        // 测试
        int[] numbers = {3,4,5,1,2};
        System.out.println(minArray(numbers));
    }
}
