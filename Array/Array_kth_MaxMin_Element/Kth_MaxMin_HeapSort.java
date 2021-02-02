package Array_kth_MaxMin_Element;

import java.util.Scanner;

public class Kth_MaxMin_HeapSort {
	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arraySize = getArraySize("Enter the Size of Array - ");
		int[] array = new int[arraySize];
		getArrayElements("Enter the elements of Array - ", arraySize, array);
		int k = getKValue("Enter the value of K (to get Kth smallest and Kth Largest element) - ");
		
		printArraySize("Array size is - ", arraySize);
		printArrayElements("Elements of Array are - ", array, arraySize);
		printKValue("K (smallest and largest element to find) value is - ", k);
		
		heapSort(array, arraySize);
		
		printArrayElements("Sorted Array is - ", array, arraySize);
		printKthSmallestElement(k+"th Smallest element is - ", array, arraySize, k);
		printKthLargestElement(k+"th Largest element is - ", array, arraySize, k);
	}

	private static void printKthLargestElement(String string, int[] array, int arraySize, int k) {
		System.out.println(string+""+array[arraySize-k]);
		
	}

	private static void printKthSmallestElement(String string, int[] array, int arraySize, int k) {
		System.out.println(string+""+array[k-1]);	
	}

	private static void heapSort(int[] array, int arraySize) {
		for(int i=(arraySize/2)-1; i>=0; i--)
			heapify(array, arraySize, i);
		
		for(int i=arraySize-1; i>=0; i--){
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			heapify(array, i, 0);
		}
	}
		
	private static void heapify(int[] array, int arraySize, int i){
		int largest = i;
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		
		if (leftChild < arraySize && array[leftChild] > array[largest])
			largest = leftChild;
		
		if (rightChild < arraySize && array[rightChild] > array[largest])
			largest = rightChild;
		
		if(largest != i){
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;

			heapify(array, arraySize, largest);
		}
	}

	private static void printKValue(String string, int k) {
		System.out.println(string+""+k);
	}

	private static void printArrayElements(String string, int[] array, int arraySize) {
		System.out.print(string);
		for(int i=0; i<arraySize; i++){
			System.out.print(" "+array[i]);
		}
		System.out.println();
	}

	private static void printArraySize(String string, int arraySize) {
		System.out.println(string+" "+arraySize);
	}

	private static int getKValue(String string) {
		System.out.println(string);
		return scanner.nextInt();
	}

	private static void getArrayElements(String string, int arraySize, int[] array) {
		System.out.println(string);
		for(int i=0; i<arraySize; i++){
			array[i]=scanner.nextInt();
		}
	}

	private static int getArraySize(String string) {
		System.out.println(string);
		return scanner.nextInt();
	}

}
