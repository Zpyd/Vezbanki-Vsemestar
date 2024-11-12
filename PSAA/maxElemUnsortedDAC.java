public class maxElemUnsortedDAC {

    /*
                 2 1 4 5 8 2 4 3 9 10

               2 1 4 5 8     2 4 3 9 10

             2 1 4    5 8

            2 1

            

     */

    public static int maxElemUnsorted(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid= (l+r)/2;
        int levo_max= maxElemUnsorted(arr, l, mid);
        int desno_max= maxElemUnsorted(arr, mid+1, r);
        if (levo_max > desno_max) {
            return levo_max;
        }else return desno_max;
    }


    public static void main(String[] args){
        int[] ar = {3,1,4,5,2,20,5,10,55};
        System.out.println(maxElemUnsorted(ar, 0, ar.length-1));
    }
}
