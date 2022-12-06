package tree;

import java.util.HashMap;

public class PreorderAndPostorder {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            hashMap.put(postorder[i], i);
        }
        return construct(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int poStart, int poEnd) {
        if (preStart > preEnd) return null;
        //边界情况，防止index=preStart+1越界
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);

        int rootVal = preorder[preStart];
        //根节点的下一个节点作为左根
        int index = hashMap.get(preorder[preStart + 1]);
        //左子树的大小
        int leftSize = index - poStart + 1;
        TreeNode root = new TreeNode(rootVal);
        root.left = construct(preorder, preStart + 1, preStart + leftSize, postorder, poStart, index);
        root.right = construct(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, poEnd - 1);
        return root;
    }
}
