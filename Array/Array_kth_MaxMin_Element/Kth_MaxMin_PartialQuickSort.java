package Array_kth_MaxMin_Element;

import java.util.Scanner;

public class Kth_MaxMin_PartialQuickSort {
	static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int arraySize = getArraySize("Enter the Size of the array - ");
		Integer[] array = new Integer[arraySize];
		getArrayElements("Enter the elements of array - ", array, arraySize);
		int k = getKValue("Enter the value of K (to get Kth smallest and Kth Largest element) - ");
		
		printArraySize("Array Size is - ", arraySize);
		printArrayElements("Array elements are - ", array, arraySize);
		printKValue(k+"th smallest and largest element to find.");
		
		int smallest = kthSmallestElement(array, 0, arraySize-1, k);
		System.out.println(k+"th Smallest element is - "+smallest);

	}
	
	private static int kthSmallestElement(Integer[] array, int left, int right, int k) {
		System.out.println("1. Outside IF - Left and Right is - ("+left+", "+right+", "+k);
		if(k > 0 && k <= right-left+1){ // If k is smaller than the number of elements
			System.out.println("2. Calling Partition - left, Right and k is - ("+left+", "+right+", "+k);
			int positionOfPivot = partition(array, left, right);
			System.out.println("positionOfPivot - "+positionOfPivot);
			
			if(positionOfPivot+1 == k){
				System.out.println("Found");
				return array[positionOfPivot];
			}
			
			if(positionOfPivot+1 > k){
				System.out.println("IF");
				//return kthSmallestElement(array, left, positionOfPivot-1, k);
				return kthSmallestElement(array, 0, right, k);
			} else {
				System.out.println("ELSE");
				//return kthSmallestElement(array, positionOfPivot+1, right, k-positionOfPivot-1);
				return kthSmallestElement(array, 0, right, k-positionOfPivot-1);
			}
			
		}
		return array[k];
	}

	private static int partition(Integer[] array, int left, int right) {
		int pivot = array[right];
		System.out.println("Left is - "+left+" Right is - "+right+" Pivot is - "+pivot);
		int i = left;
		for(int j=left; j<=right-1; j++){
			if(array[j] <= pivot){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
		}
		printArrayElements("1. In Between Array Tracking - ", array, array.length);
		int temp = array[i];
		array[i] = array[right];
		array[right] = temp;
		printArrayElements("2. In Between Array Tracking - ", array, array.length);
		
		return i;
	}

	private static void printKValue(String string) {
		System.out.println(string);
		System.out.println();
	}

	private static void printArrayElements(String string, Integer[] array, int arraySize) {
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

	private static void getArrayElements(String string, Integer[] array, int arraySize) {
		System.out.println(string);
		for(int i=0; i<arraySize; i++){
			array[i] = scanner.nextInt();
		}
		System.out.println();
	}

	private static int getArraySize(String string) {
		System.out.println(string);
		return scanner.nextInt();
	}

}
