package com.javastudy.ds.arrayandlist;

import java.util.Scanner;

/* 숫자의 합
 * 문제 출처 : 백준 온라인 저지 11720
 * https://www.acmicpc.net/problem/11720
 **/
public class NumbersSum01 {

	public static void main(String[] args) {
		
		// 사용자 입력을 받기 위한 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 숫자의 개수 N값 입력 받기
		int N = sc.nextInt();
		
		// 길이 N에 해당 하는 숫자를 문자열로 입력 받아 strNums에 저장
		String strNums = sc.next();
		
		// strNums의 문자열을 하나씩 분해해서 charNums 배열에 저장
		char[] charNums = strNums.toCharArray();
		
		// 입력 받은 숫자의 합을 더할 int 형 변수 sum 선언
		int sum = 0;
		for(int i = 0; i < charNums.length; i++) {			
			/* 입력된 문자의 아스키 값에 문자 '0'의 아스키 값을 빼면 해당 숫자가
			 * 되며 이를 다시 sum에 더하여 누적 합계를 구한다. 
			 **/
			sum += charNums[i] - '0';
		}
		
		// sum 출력하기
		System.out.println(sum);
		
		// 스캐너 닫기
		sc.close();
	}
}
