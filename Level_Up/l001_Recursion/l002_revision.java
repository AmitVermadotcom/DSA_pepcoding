public class l002_revision{

    // public static boolean placeH(String word,int r,int c){
    //     for(int i=0;i <= word.length();i++){
    //         box[r][c+i] = word.charAt(i);
    //     }
    // }

    // public static boolean unPlaceH(String word,int r,int c){
    //     for(int i=0;i <= word.length();i++){
    //         box[r+i][c] = '-';
    //     }
    // }

    // public static boolean placeV(String word,int r,int c){
    //     for(int i=0;i <= word.length();i++){
    //         box[r+i][c] = word.charAt(i);
    //     }
    // }

    // public static boolean unPlaceV(String word,int r,int c){
    //     for(int i=0;i <= word.length();i++){
    //         box[r+i][c] = '-';
    //     }
    // }

    public static int subsetsum(int setA,String A,int setB,String B,int[] arr,int idx){
        if(idx == arr.length){
            if(setB == setA){
                System.out.println(setA + " " + setB);
                System.out.println(A + " " + B);
                return 1;
            }
            return 0;
        }
        int count = subsetsum(setA + arr[idx],A + arr[idx],setB,B,arr,idx+1);

        count += subsetsum(setA,A ,setB + arr[idx] ,B+ arr[idx],arr,idx+1);

        return count;
    }

    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50,60,70};
        System.out.println(subsetsum(0,"",0,"",arr,0));
    }

    
}