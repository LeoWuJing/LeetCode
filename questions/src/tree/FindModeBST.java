package tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeBST {
    List<Integer> res = new ArrayList<>();
    int count = 0, maxCount = 0;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else { //pre!=null&&root.val==pre.val
            count++;
        }
        if (count > maxCount) {
            res.clear();
            res.add(root.val);
        } else if (count == maxCount) {
            res.add(root.val);
        }
        pre = root;
        dfs(root.right);
    }
}
