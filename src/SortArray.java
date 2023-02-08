/*Given an array, sort the array such that the sum of the
numbers of the first half is closer to the sum of the numbers in
the 2nd half of the array. The input array is not sorted
Example :
Input : [1, 2, 3, 4]
Output : [1, 4, 3, 2]
Hint: Array has an length of 4 sum of first half is 5 and sum of 2nd half in
5
Input : [2, 7, 3, 8, 11, 12]
Output : [11, 8, 2, 3, 7, 12]
Hint: Array has an length of 6 sum of first half is 21 and sum of 2nd half in
22*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortArray {
	public static Integer sum(List<Integer> list) {
		int s=0;
		for(int i=0;i<list.size();i++) {
			s+=list.get(i);
		}
		return s;
	}
	public static void sortMyArray(Integer[] input) {
		List<Integer> list=Arrays.asList(input);
		List<Integer> selectedlist1=new ArrayList<>();
		List<Integer> selectedlist2=new ArrayList<>();
		for(Integer i:list) {
			if(sum(selectedlist1)<sum(selectedlist2) && selectedlist1.size()<=list.size()/2) {
				selectedlist1.add(i);
			}else {
				selectedlist2.add(i);
			}
		}
		List<Integer> list1=new ArrayList<>();
		list1.addAll(selectedlist1);
		list1.addAll(selectedlist2);
		System.out.println(list1);
		
		System.out.println("difference between to half lists is: "+Math.abs(sum(selectedlist1)-sum(selectedlist2)));
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the list");
		int n=sc.nextInt();
		Integer[] arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr,Collections.reverseOrder());
		sortMyArray(arr);
	}
}