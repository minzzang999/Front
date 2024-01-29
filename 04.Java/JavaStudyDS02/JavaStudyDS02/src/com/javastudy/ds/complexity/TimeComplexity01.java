package com.javastudy.ds.complexity;

import java.util.Arrays;

// 연산 횟수가 1 단계인 경우 - O(1),  N인 경우 - O(N)
public class TimeComplexity01 {
	
	public static void main(String[] args) {
		int N = 1000000;
		int cnt = 0;
		
		// 반복문에서 입력 갯수 만큼 N 번의 연산이 수행 됨
		for(int i = 0; i < N; i++) {			
			cnt++;
		}
		System.out.println("전체 연산 횟수 - O(n) : " + cnt);
		
		int[] nums = {90, 70, 100, 80, 30, 20, 50, 40, 10, 60};
		System.out.println("O(n) : " + arrSum(nums));
		System.out.println("O(1) : " +arrMedian(nums));
	}
	
	// 배열 요소의 합을 반환하는 메서드
	private static int arrSum(int[] nums) {
		int sum = 0;
		
		// 반복문 안에서 배열 요소의 갯수 만큼 연산을 수행(N번 수행 - O(n))
		for(int i : nums) {
			sum += i;
		}
		return sum;
	}
	
	// 배열 요소에서 중앙값을 구해 반환하는 메서드
	private static int arrMedian(int[] nums) {
		
		/* 배열의 길이가 얼마든 상관없이 1 단계의 고정 횟수로 연산된다.
		 * 반복문이 없으므로 입력 값의 크기와 상관없이 1 단계의 고정 횟수로 연산된다.
		 * 이 메서드는 항상 같은 횟수로 1 단계 연산을 수행(1 단계인 경우 - O(1))
		 **/
		Arrays.sort(nums);
		int middle = nums.length / 2;
		
		if(nums.length % 2 == 0) {
			return (nums[middle - 1] + nums[middle]) / 2;
		} else {
			return nums[middle];
		}
	}
}
