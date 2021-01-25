package Array_Reverse;

import java.util.Scanner;

/**
 * 
 * @author SUMIT SHARMA
 * Program Name - Reverse the Array
 * Strategy Used - Recursive Method
 * Time Complexity - O(n)
 *
 */
public class Array_Reverse_Recursively {  

	public static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void reverseArray(int arr[], int start, int end) {
		if (start >= end)
			return;
		else {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		reverseArray(arr, start + 1, end - 1); // Recursively calling the function until start >= end
		// In iterative method -- We will execute the logic of swapping of elements, until start < end)
	}

	public static void main(String[] args) {

		// Using the Scanner class for getting the input from user
		Scanner scanner = new Scanner(System.in);
		
		int n; // Variable to get the number of elements in array
		int[] arr; // Array to hold the elemtnts

		// Get the number of elements in the array from user
		System.out.println("Enter numbre of elements in Array - ");
		n = scanner.nextInt();

		// Get all the elements from user using Scanner Class
		System.out.println("Enter all the elements of Array - ");
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}

		// Print the number of elements
		System.out.println("Number of elements in Arrray are - " + n);
		System.out.println();

		// Printing all the elemets of array
		System.out.print("Input Array is - ");
		printArray(arr, arr.length);

		// Alrorithm to reverse the Array entered by User (Recursively)
		reverseArray(arr, 0, arr.length - 1);

		// Printing all the elemets of array after calling reverse_array
		System.out.print("Output (Reverse) array is - ");
		printArray(arr, arr.length);

	}

}
