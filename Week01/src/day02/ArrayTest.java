package day02;

//import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);

		int arr[] = new int[5];
		// 지역변수 동적메모리 할당 O
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}System.out.println("\n=======");
		
		int arr2[][] = new int[2][3];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j]);
			}System.out.println();
		}System.out.println("=======");
		
		int arr3[][] = new int [2][];
		arr3[0] = new int[3];
		arr3[1] = new int[2];
/*		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(arr3[i][j]);
			}
		} 	 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
			 at day02.ArrayTest.main(ArrayTest.java:29)			*/
		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j]);
			}System.out.println();
		}System.out.println("=======");
		
		for (int i : arr) {
			System.out.print(i);
		}	//for each

		
		
		
		
		
		
	}
}
