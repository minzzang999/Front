package com.javastudy.functional.stream;

import java.util.Arrays;
import java.util.Comparator;

// 스트림과 람다를 사용하는 경우
public class StreamAndLambdaUse01 {

	/* 다음과 같이 정수 20개를 저장한 배열이 있다. 
	 * 이 배열을 중복 데이터 없이 홀수로 역순 정렬된 배열이 되도록 만들어 보자. 
	 **/
	public static void main(String[] args) {
				
		int[] nums = {7, 2, 3, 6, 5, 4, 1, 9, 5, 3, 6, 5, 8, 1, 9, 1, 2, 8, 4, 7};
		
		/* 스트림 API를 꼭 사용해야 되는 것은 아니지만 스트림 방식으로 코드를 
		 * 작성하면 일반적인 코드보다 간결하고 가독성이 뛰어난 코드를 작성할 수 있다.  
		 **/
		nums = Arrays.stream(nums)		// 배열에서 IntStream 생성
					.filter((n) -> n % 2 != 0)	// 짝수만 필터링
					.distinct()						// 중복 제거	
					.boxed()							// 정렬을 위해 IntStream을 Stream<Integer>로 변환
					.sorted(Comparator.reverseOrder())	// 데이터 역순 정렬
					.mapToInt(Integer::intValue)				// 다시 IntStream으로 변환
					.toArray();										// int형 배열로 변환 
		
		// 중복 데이터 없이 홀수로 역순 정렬된 배열의 내용 확인
		System.out.println(Arrays.toString(nums));
	}
}
