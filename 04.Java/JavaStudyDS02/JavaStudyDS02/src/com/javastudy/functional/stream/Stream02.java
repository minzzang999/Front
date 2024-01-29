package com.javastudy.functional.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림(Stream) 생성과 스트림 연산01
public class Stream02 {

	public static void main(String[] args) {	
		
		/* 스트림 생성
		 * 스트림을 생성하는 방법은 아주 다양하며 배열이나 컬렉션을 이용해 생성할 수도
		 * 있고 스트림이 제공하는 여러 가지 메서드를 이용해 스트림을 생성할 수도 있다.
		 **/
		
		/* 배열 스트림 생성
		 * 배열 데이터를 Arrays.stream() 메서드를 이용해 스트림을 생성
		 **/
		String[] strArr = {"Java", "HTML", "CSS", "JavaScript", "JavaFramework"};
		Stream<String> strStream = Arrays.stream(strArr);
		
		/* 컬렉션 스트림 생성
		 * Collection 인터페이스에 추가된 default 메서드를 이용해 스트림을 생성
		 **/
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> listStream = list.stream();
		
		/* Stream.builder() 메서드로 스트림 생성
		 * Stream 인터페이스의 스택틱 메서드인 builder() 메서드에 값을 지정해 스트림을
		 * 생성할 수 있으며 마지막에 build() 메서드를 호출하면 Stream을 반환한다.
		 **/
		Stream<Integer> builderStream = Stream.<Integer>builder()
															.add(8).add(3).add(2).add(9).add(5).
															build();
		
		/* Stream.iterate() 메서드로 스트림 생성
		 * Stream 인터페이스의 스태틱 메서드인 iterate() 메서드의 인수로 초기 값과
		 * 람다식을 사용해 스트림에 저정할 요소를 만들 수 있다. 아래에서 10은 초기 값이며
		 * 초기 값에서 10을 더해서 반환하는 람다식을 지정해 입력 값에 10씩 증가하는 값을
		 * 다음 요소의 입력 값이 되도록 하였으며 스트림의 사이즈는 5가 되도록 지정했다. 
		 **/
		Stream<Integer> iterateStream = Stream.iterate(10, n -> n + 10).limit(5);
		
		/* 중간 연산(intermediate operatons)
		 * 중간 연산은 스트림을 생성한 후 다양한 여러 작업을 연결해 연속적으로 데이터 흐름을
		 * 처리(파이프라인 연산)하는 작업을 수행한다. 중간 연산 단계에는 필터링(filtering),
		 * 맵핑(mapping), 정렬(sorting), 반복 작업(iterating) 등을 수행한다.
		 * 
		 * 최종 연산(terminal operations)
		 * 최종 연산은 중간 연산을 수행한 결과를 집계(calculating), 반복 작업(iterating),
		 * 최종 결과르 컬렉션 객체로 반환(collecting), 최종 결과에서 조건에 맞는 요소가
		 * 있는지 체크한 결과를 반환(matching), 결과 값 환산(reduction) 등을 수행한다. 
		 **/
		strStream.filter(s -> s.contains("Java")).forEach(System.out::println);
		
		/* map() 메서드는 인수로 받은 람다 함수를 적용해 스트림으로 반환하는 메서드 이다.
		 * 스트림의 각 요소에 20을 곱하고 내림차순 정렬해 스트림의 데이터를 콘솔에 출력한다.
		 **/
		listStream.map(i -> i * 20).sorted(Comparator.reverseOrder())
											.forEach(i -> System.out.printf("%d, ", i));
		System.out.println();
		
		/* 최종 연산이 완료된 스트림은 요소가 모두 소모되어 다시 사용할 수 없다.
		 * 아래 코드를 실행하면 IllegalStateException이 발생한다.
		 **/
		//listStream.forEach(i -> System.out.println(i));
		
		// 스트림에서 홀수만 선택해 오름차순 정렬하고 결과를 리스트로 반환한다.
		List<Integer> resultList = builderStream.filter(i -> i % 2 != 0)
											.sorted()											
											.collect(Collectors.toList());
		System.out.println(resultList);
		
		/* peek() 메서드는 반환 값이 없기 때문에 중간 결과를 확인하는 용도로 사용된다. 
		 * 스트림에서 데이터를 내림차순 정렬하고 각 요소에 10을 곱한 중간 결과를 콘솔에 
		 * 출력하고 확인하고 집계하기 위해 IntStream으로 변환 후 합계를 구해서 반환한다.
		 **/
		int sum = iterateStream.sorted(Comparator.reverseOrder())
							.map(n -> n * 10).peek(System.out::println)
							.mapToInt(Integer::intValue).sum();
		System.out.println("sum : " + sum);
	}
}
