package com.spring.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void anagrams(String s1,String s2) {
		 
		if(s1.length() != s2.length()) {
			System.out.println("false");
		}else {
			System.out.println("true");
		}
		
//		char a[] = s1.toLowerCase().toCharArray();
//		char b[] = s2.toLowerCase().toCharArray();
		
//		Arrays.sort(a);
//		Arrays.sort(b);
		
		for(int i=0;i<=s1.length();i++) {
			for(int j=i+1;j<=s2.length();j++) {
				if(i==j) {
					System.out.println(" anagram");
				}else {
					System.out.println("Not");
				}
			}
		}
		
//		if(Arrays.equals(a, b)) {
//			System.out.println("anagram");
//		}else {
//			System.out.println("not");
//		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ss1 = sc.next();
		String ss2 = sc.next();
		
		anagrams(ss1, ss2);
		
	}
	
}
