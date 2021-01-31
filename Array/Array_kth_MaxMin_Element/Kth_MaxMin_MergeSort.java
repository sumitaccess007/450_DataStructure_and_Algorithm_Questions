package Array_kth_MaxMin_Element;

import java.util.Scanner;

public class Kth_MaxMin_MergeSort {
	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arraySize = getArraySize("Enter the size of Array - ");
		
		int[] array = new int[arraySize];
		array = getArrayElements("Enter the elemets of array - ", array, arraySize);
		
		int k = getKthSmallestIndex("Enter the value of k - ");
		
		printArraySize("Array size is - ", arraySize);
		printArrayElements("Array elements are - ", array, arraySize);
		printKvalue("kth smallest and largest, where k is - ", k);
		
		mergeSort(array, 0, arraySize-1);
		
		printKthSmallestElement(array, arraySize, k);
		printKthLargestElement(array, arraySize, k);
		

	}

	private static void printKthLargestElement(int[] array, int arraySize, int k) {
		System.out.println("Kth Largest element is - "+array[arraySize-k]);
		
	}

	private static void printKthSmallestElement(int[] array, int arraySize, int k) {
		System.out.println("Kth Smallest element is - "+array[k-1]);
		
	}

	private static void mergeSort(int[] array, int left, int right) {
		if(left == right){
			return;
		} else {
			int mid = (left+right)/2;
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array, left, mid, right);
		}
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int length1 = mid-left+1;
		int length2 = right-mid;
		
		int[] LeftArray = new int[length1];
		int[] RightArray = new int[length2];
		
		for(int i=0; i<length1; i++){
			LeftArray[i]=array[left+i];
		}
		
		for(int i=0; i<length2; i++){
			RightArray[i]=array[mid+1+i];
		}
		
		int i=0, j=0;
		int k = left;
		while(i<length1 && j<length2){
			if(LeftArray[i] < RightArray[j]){
				array[k] = LeftArray[i];
				i++;
			} else {
				array[k]=RightArray[j];
				j++;
			}
			k++;
		}
		
		while(i<length1){
			array[k] = LeftArray[i];
			i++;
			k++;
		}
		
		while(j<length2){
			array[k] = RightArray[j];
			j++;
			k++;
		}
		
	}

	private static void printKvalue(String string, int k){
		System.out.println(string+" "+k);
		System.out.println();
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
	
	private static int getKthSmallestIndex(String string){
		System.out.print(string);
		System.out.println();
		return scanner.nextInt();
	}

	private static int[] getArrayElements(String string, int[] array, int arraySize) {
		System.out.print(string);
		for(int i=0; i<arraySize; i++){
			array[i] = scanner.nextInt();
		}
		System.out.println();
		return array;
	}

	private static int getArraySize(String string) {
		System.out.print(string);
		return scanner.nextInt();
	}

}
