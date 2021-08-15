public class l005morrisTraversal{
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        int bal = 0;
        int height = 0;

        TreeNode(int val) {
            this.val = val;
            this.height = 0;
            this.bal = 0;
        }
    }


    public static TreeNode rightMostNode(TreeNode curr,TreeNode node){
      while(node.right != null && node.right != curr) node=node.right;
      return node;
  }

  public static ArrayList<Integer> morrisInTraversal(TreeNode root) {
      TreeNode curr=root;
      ArrayList<Integer> ans = new ArrayList<>();
      while(curr != null){
          TreeNode left = curr.left;
          if(left == null){  
              ans.add(curr.val);
              curr=curr.right;
          }
          else{
              TreeNode rightMost = rightMostNode(curr,left);
              if(rightMost.right == null){
                  rightMost.right=curr;   //thread creation
                  curr=curr.left;
                  
              }
              else{
                  ans.add(curr.val);    //thread break
                  rightMost.right=null;
                  curr=curr.right;
              }
          }
      }
    return ans;
  }

  public static ArrayList<Integer> morrisPreTraversal(TreeNode root) {
      TreeNode curr=root;
      ArrayList<Integer> ans = new ArrayList<>();
      while(curr != null){
          TreeNode left = curr.left;
          if(left == null){
              ans.add(curr.val);
              curr=curr.right;
          }
          else{
              TreeNode rightMost = rightMostNode(curr,left);
              if(rightMost.right == null){
                  rightMost.right=curr;
                  ans.add(curr.val);
                  curr=curr.left;
                  
              }
              else{
                //   ans.add(curr.val);
                  rightMost.right=null;
                  curr=curr.right;
              }
          }
      }
    return ans;
  }


    // Recursive method
    // T.C = 
    public static boolean isValidBST(TreeNode root) {
        TreeNode[] arr=new TreeNode[1];
        arr[0]=null;
        return isValidBST_(root,arr);
    }
    public static boolean isValidBST_(TreeNode root,TreeNode[] prev) {

      if(root == null) return true;
      if(!isValidBST_(root.left,prev)) return false;

      if(prev[0] != null && prev[0].val > root.val ) return false;
      prev[0] = root;

      if(!isValidBST_(root.right,prev)) return false;
        return true;

    }


    // BST iterator Method

    public static void allLeftNode(TreeNode curr,LinkedList<TreeNode> st){
        while(curr != null){
            st.addLast(curr);
            curr = curr.left;
        }
    }
    
    public static boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        int prev = -(int)1e8;
        Boolean flag=true;
        LinkedList<TreeNode> st = new LinkedList<>();
        allLeftNode(curr,st);

        while(st.size() != 0){
            int size = st.size();
            while(size-->0){
                TreeNode rn = st.removeLast();
                if(rn.val < prev) {
                    return false;
                }
                prev = rn.val;
                if(rn.right != null){
                    allLeftNode(rn.right,st);
                }
            }
        }

        return true;
    }


    // Morris Traversal Method

    public static boolean isValidBST(TreeNode root){
        TreeNode curr = root;
        long prev = -(long)1e18;

        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                if(prev >= curr.val) return false;
                prev=curr.val;
                curr=curr.right;
            }

            else{
                TreeNode rightMost = rightMostNode(curr,left);
                if(rightMost.right == null){
                    rightMost.right=curr;
                    curr=curr.left;
                }

                else{
                    rightMost.right=null;
                    if(prev >= curr.val) return false;
                    prev=curr.val;
                    curr = curr.right;
                }
            }
        }

        return true;
    }





    public static boolean isValidBST(TreeNode root,int k) {
      TreeNode curr=root;
      ArrayList<Integer> ans = new ArrayList<>();
      while(curr != null){
          TreeNode left = curr.left;
          if(left == null){  
              if(--k == 0) return curr.val;
              curr=curr.right;
          }
          else{
              TreeNode rightMost = rightMostNode(curr,left);
              if(rightMost.right == null){
                  rightMost.right=curr;   //thread creation
                  curr=curr.left;
                  
              }
              else{
                 if(left == null){  
                if(--k == 0) return curr.val;    //thread break
                  rightMost.right=null;
                  curr=curr.right;
              }
          }
      }
    return ans;
  }
}