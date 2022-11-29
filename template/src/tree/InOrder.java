package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            //找到最底层的左孩子
            while (root != null) {
                stack.push(root);
                root = root.left; //左
            }
            //左孩子的上一个为根节点
            //左孩子为空就遍历右孩子，左右都为空就向上遍历(根节点)
            root = stack.pop();
            res.add(root.val); //中
            root = root.right; //右
        }
        return res;
    }
}
