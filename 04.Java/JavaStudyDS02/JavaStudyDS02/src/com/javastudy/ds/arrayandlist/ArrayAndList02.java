package com.javastudy.ds.arrayandlist;

import java.util.ArrayList;
import java.util.LinkedList;

// ArrayaList와 LinkedList의 메서드
public class ArrayAndList02 {

	public static void main(String[] args) {
		
		ArrayList<Integer> aList = new ArrayList<>();

		// ArrayaList에 데이터 추가
		aList.add(1);
		aList.add(0, 2);
		aList.add(3);
		System.out.println(aList.size() + " : " + aList);		
		System.out.println(aList.get(2));
		
		aList.remove(0);
		System.out.println(aList);
		
		/* 연결 리스트(Linked aList)는 배열과는 다르게 인덱스나 순서에 따라서
		 * 데이터의 물리적 배치를 사용하지 않지만 순서를 가지고 연결된 순차적인 
		 * 구조를 가지며 노드의 수는 고정되어 있지 않아서 필요에 따라서 노드를
		 * 늘리거나 줄일 수 있는 자료구조 이다. 
		 **/
		LinkedList<Integer> lList = new LinkedList<>();
		
		// lList에 데이터 추가하기
		lList.add(1);
		lList.addFirst(2);
		lList.addLast(3);
		System.out.println(lList.size() + " : " + lList);
		System.out.println(lList.get(2));
		System.out.println(lList.getLast());

		/* LinkedList는 Dequeue 인터페이스를 구현한 클래스로 Dequeue 
		 * 인터페이스에는 Queue와 Stack의 메서드가 정의되어 있기 때문에
		 * 이들 메서드를 사용하면 큐나 스택의 자료구조로 사용할 수도 있다.
		 * 
		 * lList의 목록이 나타내는 큐의 꼬리(마지막 노드, rear)에 데이터 추가
		 **/		
		lList.offer(4);
		lList.offerLast(5);
		System.out.println(lList);		

		 // lList의 목록이 나타내는 스택의 맨 위에 데이터를 추가		 
		lList.push(6);
		lList.push(7);
		System.out.println(lList);
		
		// lList에서 처음과 마지막 노드 삭제
		lList.remove(0);
		lList.removeLast();
		System.out.println(lList);
		
		// lList의 목록이 나타내는 큐의 헤드(처음 노드, front) 데이터를 읽어오면서 제거
		System.out.println(lList.poll());
		System.out.println(lList);
		
		// lList의 목록이 나타내는 스택에서 맨 위 데이터를 읽어오면서 제거		
		System.out.println(lList.pop());
		System.out.println(lList);
		
		// lList의 목록이 나타내는 큐의 헤드(처음 노드, front)에서 데이터를 읽어오고 제거하지 않음
		System.out.println(lList.peek());
		System.out.println(lList.peekLast());
	}
}
