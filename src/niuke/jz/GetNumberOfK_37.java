package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/18 21:20
 */
public class GetNumberOfK_37 {

    int[] array = {1,2,3,3,3,3,4,5};
    int k = 3;

    @Test
    public void GetNumberOfK() {
        // 特殊情况
        if (array == null || array.length <= 0) {
            System.out.println(0);
            return;
        }
        int number = 0;// 统计k出现的次数
        // 二分查找思路的变形
        int first = getFirstK( array, k, 0 ,array.length - 1);
        int last = getLastK( array, k, 0 ,array.length - 1);
        if (first > -1 && last > -1) {
            number = last - first + 1;
        }
        System.out.println(number);
    }

    // 找第一个k的位置
    public int getFirstK(int[] array, int k, int start, int end) {
        // 特殊情况判断
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        if (array[middleIndex] == k) {
            // 判断中间值的前一个数是不是K值，若不是，则表示K值第一次出现的位置就是在数组的中间位置
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                // 此时说明，数组的中间值就是K值第一次出现的位置, 或者数组的第一个数就是第一次出现的位置
                return middleIndex;
            } else {
                end = middleIndex - 1;// 否则的话，让末尾指针指向中间位置的前一个位置
            }
        } else if (array[middleIndex] < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getFirstK(array, k, start, end);
    }


    // 找最后一个k的位置
    public int getLastK(int[] array, int k, int start, int end) {
        // 特殊情况判断
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        if (array[middleIndex] == k) {
            // 判断中间值的后一个数是不是K值，若不是，则表示K值最后一次出现的位置在数组的中间值
            if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k) || middleIndex == array.length - 1) {
                // 此时说明，数组的中间值就是K值最后一次出现的位置  或者 数组的最后一个位置就是该数最后一次出现的位置
                return middleIndex;
            } else {
                start = middleIndex + 1;// 否则的话，让开始指针指向中间位置的下一个位置
            }
        } else if (array[middleIndex] < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getLastK(array, k, start, end);
    }
}
