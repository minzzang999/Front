package com.javastudy.ds.sort;

import java.util.Arrays;

// 병합 정렬(Merge Sort) - 예제 작업중
public class MergeSort01 {
	
	private static int[] nums;
	private static int[] temp;
	

	public static void main(String[] args) {
		
		nums = new int[]{6, 4, 7, 2, 5, 0, 9, 1, 3, 8};
		temp = new int[nums.length];
		//System.out.println(Arrays.toString(nums));
		mergeSort(0, nums.length - 1, "main");
		//System.out.println(Arrays.toString(nums));
		
	}

	public static void mergeSort(int start, int end, String m) {
		
		// 파라미터로 받은 start가 end보다 작으면
		if(start < end) {
			
			// 시작과 마지막 index 사이의 중간 index 위치를 구함
			int mid = (start + end) / 2;
			
			// 전체 데이터에서 첫 번째 index ~ 중간 index까지 분할1
			mergeSort(start, mid, "1");
			
			// 전체 데이터에서 중간 + 1 index ~ 마지막 index까지 분할2
			mergeSort(mid + 1, end, "2");
			
			/* 투 포인터 알고리즘
			 * 두 개로 분활된 왼쪽과 오른쪽 배열의 첫 번째 index를 각각 i, j에 저장 
			 **/
			int i = start;
			int j = mid + 1;
			int index = i;
			
			// 두 개로 분할된 왼쪽과 오른쪽 배열의 index 범위까지 반복
			while(i <= mid || j <= end) {
				if(j > end || (i <= mid && nums[i] < nums[j])) {
					temp[index++] = nums[i++];
				} else {
					temp[index++] = nums[j++];
				}
				System.out.println(Arrays.toString(temp) + " - " + m + " -s : " + start + " - m : " + mid + " - e :" + end);
			}
			//System.out.println(Arrays.toString(temp));
			System.out.println("==========================");
			for(int n = start; n <= end; n++) {
				nums[n] = temp[n];
			}
			//System.out.println(Arrays.toString(nums));
		}
	}
}