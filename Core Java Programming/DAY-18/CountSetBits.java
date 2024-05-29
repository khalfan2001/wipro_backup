package com.day18;

public class CountSetBits {
	public static int csb(int num) {//count set bits
		int count=0;
		while(num>0) {
			count+=(num&1);
			num>>=1;
			
		}
		return count;
	}
	public static int tsb(int n) {//total set bits
		int total =0;
		for(int i=1;i<=n;i++) {
			total +=csb(i);
		}
		return total;
	}
	public static void main(String[]ards) {
		int nu=5;//declare the end numbers
		int t=tsb(nu);//total 1's in the range
		System.out.println("total number of bits form 1 to"+nu+":"+t);
	}
}
