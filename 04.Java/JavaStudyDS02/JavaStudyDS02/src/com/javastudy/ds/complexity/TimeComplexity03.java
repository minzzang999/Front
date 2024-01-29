package com.javastudy.ds.complexity;

// 연산 횟수가 N ^ 2인 경우 - O(N ^ 2)
public class TimeComplexity03 {

	public static void main(String[] args) {
		int N = 1000000;
		long cnt = 0;
		
		// 중첩 for 문은 입력 갯수의 제곱 만큼 N ^ 2 번의 연산이 수행 됨
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				cnt++;
			}	
		}		
		
		System.out.println("전체 연산 횟수 - O(N ^ 2) : " + cnt);
	}

}
