package com.javastudy.ds.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 이 Car 클래스는 Comparable 인터페이스의 compareTo() 추상 메서드를
 * 오버라이드 하면서 이 메서드 안에서 Car 클래스의 인스턴스를 정렬하는 기준을
 * 정의한 클래스 이다. 
 **/
class Car implements Comparable<Car> {	
	private String name;
	private int price;
	
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return name + "(" + price + ")";
	}
	
	@Override
	public int compareTo(Car c) {
		// 자신의 가격이 파라미터로 받은 가격보다 크면 양수를 반환 
		if(this.price > c.price)  return 1;
		
		// 자신의 가격이 파라미터로 받은 가격과 같다면 0을 반환
		else if(this.price == c.price) return 0;
		
		// 자신의 가격이 파라미터로 받은 가격보다 작다면 음수를 반환
		else return -1;
	}
}

public class UserObjectSort01 {

	public static void main(String[] args) {
				
		int[] nums = {4, 7, 3, 1, 9, 6, 5};
		
		// 숫자는 기본 오름차순 정렬
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));		
		
		ArrayList<String> sList = new ArrayList<>();
		sList.add("스프링 프레임워크");
		sList.add("스자바 스크립트");
		sList.add("Node.js");
		System.out.println(sList);
		
		// 문자열은 사전순 정렬(유니코드 순으로 정렬됨)
		Collections.sort(sList);
		System.out.println(sList);
		
		ArrayList<Car> cList = new ArrayList<>();
		cList.add(new Car("람보르기니", 600000000));
		cList.add(new Car("포르쉐", 35000000));
		cList.add(new Car("롤스로이스", 50000000));
		System.out.println(cList);
		
		/* 사용자 정의 객체는 Comparable 인터페이스의 추상 메서드인 
		 * compareTo() 메서드에서 정의한 정렬 기준으로 정렬 된다.
		 **/
		Collections.sort(cList);
		System.out.println(cList);
	}
}








