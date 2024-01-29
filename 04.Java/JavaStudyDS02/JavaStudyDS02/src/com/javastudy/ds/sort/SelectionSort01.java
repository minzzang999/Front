package com.javastudy.ds.sort;

// 선택 정렬(Selection Sort)
public class SelectionSort01 {

	/* 선택 정렬은 데이터에서 최솟값(오름차순) 또는 최댓값(내림차순)을 위치를 찾아
	 * 선택하고 맨 앞에 있는 데이터와 자리바꿈(swap) 하면서 정렬하는 알고리즘 이다.
	 **/
	public static void main(String[] args) {
		
		int[] nums = {6, 4, 7, 2, 5, 0, 9, 1, 3, 8};
		
		for(int i = 0; i < nums.length; i++) {
			
			// 오름차순 정렬로 현재 맨 앞의 요소를 가장 작은 값으로 초기 설정 한다.
			int minIndex = i;
			
			// 반복문에서 정렬이 안 된 배열 요소를 탐색해 가장 작은 값을 찾는다.
			for(int j = i + 1; j < nums.length; j++) {
				
				// minIndex의 값 보다 현재 위치의 값이 작으면 새로운 index를 설정
				if(nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			
			/* 탐색이 완료되면 가장 작은 값을 정렬이 안 된 요소들 중에서
			 * 맨 앞의 요소와 자리바꿈(swap) 한다.
			 **/
			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
			
			// 향상된 for 문을 이용해 nums 배열의 정렬된 데이터를 출력한다. 
			for(int k : nums) {
				System.out.print(k);
			}
			System.out.println();
		}		
	}
}
