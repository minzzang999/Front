package com.javastudy.ds.arrayandlist;


// 재귀함수(Recursive Function) 사용하기01
public class RecursiveFunction01 {

	public static void main(String[] args) {
		
		/* 반복문보다 시간이 더 많이 걸리긴 하지만 논리적인 간결함으로
		 * 복잡한 문제를 간단하게 해결 할 수 있는 장점이 있다.
		 **/
		Hi(10);		
		System.out.println("1 ~ 10 합 : " + sum(10));
		System.out.println("============================");
		
		/* 재귀함수의 기능은 반복문으로도 구현할 수 있으며 반복문은 단순히 블럭 안의
		 * 코드를 반복 수행하면 되지만 함수의 재귀호출은 매개 변수 복사, 함수 종료 후
		 * 복귀할 주소 저장 등의 컴퓨터 내부적인 추가 작업이 필요하기 때문에 반복문
		 * 보다 재귀함수의 수행 시간이 더 많이 걸린다.
		 **/
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1 ~ 10 합 : " + sum);		
	}

	/* 함수 안에서 자기 자신을 호출하는 함수를 재귀함수(Recursive Function)라고
	 * 한다. 재귀함수는 자신 안에서 계속해서 자신을 호출하기 때문에 반복문과 마찬가지로
	 * 종료 지점을 제대로 생각하고 구현해야 한다. 그렇지 않으면 무한 반복문을 도는 것
	 * 처럼 호출 스택에 계속 쌓이면서 스택 오버플로우(Stack overflow)가 발생한다.  
	 **/
	// 메시지를 n번 출력하는 재귀함수
	public static void Hi(int n) {
		// n이 0일 때 함수 종료
		if(n == 0) return;
		System.out.println("안녕 재귀함수...");
		Hi(n - 1);
	}
	
	// 1 ~ n까지의 합을 구하는 재귀함수
	public static int sum(int n) {			
		// n이 0일 경우 함수 종료
		if(n == 0) return 0;
		return n += sum(n-1);
	}
}


