package com.javastudy.functional.lambda;

// 인터페이스를 구현하는 3가지 방식
/* Java8부터 함수형 프로그래밍을 지원하기 위해서 람다식(Lambda expression)과
 * 스트림(Stream)이 새롭게 추가되었다. 이 람다식과 스트림을 활용하면 코드가 간결하고
 * 가독성이 높은 함수형 프로그래밍 방식의 자바 코드를 작성할 수 있다. 
 *  
 * 람다식(Lambda expression)은 간결하게 익명 함수를 표현하는 함수 표현식으로
 * 줄여서 람다(Lambda) 또는 람다 함수(Lambda function)라고도 부른다.
 * 자바의 문법에서 모든 메서드는 클래스 내부에 만들어야 하므로 객체를 생성하고
 * 그 객체 안에 있는 메서드를 호출하는 단계를 거쳐야 비로소 함수를 사용할 수 있다.
 * 이것은 함수를 정의하고 그 함수를 사용해서 프로그램을 만들어가는 함수형 프로그래밍
 * 기법과는 다른 프로그래밍 방식이다.
 * 함수형 프로그래밍은 기본적으로 함수를 1급 객체로 취급해 함수가 독립적으로 사용되며
 * 함수를 변수에 대입할 수 있고 다른 함수의 매개 변수로 사용할 수 있으며 함수의 반환
 * 값으로도 사용할 수 있다. 하지만 자바는 객체 안에서만 함수가 사용되도록 문법적으로
 * 정해놓았기 때문에 이를 해결하기 위해서 나온 방법이 람다식이다. 람다식은 기존의
 * 자바 객체지향에서 함수형 프로그래밍이 가능하도록 지원하기 위해서 도입 되었으며
 * 함수형 인터페이스를 구현하는 익명 함수로 많이 사용된다.
 **/
interface Calculator {
	int add(int a, int b);	
	//int minus(int a, int b);
}

class CalculatorImpl implements Calculator {
	@Override
	public int add(int a, int b) {
		return a + b;
	}
}

public class Lambda01 {

	public static void main(String[] args) {
		
		/* Calculator 인터페이스를 구현하는 방법은 3가지 방법이 있다. 
		 * 그 첫 번째 방법은 인터페이스의 구현체 클래스를 정의하고 아래와
		 * 같이 구현체 클래스의 인스턴스를 생성하여 사용하는 방법이 있다. 
		 **/
		Calculator cal1 = new CalculatorImpl();
		System.out.println(cal1.add(10, 20));
		
		/* 두 번째 방법은 인터페이스를 직접 구현하는 익명 클래스 방법이 있다.
		 * 첫 번째와 두 번째 방법은 이전부터 인터페이스를 구현하는 방법이다. 
		 **/
		Calculator cal2 = new Calculator() {
			@Override
			public int add(int a, int b) {				
				return a + b;
			}
		};
		System.out.println(cal2.add(20, 30));
		
		/* 세 번째 방법은 Java8에서 지원하는 람다식을 이용하는 방법이다.
		 * 인터페이스 구현 클래스 없이 람다식을 사용해 인스턴스를 생성할 수 있으며 
		 * 이 람다식은 두 번째 방식인 익명 클래스 방식을 축약한 방식으로 볼 수 있다.
		 *  
		 * 아래 코드에서 (int x, int y) 부분이 Calculator 인터페이스의 add 함수의
		 * 파라미터 입력 부분에 해당하고 x + y;는 return x + y; 부분에 해당한다.
		 * 람다식을 이용해 인터페이스의 구현 클래스 없이 인스턴스를 생성하려면 해당 
		 * 인터페이스에 정의된 추상 메서드가 오로지 한 개만 존재해야 한다.
		 **/
		Calculator cal3 = (int a, int b) -> { return a + b; };
		System.out.println(cal3.add(50, 100));		
	}
}
