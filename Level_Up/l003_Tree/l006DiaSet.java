public class l006DiaSet{
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

    public static int diameter(TreeNode root){
        if(root == null) return 0;
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(Math.max(ld,rd),lh + rh + 1);
    }
    // {diameter,height}
    public static int[] diameter_02(TreeNode root){
        if(root == null) return new int[] {0,0};

        int[] l = diameter_02(root.left);
        int[] r = diameter_02(root.right);

        int mydia = Math.max(Math.max(l[0],r[0]),l[1]+r[1] + 1);

        return {mydia,Math.max(l[1],r[h])+1};
    }


    
}