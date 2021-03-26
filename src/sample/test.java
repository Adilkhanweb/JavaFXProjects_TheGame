package sample;


import java.util.Scanner;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args){
            /*
3
P 0 0
0 0 0
0 0 0
RDD
*/


        /*
5
P 0 0 0 0
RDLD
*/


        /*
7
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
0 0 0 1 0 0 0
0 0 0 1 0 0 0
0 0 0 1 0 0 0
0 0 0 P 0 0 0
LLLLLLLURDLURDL
*/
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        String[][] arr = new String[n][n];
        int rpos = 0;
        int cpos = 0;

        for (int i = 0; i < n; i++) {
            /*MAP ERROR EXCEPTION HANDLER*/
            String t = in.nextLine().trim();
            if (t.equals("") || Pattern.matches("[RLUD]+$",t)) {
                System.out.println("Not enough map elements");
                System.exit(0);
            }
                for (int j = 0; j < n; j++) {
                    arr[i] = t.split(" ");
                    /*START POSITION OF PLAYER*/
                    if (arr[i][j].equals("P")){
                        rpos = i;
                        cpos = j;
                    }
                }
        }
        String way = in.nextLine();
        for (int i = 0; i < way.length(); i++) {
            /*WALK RIGHT*/
            if (way.charAt(i) == 'R'){
                if (cpos < n - 1){
                    if (!arr[rpos][cpos + 1].equals("1") && cpos + 1 < n){
                        String temp = arr[rpos][cpos + 1];
                        arr[rpos][cpos+1] = arr[rpos][cpos];
                        arr[rpos][cpos] = temp;
                        cpos++;
                    }
                }
            }
            /*WALK LEFT*/
            else if (way.charAt(i) == 'L'){
                if (cpos >= 1){
                    if (!arr[rpos][cpos - 1].equals("1")){
                        String temp = arr[rpos][cpos - 1];
                        arr[rpos][cpos - 1] = arr[rpos][cpos];
                        arr[rpos][cpos] = temp;
                        cpos--;
                    }
                }
            }
            /*WALK UP*/
            else if (way.charAt(i) == 'U'){
                if (rpos >= 1){
                    if (!arr[rpos - 1][cpos].equals("1")){
                        String temp = arr[rpos - 1][cpos];
                        arr[rpos - 1][cpos] = arr[rpos][cpos];
                        arr[rpos][cpos] = temp;
                        rpos--;
                    }
                }
            }
            /*WALK DOWN*/
            else if(way.charAt(i) == 'D'){
                if (rpos < n - 1){
                    if (!arr[rpos + 1][cpos].equals("1") && rpos + 1 < n){
                        String temp = arr[rpos + 1][cpos];
                        arr[rpos + 1][cpos] = arr[rpos][cpos];
                        arr[rpos][cpos] = temp;
                        rpos++;
                    }
                }
            }
        }
        /*SHOW POSITION OF PLAYER*/
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.print("Player final position\nRow: "+ rpos + "\nCol: " + cpos);
    }

}
