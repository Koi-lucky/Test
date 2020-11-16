package niuke.jz;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/15 10:52
 */
public class FindPath_24 {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        // 特殊情况判断
        if (root == null || target <= 0) return result;
        // 1.先将此时的根节点加入集合中
        list.add(root.val);
        target -= root.val;// 实时更新一下target的值(每遍历一个节点就减去当前节点的值)
        // 2.判断是否是根节点，并且此时target不断更新，最终值减为0
        if (target == 0 && root.left == null && root.right == null)
            // 如果是正确的路径，就将其加入到结果集合中
            result.add(new ArrayList<>(list));
        // 3.如果不是叶节点，则遍历它的子节点(在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，)
        if (root.left != null) {
            ArrayList<ArrayList<Integer>> result1 = FindPath( root.left, target);
        }
        if (root.right != null) {
            ArrayList<ArrayList<Integer>> result2 = FindPath( root.right, target);
        }
        // 4.返回上一个父节点之前，先在路径上删除当前节点
        list.remove(list.size() - 1);
        return result;
    }
}
