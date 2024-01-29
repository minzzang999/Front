package com.javastudy.ds.arrayandlist;

// 피보나치수열(Fibonacci Sequence) 생성기
/* 피보나치수열은 12세기에 이탈리아의 수학자 레오나르도 피보나치가 소개한 수열이다.
 * 당시 토끼의 번식 과정을 설명하는 문제를 통해 이 수열을 발견하였다고 한다. 피보나치
 * 수열은 각 항이 바로 앞의 두 항의 합으로 이루어진 수열로, 처음 두 항은 0과 1이다.
 * 이를 제0항 제1항이라고 하며 제2항부터는 바로 앞의 두 수를 더한 수를 나열한다.
 * 예를 들어 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 등으로 이루어진다. 피보나치수열은
 * 일반적으로 1번 항부터 1, 1, 2, 3, 5,  8, 13, 21, 34, ...와 같이 많이 표현된다.
 *
 * 피보나치수열은 다양한 수학적 성질을 가지고 있다고 알려져 있다. 가장 잘 알려진
 * 성질 중 하나는 연속되는 두 항의 비율이 황금비(약 1.618)에 근접한다는 것이다.
 * 이 비율은 수학, 예술, 자연 등 실 세계의 다양한 분야에서 중요한 역할을 하는데
 * 실제로 피보나치수열은 건축 및 디자인, 자연의 최적화 과정, 음악 구조와 리듬,
 * 경제학의 경제 주기 예측 등의 다양한 분야에서 응용되고 있다.
 **/
public class FibonacciSequence01 {

	public static void main(String[] args) {
		
		// 피보나치수열의 제1항 ~ 제20항까지 구한다.
		long[] fiboSeq = fibonacciSequence(20);		
		
		for(long num : fiboSeq) {
			System.out.println(num);
		}
		
		System.out.println("============================");		
		System.out.println(fibonacciNum(20));
		System.out.println("============================");
		
		for(int i = 1; i <= 20; i++) {
			System.out.println(fibonacciNum(i));
		}
	}
	
	// 매개변수로 받은 n 번째 항까지 피보나치 수를 배열로 반환하는 메서드
	public static long[] fibonacciSequence(int n) {
		long[] fiboSeq = new long[n];
		
		// 제1항과 제2항을 배열에 저장
		fiboSeq[0] = 1;
		fiboSeq[1] = 1;
		
		for(int i = 2; i < fiboSeq.length; i++) {
			/* 피보나치수열의 n번째 항은 바로 이전 항과 전전 항을 더한 값이
			 * 되므로  F(n) = F(n-1) + F(n-2) 와 같이 구할 수 있다.
			 **/ 
			fiboSeq[i] = fiboSeq[i - 1] + fiboSeq[i - 2];	
		}
		return fiboSeq;
	}
	
	// 매개변수로 받은 n 번째 항의 피보나치 수를 구하는 재귀 함수
	public static long fibonacciNum(int n) {
		long num;			
		if(n < 2) { // 제1항, 제2항은 1로 설정
			num = n;			
		} else {			
			num =  fibonacciNum(n - 1) + fibonacciNum(n - 2);
		}		
		return num;
	}
}

