package tree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;
        if (depth == 1) return new TreeNode(val, root, null);
        if (depth == 2) {
            root.left=new TreeNode(val, root.left, null);
            root.right=new TreeNode(val, null, root.right);
        }else {
            root.left=addOneRow(root.left, val, depth-1);
            root.right=addOneRow(root.right, val, depth-1);
        }
        return root;
    }
}


/*
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth){
        if(depth==1){
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            depth--;
            if(depth==1){
                for(int i=queue.size();i>0;i--){
                    TreeNode node=queue.poll();
                    node.left=new TreeNode(val, node.left, null);
                    node.right=new TreeNode(val, null, node.right);
                }
                return root;
            }
            for(int i=queue.size();i>0;i--){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return root;
    }
}
*/
