package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //task 1 Создайте функцию, которая повторяет каждый символ в строке n раз.
            System.out.println("task 1");
            String task1_1 = "NOT";
            String task1_2 = "";
            System.out.print("Введите количество повторений символов: ");
            int n1 = in.nextInt();
            for (int i = 0; i < task1_1.length(); i++) {
                for (int j = 0; j < n1; j++) {
                    task1_2 += task1_1.charAt(i);
                }
            }
            System.out.println(task1_2);



        //task 2 Создайте функцию, которая принимает массив и возвращает разницу между самыми большими и самыми маленькими числами.
            System.out.println("task 2");
            System.out.println("Введите размер массива: ");
            int n2 = in.nextInt();
            int[] task2 = new int[n2];
            System.out.println("Введите элементы массива");
            for (int i = 0; i < n2; i++){
                task2[i] = in.nextInt();
            }

            int min = task2[0];
            int max = task2[0];

            for (int i = 1; i < n2; i++){
                if (min > task2[i]){
                    min = task2[i];
                }
                if (max < task2[i]){
                    max = task2[i];
                }
            }

            System.out.println("Результат: " + (max-min));



        //task 3 Создайте функцию, которая принимает массив в качестве аргумента и возвращает true или false в зависимости от того,
        // является ли среднее значение всех элементов массива целым числом или нет.

            System.out.println("task 3");
            System.out.println("Введите размер массива: ");
            int n3 = in.nextInt();
            int[] task3 = new int[n3];
            System.out.println("Введите элементы массива");
            for (int i = 0; i < n3; i++){
                task3[i] = in.nextInt();
            }

            int sum_task3 = 0;
            boolean isTrue = false;

            for (int i = 0; i < n3; i++){
                sum_task3 += task3[i];
            }


            float res_task3 = ((float) sum_task3) /n3;

            System.out.println(sum_task3);
            System.out.println(res_task3);
            System.out.println(sum_task3/n3);

            if ( res_task3 == (sum_task3/n3)){
                isTrue = true;
                System.out.println(isTrue);
            }
            else{
                System.out.println(isTrue);
            }




        // task 4 Создайте метод, который берет массив целых чисел и возвращает массив, в котором каждое целое число является суммой самого себя + всех предыдущих чисел в массиве.
        System.out.println("task 4");
        System.out.println("Введите размер массива: ");
        int n4 = in.nextInt();
        int[] task4 = new int[n4];
        int[] res_task4 = new int[n4];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < n4; i++){
            task4[i] = in.nextInt();
            for (int j = 0; j < i+1; j++){
                res_task4[i] += task4[j];
            }
        }
        for (int i = 0; i < n4; i++) {
            System.out.println(res_task4[i]);
        }



        // task 5 Создайте функцию, которая возвращает число десятичных знаков, которое имеет число (заданное в виде строки).
        // Любые нули после десятичной точки отсчитываются в сторону количества десятичных знаков.
        System.out.println("task 5");
        System.out.print("Введите число: ");
        String task5 = in.next();
        System.out.println(task5.length()-task5.indexOf(",")-1);



        // task 6 Создайте функцию, которая при заданном числе возвращает соответствующее число Фибоначчи.
        System.out.println("task 6");
        int task6 = in.nextInt();
        int count = 0, count2 = 1;
        System.out.print(count + "; ");
        for (int i = 0; i < (task6 - 1); i++){
            if (i % 2 == 0){
                count += count2;
            }
            else {
                count2+=count;
            }
            if(count > count2) {
                System.out.print(count + "; ");
            }
            else {
                System.out.print(count2 + "; ");
            }
        }



        // task 7 Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку, напишите функцию, чтобы определить, является ли вход действительным почтовым индексом.
        // Действительный почтовый индекс выглядит следующим образом:
        //– Должно содержать только цифры (не допускается использование нецифровых цифр).
        //– Не должно содержать никаких пробелов.
        //– Длина не должна превышать 5 цифр.
        System.out.println();
        System.out.println("task 7");
        String task7 = in.next();
        boolean isTrue7 = true;
        if (task7.length() == 5) {
            for (int i = 0; i < 5; i++) {
                if (((int) task7.charAt(i) < 48) || ((int) task7.charAt(i) > 57)){
                    isTrue7 = false;
                }
            }
        }
        else {
            isTrue7 = false;
        }
        System.out.println(isTrue7);



        //task 8 Пара строк образует странную пару, если оба из следующих условий истинны:
        //– Первая буква 1-й строки = последняя буква 2-й строки.
        //– Последняя буква 1-й строки = первая буква 2-й строки.
        //– Создайте функцию, которая возвращает true, если пара строк представляет собой странную пару, и false в противном случае.

        System.out.println("task 8");
        String task8_1 = in.next(), task8_2 = in.next();
        boolean isTrue8 = false;
        if ((task8_1.charAt(0) == task8_2.charAt(task8_2.length()-1)) && (task8_2.charAt(0) == task8_1.charAt(task8_1.length()-1))){
            isTrue8 = true;
        }
        System.out.println(isTrue8);



        //task 9 Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
        //– isPrefix должен возвращать true, если он начинается с префиксного аргумента.
        //– isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
        //– В противном случае верните false
        System.out.println("task 9");
        String task9_word = in.next(), task9_fix = in.next();
        boolean isTrue9 = true;

        for(int i = 0; i < task9_fix.length() - 1; ++i) {
            char prefix_word_task9 = task9_word.charAt(i);
            char prefix = task9_fix.charAt(i);
            if (prefix_word_task9 != prefix) {
                isTrue9 = false;
            }
        }
        System.out.println("Prefix: " + isTrue9);
        isTrue9 = true;

        for(int i = 0; i < task9_fix.length() - 1; ++i) {
            char sufix_word_task9 = task9_word.charAt(task9_word.length() - i - 1);
            char sufix = task9_fix.charAt(task9_fix.length() - i - 1);
            if (sufix_word_task9 != sufix) {
                isTrue9 = false;
            }
        }
        System.out.println("Sufix: " + isTrue9);



        // task 10 Создайте функцию, которая принимает число (шаг) в качестве аргумента и возвращает количество полей на этом шаге последовательности.
        System.out.println("task 10");
        int task10 = in.nextInt();
        int count10 = 0;
        for (int i = 0; i <= task10; i++){
            if (i == 0){
                count10 = 0;
            }
            else if (i % 2 == 0){
                count10 += -1;
            }
            else {
                count10 += 3;
            }
        }
        System.out.println(count10);
    }

}
