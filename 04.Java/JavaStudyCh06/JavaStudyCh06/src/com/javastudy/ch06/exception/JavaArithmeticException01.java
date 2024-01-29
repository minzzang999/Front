package com.javastudy.ch06.exception;

// ArithmeticException 예외 처리하기
public class JavaArithmeticException01 {
	
	public static void main(String[] args) {
		
		int num = 100;
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			
			/* 예외 처리를 하지 않으면 Exception이 발생되었을 때
			 * 프로그램이 비정상 종료가 된다.
			 **/ 
			try {			
			/* Math.random()에서 0.1 이하의 난수가 발생되면 나누는 수가 0 이므로
			 * 정수를 0으로 나누게 되면 AirthmeticException이 발생하게 된다.
			 **/			
			result = num / (int) (Math.random() * 10);
			System.out.println(result);
			
			} catch(ArithmeticException e) {				
				/* ArithmeticException이 발생하게 되면 catch 구문으로
				 * 프로그램 흐름이 넘어오고 아래의 내용이 콘솔에 출력 된다.
				 **/
				System.out.println("0 으로 나눌 수 없음 - " + e.getMessage());
			}
		}
	}
}
