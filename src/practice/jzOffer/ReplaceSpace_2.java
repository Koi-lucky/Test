package practice.jzOffer;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/5/31 18:59
 */
public class ReplaceSpace_2 {

    public static String replaceSpace (String s) {
        // write code here
        // 为了减少数据的移动次数，从后向前遍历

        // 特殊情况
        if (s.length() < 1) {
            return "";
        }
        // 确定新数组的长度 —— 先确定字符串中空格的个数，再确定新数组的长度
        int countS = 0, newLen = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                countS++;
            }
        }
        newLen = newLen + countS * 2;
        char[] ch = new char[newLen];
        // 遍历字符串，从后往前遍历，双指针法解决
        int left = s.length() - 1, right = newLen - 1;
        while (left >= 0 && right >= 0) {
            char temp = s.charAt(left);
            if (temp == ' ') {
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right--] = '%';
            } else {
                ch[right--] = temp;
            }
            left--;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        // 测试
        String s = "We Are Happy";
        System.out.println(replaceSpace(s));
    }
}
