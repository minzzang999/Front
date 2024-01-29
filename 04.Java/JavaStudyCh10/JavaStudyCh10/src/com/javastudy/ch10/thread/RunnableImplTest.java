package com.javastudy.ch10.thread;

// Runnable 인터페이스를 구현해 스레드 만들기
public class RunnableImplTest {
	static long mainNum;
	
	public static void main(String[] args) {
		
		/* Runnable 인터페이스를 구현(implements)해 스레드 만들기
		 * 
		 * 1. Runnable 인터페이스를 구현(implements)한 클래스를 작성한다.
		 * 
		 * 2. Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한다.		
		 **/
		RunnableImpl r1 = new RunnableImpl(20);
		RunnableImpl r2 = new RunnableImpl(20);
		
		/* 3. Thread 클래스의 인스턴스를 생성하면서 위에서 생성한 Runnable
		 * 인터페이스를 구현한 클래스의 인스턴스를 생성자를 통해서 전달한다.
		 **/
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		/* 4. Thread 클래스의 start() 메서드를 호출해 스레드를 실행한다.
		 * start() 메서드가 호출되면 이 메서드 안에서 Thread 클래스의 인스턴스
		 * 메서드인 run() 메서드가 호출되고 이 run() 메서드 안에서 생성자를 통해
		 * 전달받은 Runnable 인터페이스를 구현한 클래스의 인스턴스 메서드인 run()
		 * 메서드가 호출된다. 이 run() 메서드가 종료되면 현재 스레드도 종료된다.
		 * 
		 * 하나의 스레드에 대해서 start() 메서드는 단 한 번만 호출 할 수 있다.
		 * start() 메서드가 호출되면 스레드가 작업을 실행할 호출스택(Call Stack)이
		 * 생성되고 run() 메서드가 호출되어 그 호출스택에 run() 메서드가 첫 번째에
		 * 자리하게 된다. 모든 스레드는 자신만의 독립된 작업을 위해서 호출스택이 필요하다.
		 **/
		t1.start();
		t2.start();
		
		System.out.println("main 메서드 종료");
	}
}

// Runnable 인터페이스를 구현하는 클래스
class RunnableImpl implements Runnable {
	int num;
	
	public RunnableImpl(int num) {
		this.num = num;
	}
	
	/* 스레드에서 동작할 코드는 아래와 같이 run() 메서드를 오버라이딩해 구현한다.
	 * 스레드는 run() 메서드가 호출 되면서 시작되고 이 메서드가 종료되면 종료된다.
	 **/
	@Override
	public void run() { 
	
		for(int i = 1; i <= num; i++) {
			RunnableImplTest.mainNum += i;
			System.out.println(Thread.currentThread() 
					+ " - num 1 : " + RunnableImplTest.mainNum);
			
			try {
				/* 현재 실행중인 스레드를 1초 동안 잠을 재운다.
				 * 스레드가 1초 동안 일시정지 되고 실행 대기 상태로 간다. 
				 **/
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}

