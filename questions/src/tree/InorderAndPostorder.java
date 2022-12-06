package tree;

import java.util.HashMap;

public class InorderAndPostorder {
    HashMap<Integer, Integer> hashMap=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        for(int i=0;i<n;i++){
            hashMap.put(inorder[i], i);
        }
        return build(inorder, 0, n-1, postorder, 0, n-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd){
        if(poStart>poEnd) return null;

        int rootVal=postorder[poEnd];
        int index=hashMap.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        int rightSize=inEnd-index;
        root.left=build(inorder, inStart, index-1, postorder, poStart, poEnd-rightSize-1);
        root.right=build(inorder, index+1, inEnd, postorder, poEnd-rightSize, poEnd-1);
        return root;
    }
}
