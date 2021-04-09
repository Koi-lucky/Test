package practice.again.com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/9 19:04
 */
public class Main {

    public static void main(String[] args) {
        // 键盘键入
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        int index = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = index;
            index++;
        }
        // 输入k行数据，每行有两个数，用空格隔开
        for (int i = 0; i < k; i++) {
            int t1 = input.nextInt();
            int t2 = input.nextInt();
            // 翻转操作
            resverseArray(arr, t1 - 1, t2 - 1);
        }
        // 结果值输出
        System.out.println(Arrays.toString(arr));

        input.close();
    }


    // 编写一个函数用于进行数组某个区间内数的反转操作
    public static void resverseArray(int[] arr, int i, int j) {
        // 特殊情况判断
        if (i >= j ) {
            return;
        }
        // 反转的操作
        int k = i, m = j;
        while (k <= m) {
            int temp = arr[k];
            arr[k] = arr[m];
            arr[m] = temp;
            k++;
            m--;
        }
    }
}
