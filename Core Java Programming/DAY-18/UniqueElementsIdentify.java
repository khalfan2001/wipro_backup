package com.day18;

public class UniqueElementsIdentify {
	public static int[] fue(int[] nums) {
		int xor=0;
		for(int num:nums) {
			xor^=num;
		}
		int setBit=xor &~(xor-1);
		int[] result =new int[2];
		for(int num:nums) {
			if((num&setBit)==0) {
				result[0]^=num;
			}
			else {
				result[1]^=num;
			}
		}
		return result;
	}
	public static void main(String[]args) {
		int []nums = {2,4,7,4,2,5};
		int[] ue=fue(nums);
		System.out.println("unique numbers are:"+ue[0]+","+ue[1]);
	}
}
