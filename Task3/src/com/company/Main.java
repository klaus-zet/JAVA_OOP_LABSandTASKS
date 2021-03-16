package com.company;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Номер задачи?");
        int task = in.nextInt();
        switch(task){
            case 21:
                int task21a = in.nextInt();
                int task21b = in.nextInt();
                int task21c = in.nextInt();
                System.out.println(solutions(task21a, task21b, task21c));
            case 22:
                in.nextLine();
                String task22 = in.nextLine();
                System.out.println(findZip(task22));
            case 23:
                int task23 = in.nextInt();
                System.out.println(checkPerfect(task23));
            case 24:
                in.nextLine();
                String task24 = in.nextLine();
                System.out.println(flipEndChars(task24));
            case 25:
                in.nextLine();
                String task25 = in.nextLine();
                System.out.println(isValidHexCode(task25));
            case 26:
                in.nextLine();
                String task26x = in.nextLine();
                String task26y = in.nextLine();
                String[] task26xx = task26x.split(" ");
                String[] task26yy = task26y.split(" ");
                System.out.println(same(task26xx, task26yy));
            case 27:
                in.nextLine();
                int task27 = in.nextInt();
                System.out.println(isKaprekar(task27));
            case 28:
                in.nextLine();
                String task28 = in.nextLine();
                System.out.println(longestZero(task28.toCharArray()));
            case 29:
                in.nextLine();
                int task29 = in.nextInt();
                System.out.println(nextPrime(task29));
            case 30:
                in.nextLine();
                int task30x = in.nextInt();
                int task30y = in.nextInt();
                int task30z = in.nextInt();
                System.out.println(rightTriangle(task30x, task30y, task30z));
        }
        in.close();
    }
    public static String solutions(int x, int y, int z){
        float diskriminant = (y*y)-(4*x*z);
        if(diskriminant > 0){
            return "Two solutions";
        }
        else if(diskriminant == 0){
            return "One solution";
        }
        else{
            return "No solutions";
        }
    }
    public static int findZip(String x){
        int count = 0;
        for(int i = 0; i < x.length()-3; i++){
            if(x.charAt(i) == 'z'){
                if(x.charAt(i+1) == 'i'){
                    if(x.charAt(i+2) == 'p'){
                        count += 1;
                        if(count == 2){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static boolean checkPerfect(int x){
        int check = 0;
        for(int i = 1; i <= x/2; i++){
            if(x%i==0){
                check += i;
            }
        }
        if(check==x){
            return true;
        }
        else{
            return false;
        }
    }
    public static String flipEndChars(String x){
        char[] array = x.toCharArray();
        if (x.length() < 3){
            return "Incompatible";
        }
        char y = array[array.length-1];
        if(y == array[0]){
            return "Two's a pair";
        }
        else{
            array[array.length-1] = array[0];
            array[0] = y;
            return new String(array);
        }
    }
    public static boolean isValidHexCode(String x){
        char[] array = x.toCharArray();
        char[] validChars = new char[] {'A', 'B', 'C', 'D', 'E', 'F', '0', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int counter = 0;
        int counter1 = 0;
        if(x.length() != 7){
            return false;
        }
        if(array[0] != '#'){
            return false;
        }
        for(int i = 1; i < x.length(); i++){
            for(int j = 0; j < validChars.length; j++){
                counter += 1;
                if(array[i] == validChars[j]){
                    break;
                }
                counter1 += 1;
            }
            if(counter1 == counter){
                return false;
            }
        }
        return true;
    }
    public static boolean same(String[] x, String[] y){
        Set setx = new HashSet(Arrays.asList(x));
        Set sety = new HashSet(Arrays.asList(y));

        if(setx.size() == sety.size()){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isKaprekar(int x){
        int sqr = x*x;
        String fst = "";
        String snd = "";
        String tsqr = Integer.toString(sqr);
        char[] tsqrch = tsqr.toCharArray();
        int fsti = 0;
        if(x%2 != 0){
            snd += tsqrch[tsqr.length()/2];
        }
        for(int i = 0; i < tsqr.length()/2; i++){
            fst += tsqrch[i];
            snd += tsqrch[tsqr.length()/2 + 1 +i];
        }
        if(fst.length() != 0){
            fsti = Integer.parseInt(fst);
        }
        int sndi = Integer.parseInt(snd);
        if(fsti+sndi == x){
            return true;
        }
        else{
            return false;
        }
    }
    public static String longestZero(char[] x){
        int count = 0;
        String zeros = "";
        for(int i = 0; i < x.length; i++){
            if(x[i] == '0'){
                count += 1;
            }
            else{
                count = 0;
            }
            if(count > zeros.length()){
                zeros += '0';
            }
        }
        return zeros;
    }
    public static int nextPrime(int x){
        int testing = x - 1;
        int flag;
        while(true){
            flag = 0;
            testing += 1;
            for(int i = 2; i < testing/2; i++){
                if(testing % i == 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return testing;
            }
        }
    }
    public static boolean rightTriangle(int x, int y, int z){
        x = x*x;
        y = y*y;
        z = z*z;
        if(x+y == z || x+z == y || y+z == x){
            return true;
        }
        else{
            return false;
        }
    }
}
