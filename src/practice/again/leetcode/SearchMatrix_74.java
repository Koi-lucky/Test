package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/30 21:34
 */
public class SearchMatrix_74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 二分查找算法的应用

        if (matrix.length == 1 && matrix[0].length == 1) return target == matrix[0][0];
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;// 把二维数组想象成一个已经排好序的一维数组
        int[] arr = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = matrix[i][j];
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
