package com.javastudy.ds.arrayandlist;

// 팩토리얼(Factorial) 생성기
/* 계승(Factorial)은 1부터 어떤 양의 정수 n까지의 정수를 모두 곱한 것을 말하며
 * n!(n factorial로 읽음)로 나타낸다. 1부터 n개의 양의 정수를 모두 곱한 것을 
 * n계승이라고 하며 n!로 나타낸다. 즉 n! = 1 x 2 x 3 x ... x (n-1) x n 이다.
 * 
 * 0! = 1,  1! = 1,  2! = 2,  3! = 6,  4! = 24, 5! = 120,  6! = 720...
 **/
public class Factorial01 {

	public static void main(String[] args) {
		
		System.out.println(factorial(6));
		System.out.println(factorial0(6));
		
	}
	
	// n!(n factorial)을 구하는 재귀함수
	public static long factorial(int n) {
		if(n == 1) return 1;
		else return n * factorial(n - 1);
	}
	
	// n!(n factorial)을 구하여 반환하는 메서드
	public static long factorial0(int n) {
		long factorial = 1;
		for(int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
