package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Номер задачи?");
        int task = in.nextInt();
        switch(task){
            case 40:
                in.nextLine();
                String task30s = in.nextLine();
                String[] task30c = task30s.split(" ");
                int k = in.nextInt();
                processor(task30c, k);
            case 41:
                in.nextLine();
                String task41 = in.nextLine();
                System.out.println(Arrays.toString(split(task41)));
            case 42:
                in.nextLine();
                String task42 = in.nextLine();
                System.out.println("Snake or Camel");
                String func = in.nextLine();
                if(func == "Snake") {
                    System.out.println(toCamelCase(task42));
                }else{
                    System.out.println(toSnakeCase(task42));
                }
            case 43:
                float start = in.nextInt();
                float end = in.nextInt();
                float wage = in.nextInt();
                float multy = in.nextInt();
                System.out.println(overTime(start, end, wage, multy));
            case 44:
                in.nextLine();
                String task44w = in.nextLine();
                String task44h = in.nextLine();
                System.out.println(BMI(task44w, task44h));
            case 45:
                int task45 = in.nextInt();
                System.out.println(bugger(task45));
            case 46:
                in.nextLine();
                String task46 = in.nextLine();
                System.out.println(toStarShorthand(task46));
            case 47:
                in.nextLine();
                String task47a = in.nextLine();
                String task47b = in.nextLine();
                System.out.println(doesRhyme(task47a, task47b));
            case 48:
                int task48a = in.nextInt();
                int task48b = in.nextInt();
                System.out.println(trouble(task48a, task48b));
            case 49:
                in.nextLine();
                String task49 = in.nextLine();
                char task49b = in.nextLine().charAt(0);
                System.out.println(countUniqueBooks(task49, task49b));
        }

    }
    public static void processor(String[] str, int k){
        int counter = 0;
        int spaceMarker = 0;
        int flag = 0;
        for(int i = 0; i < str.length; i++){ // Loop till printed all the words
            for(int j = counter; j < str.length; j++){
                if(str[j].length()+spaceMarker <= k){ // Sum the length of the next word and the previous ones in the line.
                    System.out.print(str[j] + " ");
                    spaceMarker += str[j].length();
                }
                else{
                    System.out.println();
                    spaceMarker = 0;
                    if(counter == j){ // So loop doesn't print the last word more than once.
                        flag = 1;
                    }
                    else{
                        counter = j;
                    }
                    break;
                }
            }
        if(flag == 1){
            break;
        }
        }
    }
    public static String[] split(String x){
        String [] res = new String[x.length()/2];
        String s1 = "";
        int leftpart = 0;
        int rigthpart = 0;
        int j = 0;
        for(int i =0;i<=x.length()-1;i++){
            if(x.charAt(i)=='('){
                s1+=x.charAt(i);
                leftpart++;
            }else if(x.charAt(i)==')'){
                s1+=x.charAt(i);
                rigthpart++;
                if(leftpart==rigthpart){
                    res[j] = s1;
                    j++;
                    leftpart = rigthpart = 0;
                    s1 = "";
                }
            }
        }
        return res;
    }
    public static String toCamelCase(String s){
        String[] s1 = s.split("_");
        String res = "";
        for(int i = 0;i<s1.length;i++){
            res+=Character.toUpperCase(s1[i].charAt(0))+s1[i].substring(1, s1[i].length());
        }
        return res;
    }
    public static String toSnakeCase(String s){
        String res = "";
        for(int i = 0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                res +="_"+Character.toLowerCase(s.charAt(i));
            }else {
                res += s.charAt(i);
            }
        }
        return res;
    }
    public static String overTime(float start, float end, float pay, float multy){
        if(end<=17){
            return ("$"+String.format("%1$,.2f",((end-start)*pay)));
        }else{
            return ("$"+String.format("%1$,.2f",((17-start)*pay+(end-17)*pay*multy)));
        }
    }
    public static String BMI(String weight, String height){
        double weight_num = 0;
        if(weight.indexOf("pounds")!=-1){
            weight_num = Double.parseDouble(weight.substring(0, weight.indexOf("pounds")))*0.4536;
        }else{
            weight_num = Double.parseDouble(weight.substring(0, weight.indexOf("kilos")));
        }
        double height_num = 0;
        if(height.indexOf("inches")!=-1){
            height_num = Double.parseDouble(height.substring(0, height.indexOf("inches")))*0.0254;
        }else{
            height_num = Double.parseDouble(height.substring(0, height.indexOf("meters")));
        }
        double mass_index = (weight_num/(height_num*height_num));//*10000;
        if(mass_index<18.5){
            return (String.format("%1$,.1f", mass_index)+" Underweight");
        }else if(mass_index<=24.9){
            return (String.format("%1$,.1f", mass_index)+" Normal Weight");
        }else{
            return (String.format("%1$,.1f", mass_index)+" Overweight");
        }
    }
    public static int bugger(int a){
        int plh = a;
        int sum = a;
        int count = 0;
        while(sum/10!=0){
            sum=plh%10;
            while(plh/10!=0){
                plh/=10;
                sum*=plh%10;
            }
            plh=sum;
            count+=1;
        }
        return count;
    }
    public static String toStarShorthand(String s){
        if(s.length()==1){
            return s;
        }
        int count = 1;
        String s1 = "";
        char plh = s.charAt(0);
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==plh){
                count+=1;
            }else{
                if(count>1){
                    s1+=plh+"*"+count;
                }else{
                    s1+=plh;
                }
                count = 1;
                plh = s.charAt(i);
            }
        }
        if(count>1){
            s1+=plh+"*"+count;
        }else{
            s1+=plh;
        }
        return s1;
    }
    public static boolean doesRhyme(String s1, String s2){
        String [] s1_words = s1.split(" ");
        String s1_last_word = s1_words[s1_words.length-1];
        String [] s2_words = s2.split(" ");
        String s2_last_word = s2_words[s2_words.length-1];
        String s1_gl = "";
        String s2_gl = "";
        for(int i = 0;i<s1_last_word.length();i++){
            if((Character.toLowerCase(s1_last_word.charAt(i))=='a')||(Character.toLowerCase(s1_last_word.charAt(i))=='e')||(Character.toLowerCase(s1_last_word.charAt(i))=='i')||(Character.toLowerCase(s1_last_word.charAt(i))=='o')||(Character.toLowerCase(s1_last_word.charAt(i))=='u')){
                s1_gl+=Character.toLowerCase(s1_last_word.charAt(i));
            }
        }
        for(int j = 0;j<s2_last_word.length();j++){
            if((Character.toLowerCase(s2_last_word.charAt(j))=='a')||(Character.toLowerCase(s2_last_word.charAt(j))=='e')||(Character.toLowerCase(s2_last_word.charAt(j))=='i')||(Character.toLowerCase(s2_last_word.charAt(j))=='o')||(Character.toLowerCase(s2_last_word.charAt(j))=='u')){
                s2_gl+=Character.toLowerCase(s2_last_word.charAt(j));
            }
        }
        return (s1_gl.equals(s2_gl));
    }
    public static boolean trouble(int num1, int num2){
        int count1 = 0;
        String str_num1 = String.valueOf(num1);
        char plh = str_num1.charAt(0);
        char repeat = str_num1.charAt(0);
        int count2 = 0;
        String str_num2 = String.valueOf(num2);
        for(int i = 1; i<str_num1.length();i++){
            if(str_num1.charAt(i)==plh){
                count1+=1;
            }else{
                plh=str_num1.charAt(i);
                count1 = 1;
            }
            if(count1==3){
                repeat = str_num1.charAt(i);
                break;
            }
        }
        for(int j = 0;j<str_num2.length();j++){
            if(str_num2.charAt(j)==repeat){
                count2+=1;
            }else{
                count2 = 0;
            }
            if(count2==2){
                return true;
            }
        }
        return false;
    }
    public static int countUniqueBooks(String s, char a){
        int count = 0;
        int a_in_txt = 0;
        int plh = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==a){
                a_in_txt+=1;
                count+=plh;
                plh = 0;
            }else if((s.charAt(i)!=s.charAt(i-1))&&(a_in_txt%2!=0)){
                plh+=1;
            }
        }
        return count;
    }
}
