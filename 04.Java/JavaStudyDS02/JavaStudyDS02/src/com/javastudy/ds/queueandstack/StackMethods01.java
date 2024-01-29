package com.javastudy.ds.queueandstack;

import java.util.Stack;

// 선입후출(FILO, First In Last Out) 구조를 가진 스택(Stack)
public class StackMethods01 {

	public static void main(String[] args) {
		
		/* 스택의 자료구조는 선입후출(FILO, First In Last Out) 구조를 가지고 있어서
		 * 맨 처음 들어온 데이터가 맨 아래에 저장되어 제일 마지막에 나갈 수 있는 자료구조이다. 
		 *  
		 * 		 | 30 |  <- top
		 * 		 | 70 |
		 * 		 | 90 |
		 * 		 | 20 |
		 * 		 | 50 |	
		 *       -----
		 **/
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(50);
		stack.push(20);
		stack.push(90);
		stack.push(70);
		stack.push(30);
		System.out.println(stack + " - " + stack.size());
		
		// peek() 메서드는 스택의 top에 있는 데이터를 삭제하지 않고 읽어만 온다.
		System.out.println(stack.peek());
		System.out.println(stack);
				
		// pop() 메서드는 스택의 top에 있는 데이터를 읽어오면서 삭제한다.
		System.out.println(stack.pop());		
		System.out.println(stack);
				
		// search() 메서드는 지정한 값이 맨 위를 기준으로 몇 번째에 있는지 알려준다.
		System.out.println(stack.search(20));
		System.out.println(stack.isEmpty());
	}
}
