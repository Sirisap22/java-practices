/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;
import java.util.*;
/**
 *
 * @author ACER PREDATOR
 */
public class MergeLists {
	public static void start() {
		String[] strList1;
		String[] strList2;
		int[] intList1 = {};
		int[] intList2 = {};
		
//		for (int i = 0; i < 5; i++) {
//			intList1 = new int[5];
//			intList1[i] = (int)(Math.random()*Integer.MAX_VALUE);
//		}
//		for (int j = 0; j < 5; j++) {
//			intList2 = new int[5];
//			intList2[j] = (int)(Math.random()*Integer.MAX_VALUE);
//		}
		
		list1:
		while(true) {
			System.out.print("Enter list1 : ");
			Scanner inputList1 = new Scanner(System.in);
			try {
				strList1 = inputList1.nextLine().trim().split(" ");
				intList1 = processStrToInt(strList1);
				break;
			}
			catch (IllegalArgumentException error){	
				System.out.println(error);
				continue list1;
			}
		}
		
		
		list2:
		while(true) {
			System.out.print("Enter list2 : ");
			Scanner inputList2 = new Scanner(System.in);
			try {
				strList2 = inputList2.nextLine().trim().split(" ");
				intList2 = processStrToInt(strList2);
				break;
			}
			catch (IllegalArgumentException error){	
				System.out.println(error);
				continue list2;
			}
		}
		
		Arrays.sort(intList1);
		Arrays.sort(intList2);

		int[] mergedList = mergeSortedArrays(intList1, intList2);
		
		printArr(mergedList);
	}
	
	public static int[] processStrToInt(String[] strList) {
		int[] intList = new int[strList.length];
		int i = 0;
		for (String str: strList) {
			try {
				intList[i] = Integer.parseInt(str);
				i++;
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Not a integer: '" + str + "' at index " + i + ", please try again.", e);
			}
		}
		return intList;
	}
	
	public static int[] mergeSortedArrays(int[] list1, int[] list2) {
		if (list1.length == 0) {
			return list2;
		} else if (list2.length == 0) {
			return list1;
		}
		
		int[] mergeArr = new int[list1.length + list2.length];
		
		int currentIndexFirst = 0;
		int currentIndexSecond = 0;
		int currentMergeIndex = 0;
		while (currentIndexFirst < list1.length && currentIndexSecond < list2.length) {
			if (list2[currentIndexSecond] > list1[currentIndexFirst]) {
				mergeArr[currentMergeIndex++] = list1[currentIndexFirst++];
			} else {
				mergeArr[currentMergeIndex++] = list2[currentIndexSecond++];
			}
		}
		while(currentIndexFirst < list1.length) {
			mergeArr[currentMergeIndex++] = list1[currentIndexFirst++];
		}
		while (currentIndexSecond < list2.length) {
			mergeArr[currentMergeIndex++] = list2[currentIndexSecond++];
		}
		
		return mergeArr;
	}
	
	private static void printArr(int[] list) {
		System.out.print("The merged list is ");
		for (int num: list) {
			System.out.print(num + " ");
		}
		System.out.print("\n");
	}
} 
