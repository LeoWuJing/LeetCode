package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicate {
    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    String dfs(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",").append(dfs(root.left)).append(",").append(dfs(root.right));
        String s = sb.toString();
        int freq = map.getOrDefault(s, 0);
        //多次重复也只加入一次
        if (freq == 1) res.add(root);
        map.put(s, freq + 1);
        return s;
    }
}
