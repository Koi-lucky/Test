package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/3 14:24
 */
public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        // 二分查找法解决
        // 如果第m个版本是错的，则第一个错的版本在[1,m]之间【因为mid==m,所以循环的条件left < right】
        // 否则的话，就在[m+1,n]之间

        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) { return false;}
}
