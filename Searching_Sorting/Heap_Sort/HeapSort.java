package Heap_Sort;

import java.util.Scanner;

public class HeapSort {
	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int arraySize = getArraySize("Enter the size of Array - ");
		int[] array = new int[arraySize];
		getArrayElements("Enter the elements of array - ", array, arraySize);
		
		printArraySize("Array Size is - ", arraySize);
		printArrayElements("Array elements are - ",array, arraySize);
		
		heapSort(array, arraySize);
		
		printArrayElements("Sorted Arrsy is - ",array, arraySize);

	}

	private static void heapSort(int[] array, int arraySize) {
		
		for(int i=(arraySize/2)-1; i>=0; i--){
			//System.out.println("Value of i is - "+i+" arraySize is - "+arraySize);
			heapify(array,arraySize,i);			
		}
		
		for(int j=arraySize-1; j>=0; j--){
			int swap = array[0];
			array[0] = array[j];
			array[j] = swap;
			
			heapify(array, j, 0);
		}
		
	}

	private static void heapify(int[] array, int arraySize, int i) {
		//System.out.println("Inside Heapify Method - i is - "+i);
		int largest = i;
		int leftChild = i*2+1;
		int rightChild = i*2+2;
		//System.out.println("Largest is - "+largest+" LeftChild is - "+leftChild+" RightChild is - "+rightChild);
		
		if(leftChild < arraySize && array[leftChild] > array[largest]){
			largest =  leftChild;
		}
		
		if(rightChild < arraySize && array[rightChild] > array[largest]){
			largest = rightChild;
		}
		//System.out.println("Largest is - "+largest);
		
		if(largest != i){
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			
			//System.out.println("Calling Heapify with arguments - "+arraySize+"  "+largest);
			heapify(array, arraySize, largest);
		} /*else {
			System.out.println("IF Failed");
		}*/

		
	}

	private static void printArrayElements(String string, int[] array, int arraySize) {
		System.out.print(string);
		for(int i=0; i<arraySize; i++){
			System.out.print(" "+array[i]);
		}
		System.out.println();
	}

	private static void printArraySize(String string, int arraySize) {
		System.out.println(string+""+arraySize);
	}

	private static void getArrayElements(String string, int[] array, int arraySize) {
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
