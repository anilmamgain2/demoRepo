package com.test;


public class QuickSelectAlgo {

	public static void main(String[] args) {
		int[] array= {99,100,85,77,56};
		QuickSelectAlgo t=new QuickSelectAlgo();
		int numberOfElement=1;
		t.sort(array,0,array.length,numberOfElement-1);
	}
	
	public void sort(int[] array,int start,int end,int index) {
			
			int pivotIndex=pivotIndex(array,start,end-1);
			if(pivotIndex<index) {
				sort(array,pivotIndex+1,end,index);
			}else if (pivotIndex>index){
				sort(array,start,pivotIndex-1,index);
			}else {
				System.out.println(array[pivotIndex]);
			}
		
	}

	public int pivotIndex(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		int pivot=array[end];
		int pivotIndex=start;
		int temp=0;
		for (int i = start; i <end; i++) {
			if(array[i]<=pivot) {
				temp=array[i];
				array[i]=array[pivotIndex];
				array[pivotIndex]=temp;
				++pivotIndex;
			}
		}
		temp=array[end];
		array[end]=array[pivotIndex];
		array[pivotIndex]=temp;
		return pivotIndex;
	}
}
