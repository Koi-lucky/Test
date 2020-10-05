package leetcode;

import org.junit.Test;

import java.util.*;

public class FourSum_18 {

    int[] nums = { 1, 0, -1, 0, -2, 2};
    int target = 0;

    /**
     * 方法一：暴力法(O(n^4))
     * 思路分析：
     * 1.定义一个列表集合list1，用于存储和值为target的四个数的组合
     * 2.定义一个列表集合list2，用于存储多个list1
     * 3.定义一个set集合，用于过滤list2
     * 4.先判空
     * 5.四重循环
     *     5.1 在最小的那层循环中，初始化list1，获取每一个符合目标的组合
     *     5.2 每初始化一个list1，就添加进set（获取所有的list1，并过滤）
     * 6.将过滤后的组合赋给list2，再输出
     */
    @Test
    public void fourSum1() {
        // 1.定义一个列表集合list1，用于存储和值为target的四个数的组合
        List<Integer> list1 = null;
        // 2.定义一个列表集合list2，用于存储多个list1
        List<List<Integer>> list2 = new ArrayList<>();
        // 3.定义一个set集合，用于过滤list2
        Set<List<Integer>> set = new HashSet<>();
        // 4.先判空
        if (nums.length < 4 || nums == null) {
            System.out.println(list2);
        }
        // 5.四重循环
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        //  5.1 在最小的那层循环中，初始化list1，获取每一个符合目标的组合
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            list1 = new ArrayList<Integer>();
                            list1.add(nums[i]);
                            list1.add(nums[j]);
                            list1.add(nums[k]);
                            list1.add(nums[l]);
                            //  5.2 每初始化一个list1，就添加进set（获取所有的list1，并过滤）
                            Collections.sort(list1);//给列表排序，方便下一步的过滤
                            set.add(list1);
                        }
                    }
                }
            }
        }
        // 6.将过滤后的组合赋给list2，再输出
        for (List<Integer> integerList : set) {
            list2.add(integerList);
        }
        System.out.println(list2);
    }


    /**
     * 方法二：排序 + 双指针（O（n^3））
     * 思路分析：
     * 1.定义一个列表集合，用于存储多个四个数的组合
     * 2.先判空，再数组排序
     * 3.三层循环（前面两个数各一层循环，后面两个数一层循环）+ 【双指针 (左右指针分别指向下标 j+1和下标 n-1)】 + 【剪枝 (也就是下面的四点)】
     *      3.1 在确定第一个数之后，如果 nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于 target，因此退出第一重循环；
     *      3.2 在确定第一个数之后，如果 nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于 target，因此第一重循环直接进入下一轮，枚举 nums[i+1]；
     *      3.3 在确定前两个数之后，如果 nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明此时剩下的两个数无论取什么值，四数之和一定大于 target，因此退出第二重循环；
     *      3.4 在确定前两个数之后，如果 nums[i]+nums[j]+nums[n-1]+nums[n-2]<target，说明此时剩下的两个数无论取什么值，四数之和一定小于 target，因此第二重循环直接进入下一轮，枚举 nums[j+1]。
     *      3.5 计算四个数的和并判断
     *          如果和等于 target，则将枚举到的四个数加到答案中，然后将左指针右移直到遇到不同的数，将右指针左移直到遇到不同的数；
     *          如果和小于 target，则将左指针右移一位；
     *          如果和大于 target，则将右指针左移一位。
     *
     * 【注意】
     *          每一种循环枚举到的下标必须大于上一重循环枚举到的下标；
     *          同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素。
     */
    @Test
    public void fourSum2() {
        // 1.定义一个列表集合，用于存储多个四个数的组合
        List<List<Integer>> list = new ArrayList<>();
        // 2.先判空，再数组排序
        if (nums.length < 4 || nums == null) {
            System.out.println(list);
        }
        Arrays.sort(nums);
        // 3.三层循环（前面两个数各一层循环，后面两个数一层循环）+ 【双指针】 + 【剪枝】
        // 第1层循环
        for (int i = 0; i < nums.length - 3; i++) {
            //防止有相等的的数被重复利用
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 3.1 在确定第一个数之后，如果 nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，
            // 说明此时剩下的三个数无论取什么值，四数之和一定大于 target，因此退出第一重循环；
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 3.2 在确定第一个数之后，如果 nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target，
            // 说明此时剩下的三个数无论取什么值，四数之和一定小于 target，因此第一重循环直接进入下一轮，枚举 nums[i+1]；
            if (nums[i] + nums[nums.length - 3] + nums[nums.length -  2] + nums[nums.length -  1] < target) {
                continue;
            }
            // 第2层循环
            for (int j = i + 1; j < nums.length - 2; j++) {
                //同一层中，防止有相等的数被重复利用
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 3.3 在确定前两个数之后，如果 nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，
                // 说明此时剩下的两个数无论取什么值，四数之和一定大于 target，因此退出第二重循环；
                if ( nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 3.4 在确定前两个数之后，如果 nums[i]+nums[j]+nums[n-1]+nums[n-2]<target，
                // 说明此时剩下的两个数无论取什么值，四数之和一定小于 target，因此第二重循环直接进入下一轮，枚举 nums[j+1]。
                if ( nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                // 第3层循环：双指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //  3.5 计算四个数的和并判断
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        // 如果和等于 target，则将枚举到的四个数加到答案中，然后将左指针右移直到遇到不同的数，将右指针左移直到遇到不同的数；
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 同一层中，防止有相等的数被重复的利用
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < right) {
                        // 如果和小于 target，则将左指针右移一位；
                        left++;
                    } else {
                        //  如果和大于 target，则将右指针左移一位。
                        right--;
                    }
                }
            }
        }
        System.out.println(list);
    }

    /**
     * 【官方题解答案】 和 【方法二】 答案不一致????
     */
    @Test
    public void fourSum3() {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                System.out.println(quadruplets);
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            System.out.println(quadruplets);
    }

}
