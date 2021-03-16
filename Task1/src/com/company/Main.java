package com.company;
import  java.util.Scanner;
import java.io.IOException;

public class Main {
	//функция для task 3

	public static int animals(int var1, int var2, int var3) {
		int result_task3;
		result_task3 = var1 * 2 + var2 * 4 + var3 * 4;
	return result_task3;
	}


	//функция для task 4

	public static boolean profitableGamble(float prob, int prize, int pay) {
		boolean result_task4 = false;
		if (prob*prize > pay){
			result_task4 = true;
		}
		return result_task4;
	}


	//функция для task 5

	public static void operation(int x, int y, int rez) {

		if (x+y == rez){
			System.out.println("Сложение");
		}
		else if (x-y == rez){
			System.out.println("Вычитание");
		}
		else if (x*y == rez){
			System.out.println("Умножение");
		}
		else if (x/y == rez){
			System.out.println("Деление");
		}
		else {
			System.out.println("none");
		}
	}


	//функция для task 6

	public static void ctoa(char task_6){
		int askii = (int) task_6;
		System.out.println(askii);
	}


	//функция для task 7

	public static void addUpTo(int task_7){
		int count = 0;
		for (int i = 1; i < task_7+1; i++){
			count +=i;
		}
		System.out.println(count);
	}


	//функция для task 8

	public static void nextEdge(int task_8_a, int task_8_b){
		double result_task8 = Math.sqrt(task_8_a * task_8_a + task_8_b * task_8_b + 2 * task_8_a * task_8_b);
		int Final_result_task8;
		Final_result_task8 = (int) result_task8;
		if (result_task8 == Final_result_task8) {
			System.out.println(result_task8 - 1);
		}
		else {
			System.out.println(Final_result_task8);
		}
	}

	//функция для task 9

	public static void sumOfCubes(int n, int array[]){
		int result_task9 = 0;
		for (int i = 0; i < n; i++) {
			result_task9 += array[i]*array[i]*array[i];
		}
		System.out.println(result_task9);
	}



	//функция для task 10

	public static void abcmath(int task10_a, int task10_b, int task10_c){
		for (int i = 0; i < task10_b; i++){
			task10_a += task10_a;
		}
		System.out.println(task10_a);
		if (task10_a % task10_c == 0){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
	}


    public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		//task 1
		/*
		int a, b;
		System.out.print("Введите первое число: ");
		a = in.nextInt();
		System.out.print("Введите второе число: ");
		b = in.nextInt();
		System.out.println("task 1: " + a % b);

		//task 2
		System.out.println("task 2: " + a * b / 2);
		 */

		//task 3
/*
		int chickens, cows, pigs;
		System.out.print("Сколько куриц: ");
		chickens = in.nextInt();
		System.out.print("Сколько коров: ");
		cows = in.nextInt();
		System.out.print("Сколько свиней: ");
		pigs = in.nextInt();
		int result_task_3 = animals(chickens, cows, pigs);
		System.out.println("task 3: " + result_task_3);


 */
		//task 4
/*
		int prize, pay;
		float prob;
		System.out.print("Prob: ");
		prob = in.nextFloat();
		System.out.print("Prize: ");
		prize = in.nextInt();
		System.out.print("Pay: ");
		pay = in.nextInt();
		System.out.println(profitableGamble(prob, prize, pay));


		//task 5

		int x, y, rez;
		System.out.print("X: ");
		x = in.nextInt();
		System.out.print("Y: ");
		y = in.nextInt();
		System.out.print("Rez: ");
		rez = in.nextInt();
		operation(x, y, rez);



 */

		//task 6
/*
		System.out.print("task 6: ");
		char task_6;
		task_6 = (char) System.in.read();
		ctoa(task_6);




		//task 7

		System.out.print("task 7: ");
		int task_7;
		task_7 = in.nextInt();
		addUpTo(task_7);


		//task 8

		System.out.print("task 8, a: ");
		int task_8_a, task_8_b;
		task_8_a = in.nextInt();
		System.out.print("task 8, b: ");
		task_8_b = in.nextInt();
		nextEdge(task_8_a, task_8_b);


		//task 9

		System.out.print("task 9, количество элементов в массиве: ");
		int n = in.nextInt();
		int array[] = new int[10];
		for (int i = 0; i < n; i++) {
			System.out.println("Введите " + (i+1) + " элемент массива");
			array[i] = in.nextInt();
		}
		sumOfCubes(n, array);

 */
		//task 10
/*
		int task10_a, task10_b, task10_c;
		System.out.print("task 10, a = ");
		task10_a = in.nextInt();
		System.out.print("task 10, b = ");
		task10_b = in.nextInt();
		System.out.print("task 10, c = ");
		task10_c = in.nextInt();
		abcmath(task10_a, task10_b, task10_c);

 */
		double value = 34.777554;
		BigDecimal result = new BigDecimal(value);
		result = result.setScale(3, RoundingMode.DOWN);
		System.out.println(result);


	}
}
