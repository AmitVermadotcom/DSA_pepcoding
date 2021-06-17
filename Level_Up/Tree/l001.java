import java.util.ArrayList;
import java.util.HashMap;

public class l001 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int Maximum(TreeNode root) {
        return root == null ? -(int) 1e9 : Math.max(Math.max(Maximum(root.left), Maximum(root.right)), root.val);
    }

    public static boolean find(TreeNode root, int data) {
        if (root == null)
            return false;
        if (root.val == data)
            return true;

        return find(root.left, data) || find(root.right, data);
    }

    public static ArrayList<TreeNode> NodeToRootPath(TreeNode root, int data) {
        if (root == null || root.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            if(root == null) return base;
            base.add(root);
            return base;
        }

        
        ArrayList<TreeNode> left = nodeToRootPath(root.left,data);
    
        if(left.size() != 0){
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath(root.right,data);
        if(right.size() != 0){
            right.add(root);
        }
        
        return right;
    }

    public static boolean NodeToRootPath(TreeNode root, int data,ArrayList<TreeNode> ans) {
        if (root == null)
            return false;

        boolean res = root.val == data || find(root.left, data) || find(root.right, data);
        if(res) ans.add(root);
        return res;
    }


    // Root to all leaf path
    public static ArrayList<Integer> helper(TreeNode root,ArrayList<Integer> subAns,ArrayList<ArrayList<Integer>> ans){
        if(root.left == null || root.right == null){
            ArrayList<Integer> base=new ArrayList<>(subAns);
            ans.add(subAns);
            return base;
        }
        
        subAns.add(root.val);
        ArrayList<Integer> left = helper(root.left,data);
        
        ArrayList<Integer> right = helper(root.right,data);
       subAns.remove(root.val);
        return right;

    }

    public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root){
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        ArrayList<Integer> subAns=new ArrayList<>();
        rootToAllLeafPath(root,subAns,ans);
        return ans;
    }


// single child parent in tree
    public static void helper(TreeNode root,TreeNode parent,ArrayList<Integer> ans){
      if(root == null) return;
      if(parent != null && (parent.left == null || parent.right == null)){
          ans.add(parent.val);
      }
      helper(root.left,root,ans);
      helper(root.right,root,ans);
  }

  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    helper(root,null,ans);
    return ans;
  }
  
// Count of single child parent in tree
  public static int countExactlyOneChild(TreeNode root) {
    return helper(root,null);
  }
  public static int helper(TreeNode root,TreeNode parent){
      if(root == null) return 0;
    int count=0;
      if(parent != null && (parent.left == null || parent.right == null)){
        //   ans.add(parent.val);
          count++;
      }
      count += helper(root.left,root);
      count += helper(root.right,root);
    return count;
  }

//   863. All Nodes Distance K in Binary Tree

    public static int findNodes(TreeNode root,int k,TreeNode Target,ArrayList<Integer> ans){
        if(root == null) return -1;

        if(root == Target){
            kDown(root,k,null,ans);
            return 1;
        }

        int ld = findNodes(root.left,k,Target,ans);
        if(ld != -1){
            kDown(root,k-ld,root.left,ans);
            return ld + 1;
        }

        int rd = findNodes(root.right,k,Target,ans);
        if(rd != -1){
            kDown(root,k-rd,root.right,ans);
            return rd + 1;
        }
        return -1;
    }

    public static void kDown(TreeNode root,int k,TreeNode block,ArrayList<Integer> ans){
        if(root == null || k < 0 || root == block) return;

        if(k == 0){
            ans.add(root.val);
            return;
        }

        kDown(root.left,k-1,block,ans);
        kDown(root.right,k-1,block,ans);
    }


    // Burning tree***************************************************** very important 

    public static int BurningTree(TreeNode root,int Target,ArrayList<ArrayList<Integer>> ans){
        if(root == null) return -1;
        if(root.val == Target){
            kDown(root,0,null,ans);
            return 1;
        }

        int ld = BurningTree(root.left,Target,ans);
        if(ld != -1){
            kDown(root,ld,root.left,ans);
            return ld + 1;
        }

        int rd = BurningTree(root.right,Target,ans);
        if(rd != -1){
            kDown(root,rd,root.right,ans);
            return rd +1;
        }

        return -1;
    }

    public static void kDown(TreeNode root,int time,TreeNode block,ArrayList<ArrayList<Integer>> ans){
        if(root == null || root == block ) return;

        if(time == ans.size())
            ans.add(new ArrayList<Integer>());
        ans.get(time).add(root.val);

        kDown(root.left,time+1,block,ans);
        kDown(root.right,time+1,block,ans);
    }

    // burning tree with water
    // -2 -> fire will not reach that node.
    //  if greater than zero -> fire with time t.
    //  -1 => target not found


    // -1 : did we gett the target node, -2 : fire will not reach that node, t > 0 :
    // fire will reach with time t.
    public static int burningTreeWithWater(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans,
            HashSet<Integer> water) {
        if (root == null)
            return -1;
        if (root.val == target) {
            if (!water.contains(root.val)) {
                kdown(root, 0, null, ans);
                return 1;
            } else
                return -2;
        }

        int ld = burningTreeWithWater(root.left, target, ans, water);
        if (ld > 0) {
            if (!water.contains(root.val)) {
                kdown(root, ld, root.left, ans);
                return ld + 1;
            }
            return -2;
        }
        if (ld == -2)
            return -2;

        int rd = burningTreeWithWater(root.right, target, ans, water);
        if (rd > 0) {
            if (!water.contains(root.val)) {
                kdown(root, rd, root.right, ans);
                return rd + 1;
            }
            return -2;
        }
        if (rd == -2)
            return -2;

        return -1;
    }

    public static void kDown(TreeNode root,int time,TreeNode block,ArrayList<ArrayList<Integer>> ans,HashMap<Integer,Integer> map){
        if(root == null || root == block || map.containsKey(root.val) == false) return;

        if(time == ans.size())
            ans.add(new ArrayList<Integer>());
        ans.get(time).add(root.val);

        kDown(root.left,time+1,block,ans,map);
        kDown(root.right,time+1,block,ans,map);
    }


    // Lowest common ancestor===================

    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return null;

        if(root.val == p || root.val == q) return root;

        TreeNode ln = lowestCommonAncestor(root.left,p,q);

        TreeNode rn = lowestCommonAncestor(root.right,p,q);

        if(ln != null && rn != null) return root;

        return ln == null ? rn:ln; 
    }


    class BSTIterator {

        private ArrayDeque<TreeNode> st = new ArrayDeque<>(); // addFirst, removeFirst

        public BSTIterator(TreeNode root) {
            addAllLeft(root);
        }

        private void addAllLeft(TreeNode node) {
            while (node != null) {
                this.st.addFirst(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode rnode = this.st.removeFirst();
            addAllLeft(rnode.right);

            return rnode.val;
        }

        public boolean hasNext() {
            return this.st.size() != 0;
        }
    }


    // left view of binary tree ===========================
    public static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size() != 0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                if(rnode.left != null) que.addLast(rnode.left);
                if(rnode.right != null) que.addLast(rnode.right);
            }
        }
        return ans;
    }


    // Vertical view of binary tree=====================

    public static void widhtOfTree(TreeNode root,int vl,int[] minmax){  //widht or shadow of tree
        if(root == null) return;
        minmax[0] = Math.min(minmax[0],vl);
        minmax[1] = Math.max(minmax[1],vl);
        
        widhtOfTree(root.left,vl-1,minmax);
        widhtOfTree(root.right,vl+1,minmax);
    }

    public class vPair{
        int vl=0;
        TreeNode node = null;
        vPair(int vl,TreeNode node){
            this.vl = vl;
            this.node = node;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int[] minmax = new int[2];
        widhtOfTree(root,0,minmax);
        int len = minmax[1]-minmax[0] + 1;
        for(int i=0;i<len;i++) ans.add(new ArrayList<>());
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(Math.abs(minmax[0]),root));

        while(que.size() != 0){
            int size = que.size();
            // vPair nw = que.getFirst();
            
            while(size-- > 0){
                vPair rnode = que.removeFirst();
                ans.get(rnode.vl).add(rnode.node.val);
                if(rnode.node.left != null) que.addLast(new vPair(rnode.vl -1,rnode.node.left));
                if(rnode.node.right != null) que.addLast(new vPair(rnode.vl +1,rnode.node.right));
            }
        }
        return ans;
    }


    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(root == null) return;
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        while(que.size() != 0){
            int size = que.size();
            ArrayList<Integer> smallAns=new ArrayList<>();
            while(size-- > 0){
                TreeNode node = que.removeFirst();
                
                smallAns.add(node.val);
                if(node.left != null){
                    que.addLast(node);
                }
                
            }
        }
        return ans;
    }
}