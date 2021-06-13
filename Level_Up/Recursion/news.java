import java.util.*;
public class news{
    public static void main(String[] args) {
        // queenSet();
        // int[] arr={10,20,30,40,50,60,70,80};

        // set(arr,"","",0,0,0);
        // System.out.println(Nqueen(16,4,0,0,""));
        int n = 4, m = 4, q = 4;
        boolean[][] boxes = new boolean[n][m];
        System.out.println(nqueen_Combination_subseq(boxes, q, 0, ""));
        // System.out.println(nqueen_Permutation01(boxes, q, 0, ""));
    }

    public static int Nqueen(int tboxes,int tq,int qpsf,int bn,String ans){
        if(qpsf == tq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i = bn;i < tboxes;i++){
            int a = i / 4 ;
            int b = i % 4;
            count += Nqueen(tboxes,tq,qpsf+1,i + 1,ans + "("+a+","+b+")");
        }

        return count;
    }

    public static void set(int[] arr,String a,String b,int cntA,int cntB,int idx){
        if(idx == arr.length){
            if(cntB == cntA ){
                System.out.print(a + " = " + b);
                System.out.println();
                }
            return;
        }
        
        set(arr,a + arr[idx] + " ",b,cntA+arr[idx],cntB,idx+1);
        set(arr,a,b + arr[idx]+ " ",cntA,cntB+arr[idx],idx+1);

        return;
    }

    public static int nqueen_Combination_subseq(boolean[][] box,int tnq,int idx,String ans){
        int n=box.length;
        int m=box[0].length;
        if (tnq == 0 || idx >= n * m) {
            if (tnq == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        int r= idx / n;
        int c = idx % m;

        if(isSafeToPlaceQueen(box,r,c)){
            box[r][c]=true;
            count += nqueen_Combination_subseq(box,tnq-1,idx+1,ans + "(" + r + ", " + c + ") ");
            box[r][c]=false;
        }

        count += nqueen_Combination_subseq(box,tnq,idx+1,ans);

        return count;
    }

    public static int nqueen_Permutation01(boolean[][] box,int tnq,int idx,String ans){
        int n=box.length,m=box[0].length,count=0;
        if(tnq == 0){
            System.out.println(ans);
            return 1;
        }
        for(int i=0;i < n*m; i++){
        int r = i / n;
        int c = i % m;
            if(box[r][c] == false && isSafeToPlaceQueen(box,r,c)){
                box[r][c] = true;
                count += nqueen_Permutation01(box,tnq-1,0,ans + "(" + r + ", " + c + ") ");
                box[r][c] = false;
            }
        }

        return count;
    }

    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int n = boxes.length, m = boxes[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad < n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (boxes[x][y])
                        return false;
                } else
                    break;
            }
        }

        return true;
    }


    // public static void printA(ArrayList<Integer> a){
    //     for(int i=0;i < a.size();i++){
    //         System.out.print(a.get(i) + " ");
    //     }
    //     System.out.println();
    // }
}