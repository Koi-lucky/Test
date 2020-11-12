package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/11 22:17
 */
public class ReOrderArray_13 {

    int[] array = {1,2,3,4,5};

    @Test
    public void reOrderArray() {
        // 特殊情况判断
        if (array == null) {
            return;
        }
        // 1.定义两个指针用于扫描数组，一个指向数组的开始，一个指向数组的末尾
        int indexLeft = 0;
        int indexRight = array.length - 1;
        // 2.遍历数组
        while (indexLeft < indexRight) {
            // 如果左指针指向的数据是奇数，则指针右移
            if (!isEven(array[indexLeft])) {
                indexLeft++;
            }
            // 如果右指针指向的数据是偶数，则指针左移
            if (isEven(array[indexRight])) {
                indexRight--;
            }
            // 否则的话，交换左右指针的数值
            if (indexLeft < indexRight) {
                int temp = array[indexLeft];
                array[indexLeft] = array[indexRight];
                array[indexRight] = temp;
            }
        }
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }

    // 具体的操作 —— 判断一个数是否是偶数（用位操作判断）
    public boolean isEven(int number) {
        // 位操作判断该数是不是偶数
        return (number & 1) == 0 ;
    }
}
