package com.javastudy.ds.queueandstack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 쌓여있는 카드
 * 문제 출처 : 백준 온라인 저지 2164
 * https://www.acmicpc.net/problem/2164
 **/
public class StackOfCards01 {

	public static void main(String[] args) {

		// 사용자 입력을 받기 위한 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 카드의 개수 N값 입력 받기
		int N = sc.nextInt();
		
		// 카드를 저장할 큐 생성
		Queue<Integer> cardQueue = new LinkedList<>();
		
		// 카드 개수 N만큼 반복하며 큐에 카드 저장
		for(int i = 1; i <= N; i++) {
			cardQueue.add(i);
		}

		/* 카드가 1장 남을 때까지 반복하여 front에 있는 카드를 버리고 – poll()
		 * 다시 front에 있는 카드를 가져와 큐의 뒤에 추가 - poll(), add() 
		 **/
		while(cardQueue.size() > 1) {
			cardQueue.poll();
			cardQueue.add(cardQueue.poll());
		}
		
		// 마지막 남을 카드 숫자 출력
		System.out.println(cardQueue.peek());
		sc.close();
	}
}
