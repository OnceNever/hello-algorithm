package cn.seeyourface.entity;

/**
 * <p></p>
 *
 * @author yangLei
 * @date 2024/12/30 15:56
 * @since 1.0.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
