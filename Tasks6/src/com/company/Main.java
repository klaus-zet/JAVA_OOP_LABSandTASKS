package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Номер задачи?");
        int task = in.nextInt();
        switch (task) {
            case 60:
                in.nextLine();
                int task60 = in.nextInt();
                System.out.println(bell(task60));

            case 61:
                in.nextLine();
                String task61 = in.nextLine();
                System.out.println(translateSentence(task61));

            case 62:
                in.nextLine();
                String task62a = in.nextLine();
                System.out.println(validColor(task62a));

            case 63:
                in.nextLine();
                String task63a = in.nextLine();
                System.out.println(stripUrlParams(task63a));
            case 64:
                in.nextLine();
                String task64 = in.nextLine();
                System.out.println(Arrays.toString(getHashTags(task64)));
            case 65:
                in.nextLine();
                int task65 = in.nextInt();
                System.out.println(ulma(task65));
            case 66:
                in.nextLine();
                String task66 = in.nextLine();
                System.out.println(longestNonrepeatingSubstring(task66));
            case 67:
                in.nextLine();
                int task67 = in.nextInt();
                System.out.println(convertToRoman(task67));
            case 68:
                in.nextLine();
                String task68 = in.nextLine();
                System.out.println(formula(task68));
            case 69:
                in.nextLine();
                int task69 = in.nextInt();
                System.out.println(palindromedescendant(task69));
        }

    }

    public static double bell(int x){ // Compute Bell's triangle to get these magic numbers.
        int[][] bellTriangle = new int[x+1][x+1];
        bellTriangle[0][0] = 1;
        for (int i=1; i<=x; i++)
        {
            bellTriangle[i][0] = bellTriangle[i-1][i-1];
            for (int j=1; j<=i; j++)
                bellTriangle[i][j] = bellTriangle[i-1][j-1] + bellTriangle[i][j-1];
        }
        return bellTriangle[x][0];
    }
    public static String translateWord(String x){
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        String beforeVowel = "";
        int flag = 0;
        for(int i = 0; i < x.length(); i++){
            char current = x.charAt(i);
            for(int j = 0; j < vowels.length; j++){
                if(current == vowels[j]){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                beforeVowel += current;
                flag = 0;
            }
        }
        if(beforeVowel.length()==0){
            return x+"ay";
        }
        else{
            return x.substring(x.indexOf(beforeVowel) +  beforeVowel.length()) + beforeVowel + "ay";
        }
    }
    public static String translateSentence(String x){
        x = x.toLowerCase();
        String[] xSplit = x.split(" ");
        for(int i = 0; i < x.length(); i++){
            if(xSplit[i].charAt(xSplit[i].length()-1) == ',' || xSplit[i].charAt(xSplit[i].length()-1) == '.'){
                char punct = xSplit[i].charAt(xSplit[i].length()-1);
                xSplit[i] = xSplit[i].substring(0, xSplit[i].length()-2);
                xSplit[i] = translateWord(xSplit[i])+punct;
            }
            else{
                xSplit[i] = translateWord(xSplit[i]);
            }
        }
        xSplit[0] = Character.toUpperCase(xSplit[0].charAt(0))+xSplit[0].substring(1, xSplit[0].length()-1);
        return xSplit.toString();
    }
    public static boolean validColor(String x){
        int checker = 0;
        int num = x.indexOf('(');
        if (x.contains(" "))
            return false;
        String [] newrgb = x.substring(x.indexOf('(')+1,x.indexOf(')')).split(",");
        double [] n = new double [num];
        for (int i = 0 ; i < num; i++) {
            n[i] = Double.parseDouble(newrgb[i]);
        }
        for (int i = 0 ; i < num; i++) {
            if(n[i] >= 0 && n[i] <= 255 && num == newrgb.length){
                checker+=1;
            }
        }
        if(checker == newrgb.length){
            return true;
        }
        return false;
    }
    public static String stripUrlParams (String url, String ... paramsToStrip) {
        String str = "";
        if(!url.contains("?"))
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }
        char[] params = str.toCharArray();

        StringBuilder print = new StringBuilder();
        for(char param : params) {
            if(Character.isLetter(param))
                if(!(print.toString().contains(String.valueOf(param)))) {
                    if(paramsToStrip.length > 0) {
                        for(String arg : paramsToStrip) {
                            if(!(arg.contains(String.valueOf(param))))
                                print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");
                        }
                    }
                    else
                        print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");
                }
        }
        return url + print.substring(0, print.length()-1);
    }
    public static String[] getHashTags(String x){
        String[] hashtags = new String[]{" ", " ", " "};
        StringBuilder buf = new StringBuilder();
        for (int i = 0 ; i<x.length();i++){
            if (x.charAt(i) != ' ')
                buf.append(x.charAt(i));
            else if (buf.length() > hashtags[0].length()) {
                hashtags[0] = buf.toString();
                buf = new StringBuilder();
            }
            else if (buf.length() > hashtags[1].length()) {
                hashtags[1] = buf.toString();
                buf = new StringBuilder();
            }
            else if (buf.length() > hashtags[2].length()) {
                hashtags[2] = buf.toString();
                buf = new StringBuilder();
            }
            else
                buf = new StringBuilder();
        }
        for (int i = 0; i < hashtags.length; i++){
            hashtags[i] = "#" + hashtags[i].toLowerCase();
        }
        return hashtags;
    }
    public static int ulma (int n){
        int[] mas = new int[n];
        mas[0]=1;
        mas[1]=2;
        int len=2, next=3;
        while (len<n){
            int count =0;
            for (int i=0;i<len;i++){
                for (int j=len-1; j>i; j--){
                    if (mas[i]+mas[j]==next && mas[i]!=mas[j])
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                mas[len]=next;
                len++;
            }
            next++;
        }
        return mas[n-1];
    }
    public static String longestNonrepeatingSubstring(String str){
        String subStr = "";
        char [] mass = str.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (char c : mass) {
            if (!strBuilder.toString().contains(String.valueOf(c)))
                strBuilder.append(c);
            else {
                if (strBuilder.length() > subStr.length())
                    subStr = strBuilder.toString();
                strBuilder = new StringBuilder("" + c);
            }
        }
        str = strBuilder.toString();
        if (str.length()>subStr.length())
            subStr=str;
        return subStr;
    }
    public static String convertToRoman (int num){
        StringBuilder roman = new StringBuilder();
        if (num < 1 || num > 3999)
            return "Invalid number";
        while (num >= 1000) {
            roman.append("M");
            num -= 1000;        }
        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }
        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }
        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }
        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }
        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }
        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }
        return roman.toString();
    }
    public static boolean formula(String formula){
        String[] mass = formula.split(" ");
        int ans = 0;
        int expectedResult = 0;
        if (!Character.isDigit(mass[0].charAt(0))) {
            return false;
        }
        else{
            ans = Integer.parseInt(mass[0]);
        }

        int n = 1;
        while (!mass[n].equals("=")) {
            if (mass[n].equals("+")){
                ans += Integer.parseInt(mass[n + 1]);
            }
            if (mass[n].equals("-")){
                ans -= Integer.parseInt(mass[n + 1]);
            }
            if (mass[n].equals("*")){
                ans *= Integer.parseInt(mass[n + 1]);
            }
            if (mass[n].equals("/")){
                ans /= Integer.parseInt(mass[n + 1]);
            }
            n += 2;
        }
        n = formula.indexOf('=');
        String check = formula.substring(n + 1, formula.length());
        if (check.contains("=")){
            return false;
        }
        else{
            expectedResult = Integer.parseInt(mass[mass.length - 1]);
        }
        return ans == expectedResult;
    }
    public static boolean palindromedescendant(int num){
        boolean flag = false;
        StringBuffer curGen =new StringBuffer(num);
        StringBuffer nextGen =new StringBuffer(num);
        if (curGen.length()%2!=0)
            return false;
        else{
            while (!flag){
                if(curGen != curGen.reverse()){
                    for(int i=0; i<curGen.length();i+=2){
                        int a = Integer.parseInt(String.valueOf(curGen.charAt(i)));
                        int b = Integer.parseInt(String.valueOf(curGen.charAt(i+1)));
                        nextGen.append(a+b);
                    }
                }
                else
                    flag = true;
            }
        }
        return flag;
    }
}