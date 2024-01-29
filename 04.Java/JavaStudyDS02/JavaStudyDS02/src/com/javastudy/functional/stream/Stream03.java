package com.javastudy.functional.stream;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// 스트림(Stream) 생성과 스트림 연산02
public class Stream03 {

	public static void main(String[] args) {	

		/* 기본형 스트림 생성
		 * range(start, end) 메서드는 start 지점은 포함, end 지점이 포함되지 않는다. 
		 * rangeClosed(start, end) 메서드는 start 지점과 end 지점 모두가 포함된다.
		 **/
		IntStream intStream = IntStream.range(1, 10);
		LongStream longStream = LongStream.rangeClosed(1, 1000);
		
		/* reduce() 메서드는 중간 연산 결과를 바탕으로 결과 값을 만들어 낼 때 사용할 수
		 * 있는 최종 연산 메서드로 파라미터에 따라서 다음과 같이 3가지 종류가 있다.
		 **/
		
		/* 인수가 하나인 reduce() 메서드 사용
		 * 각 요소를 처리하는 계산 함수를 인수로 지정하면 각 요소를 순회하면서 결과를 만든다.   		
		 **/
		OptionalInt sum1 = intStream.reduce(Integer::sum);		
		System.out.println("sum1 : " + sum1.getAsInt());
		
		/* 인수가 두개인 reduce() 메서드 사용
		 * 	첫 번째 인수는 계산을 위한 초기 값, 두 번째 인수는 각 요소를 처리하는 계산 함수로
		 * 각 요소를 순회하면서 중간 결과를 생성하고 마지막으로 최종 결과를 만들어 반환한다.   	
		 **/
		long sum2 = longStream.reduce(0, (a, b) -> a + b);
		System.out.println("sum2 : " + sum2);
		
		// 기본형 스트림을 boxed() 메서드를 이용해 Wrapper 타입으로 박싱할 수 있다.
		Stream<Long> boxedStream = LongStream.rangeClosed(1, 1000).boxed();
		
		/* 인수가 세 개인 reduce() 메서드 사용
		 * 병렬 처리 스트림을 연산할 때 인수가 세 개인 reduce() 메서드를 사용할 수 있다.
		 * 첫 번째 인수는 초기 값, 두 번째 인수는 각 스레드가 처리하는 계산 함수, 세 번째
		 * 인수는 각 스레드에서 연산한 결과를 조합해 최종 결과를 계산할 함수를 지정하면 된다.
		 **/
		long sum3 = boxedStream.parallel()
				.reduce(0L, 
							Long::sum, 
							(a, b) -> {
								//System.out.println("comine function called");
								return a + b;
							});
		System.out.println("sum3 : " + sum3);
		
		/* Java8부터 Random 클래스는 세 가지의 타입(IntStream, LongStream, 
		 * DoubleStream)의 난수 스트림을 만들 수 있는 메서드를 제공한다.
		 **/
		IntStream lottoStream = new Random().ints(6, 1, 46);
		lottoStream.sorted().forEach(System.out::println);
		
		// 스트림 인터페이스의 스태틱 메서드인 of() 메서드를 이용해 생성
		DoubleStream doubleStream = 
				DoubleStream.of(9.3, 3.5, 0.3, 7.6, 4.9, 8.5, 2.1, 6.2, 1.8, 5.4);
		
		/* DoubleStream에 요소를 int 형으로 변환하고 Wrapper 타입으로 박싱한다.
		 * 그리고 스트림을 정렬하고 map() 메서드에서 스트림의 요소를 다시 String으로
		 * 변환한 후 reduce() 메서드에서 입력되는 값을 역순으로 변환해 String을 반환 한다.
		 **/
		String result = doubleStream.mapToInt(n -> (int) n)
									.boxed().sorted()
									.map(n -> "" + n)
									.reduce("", (a, b) -> b + a);
		System.out.println(result);
	}
}
