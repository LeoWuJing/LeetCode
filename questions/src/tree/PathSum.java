package tree;

/*
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null) return false;
        targetSum-=root.val;
        if(root.left==null&&root.right==null&&targetSum==0) return true;
        return hasPathSum(root.left, targetSum)||hasPathSum(root.right, targetSum);
    }
}
*/

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        dfs(root,targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum){
        if(root==null) return;
        path.add(root.val);
        targetSum-=root.val;
        if(root.left==null&&root.right==null&&targetSum==0){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        //不符合时回退(删除当前加入的节点)
        path.remove(path.size()-1);
    }
}