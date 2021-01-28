package Array_Max_Min_Element;

import java.util.Scanner;

class MinMax{
	int min;
	int max;
}


public class GetMaxMin_TournamentMethod {
	
	// Declaring Scanner class as a Class Constant, this constant can now be used anywhere in the class
	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int arraySize = getArraySize("Enter the size of the array - ");
		int[] array = new int[arraySize];
		getArrayElements("Enter the elements of the array - ", arraySize, array);
		System.out.println();
		printArraySize("Size of the Array is - ", arraySize);
		printArrayElements("Elements of the array are - ", arraySize, array);
		
		MinMax minmax =  new MinMax();
		minmax = getMinMax(array, 0, arraySize-1);
		
		printFinalMinMax(minmax);

	}


	private static void printFinalMinMax(MinMax minmax) {
		System.out.println();
		System.out.println("Final Min and Max elements are - ");
		System.out.println("Minimum is - "+minmax.min);
		System.out.println("Maximum is - "+minmax.max);
	}


	private static MinMax getMinMax(int[] array, int start, int end) {
		MinMax finalMinMax = new MinMax();
		MinMax firstHalfMinMax = new MinMax();
		MinMax secondHalfMinMax = new MinMax();
		
		if(start == end){
			finalMinMax.min=array[start];
			finalMinMax.max=array[start];
			return finalMinMax;
		}
		
		if(end == start + 1){
			if(array[start] < array[end]){
				finalMinMax.min=array[start];
				finalMinMax.max=array[end];
			} else {
				finalMinMax.min=array[end];
				finalMinMax.max=array[start];
			}
			return finalMinMax;
		}
		
		int mid = (start + end) / 2;
		firstHalfMinMax = getMinMax(array, start, mid);
		secondHalfMinMax = getMinMax(array, mid+1, end);
		
		if(firstHalfMinMax.min < secondHalfMinMax.min){
			finalMinMax.min = firstHalfMinMax.min;
		} else {
			finalMinMax.min = secondHalfMinMax.min;
		}
		
		if(firstHalfMinMax.max < secondHalfMinMax.max){
			finalMinMax.max = secondHalfMinMax.max;
		} else {
			finalMinMax.max = firstHalfMinMax.max;
		}
		return finalMinMax;
	}


	private static void printArrayElements(String string, int arraySize, int[] array) {
		System.out.print(string);
		for(int i=0; i<arraySize; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	private static int[] getArrayElements(String string, int arraySize, int[] array) {
		System.out.println(string);
		for(int i=0; i<arraySize; i++){
			array[i]=scanner.nextInt();
		}
		return array;
	}

	private static void printArraySize(String string, int arraySize) {
		System.out.println(string+""+arraySize);
	}

	private static int getArraySize(String string) {
		System.out.print(string);	
		return scanner.nextInt();
	}

}
