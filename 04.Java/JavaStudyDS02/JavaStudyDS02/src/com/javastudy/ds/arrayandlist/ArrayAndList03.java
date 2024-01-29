package com.javastudy.ds.arrayandlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ArrayList와 LinkedList 속도 비교
public class ArrayAndList03 {

	public static void main(String[] args) {
		
		List<Integer> aList = new ArrayList<>();
		List<Integer> lList = new LinkedList<>();
		long start = 0, end = 0;		

		// ArrayList의 특정 위치에 데이터 추가하기
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			aList.add(0, i);
		}		
		end = System.currentTimeMillis();
		System.out.printf("ArrayList 데이터 추가 : %d\n", end - start);
				
		// LinkedList의 특정 위치에 데이터 추가하기
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			lList.add(0, i);
		}		
		end = System.currentTimeMillis();
		System.out.printf("LinkedList 데이터 추가 : %d\n", end - start);		

		// ArrayList에서 데이터 검색하기
		start = System.currentTimeMillis();
		for(int i = 0; i < aList.size(); i++) {
			aList.get(i);
		}		
		end = System.currentTimeMillis();
		System.out.println("ArrayList 데이터 검색 : " + (end - start));
				
		// LinkedList에서 데이터 검색하기
		start = System.currentTimeMillis();
		for(int i = 0; i < lList.size(); i++) {
			lList.get(i);
		}		
		end = System.currentTimeMillis();
		System.out.println("LinkedList 데이터 검색 : " + (end - start));		

		// ArrayList에서 데이터 삭제하기
		start = System.currentTimeMillis();
		for(int i = 0; i < aList.size(); i++) {
			aList.remove(0);
		}		
		end = System.currentTimeMillis();
		System.out.println("ArrayList 데이터 삭제 : " + (end - start));
				
		// LinkedList에서 데이터 삭제하기
		start = System.currentTimeMillis();
		for(int i = 0; i < lList.size(); i++) {
			lList.remove(0);
		}		
		end = System.currentTimeMillis();
		System.out.println("LinkedList 데이터 삭제 : " + (end - start));
	}
}
