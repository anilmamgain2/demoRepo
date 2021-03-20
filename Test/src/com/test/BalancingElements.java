package com.test;

public class BalancingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {2,1,15,99,100,150,100};
		int evenSum=0;
		int oddSum=0;
		int index=0;
		int countBalanceElement=0;
		for (int i = 0; i < array.length; i++) {
			if(index<i) {
				if(i==0) {
					evenSum=evenSum+array[i-1];
				}
				else if((i-1)%2==0) {
					
					evenSum=evenSum+array[i];
				}
				else {
					oddSum=oddSum+array[i];
				}
			}
			if(index>i) {
				if(i%2==0) {
					
					evenSum=evenSum+array[i];
				}
				else {
					oddSum=oddSum+array[i];
				}
			}
			if(i==array.length-1) {
				if(evenSum==oddSum) {
					countBalanceElement++;
				}
				if(index!=array.length-1) {
				index=index+1;
				i=-1;
				 evenSum=0;
				 oddSum=0;
				}
			}
		}
		System.out.println("countBalanceElement"+countBalanceElement);
	}

}
