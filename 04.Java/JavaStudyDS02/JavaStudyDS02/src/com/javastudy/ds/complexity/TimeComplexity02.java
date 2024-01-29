package com.javastudy.ds.complexity;

// 연산 횟수가 3N인 경우 - O(N)
public class TimeComplexity02 {
	
	public static void main(String[] args) {
		
		int N = 1000000;
		int cnt = 0;
		
		// 반복문에서 입력 갯수 만큼 N 번의 연산이 수행 됨
		for(int i = 0; i < N; i++) {
			cnt++;
		}
		
		// 반복문에서 입력 갯수 만큼 N 번의 연산이 수행 됨
		for(int i = 0; i < N; i++) {
			cnt++;
		}		
		
		// 반복문에서 입력 갯수 만큼 N 번의 연산이 수행 됨
		for(int i = 0; i < N; i++) {
			cnt++;
		}
		
		/* 연산 횟수가 앞 예제 O(N)에 비해 3배 차이 나는 O(3N)
		 * 이지만 시간 복잡도에서 상수는 무시하므로 O(N)과 같다.
		 **/
		System.out.println("전체 연산 횟수 - O(n) : " + cnt);
	}
}
