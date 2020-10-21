package leetcode;

import org.junit.Test;

public class IsLongPressedName_925 {

    String name = "saeed";
    String typed = "ssaaedd";

    /**
     * 思路分析：
     * 1.将两个字符串转为字符数组
     * 2.定义两个指针，分别指向两个数组的头部
     * 3.匹配name数组中的字符，
     *      如果匹配上了，两个指针都后移；
     *      如果没匹配上，判断是不是typed数组当前字符等于前一个字符（也就是长键字符），此时只需要将第二个指针后移
     *      如果上面两种情况都没有，那就返回false
     * 4.最终结果判断，指向name数组的指针的大小 是否等于 name数组的长度
     */
    @Test
    public void isLongPressedName() {
        // 将字符串存在数组中，方便利用下标对其进行操作
        char[] ch1 = name.toCharArray();
        char[] ch2 = typed.toCharArray();
        // 2.定义两个指针，分别指向两个数组的头部
        int left = 0;
        int right = 0;
        // 3.匹配name数组中的字符，
        while (right < ch2.length) {
            if (left < ch1.length && ch1[left] == ch2[right]) {
                // 如果匹配上了，两个指针都后移；
                left++;
                right++;
            } else if (right > 0 && ch2[right] == ch2[right - 1]) {
                // 如果没匹配上，判断是不是typed数组当前字符等于前一个字符（也就是长键字符），此时只需要将第二个指针后移
                right++;
            } else {
                // 如果上面两种情况都没有，那就返回false
                System.out.println(false);
            }
        }
        // 4.最终结果判断，指向name数组的指针的大小 是否等于 name数组的长度
        System.out.println(left == ch1.length);
    }

}
