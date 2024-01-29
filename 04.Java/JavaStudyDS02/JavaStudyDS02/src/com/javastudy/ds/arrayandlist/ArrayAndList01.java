package com.javastudy.ds.arrayandlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 배열과 가변 배열 구조인 ArrayList
public class ArrayAndList01 {

	public static void main(String[] args) {
		
		int[] nums = {1, 3, 5, 7, 9};
		String[] books = {"자바 프로그래밍 입문", "자바 완전정복", "자바의 정석"};		
		List<String> bookList = new ArrayList<>(Arrays.asList(books));
		
		/* 배열은 index를 통해 접근하기 때문에 데이터 검색은 빠르다. 하지만 데이터를 
		 * 추가, 삭제할 때는 기존에 저장되어 있는 데이터를 이동해야하기 때문에 느리다.
		 **/
		for(int i = 0; i < nums.length; i++) {
			System.out.printf("%s", i < nums.length - 1 ? nums[i] + ", " : nums[i] + "\n");
		}
		
		/* 배열의 길이는 한 번 정해지면 변경할 수 없기 때문에 새로운 데이터를 기존 
		 * 데이터 뒤에 추가하려면 기존 배열보다 더 큰 배열을 새로 만들어 사용해야 한다.
		 **/
		int[] nums2 = new int[nums.length + 10];
		for(int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i]; 
		}
		nums2[5] = 20;
		System.out.println(Arrays.toString(nums2));
		
		/* 자바에서는 컬렉션 프레임워크에서 Vector와 ArrayList를 가변 배열 형태로
		 * 제공하고 있다. ArrayList는 배열을 기반으로 자료를 저장하고 관리하며 요소를
		 * 저장할 수 있는 크기가 고정되어 있지 않고 가변적으로 동작하도록 설계되어 있다.
		 **/
		bookList.add("열혈 자바");
		System.out.println(bookList);
		
		System.out.println(nums.length + " : " + Arrays.toString(nums));
		System.out.println(bookList.size() + " : " + bookList);
	}
}
