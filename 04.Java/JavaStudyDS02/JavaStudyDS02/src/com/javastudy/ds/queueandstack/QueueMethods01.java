package com.javastudy.ds.queueandstack;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 선입선출(First In First Out) 구조를 가진 큐(Queue)
public class QueueMethods01 {

	public static void main(String[] args) {
		
		/* LinkedList는 Dequeue 인터페이스를 구현한 클래스로 Dequeue
		 * 인터페이스에는 Queue와 Stack의 메서드가 정의되어 있기 때문에
		 * 이들 메서드를 사용하면 큐나 스택의 자료구조를 사용할 수도 있다.
		 * 
		 * 큐의 자료구조는 선입선출(FIFO, First In First Out) 구조를 가지고 있어서
		 * 데이터가 들어온 순서대로 데이터가 나가는 구조로 다음과 같이 큐의 대기열에 추가된다. 
		 * 
		 * --front------------rear--    
		 *    70  30  50  90  60   
		 * --------------------------- 
		 **/
		Queue<Integer> queue1 = new LinkedList<>();
		queue1.add(70);
		queue1.add(30);
		queue1.add(50);
		queue1.add(90);
		queue1.add(60);

		// peek() 메서드는 큐의 front에 있는 데이터를 삭제하지 않고 읽어만 온다.		
		System.out.println(queue1.peek());

		/* elememt() 메서드는 peek() 메서드와 동일하게 큐의 front에 있는 데이터를
		 * 삭제하지 않고 읽어오지만 큐가 비어 있으면 NoSuchElementException을
		 * 발생시킨다. 
		 **/
		System.out.println(queue1.element());
		System.out.println(queue1);
		
		// poll() 메서드는 큐의 front에 있는 데이터를 읽어오면서 삭제한다.
		System.out.println(queue1.poll());
		
		/* remove() 메서드는 poll() 메서드와 동일하게 큐의 front에 있는 데이터를
		 * 읽어오면서 삭제하지만 큐가 비어 있으면  NoSuchElementException을
		 * 발생시킨다.
		 **/
		System.out.println(queue1.remove());
		System.out.println(queue1);
		System.out.println("==============================");

		/* Queue 인터페이스를 기반으로 PriorityQueue 클래스가 구현되어 있다.
		 * 우선순위 큐는 큐의 선입선출(FIFO, First In First Out) 구조를 가지면서
		 * 데이터가 들어온 순서대로 데이터가 나가는 것이 아니라 우선순위를 정하여
		 * 우선순위가 높은 데이터가 먼저 나가는 자료구조 이다. 우선순위 큐는 내부적으로
		 * 힙(Heap)으로 구성되어 있으며 힙은 이진트리 구조를 사용해 구현된다.
		 * 
		 * 숫자는 기본적으로 우선순위 큐에서 오름차순으로 정렬되어 큐의 대기열에 추가된다. 
		 * 
		 * --front-------------rear--    
		 *    30  50  60  70  90   
		 * ---------------------------
		 *  
		 *  
		 * 우선순위 큐의 기본 우선순위가 오름차순이므로 데이터를 이진트리에 저장하면 큐에서
		 * 제일 작은 수가 맨 위의 루트 노드에 저장되고 트리 아래로 내려갈수록 큰 수가 
		 * 저장되는 구조를 가지게 되는데 이런 구조의 힙을 최소 힙(Min Heap)이라고 한다.
		 * 최소 힙은 이진트리의 맨 위쪽인 루트 노드에 제일 작은 수가 저장될 수 있도록
		 * 데이터가 저장될 때 수의 크기를 비교해 작은 수가 위쪽으로 큰 수가 아래쪽으로 저장될
		 * 수 있도록 자리바꿈하면서 저장되며 이렇게 저장된 데이터는 아래와 같은 구조가 된다.
		 * 
		 * 			  30
		 * 		    /    \
		 *       60     50
		 *      /  \        
		 *    90  70
		 **/
		Queue<Integer> queue2 = new PriorityQueue<>();
		queue2.offer(70);
		queue2.offer(30);
		queue2.offer(50);
		queue2.offer(90);
		queue2.offer(60);		
		
		// 이진트리의 내용 출력 - [30, 60, 50, 90, 70]
		System.out.println(queue2);	
		
		// 큐의 대기열 출력 - 우선순위 순으로 출력 : 30, 50, 60, 70, 90
		/*
		while(true) {
			System.out.printf("%s", queue2.poll() + ", ");
			if(queue2.peek() == null) {
				break;
			}
		}
		System.out.println();
		*/
		
		// peek() 메서드는 큐의 front에 있는 데이터를 삭제하지 않고 읽어만 온다.		
		System.out.println(queue2.peek());		
		
		/* elememt() 메서드는 peek() 메서드와 동일하게 큐의 front에 있는 데이터를
		 * 삭제하지 않고 읽어오지만 큐가 비어 있으면 NoSuchElementException을
		 * 발생시킨다. 
		 **/
		System.out.println(queue2.element());
		System.out.println(queue2);
		
		// poll() 메서드는 큐의 front에 있는 데이터를 읽어오면서 삭제한다.
		System.out.println(queue2.poll());
		System.out.println(queue2);
		
		/* remove() 메서드는 poll() 메서드와 동일하게 큐의 front에 있는 데이터를
		 * 읽어오면서 삭제하지만 큐가 비어 있으면  NoSuchElementException을
		 * 발생시킨다.
		 **/
		System.out.println(queue2.remove());
		System.out.println(queue2);		
	}
}
