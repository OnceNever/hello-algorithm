package cn.seeyourface.binaryTree;

import cn.seeyourface.entity.TreeNode;
import sun.misc.Queue;

import java.util.*;

/**
 * <p>
 *     请设计一个函数判断一棵二叉树是否 轴对称 。
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [6,7,7,8,9,9,8]
 * 输出：true
 * 解释：从图中可看出树是轴对称的。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 解释：从图中可看出最后一层的节点不对称。
 * 提示：
 *
 * 0 <= 节点个数 <= 1000
 * </p>
 *
 * @author yangLei
 * @date 2024/12/30 16:00
 * @since 1.0.0
 */
public class Que_145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(7);
        TreeNode root11 = new TreeNode(8);
        TreeNode root12 = new TreeNode(9);
        TreeNode root21 = new TreeNode(8);
        TreeNode root22 = new TreeNode(9);
        root.left = root1;
        root.right = root2;
        root1.left = root11;
        root1.right = root12;
        root2.left = root22;
        root2.right = root21;
        System.out.println(checkSymmetricTree(root));
    }

    public static boolean checkSymmetricTree(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public static Boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}
