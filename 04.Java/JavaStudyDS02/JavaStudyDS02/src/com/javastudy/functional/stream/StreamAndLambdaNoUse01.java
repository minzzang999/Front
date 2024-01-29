package com.javastudy.functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

// 스트림과 람다를 사용하지 않는 경우
public class StreamAndLambdaNoUse01 {

	/* 다음과 같이 정수 20개를 저장한 배열이 있다. 
	 * 이 배열을 중복 데이터 없이 홀수로 역순 정렬된 배열이 되도록 만들어 보자. 
	 **/
	public static void main(String[] args) {
				
		int[] nums = {7, 2, 3, 6, 5, 4, 1, 9, 5, 3, 6, 5, 8, 1, 9, 1, 2, 8, 4, 7};
		
		// ArrayList에 배열에서 짝수를 추출해 저장
		ArrayList<Integer> nList = new ArrayList<>();
		for(int n : nums) {
			if(n % 2 != 0) {
				nList.add(n);
			}
		}
		
		// ArrayList에 있는 중복 데이터를 제거하기 위해서 HashSet으로 변경
		HashSet<Integer> set = new HashSet<>(nList);
		
		// HashSet을 ArrayList로 변경하고 역순으로 정렬
		ArrayList<Integer> uList = new ArrayList<>(set);
		Collections.sort(uList, Comparator.reverseOrder());
		
		// 다시 int형 배열로 만들기
		nums = new int[uList.size()];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = uList.get(i);
		}
		
		// 중복 데이터 없이 홀수로 역순 정렬된 배열의 내용 확인
		System.out.println(Arrays.toString(nums));
	}
}
