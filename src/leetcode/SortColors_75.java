package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SortColors_75 {

    int[] nums = { 2, 0, 2, 1, 1, 0, 2, 1};

    /**
     * 方法一：单指针
     * 思路分析：
     * 1.定义一个指针用于记录数在数组中的下标
     * 2.遍历两次数组，第一次把所有的0放在数组前面，第二次把所有的1放在0的后面，这样2就自然在1的后面了
     *  2.1 第一次遍历数组，把所有的0放在数组的最前面，让0来做数组的头，同时让指针index不断后移来记录位置，最终index+1就代表了数组头（0）的长度
     *  2.2 第二次遍历数组，把所有的1放在0的后面，同时让index不断的后移，最终2自然就都在1的后面了
     */
    @Test
    public void sortColors1() {
        // 1.定义一个指针，用于记录数在数组中的下标位置
        int index = 0;
        // 2.第一次遍历数组
        // 把所有的0都移到数组前面，来做数组的头，index不断地后移代表了数组头的长度
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];// 定义一个临时变量用于做两数交换的“桥梁”
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        // 3.第二次遍历数组
        // 把所有的1都移到0的后面，index不断地后移，这样1之后的数就都是2了
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];// 定义一个临时变量用于做两数交换的“桥梁”
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 方法二：双指针
     * 思路分析：
     * 1.定义两个指针，左指针用于记录0的下标，由指针用来记录2的下标
     * 2.遍历一次数组，让左右指针找0或2，进行交换，将对应的左指针右移、右指针左移
     */
    @Test
    public void sortColors2() {
        // 1.定义两个指针，左指针用于记录0的下标，由指针用来记录2的下标
        int index1 = 0;
        int index2 = nums.length - 1;
        // 2.遍历一次数组，让左右指针找0或2，进行交换，将对应的左指针右移、右指针左移
        // 数组的边界条件必须是 【i<=index2】,（动态变化的边界条件）
        // 因为每次找到一个2都会放到数组的后面，右指针都会发生左移，所以每找到一个2，实际未排序的数组长度都会减一
        // 直到找到所有的2之后，数组的长度就变成了index2+1，数组最末尾的下标就是index2
        for(int i = 0; i <= index2; i++) {
            // 找出所有的2，移至数组的最后面，与此同时数组的右指针左移
            while ( i <= index2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[index2];
                nums[index2] = temp;
                index2--;
            }
            // 在所有的2摆放完毕后，再找所有的1，移至数组的最前面
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[index1];
                nums[index1] = temp;
                index1++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
