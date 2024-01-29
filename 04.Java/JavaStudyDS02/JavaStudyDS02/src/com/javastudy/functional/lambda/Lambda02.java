package com.javastudy.functional.lambda;

// 함수형 인터페이스와 람다식 표현 방법
/* @FunctionalInterface 애노테이션은 람다식으로 구현할 함수형 인터페이스를
 * 정의하는 것으로 이 애노테이션이 지정된 인터페이스는 오로지 단일 추상 메서드만
 * 정의할 수 있다. 그러므로 람다식으로 구현할 인터페이스에는 두 개 이상의 추상 메서드를
 * 정의할 수 없도록 @FunctionalInterface 애노테이션을 지정하는 것이 좋다.
 * 
 * 람다식은 함수형 프로그램을 지원하기 위해서 인터페이스의 추상 메서드를 구현할 때 
 * 사용할 수 있는 이름 없는 함수이며 인터페이스 안에서 정의되어 있는 추상 메서드가
 * 여러 개라면 이름을 사용할 수 없는 람다식이 어떤 추상 메서드를 구현하고 있는지 알 수
 * 없기 때문에 함수형 인터페이스에 추상 메서드는 하나만 정의 할 수 있지만 Java8부터
 * 지원하는 default 메서드와 static 메서드는 여러 개를 정의할 수 있다.  
 * 
 * 자바에서 메서드를 호출하려면 클래스 이름이나 참조 변수를 통해서 호출 할 수 있다.
 * 그러므로 람다식을 사용하기 위해서 함수형 인터페이스를 만들고 그 안에 람다식으로
 * 구현할 추상 메서드를 정의하고 람다식으로 구현한 이름 없는 함수를 대입해 사용한다.
 **/
@FunctionalInterface
interface Cal01{
	public void add();
	
	// 만약 이 인터페이스에 추상 메서드가 두개 이상이라면 람다는 사용할 수 없다.
	// public int minus(int x, int y);
	
	// 함수형 인터페이스에도 default 메서드와 static 메서드는 여러 개 정의 할 수 있다.
	default void defaultPrint(String msg) {
		System.out.println(msg + " 출력...");
	}
	
	static void staticPrint(String msg) {
		System.out.println(msg + " 출력...");
	}
}

interface Cal02{
	public void add(int a);
}

interface Cal03 {
	public int add();
}

interface Cal04{
	public double add(int a, double b);
}


public class Lambda02 {

	public static void main(String[] args) {
		
		// 람다식은 다음과 같이 "(매개변수) -> { 실행문 }"과 같은 구조로 작성한다. 
		Cal01 cal01 = () -> { System.out.println(10 + 10); };
		
		// 함수의 구현부가 한 줄이면 중괄호를 생략할 수 있다.
		//Cal01 cal01 = () ->  System.out.println(10 + 10);
		cal01.add();
		
		// 매개 변수가 한 개 일 때 람다식은 다음과 같다
		// Cal02 cal02 = (int a) -> { System.out.println(a + 20); };
		
		// 매개 변수가 한 개 일 때 아래와 같이 매개 변수의 자료형을 생략 할 수 있다.
		// Cal02 cal02 = (a) -> { System.out.println(a + 20); };
		
		/* 매개 변수가 한 개 일 때는 괄호를 생략할 수 있고 괄호를 생략하면 매개 변수의
		 * 타입을 반드시 생략해야 한다. 함수 본문이 한 줄이면 중괄호 또한 생략할 수 있다.
		 **/
		Cal02 cal02 = a -> { System.out.println(a + 20); };
		// Cal02 cal02 = a ->  System.out.println(a + 20);
		cal02.add(20);
		
		/* 람다식의 함수 본문에서 반환 값이 있으면 return 문을 사용할 수 있고
		 * return 문이 사용되면 중괄호는 생략할 수 없다.
		 **/
		Cal03 cal03 = () -> { return 30 + 30; };
		
		/* 앞에서와 같이 함수 본문이 한 줄이면 중괄호를 생략할 수 있으며 만약 함수
		 * 본문이 return 문만 있는 경우 아래와 같이 return은 생략할 수 있으며
		 * 이 때 중괄호도 함께 생략해야 된다.
		 **/		
		//Cal03 cal03 = () -> 30 + 30;
 		System.out.println(cal03.add());
		
 		/* 람다식 함수의 매개 변수도 여러 개를 사용할 수 있고 함수 본문이 return만 
 		 * 있는 경우 return과 중괄호를 함께 생략할 수 있다.
 		 */ 		 
		//Cal04 cal04 = (int a, double b) -> { return a + b; };
		Cal04 cal04 = (int a, double b) -> a + b;
		System.out.println(cal04.add(40, 40));
	}
}
