package com.day19;

public class TowerOfHanoi {
public static void toh(int n, char s, char aux, char d) {
	if(n==1) {
		System.out.println("shift disk 1 from " + s+ " to " +d);
	return;	
	}
	toh(n-1, s,d,aux);
	System.out.println("--> move disk"+n+"from "+s+" to "+d);
	toh(n-1,aux,s,d);
}
public static void main(String[]args) {
	int n=3;
	toh(n,'A','B','C');
}
}
