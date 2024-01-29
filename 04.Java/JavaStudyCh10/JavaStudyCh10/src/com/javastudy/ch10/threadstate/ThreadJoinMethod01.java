package com.javastudy.ch10.threadstate;

// 다른 스레드의 종료를 기다리는 join() 메서드
public class ThreadJoinMethod01 {

	public static void main(String[] args) {
		
		SumThread t = new SumThread(1, 100);
		t.setName("SumThread");
		t.start();
		
		try {
			// SumThread가 종료될 때 까지 main 스레드는 종료되지 않고 기다린다.			 
			t.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		/* 위에서 t.join() 메서드가 호출되지 않았다면 SumThread 스레드가
		 * 작업을 완료하기 전에 main 스레드는 종료되었을 것이다.
		 * 
		 * 위의 try { } catch() { } 블록을 주석 처리하고 테스트 하면
		 * SumThread가 실행을 완료할 때까지 main() 메서드가
		 * 기다리지 않고 아래 코드가 실행되기 때문에 아래의 결과는 0이 된다. 			
		 **/
		System.out.println("1 ~ 100까지의 합 : " + t.getTotal());
		System.out.println("main 스레드 종료");
	}
}

class SumThread extends Thread {
	
	private int total;
	private int start;
	private int end;
	
	public SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		for(int i = start; i <= end; i++) {
			total += i;
		}
			
		System.out.println("SumThread 종료");
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}

