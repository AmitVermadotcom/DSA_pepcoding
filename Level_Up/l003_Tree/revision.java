public class revision{

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

    public static void updateHeightBal(TreeNode root){
        int l = root.left != null ? root.left.height : -1;
        int r = root.right != null ? root.right.height : -1;

        root.height = Math.max(l,r)+1;
        root.bal = l - r;
    }

    public static TreeNode rightRotation(TreeNode A){
        TreeNode B = A.left;
        TreeNode BKaRight = B.right;

        B.right = A;
        A.left = BKaRight;
        updateHeightBal(A);
        updateHeightBal(B);

        return B;
    }

    public static TreeNode leftRotation(TreeNode A){
        TreeNode B = A.right;
        TreeNode BKaLeft = B.left;

        B.left = A;
        A.right = BKaLeft;
        updateHeightBal(A);
        updateHeightBal(B);
        return B;
    }

    public static TreeNode add(TreeNode root,int data){
        if(root == null) return new TreeNode(data);
        if(root.val > data){
            root.left = add(root.left,data);
        }
        else {
            root.right = add(root.right,data);
        }

        return getRotation(root);
    }

    public static TreeNode getRotation(TreeNode root){
        updateHeightBal(root);
        if(root.bal == 2){
            if(root.left == 1){ //ll
                return rightRotation(root);
            }
            else{  //lr
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }
        else if(root.bal == -2){
            if(root.right == 1){ //rl
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
            else{       //rr
                
                return leftRotation(root);
            }
        }
        return root;
    }


    // Morris Traversal

    public static TreeNode getRightMostNode(TreeNode curr,TreeNode node){
        while(node.right != null && node.right != curr) node=node.right;

        return node;
    }

    public static ArrayList<Integer> morrisInTraversal(TreeNode root){
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rightMostNode = getRightMostNode(curr,left);
                if(rightMostNode.right == null){
                    rightMostNode.right=curr;
                    curr = curr.left;
                }
                else{
                    rightMostNode.right=null;
                    ans.add(curr.val);
                    curr=curr.right;

                }
            }
        }

        return ans;
    } 


    public static ArrayList<Integer> morrisPreTraversal(TreeNode root){
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rightMostNode = getRightMostNode(curr,left);
                if(rightMostNode.right == null){
                    rightMostNode.right=curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }
                else{
                    rightMostNode.right=null;
                    curr=curr.right;

                }
            }
        }

        return ans;
    } 


    public static Node bToDLL(Node root) {
        TreeNode curr = root;
        Node prev=new Node(-1);
        Node dummy=prev;
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                prev.right=curr;
                curr.left=prev;
                curr = curr.right;
            }
            else{
                TreeNode rightMostNode = getRightMostNode(curr,left);
                if(rightMostNode.right == null){
                    rightMostNode.right=curr;
                    curr = curr.left;
                }
                else{
                    rightMostNode.right=null;
                    prev.right=curr;
                    curr.left=prev;
                    curr=curr.right;

                }
            }
        }

        prev = dummy.right;
        prev.left=null;
        dummy.right=null;

        return prev;
    }
}