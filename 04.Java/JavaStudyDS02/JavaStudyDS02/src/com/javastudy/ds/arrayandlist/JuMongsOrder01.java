package com.javastudy.ds.arrayandlist;

import java.util.Arrays;
import java.util.Scanner;

/* 주몽의 명령
 * 문제 출처 : 백준 온라인 저지 1940
 * https://www.acmicpc.net/problem/1940
 **/
public class JuMongsOrder01 {

	public static void main(String[] args) {
		
		// 사용자 입력을 받기 위한 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 재료의 개수 N과, 갑옷을 만드는데 필요한 수 M 입력 받기
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 재료 정보를 담을 배열 생성
		int[]A = new int[N];
		
		// 재료의 개수 N만큼 반복하면서 재료를 배열에 저장
		for(int i = 0; i < N; i++) {
		  A[i] = sc.nextInt();
		}

		// 재료가 저장된 배열 정렬
		Arrays.sort(A);
		
		// 만들 수 있는 갑옷의 수를 저장할 카운트 변수
		int count = 0;	
		
		// 양 끝의 index 변수 i, j
		int i = 0, j = N - 1;
		
		// 투 포인터 이동 원칙을 적용해 포인터를 이동하면서 처리
		while(i < j) {			
			// if(재료 합 < M) 작은 번호 index i++			
			if(A[i] + A[j] < M) {
				i++;
			}
			// else if(재료 합 > M) 큰 번호 index j--
			else if(A[i] + A[j] > M) {
				j--;
			}
			//else 카운트 증가, 양쪽 index i, j 이동
			else {
				count++;
				i++;
				j--;				
			}
		}
		// count 출력
		System.out.println(count);
		sc.close();
	}
}
