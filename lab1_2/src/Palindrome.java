import  java.util.Scanner;

public class Palindrome {

    public static String reverseString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }

    public static void isPalindrome(String str){
        System.out.print("Слово наоборот: " + reverseString(str));
        String str1 = reverseString(str);
        System.out.print("; Является ли палиндромом: ");
        System.out.println(str.equals(str1));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "java Palindrome madam racecar apple kayak song noon";
        String[] words = str.split(" ");
        for (String word : words) {
            isPalindrome(word);
        }
    }



}

