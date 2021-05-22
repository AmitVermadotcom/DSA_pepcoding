import java.util.ArrayList;

public class question {
    

     public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }

        // Tree traversal=================================================================================|

        public static void preOrederyraversal(Node root,ArrayList<Integer> ans){
            if(root == null){
                return;
            }

            ans.add(root.data);
            int leftd=preOrederyraversal(root.left,ans);
            int rigthd=preOrederyraversal(root.rigth,ans);
        }

        public static void inOrederyraversal(Node root,ArrayList<Integer> ans){
            if(root == null){
                return;
            }

            int leftd=inOrederyraversal(root.left,ans);
            ans.add(root.data);
            int rigthd=inOrederyraversal(root.rigth,ans);
        }

        public static void postOrederyraversal(Node root,ArrayList<Integer> ans){
            if(root == null){
                return;
            }
        
            int leftd=postOrederyraversal(root.left,ans);
            int rigthd=postOrederyraversal(root.rigth,ans);
            ans.add(root.data);
        }


        // Basic functions===================================================================================|

        public static int size(Node root){
            if(root == null){
                return 0;
            }

            return size(root.left)+size(root.rigth)+1;
        }

        public static int heightDeafultEdgeTerms(Node root){
            if(root == null) return -1;

            int lefth=heightDeafultEdgeTerms(root.left);
            int righth=heightDeafultEdgeTerms(root.rigth);
            
            return Math.max(lefth,rigth)+1;
        }

         public static int heightNodeTerms(Node root){
            if(root == null) return 0;

            int lefth=heightNodeTerms(root.left);
            int righth=heightNodeTerms(root.rigth);
            
            return Math.max(lefth,rigth)+1;
        }

        public static int maximum(Node root){
            if(root == null) return -(int) 1e8;

            int lmax=heightNodeTerms(root.left);
            int rmar=heightNodeTerms(root.rigth);
            
            return Math.max(Math.max(lmax,rmax)root.data);
        }

        public static int minimum(Node root){
            if(root == null) return (int) 1e8;

            int lmin=minimum(root.left);
            int rmin=minimum(root.rigth);
            
            return Math.min(Math.min(lmin,rmin)root.data);
        }

        public static void printAtkDepth(Node root,int k,ArrayList <Integer> ans){
            if(k == 0){
                System.out.println(node.data);
                return;
            }
            if(root.data == null){
                System.out.println("Not Found");
                return;
            }

            if(k > 0){
                printAtkDepth(root.left,k-1,ans.add(Node.data));
                printAtkDepth(root.rigth,k-1,ans.add(Node.data))
            }
        }

        public static boolean rootToNodePath(Node root,int data,ArrayList <Node> ans){
            if(root == null) return false;
            if(root.data == data){
                return true;
            }
            boolean res= (root.data == data) || rootToNodePath(Node root.left,int data,ans) || rootToNodePath(Node root.rigth,int data,ans);
            
            if(res){
                ans.add(root);
            }
            return res;

        }
    }
    public static class BSTSolPair{
        int minEle = (int) 1e8;
        int maxEle = -(int) 1e8;
        int height = 0;
        boolean isBal=true;
        boolean isBst = true;
        int totalnumofbst = 0;
        int largestbstsize = 0;
        Node largestbstnode = null; 
    }
    public static BSTSolPair sol(Node root){
        if (node == null) {
            return new BSTSolPair();
        }
        BSTSolPair left = sol(root.left);
        BSTSolPair right = sol(root.right);
        BSTSolPair ans = new BSTSolPair();
        ans.isBal = left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1;
        ans.isBst = left.isBst && right.isBst && left.maxEle < root.data && right.minEle > root.data ;

        ans.minEle = Math.min(root.data,left.minEle);
        ans.maxEle = Math.max(root.data,right.maxEle);
        ans.totalnumofbst = left.totalnumofbst + right.totalnumofbst + if(ans.isBst ? 1 : 0); 
        if(ans.isBst){
            ans.largestbstsize = left.largestbstsize + right.largestbstsize + 1;
            ans.largestbstnode = root;
        } 
        else {
            if(left.largestbstsize > right.largestbstsize){
                ans.largestbstnode = left.largestbstnode;
                ans.largestbstsize = left.largestbstsize;
            }
            else{
                ans.largestbstnode = right.largestbstnode;
                ans.largestbstsize = right.largestbstsize);
            }
        }
        return ans;
    }
     public static class larBstPair{
      Node largestbstnode = null;
      int largestbstsize = 0;
      boolean isBst = true;
      int minEle = (int) 1e8;
      int maxEle = -(int) 1e8; 
    }

    //  largest-bst-subtree-official=============================================================
    
    public static class larBstPair{
      Node largestbstnode = null;
      int largestbstsize = 0;
      boolean isBst = true;
      int minEle = (int) 1e8;
      int maxEle = -(int) 1e8; 
    }
    public static larBstPair BSTsol(Node root){
        if(root == null){
            return new larBstPair();
        }

        larBstPair left = BSTsol(root.left);
        larBstPair right = BSTsol(root.right);

        larBstPair ans=new larBstPair();
        ans.isBst = false;
        if(left.isBst && right.isBst && left.maxEle < root.data && root.data < right.minEle){
            ans.isBst=true;
            ans.largestbstnode=root;
            ans.largestbstsize = left.largestbstsize + right.largestbstsize + 1;
            ans.maxEle = Math.max(root.data, right.maxEle);
            ans.minEle = Math.min(root.data, left.minEle);
        }
        else{
            if(left.largestbstsize > right.largestbstsize){
                ans.largestbstsize = left.largestbstsize;
                ans.largestbstnode = left.largestbstnode;
            }
            else{
                ans.largestbstsize = right.largestbstsize;
                ans.largestbstnode = right.largestbstnode;
            }
        }
        return ans;
    }

    public static void BSTsol_(Node root){
      larBstPair ans=BSTsol(root);
        System.out.println(ans.largestbstnode.data +"@"+ans.largestbstsize);
    }

    //  tilt-of-binary-tree=====================================================
    static int Ttilt = 0;
    public static int tilt(Node node){
    if(node == null) return 0;
    int ltilt = tilt(node.left);
    int rtilt = tilt(node.right);
    Ttilt = Ttilt + Math.abs(ltilt-rtilt);
    return ltilt + rtilt + node.data;
  }

}