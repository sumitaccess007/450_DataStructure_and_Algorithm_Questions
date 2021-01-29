package Array_Max_Min_Element;

import java.util.Scanner;

class MinMaxElement {
	int min;
	int max;
}

public class GetMinMax_CompareInPairs {
	static final Scanner scanner = new Scanner(System.in); 
	
	public static void main(String[] args) {
		
		int arraySize = getArraySize("Enter the size of array - ");
		int[] array = new int[arraySize];
		array = getArrayElements("Enter the elements of array - ", arraySize, array);
		printArraySize("Number of elements in array are - ", arraySize);
		printArrayElements("Elemens of Array are - ", arraySize, array);
		
		MinMaxElement finalMinMax = new MinMaxElement();
		finalMinMax = getMinMax(array, arraySize);
		printMinMax("Min and Max elements are - ", finalMinMax);

	}


	private static void printMinMax(String string, MinMaxElement finalMinMax) {
		System.out.println(string);
		System.out.println("Min Element is - "+finalMinMax.min);
		System.out.println("Max Element is - "+finalMinMax.max);
	}


	private static MinMaxElement getMinMax(int[] array, int arraySize) {
		MinMaxElement minmax = new MinMaxElement();
		int index;
		
		if(arraySize % 2 == 0){
			if(array[0] < array[1]){
				minmax.min=array[0];
				minmax.max=array[1];
			} else {
				minmax.min=array[1];
				minmax.max=array[0];
			}
			index = 2;
		} else {
			minmax.min=array[0];
			minmax.max=array[0];
			index = 1;
		}
		
		while(index < arraySize){
			if(array[index] < array[index+1]){
				if(array[index] < minmax.min){
					minmax.min = array[index];
				}
				if(array[index+1] > minmax.max){
					minmax.max = array[index+1];
				}
			} else {
				if(array[index+1] > minmax.max){
					minmax.max = array[index+1];
				}
				if(array[index] < minmax.min){
					minmax.min = array[index];
				}
			}
			index=index+2;
		}
		return minmax;
	}


	private static void printArrayElements(String string, int arraySize, int[] array) {
		System.out.print(string);
		for (int i=0; i<arraySize; i++){
			System.out.print(" "+array[i]);
		}
		System.out.println();
	}


	private static void printArraySize(String string, int arraySize) {
		System.out.print(string+""+arraySize);
		System.out.println();
	}


	private static int[] getArrayElements(String string, int arraySize, int[] array) {
		System.out.print(string);
		for(int i=0; i<arraySize; i++){
			array[i] = scanner.nextInt();
		}
		System.out.println();
		return array;
	}


	private static int getArraySize(String string) {
		System.out.print(string);
		System.out.println();
		return scanner.nextInt();
	}

}
