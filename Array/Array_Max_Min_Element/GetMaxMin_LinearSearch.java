package Array_Max_Min_Element;

/**
 * 
 * @author SUMIT SHARMA
 * Program Name - Find the Max and Min element from array with minimum number of comparsions
 * Strategy Used - Simple Linear Search Method
 * Time Complexity - O(n)
 *
 */

import java.util.Scanner;

class MinMaxElements {
	int min;
	int max;
}

public class GetMaxMin_LinearSearch {

	Scanner scanner = new Scanner(System.in);
	static int[] array;

	public static void main(String[] args) {

		MinMaxElements minMaxElements = new MinMaxElements();

		int arraySize = getArraySize();

		int firstIndex = 0;
		int lastIndex = arraySize;

		getArrayElements(arraySize);
		printArraySize(arraySize);
		printArrayElements(array);
		printMinMaxElements(minMaxElements);
		getMinMaxElement(array, firstIndex, lastIndex - 1, minMaxElements);
		printMinMaxElements(minMaxElements);

	}

	private static void printMinMaxElements(MinMaxElements minMaxElements) {
		System.out.println();
		System.out.println("Min Element is - " + minMaxElements.min);
		System.out.println("Max Element is - " + minMaxElements.max);
	}

	private static MinMaxElements getMinMaxElement(int[] array2, int firstIndex2, int lastIndex2,
			MinMaxElements minMaxElements) {
		minMaxElements.min = array2[0];
		minMaxElements.max = array2[0];

		if (firstIndex2 == lastIndex2) {
			minMaxElements.min = array2[firstIndex2];
			minMaxElements.max = array2[firstIndex2];
			return minMaxElements;
		}

		if (array2[0] < array2[1]) {
			minMaxElements.min = array2[0];
			minMaxElements.max = array2[1];
		} else {
			minMaxElements.min = array2[1];
			minMaxElements.max = array2[0];
		}

		for (int i = firstIndex2 + 2; i <= lastIndex2; i++) {
			if (array2[i] < minMaxElements.min) {
				minMaxElements.min = array2[i];
			}
			else if (array2[i] > minMaxElements.max) {
				minMaxElements.max = array2[i];
			}
		}
		return minMaxElements;
	}

	private static void printArrayElements(int[] array2) {
		System.out.print("Array Elements are -");
		for (int i = 0; i < array2.length; i++) {
			System.out.print(" " + array2[i]);
		}
		System.out.println();
	}

	private static void getArrayElements(int arraySize) {
		System.out.print("Enter the elements of array - ");
		Scanner scanner = new Scanner(System.in);
		array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println();
	}

	private static void printArraySize(int arraySize2) {
		System.out.println("Array Size is - " + arraySize2);
	}

	private static int getArraySize() {
		System.out.println("Enter the Size of Array - ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

}
