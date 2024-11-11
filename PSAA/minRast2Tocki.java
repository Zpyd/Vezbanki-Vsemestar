/*

    Најдете го минималното растојание помеѓу две точки (во
    множество од n точки).

 */


import java.util.*;
public class minRast2Tocki {

    static class Tocka {
        int x;
        int y;
        Tocka(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static float minRast(Tocka[] t, int n) {
        float d = (float)Math.sqrt(Math.pow((t[0].x - t[1].x),2) + Math.pow((t[0].y - t[1].y),2));
        int[][] minkoord=new int[2][2];
        minkoord[0][0]=t[0].x;minkoord[0][1]=t[0].y; minkoord[1][0]=t[1].x; minkoord[1][1]=t[0].y;

        float pom;
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
               pom= (float)Math.sqrt(Math.pow((t[i].x - t[j].x),2) + Math.pow((t[i].y - t[j].y),2));
               if(pom<d){
                   d=pom;
                   minkoord[0][0]=t[i].x;minkoord[0][1]=t[i].y; minkoord[1][0]=t[j].x; minkoord[1][1]=t[j].y;
               }
            }
        }
        return d;
    }
    public static void main(String[] args) {
       
        Random rand =new Random();
        int n=5;
        Tocka[] t =new Tocka[n];
        for (int i=0;i<n;i++) {
            t[i]= new Tocka(rand.nextInt(10), rand.nextInt(10));
        }
        System.out.println(minRast(t,n));
    }
}
