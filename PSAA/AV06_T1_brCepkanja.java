/*
`
    12.11.2024
    od tast se vnesuva bool string treba da se razdele na delovi sekoj podstring e polindrom sekoj pod so 1 e pal
    min br na cepkanja za site dobieni segmenti da se palindromi


 */


import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class AV06_T1_brCepkanja {
    static Map<String, Boolean> DP_passed_ranges;

    public static void main(String[] argc) {
        DP_passed_ranges = new HashMap<String, Boolean>();
        Dictionary<Integer,Integer> bla = new HashMap<>();

        // String str = "xabaay";
        String str = "abb";
        System.out.println(minPartitions(str,  0, str.length() - 1));
    }

    public static int minPartitions(String str, int start, int end){
        if (start >= end || isPalindrom(str, start, end)){
            return 0;
        }

        int result=Integer.MAX_VALUE, count;

        for (int i = start; i < end; i++){
            count = minPartitions(str, start, i) + minPartitions(str,i+1, end) + 1;

            /*

                x|a|b|a|a|y
                1) mP(x) + mP(abaay) #prvo se cepka mp(x) se do kraj pa posle pocnuva so mp(abaay) -> 0 + y (2) -> result > -> result = 0+y
                2) mP(xa) + mP(baay) # voa ne se izvrsuva se do celoto 1) ne se izvrse

               kaj mP(abaay)
               1)4
               2)4
               3)2
               4)2 -> y=2


            */

            result = Math.min(result, count);
        }

        return result;
    }

    private static boolean isPalindrom(String str, int start, int end){
        String current_word = str.substring(start, end+1);
        if (DP_passed_ranges.containsKey(current_word))
            return DP_passed_ranges.get(current_word);

        boolean is_palindrome = true;
        while (start < end){
            if (str.charAt(start) != str.charAt(end)) {
                is_palindrome = false;
                break;
            }

            start++;
            end--;
        }

        DP_passed_ranges.put(current_word, is_palindrome);
        return is_palindrome;
    }
}
