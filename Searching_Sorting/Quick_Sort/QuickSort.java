package Quick_Sort;

import java.util.Scanner;

public class QuickSort {
	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arraySize = getArraySize("Enter the size of array - ");
		int[] array = new int[arraySize];
		getArrayElements("Enter the elements of array - ", array, arraySize);
		
		printArraySize("Array size is - ", arraySize);
		printArrayElements("Elements of array are - ", array, arraySize);
		
		System.out.println("Calling Quick Sort - ");
		quickSort(array, 0, arraySize-1);
		printArrayElements("Elements of array after Quick Sort are  - ", array, arraySize);
	}

	private static void quickSort(int[] array, int low, int high) {
		System.out.println("In Quick Sort, Low is - "+low+" High is - "+high);
		if(low < high){
			int pivot = partition(array, low, high);
			System.out.println("Pivot index is - "+pivot+" Element is - "+array[pivot]);
			quickSort(array, low, pivot-1);
			quickSort(array, pivot+1, high);
		}
		
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		System.out.println("In Partition method,,, low is - "+low+" high is - "+high+" pivot is - "+pivot+" i is -"+i);
		for(int j=low; j<high; j++){
			System.out.println("The value of j is - "+j+" array element is - "+array[j]+" i is - "+i);
			if(array[j] < pivot){
				i=i+1;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i+1];
		array[i+1] = array[high];
		array[high] = temp;
		return i+1;
	}

	private static void printArrayElements(String string, int[] array, int arraySize) {
		System.out.println(string);
		for(int i=0; i<arraySize; i++){
			System.out.print(" "+array[i]);
		}
		System.out.println();
	}

	private static void printArraySize(String string, int arraySize) {
		System.out.println(string+" "+arraySize);
		
	}

	private static void getArrayElements(String string, int[] array, int arraySize) {
		System.out.println(string);
		for(int i=0; i<arraySize; i++){
			array[i] = scanner.nextInt();
		}
		
	}

	private static int getArraySize(String string) {
		System.out.println(string);
		return scanner.nextInt();
	}

}
