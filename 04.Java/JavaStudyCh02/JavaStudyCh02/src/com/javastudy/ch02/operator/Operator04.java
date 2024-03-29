package com.javastudy.ch02.operator;

// 복합 대입 연산자와 증감 연산자 사용하기
public class Operator04 {
	
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 10;
		int num3 = 10;		
		
		/* 복합 대입연산자
		 * 아래에서 사용한 "+=", "*=", "%=" 연산자 들은 모두 먼저 더하기(+), 곱하기(*),
		 * 나머지(%) 연산을 수행한 후에 좌측의 변수에 대입하는 두 가지 동작(연산)을
		 * 수행하는 연산자로 이런 유형의 대입 연산자를 복합 대입연산자라고 한다.
		 * 아래에서 num1 += 10; 코드의 동작은 먼저 num1 + 10의 연산을 수행한 후에
		 * 그 결과를 다시 num1에 대입하게 된다. 즉 num1 = num1 + 10과 동일하다.
		 **/
		System.out.println("num1 += 10 = " + (num1 += 10));
		System.out.println("num2 *= 10 = " + (num2 *= 10));
		System.out.println("num3 %= 3 = " + (num3 %= 3));					
		System.out.println();

		int i = 5;
		int j = 10;
		
		/* 증감 연산자
		 * 증감 연산자는 연산 대상이 되는 피연산자가 하나인 단항 연산자로 피연산자의 값을
		 * 1 증가 또는 1 감소시키는 연산자이다. 증감 연산자는 아래와 같이 피연산자의 앞에
		 * 지정할 수도 있고 뒤에 지정할 수도 있다. 앞에 지정하는 경우를 선 증감 연산자라고
		 * 하며 뒤에 지정하는 경우를 후 증감 연산자라고 한다. 선 증감 연산자는 다음 연산을
		 * 수행하기 전에 피연산자의 값을 먼저 1 증감 시키고 다음 연산을 수행하며 후 증감
		 * 연산자는 다음 연산을 수행한 후에 피연산자의 값을 먼저 1 증감 시킨다.
		 *
		 * 아래 코드에서 i++은 앞에 있는 문자열 데이터 "i++ = "과 연결(+) 연산을
		 * 수행한 후에 a의 값을 1 증가시키고 --j는 먼저 j의 값을 1 감소 시킨 후에 앞에
		 * 있는 문자열 데이터 "--j = "과 연결(+) 연산을 수행한다.
		 **/
		System.out.println("i++ = " + i++ + " : " + i);
		System.out.println("--j = " + --j + " : " + j);
		
		int x = 10;
		int y = 0;

		// 먼저 x에 저장된 10을 y에 대입(할당)한 후 x의 값을 10에서 1증가 시킨다.
		y = x++;
		System.out.println("x : " + x + ", y : " + y);
		
		x = 10;
		y = 0;
		
		// 먼저 x에 저장된 10을 1증가 시킨 후 증가된 x의 값 11을 y에 대입 시킨다.
		y = ++x;
		System.out.println("x : " + x + ", y : " + y);		
	}
}
