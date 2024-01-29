package com.javastudy.ds.sort;

// 삽입 정렬(Insertion Sort)
public class InsertionSort01 {

	/* 삽입 정렬은 이미 정렬된 데이터 범위에서 정렬되지 않은 데이터를 적절한 위치에
	 * 삽입 시켜서 정렬하는 알고리즘으로 두 번째 요소부터 n번째 요소까지 현재 요소의
	 * 앞쪽에 있는 요소들과 비교해 현재 요소가 위치할 index에 요소를 삽입하는 방식이다.
	 **/
	public static void main(String[] args) {
		
		int[] nums = {6, 4, 7, 2, 5, 0, 9, 1, 3, 8};
		
		// 최초 실행될 때 두 번째 요소가 현재 요소가 된다.
		for(int i = 1; i < nums.length; i++) {
			
			// 현재 선택된 요소의 값을 임시 변수에 저장한다.
			int temp = nums[i];
			
			// 현재 요소를 기준으로 이전 원소를 탐색하기 위한 index 변수
			int prev = i - 1;
			
			// 현재 선택된 요소가 이전 요소 보다 작은 경우만 index 0번까지 반복
			while(prev >= 0 && nums[prev] > temp) {
				// 현재 선택된 요소가 탐색 중인 요소 보다 작다면 탐색한 요소를 다음으로 보낸다.
				nums[prev + 1] = nums[prev];
				prev--;
			}
			
			// 탐색이 종료된 지점에 현재 선택된 요소의 값을 삽입한다.
			nums[prev + 1] = temp;
			
			// 향상된 for 문을 이용해 nums 배열의 정렬된 데이터를 출력한다. 
			for(int k : nums) {
				System.out.print(k);
			}
			System.out.println();
		}		
	}
}
