package niuke.jz;

import org.junit.Test;

public class Find_1 {

    int target = 7;
    int[][] array = {
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
    };

    @Test
    public void Find() {
        // 定义两个指针用于操作数组
        int i = 0;
        int j = array[0].length - 1;
        while (array.length > 0 && i < array.length && j >= 0) {
            // 从左上角开始判断
            // 如果左上角的值 > target ,则删除最右边那一列 （因为左上角的值已经是最后边那一列的min，最小值都已经 > target，后面就不用判断）
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                // 如果左上角的值 < target ,则删除最上面那一行 （因为左上角的值已经是最上面那一行的max，最大值都已经 < target，后面就不用判断）
                i++;
            } else {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
