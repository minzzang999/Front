package com.javastudy.ch03.forwhile;

// 중첩 for 문을 이용해 구구단 출력하기
public class For05 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 9; i++) {
			
			for(int j = 2; j <= 9; j++) {				
				System.out.print(j + " x " + i + " = " + i * j + "\t");				
			}
			System.out.println();
		}
	}
}
