package practice.again.jz;

import org.junit.Test;

import java.util.HashSet;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/4 21:01
 */
public class FindRepeatNumber_3 {

    int[] nums = {2, 3, 1, 0, 2, 5, 3};

    @Test
    public void findRepeatNumber() {
        HashSet<Integer> set = new HashSet<>();
        //设置一个变量，当遇到重复的元素时，就将该元素的值赋给这个变量
        int repeat = -1;
        for (int i = 0; i < nums.length; i++) {
            //遍历数组中的每个元素：
            //将该元素加入集合中，判断是否添加成功
            //如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，将该元素的值赋给 repeat，并结束遍历
            if(!set.add(nums[i])) {
                repeat = nums[i];
                break;
            }
        }
        System.out.println(repeat);
    }
}
