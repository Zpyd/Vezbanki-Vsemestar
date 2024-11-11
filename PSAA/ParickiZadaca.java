/*

    Napisi programa koja ke najde najmal broj na paricki(moneti) za dadena cena

    primer money system: 50 20 10 2 1

 */




import java.util.Scanner;
public class ParickiZadaca {

    public static void mergeSort(int[] niza, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = (l+r)/2;
        mergeSort(niza, l, mid);
        mergeSort(niza, mid+1, r);
        merge(niza, l, mid, r);
    }

    private static void merge(int[] niza, int l, int mid, int r) {
        int i = l, j = mid + 1, k=0;
        int[] pom = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (niza[i] > niza[j]) {
                pom[k++] = niza[i++];
            }
            else {
                pom[k++] = niza[j++];
            }
        }
        while (i <= mid) {
            pom[k++] = niza[i++];
        }
        while (j <= r) {
            pom[k++] = niza[j++];
        }
        for (k=0;k<r-l+1;k++){
            niza[l+k] = pom[k];
        }
    }


    public static int greedyBrojParicki(int cena, int[] pari ){
        //trebase msm za greedy da se prvo podredat od najgolem do najmal pa posle da se iskoriste toa
        int min=0;
        mergeSort(pari,0,pari.length-1);
        for (int i=0;i<pari.length;i++){
            System.out.print(pari[i] + " ");
        } System.out.println();

        int i=0, broj=0, count;
        while(cena!=0) { //17-10=7
            broj = cena / pari[i++];
            min += broj;
            cena -= broj*pari[i-1];
        }


        return min;
    }

    // Define coin denominations
    public static int minBrojParicki(int cena) {
        int p1, p2, p3, p4, p5;
        int min = Integer.MAX_VALUE;
        int pom, broj = -1; // Initialize 'broj' here to avoid any issues

        for (p1 = 0; p1 <= (cena / 50); p1++) {
            for (p2 = 0; p2 <= (cena / 20); p2++) {
                for (p3 = 0; p3 <= (cena / 10); p3++) {
                    for (p4 = 0; p4 <= (cena / 2); p4++) {
                        for (p5 = 0; p5 <= cena; p5++) {
                            pom = p1 * 50 + p2 * 20 + p3 * 10 + p4 * 2 + p5;
                            if (pom == cena) {
                                broj = p1 + p2 + p3 + p4 + p5;
                                min = Math.min(min, broj);
                            }
                        }
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min; // Return -1 if no solution is found
    }

    public static void main(String[] args) {

        int pari[] = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < pari.length; i++) {
            System.out.println("Vnesi sledna para (or -1 za kraj): ");
            int output=sc.nextInt();
            if(output == -1) { //this doesnt work poradi merge sort treba dinamicno so Arraylist da se alocira ako sakam da implementiram toa
                break;
            }
            pari[i] = output;
        }

        ParickiZadaca parickiZadaca = new ParickiZadaca();
        long startTime = System.currentTimeMillis();
        System.out.println("Brute force algoritam output: " + parickiZadaca.minBrojParicki(1000) + " Vreme: " + (System.currentTimeMillis()-startTime));
        startTime = System.currentTimeMillis();
        System.out.println("Greedy alg output: " + parickiZadaca.greedyBrojParicki(1000,pari) + " Vreme: " + (System.currentTimeMillis()-startTime));
    }
}
