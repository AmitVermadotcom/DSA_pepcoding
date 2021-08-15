public class l002{


    // leetcode 987 vertical order sum with priority queue

    public static void widhtOfTree(TreeNode root,int level,int[] minmax){
        if(root == null) return;
        minmax[0] = Math.min(minmax[0],level);
        minmax[1] = Math.max(minmax[1],level);

        widhtOfTree(root.left,level-1,minmax);
        widhtOfTree(root.right,level+1,minmax);
    }

    public class vPair{
        int vl=0;
        TreeNode node = null;
        vPair(int vl,TreeNode node){
            this.vl = vl;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root == null) return ans;
        int[] minmax=new minmax[2];
        widhtOfTree(root,0,minmax);
        int len=minmax[1]-minmax[0]+1;
        for(int i=0;i<len;i++) ans.add(new ArrayList<>());
        PriorityQueue<vPair> parent = new PriorityQueue<>((a,b) => {
            if(a.vl == b.vl){
                return a.node.val - b.node.val;
            }
            return a.vl - b.vl;
        });

        PriorityQueue<vPair> child = new PriorityQueue<>((a,b) => {
            if(a.vl == b.vl){
                return a.node.val - b.node.val;
            }
            return a.vl - b.vl;
        });

        parent.add(new vPair(Math.abs(minmax[0]),root));

        while(parent.size() != 0){
            int size = parent.size();
            while(size-->0){
                vPair rp = parent.removeFirst();
                ans.get(rp.vl).add(rp.node.val);
                if(rp.node.left != null) child.add(new vPair(rp.vl-1,rp.node.left));
                if(rp.node.right != null) child.add(new vPair(rp.vl+1,rp.node.right));
            }
            PriorityQueue<vPair> temp=child;
            child=parent;
            parent=temp;
        }

        return ans;
    }

    // binary tree to doubly linkedlist
    // Iterative method ==== Best one for interview
    void insertAllLeft(LinkedList<Node> st,Node node){
        if(node == null) return;
        while(node != null){
            st.addFirst(node);
            node=node.left;
        }
    }
    Node bToDLL(Node root)
    {
	//  Your code here
    	LinkedList<Node> st=new LinkedList<>();
    	Node prev= new Node(-1);
    	Node dummy=prev;
    	insertAllLeft(st,root);
    	
    	while(st.size() != 0){
	        Node rnode = st.removeFirst();
	        prev.right = rnode;
	        rnode.left = prev;
	        prev=rnode;
	        insertAllLeft(st,rnode.right);
	    }
	    Node head = dummy.right;
	    head.left = dummy.right = dummy.left =null;
	    return head;
    }

    // recursive with static variable === best one for test
    static Node prev=null;
    Node bToDLL(Node root)
    {
	//  Your code here	
	    Node dummy = new Node(-1);
	    prev=dummy;
	    helper(root);
	    Node head = dummy.right;
	    head.left=null;
	    return head;
    }
    
    void helper(Node root){
        if(root == null) return;
        helper(root.left);
        prev.right=root;
        root.left=prev;
        prev=root;
        helper(root.right);
    }

    
}