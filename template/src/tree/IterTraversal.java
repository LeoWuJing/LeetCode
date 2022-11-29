package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterTraversal {
    public List<Integer> preorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null) stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(node!=null){
                stack.pop();
                //入栈：根右左    后序遍历
//                stack.push(node);
//                stack.push(null);
                if(node.right!=null) stack.push(node.right);
                //入栈：右根左    中序遍历
//                stack.push(node);
//                stack.push(null);
                if(node.left!=null) stack.push(node.left);
                stack.push(node);
                stack.push(null);

            }else {
                stack.pop(); //弹出空节点
                node=stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
