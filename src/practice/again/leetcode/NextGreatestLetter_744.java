package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/2 21:47
 */
public class NextGreatestLetter_744 {

    char[] letters = {'a','b','c'};
    char target = 'z';

    @Test
    public void nextGreatestLetter() {
        // 二分查找法

        int i = 0, j = letters.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        // 如果循环结束之后没找着比他还大的字符，则返回字符数组第一个字符
        System.out.println(i < letters.length ? letters[i] : letters[0]);
    }
}
