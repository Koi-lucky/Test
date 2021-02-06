package practice.again.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 18:10
 */
public class FindDuplicate_287 {

    int[] nums = {1,3,4,2,2};

    @Test
    public void findDuplicate() {
        // 哈希表实现
        Set<Integer> set = new HashSet<>();
        for (int value : nums) {
            if (set.contains(value)) {
                System.out.println(value);
                return;
            }
            set.add(value);
        }
        System.out.println(-1);
    }
}
