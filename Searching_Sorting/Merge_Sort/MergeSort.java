package Merge_Sort;

import java.util.Scanner;

public class MergeSort {
	final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int arraySize=getArraySize("Enter the size of array - ");
		int[] array = new int[arraySize];
		array = getArrayElements("Enter elements of Array - ", arraySize, array);
		
		printArraySize("Array size is - ", arraySize);
		printArrayElements("Array Elements are - ", arraySize, array);
		
		mergeSort(array, 0, arraySize-1);

		printArray(array);
	}

	private static void printArray(int[] array) {
		System.out.println();
		System.out.print("Sorted Array is - ");
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		
	}

	private static void mergeSort(int[] array, int l, int r) {
		if(l==r){
			return;
		} else {
			int m = (l+r)/2;
			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			merge(array, l, m, r);
		}
	}

	private static void merge(int[] array, int l, int m, int r) {
		int l1 = m-l+1;
		int l2 = r-m;
		
		int[] L = new int[l1];
		int[] R = new int[l2];
		
		for(int i=0; i<l1; i++){
			L[i] = array[l+i];
		}
		for(int i=0; i<l2; i++){
			R[i] = array[m+1+i];
		}
		
		int i=0, j=0;
		int k = l;
		while(i < l1 && j < l2) {
			if(L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		
		while(i<l1){
			array[k] = L[i];
			i++;
			k++;
		}
		
		while(j<l2){
			array[k] = R[j];
			j++;
			k++;
		}
	}
	

	private static void printArrayElements(String string, int arraySize, int[] array) {
		System.out.print(string);
		for(int i=0; i<arraySize; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	private static void printArraySize(String string, int arraySize) {
		System.out.println(string+" "+arraySize);
		
	}

	private static int[] getArrayElements(String string, int arraySize, int[] array) {
		System.out.println(string);
		for(int i=0; i<arraySize; i++){
			array[i]=scanner.nextInt();
		}
		return array;
	}

	private static int getArraySize(String string) {
		System.out.print(string);
		return scanner.nextInt();
	}

}
