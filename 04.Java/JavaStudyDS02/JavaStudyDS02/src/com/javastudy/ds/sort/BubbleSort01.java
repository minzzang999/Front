package com.javastudy.ds.sort;

// 버블 정렬(Bubble Sort)
public class BubbleSort01 {
	
	public static void main(String[] args) {
		
		int[] nums = {6, 4, 7, 2, 5, 0, 9, 1, 3, 8};
		
		/* 버블정렬 알고리즘은 배열의 크기가 n개일 때 배열의 첫 번째 요소부터
		 * n-1까지 접근해 인접한 요소(다음에 오는 요소)와 크기를 비교하여
		 * swap(자리바꿈)을 반복하는 알고리즘이다. 
		 **/
		for(int i = 0; i < nums.length - 1; i++) {			
			for(int j = 0; j < nums.length -1 - i; j++) {	
				
				/* 현재 배열의 요소와 바로 다음에 위치한 배열의 요소를 비교하여 현재의
				 * 요소가 크다면 뒤 쪽으로 옮기고 다음 요소를 앞으로 옮기는 작업을 한다.
				 **/
				if(nums[j] > nums[j + 1]) {	
					
					/* 임시 저장소로 사용할 temp 변수를 선언하고 크기가 큰 현재
					 * 위치의 요소를 temp 변수에 저장한 후 크기가 작은 다음 위치의
					 * 요소를 현재 위치에 저장한다. 그리고 temp 변수에 저장된
					 * 값을 다음 위치에 저장하여 현재 위치의 요소를 뒤 쪽으로 옮긴다. 
					 **/
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;					
				}				
			}			
			
			// 향상된 for 문을 이용해 nums 배열의 정렬된 데이터를 출력한다. 
			for(int k : nums) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
}
