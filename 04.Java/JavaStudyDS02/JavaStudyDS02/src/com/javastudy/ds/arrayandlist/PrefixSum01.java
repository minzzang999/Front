package com.javastudy.ds.arrayandlist;

import java.util.Scanner;

/* 구간 합(Prefix Sum) 구하기
 * 문제 출처 : 백준 온라인 저지 11659
 * https://www.acmicpc.net/problem/11659
 **/
public class PrefixSum01 {

	public static void main(String[] args) {
		
		// 사용자 입력을 받기 위한 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 숫자의 개수 N과, 구하는 횟수 M 입력 받기
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 합 배열을 만들 long형 배열 변수 S 선언		
		long[] S = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			// 합 배열 만들기(S[i] = S[i - 1] + A[i])
			S[i] = S[i - 1] + sc.nextInt();
		}
		
		for(int m = 0; m < M; m++) {
			//* 합을 구해야 하는 구간(i, j) 입력 받기
			int i = sc.nextInt();
			int j = sc.nextInt(); 
			
			/* 입력 받은 i, j 구간 합을 구해 출력하기
			 * 구간 합을 구하는 공식 : S[j] - S[i - 1] 활용
			 **/
			System.out.println(S[j] - S[i - 1]);
		}
		
		sc.close();
	}
}
