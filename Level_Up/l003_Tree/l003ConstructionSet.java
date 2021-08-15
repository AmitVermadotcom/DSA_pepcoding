import java.util.*;

public class l003ConstructionSet{
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    // bst from preOrder
    public static int idx=0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder,-(int)1e8,(int)1e8);
    }
    public static TreeNode bstFromPreorderHelper(int[] preorder,int min,int max) {
        if(i >= preorder.length) return null;
        if(preorder[idx] > max || preorder[idx] < min) return null;
        TreeNode node = new TreeNode(preorder[idx]);
        idx++;
        node.left = bstFromPreorderHelper(preorder,min,node.val);
        node.right = bstFromPreorderHelper(preorder,node.val,max);
        return node;
    }

    // bst from postOrder
    public static int idx=0;
    public static TreeNode bstFromPostorder(int[] preorder) {
        idx=preorder.length-1;
        return bstFromPostorderHelper(preorder,-(int)1e8,(int)1e8);
    }
    public static TreeNode bstFromPostorderHelper(int[] preorder,int min,int max) {
        if(idx < 0) return null;
        if(preorder[idx] > max || preorder[idx] < min) return null;
        TreeNode node = new TreeNode(preorder[idx]);
        idx--;
        node.right = bstFromPostorderHelper(preorder,node.val,max);
        node.left = bstFromPostorderHelper(preorder,min,node.val);
        return node;
    }


    public static TreeNode constructFromInOrder(int[] inOrder) {
        return constructFromInOrderHelper(inOrder,0,inOrder.length-1);
    }

    public static TreeNode constructFromInOrderHelper(int[] inOrder,int si,int ei){
        if(si > ei) return null;

        int mid = (si + ei) /2;
        TreeNode node = new TreeNode(inOrder[mid]);
        node.left = constructFromInOrderHelper(inOrder,si,mid-1);
        node.right = constructFromInOrderHelper(inOrder,mid+1,ei);

        return node;
    }

    public static class bstlPair{
        TreeNode node=null;
        int lr;
        int rr;
        bstlPair(TreeNode node,int min,int max){
            this.node=node;
            this.lr=min;
            this.rr=max;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder){
        if(LevelOrder.length == 0) return null;

        LinkedList<bstlPair> que = new LinkedList<>();
        TreeNode root=new TreeNode(LevelOrder[0]);
        que.addLast(new bstlPair(root,-(int)1e8,(int)1e8));

        while(idx < LevelOrder.lenth){
            bstlPair rp = que.removeFirst();
            if(rp.lr > LevelOrder[idx] || rp.rr < LevelOrder[idx]) continue;
            TreeNode curr = new TreeNode(LevelOrder[idx++]);
            if(curr.val < rp.node.val){
                rp.node.left=curr;
            }
            else{
                rp.node.right=curr;
            }
            que.addLast(new bstlPair(curr,rp.lr,curr.val));
            que.addLast(new bstlPair(curr,curr.val,rp.rr));
        }
        return root;
    }
    // 



    // Binary tree from inorder and preorder

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
    public static TreeNode helper(int[] pre,int psi,int pei,int[] in,int isi,int iei){
        if(isi > iei) return null;
        int idx = isi;
        while(in[idx] != pre[psi]) idx++;
        int tel = idx - isi;
        TreeNode node=new TreeNode(pre[psi]);

        node.left = helper(pre,psi+1,psi+tel,in,isi,idx-1);
        
        node.right = helper(pre,psi+tel+1,pei,in,idx+1,iei);
        return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(postorder,0,n-1,inorder,0,n-1);
    }
    public static TreeNode helper(int[] post,int psi,int pei,int[] in,int isi,int iei){
        if(isi > iei) return null;
        int idx = isi;
        while(in[idx] != post[pei]) idx++;
        int tel = idx - isi;
        TreeNode node=new TreeNode(post[pei]);

        node.left = helper(post,psi,psi+tel-1,in,isi,idx-1);
        
        node.right = helper(post,psi+tel,pei-1,in,idx+1,iei);
        return node;
    }

}