package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SinglyLinkedList {

	public static void main(String[] args) {
	
		String d="((()))))";
		int balance=0;
		for (int i = 0; i < d.length(); i++) {
			if(d.charAt(i)=='(') {
				balance++;
			}
			else {
				balance--;
			}
		}
		
		//System.out.println(Math.abs(balance));
		int[] array= {2,1,15,99,100,150,100};
		
		int firstMax=0;
		int secMax=0;
		
		if(array.length>=2) {
		for (int i = 0; i < array.length; i++) {
			
			if(i==0) {
				firstMax=array[i];
			}
			else{
				if(array[i] < firstMax) {
					firstMax=array[i];
				}
			}
			
		}
		for (int i = 0; i < array.length; i++) {
			
			if(i==0 && array[i]!=firstMax) {
				secMax=array[i];
			}
			else{
				if(array[i] < secMax && array[i]!=firstMax) {
					secMax=array[i];
				}
			}
			
		}
		
		System.out.println("firstmax:"+firstMax+" secondMax:"+secMax);
		}
		else {
			System.out.println("No max");
			
		}
		
		
		
	
	}
	
		
			


}