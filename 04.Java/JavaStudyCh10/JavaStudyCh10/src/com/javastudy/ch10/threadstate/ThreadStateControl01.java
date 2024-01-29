package com.javastudy.ch10.threadstate;

// 스레드 상태 체크하기
public class ThreadStateControl01 {

	public static void main(String[] args) {
		
		TestThread t = new TestThread("TestThread");
		ThreadStatePrint ts = new ThreadStatePrint(t);
		ts.setName("ThreadStatePrint");
		ts.start();
		System.out.println("main 종료");
	}
}

// Thread 클래스를 상속해 스레드 상태를 출력하는 클래스
class ThreadStatePrint extends Thread {
	TestThread t;
	
	public ThreadStatePrint(TestThread t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		while(true) {
			
			// TestThread 스레드의 현재 상태를 구한다.
			Thread.State state = t.getState();	
			System.out.println(this.getName() + " 상태 : " + this.getState());			
			System.out.println(t.getName() + " 상태 : " + state);
			
			if(state == Thread.State.NEW) {				
				/* start() 메서드를 호출하면 곧 바로 스레드가 실행되는 것이 아니라
				 * RUNNABLE 상태가 된다. t 스레드는 현재 실행대기 상태에 놓인다.
				 **/
				t.start();
				System.out.println("t 시작");
			}
			
			if(state == Thread.State.TERMINATED) {				
				// TestThread가 종료 상태면 반복문을 빠져나가 종료한다.				
				System.out.println(Thread.currentThread().getName() + " 종료");
				break;
			}
			
			try {					
				/* ThreadStatePrint 클래스의 스레드가 지정한 시간동안 일시정지
				 * 되는 것이 아니라 현재 실행중인 스레드를 0.5초 정지 시킨다.
				 **/
				Thread.sleep(500);				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}

class TestThread extends Thread {	
	
	public TestThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		
		int cnt = 0;
		while(true) {
			try {				
				/* TestThread 클래스의 스레드가 지정한 시간동안 일시정지
				 * 되는 것이 아니라 현재 실행중인 스레드를 0.5초 정지 시킨다.
				 **/
				Thread.sleep(500);
				cnt++;
				if(cnt > 5) {
					break;
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}



