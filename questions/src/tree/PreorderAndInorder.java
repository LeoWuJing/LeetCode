package tree;

import java.util.HashMap;

public class PreorderAndInorder {
    HashMap<Integer, Integer> hashMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n=inorder.length;
        for(int i=0;i<n;i++){
            hashMap.put(inorder[i], i);
        }
        return build(preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd) return null;

        int rootVal=preorder[preStart];
        int index=hashMap.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        //更新后的索引
        int leftSize=index-inStart;
        root.left=build(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1);
        root.right=build(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd);
        return root;
    }
}
