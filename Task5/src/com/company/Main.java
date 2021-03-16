package com.company;
import java.util.Scanner;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        System.out.println("Номер задачи?");
        int task = in.nextInt();
        switch(task){
            case 50:
                in.nextLine();
                String task50 = in.nextLine();
                int[] res = encrypt(task50);
                for(int i = 0; i < res.length; i++){
                    System.out.print(res[i]);
                    System.out.print(' ');
                }
                System.out.println(decrypt(res));

            case 51:
                in.nextLine();
                String task51a = in.nextLine();
                String task51b = in.nextLine();
                String task51c = in.nextLine();
                System.out.println(canMove(task51a, task51b, task51c));

            case 52:
                in.nextLine();
                String task52a = in.nextLine();
                String task52b = in.nextLine();
                System.out.println(canComplete(task52a, task52b));

            case 53:
                in.nextLine();
                String[] ints = in.nextLine().split(" ");
                int[] trueints = new int[ints.length];
                for(int i = 0; i < ints.length; i++){
                    trueints[i] = Integer.parseInt(ints[i]);
                }
                System.out.println(sumDigProd(trueints));
            case 54:
                in.nextLine();
                String[] task54 = in.nextLine().split(" ");
                System.out.println(sameVowelGroup(task54));
            case 55:
                in.nextLine();
                String task56 = in.nextLine();
                System.out.println(validateCard(task56));
            case 56:
                in.nextLine();
                String task57 = in.nextLine();
                System.out.println(numToEng(task57));
            case 57:
                in.nextLine();
                String task58 = in.nextLine();
                System.out.println(getSha256Hash(task58));
            case 58:
                in.nextLine();
                String task59 = in.nextLine();
                System.out.println(correctTitle(task59));
            case 59:
                in.nextLine();
                int task60 = in.nextInt();
                System.out.println(hexLattice(task60));

        }
    }
    public static int[] encrypt(String x){
        char[] xlist = x.toCharArray();
        int[] xnumlist = new int[x.length()];
        xnumlist[0] = (int) xlist[0];
        for(int i = 1; i < x.length(); i++){
            xnumlist[i] = (int) xlist[i];
            xnumlist[i] = (int) xlist[i] - (int) xlist[i-1];
        }
        return xnumlist;
    }
    public static String decrypt(int[] x){
        char[] xlist = new char[x.length];
        xlist[0] = (char) x[0];
        for(int i = 1; i < x.length; i++){
            xlist[i] = (char) (x[i] + (int) xlist[i-1]);
        }
        String res = String.valueOf(xlist);
        return res;
    }
    public static boolean canMove(String piece, String start, String end){
        int[] charToInt = new int[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int x0 = 0;
        int x1 = 0;
        int y0 = (int) start.charAt(1);
        int y1 = (int) end.charAt(1);
        for(int i = 0; i < charToInt.length; i++){
            if(start.charAt(i) == charToInt[i]){
                x0 = i;
            }
            if(end.charAt(i) == charToInt[i]){
                x1 = i;
            }
        }
        if(piece == "Rook"){
            if(x0 == x1 || y0 == y1){
                return true;
            }
        }
        if(piece == "Bishop"){
            if((x0-x1) == (y0 - y1)){
                return true;
            }
        }
        if(piece == "Queen"){
            if(((x0-x1) == (y0 - y1)) || x0 == x1 || y0 == y1){
                return true;
            }
        }
        if(piece == "King"){
            if(Math.abs(x1-x0) <= 1 && Math.abs(y1-y0) <= 1){
                return true;
            }
        }
        return false;
    }
    public static boolean canComplete(String x, String y){
        int count = 0;
        int posmemory = 0;
        for(int i=0; i < y.length(); i++){
            for(int j = posmemory; j < x.length(); j++){
                if(y.charAt(i) == x.charAt(j)){
                    count++;
                    posmemory = j;
                    continue;
                }
            }
        }
        if(count == x.length()){
            return true;
        }
        else{
            return false;
        }
    }
    public static int sumDigProd(int[] x){
        int sum = 0;
        int multy = 1;
        int num = 0;
        for(int i = 0; i < x.length; i++){
            sum += x[i];
        }
        char[] sumChar = Integer.toString(sum).toCharArray();
        while(sumChar.length != 1){
            for(int i = 0; i < sumChar.length; i++){
                multy *= Character.getNumericValue(sumChar[i]);
            }
            sumChar = Integer.toString(multy).toCharArray();
            multy = 1;
        }
        return Character.getNumericValue(sumChar[0]);
    }
    public static String[] sameVowelGroup(String[] x){
        int count = 0;
        String[] res = new String[x.length];
        res[0] = x[0];
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] initVowels = new char[x[0].length()];
        char[] newInitVowels = initVowels;
        for(int i = 0; i < x[0].length(); i++){
            for(int j = 0; j < x[0].length(); j++){
                if(x[0].charAt(i) == vowels[j]){
                    initVowels[i] = vowels[j];
                }
            }
        }
        for(int i = 1; i < x.length; i++){
            for(int j = 0; j < x[i].length(); j++){
                for(int z = 0; j < initVowels.length; z++){
                    if(x[i].charAt(j) == newInitVowels[z]){
                        count++;
                        newInitVowels[z] = ' ';
                    }
                }
            }
            newInitVowels = initVowels;
            if(count == initVowels.length){
                res[i] = x[i];
            }
        }
        return res;
    }
    public static boolean validateCard(String x){
        int multyCache = 0;
        int sum = 0;
        int checkSum = Character.getNumericValue(x.charAt(x.length()-1));
        char[] charredX = x.toCharArray();
        char[] reversed = new char[charredX.length-1];
        for(int i = 0; i < charredX.length-1; i++){ //reverse
            reversed[i] = charredX[charredX.length - 2 - i];
        }
        for(int i = 0; i < reversed.length;){ //double 'em
            multyCache = Character.getNumericValue(reversed[i])*2;
            if(multyCache%10 != 0){
                multyCache = multyCache%10 + 1;
            }
            reversed[i] = Character.forDigit(multyCache, 10);
            i+=2;
        }
        for(int i = 0; i < reversed.length; i++){
            sum += Character.getNumericValue(reversed[i]);
        }
        if(10 - sum%10 == checkSum){
            return true;
        }
        else{
            return false;
        }
    }
    public static String numToEng(String x){
        String res = "";
        int flag = 0;
        String[] unitsDict = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] decsDict = new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"};
        String[] highDecsDict = new String[] {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if(x.length() == 3){
            res = unitsDict[Character.getNumericValue(x.charAt(0))] + " " + "hundred ";
        }
        if(x.length() >= 2){
            if((x.charAt(1) == '1' && x.length() == 3 )|| (x.charAt(0) == '1' && x.length() == 2)){
                flag = 1;
                res = res + decsDict[Character.getNumericValue(x.charAt(x.length()-1))] + " ";
            }
            else if(x.charAt(1) == '0'){
                res = res;
            }
            else{
                res = res + highDecsDict[Character.getNumericValue(x.charAt(x.length()-2))-2] + " ";
            }
        }
        if(flag != 1){
            res = res + unitsDict[Character.getNumericValue(x.charAt(x.length()-1))];
        }
        return res;
    }
    public static String getSha256Hash(String x) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(x.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for(byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    public static String correctTitle(String x){
        x = x.toLowerCase();
        String res = "";
        char[] charredX = new char[20];
        String[] words = x.split(" ");
        String[] ressed = new String[words.length];
        for(int i=0; i< words.length; i++){
            if(words[i].equals("in") || words[i].equals("the") || words[i].equals("and") || words[i].equals("of")){
                ressed[i] = words[i];
            }
            else{
                charredX = words[i].toCharArray();
                charredX[0] = Character.toUpperCase(charredX[0]);
                ressed[i] = new String(charredX);
            }
        }
        for(int i = 0; i < ressed.length;i++){
            res += ressed[i] + " ";
        }
        return res;
    }
    public static String hexLattice(int x){
        int j = 0;
        x -= 1;
        for(int i = 1; x > 0; i++){ //Check if valid and get the grade of this hexagon (j).
            x = x - i * 6;
            j = i + 1;
        }
        if (x == 0){
            String col = "";
            int cols = j * 2 - 1;
            int elemsInCol = j;
            int spaces = j - 1;
            for (int z = cols; z > 0; z--){
                for (int i = 0; i < spaces; i++){
                    col = col + " ";
                }
                for (int i = 0; i < elemsInCol; i++){
                    col = col +"o ";
                }
                if (z > j){
                    spaces = spaces - 1;
                    elemsInCol = elemsInCol + 1;
                }
                else{
                    spaces = spaces + 1;
                    elemsInCol = elemsInCol - 1;
                }
                System.out.println(col);
                col = "";
            }
            return "";
        }
        else {
            return "Invalid";
        }
    }
}

