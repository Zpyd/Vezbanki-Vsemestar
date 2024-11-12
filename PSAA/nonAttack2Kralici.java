public class nonAttack2Kralici {

    public static boolean DaliNapagja(int x1, int y1, int x2, int y2) {
        return ((x1 == x2) || (y1 == y2) || (Math.abs(x2-x1)==Math.abs(y2-y1)));
    }

    public static int neNapagjacki(){
        int count=0;
        for (int x1=0; x1<8; x1++){
            for (int y1=0; y1<8;y1++){
                for (int x2=0; x2<8; x2++){
                    for (int y2=0; y2<8;y2++){
                        if (!DaliNapagja(x1, y1, x2, y2)){
                           count++;
                        }
            }
        }
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(neNapagjacki());
    }

}
