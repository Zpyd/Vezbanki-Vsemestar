package com.mycompany.numofcepkanjazapolinomi;


import java.util.*;

public class NumOfCepkanjaZaPolinomi{ 


    static HashMap<String,Boolean> DP_List_Polinomes =new HashMap<>();
    
    public static boolean isPolinome(String str,int l,int r){
       String delce_odZbor= str.subSequence(l, r).toString();
        
       if(DP_List_Polinomes.containsKey(delce_odZbor)){
          return DP_List_Polinomes.get(delce_odZbor);  
        } 
       
        int i=l, j=r;


        while(i<j){
            if (str.charAt(i)!=str.charAt(j)) {
                DP_List_Polinomes.put(delce_odZbor, Boolean.FALSE);
                return false;
            }
            i++; j--;
        }

        DP_List_Polinomes.put(delce_odZbor, Boolean.TRUE);
        return true;
    }

    public static int numCepkanja(String word, int l, int r){
        int min=Integer.MAX_VALUE,temp;
        if(l>=r || isPolinome(word,l,r)) {
            return 0;
        }

        //treba da ima nekoja so ke se sporeduva za kako minumimumo ke go dobieme
        for (int i=l; i<r; i++) {
            temp = numCepkanja(word, l, i) + numCepkanja(word, i + 1, r) + 1;
            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }



    public static void main(String[] args){
        String word="aabbcbbaaaccdcdc";
        System.out.println(numCepkanja(word,0,word.length()-1));


    }



}



    
