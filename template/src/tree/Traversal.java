package tree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    public List<Integer> orderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left, res);
//        res.add(root.val);
        preorder(root.right, res);
//        res.add(root.val);
    }
}
