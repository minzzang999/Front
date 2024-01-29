package com.javastudy.ch10.thread;

// Thread 클래스를 상속해 스레드 만들기
public class ThreadExtends {
	static int mainNum;

	public static void main(String[] args) {
		
		/* Thread 클래스를 상속(extends)해 스레드 만들기
		 * 
		 * 1. Thread 클래스를 상속(extends)한 클래스를 작성한다. 
		 * 
		 * 2. Thread 클래스를 상속한 클래스의 인스턴스를 생성한다.
		 **/
		MultiThread t1 = new MultiThread(20);
		MultiThread t2 = new MultiThread(20);
		
		/* 3. Thread 클래스로부터 상속받은 start() 메서드를 호출해 스레드를 실행한다.
		 * Runnable 인터페이스를 구현한 클래스의 run() 메서드는 Thread 클래스의
		 * 인스턴스를 통행 실행되지만 Thread 클래스를 직접 상속한 클래스는 부모인
		 * Thread 클래스의 모든 멤버를 상속 받았기 때문에 자신의 인스턴스를 생성하고
		 * 부모인 Thread 클래스로부터 상속받은 start() 메서드를 호출 할 수 있다.
		 * Thread 클래스 또한 Runnable 인터페이스를 구현한 클래스 이다.
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

// Thread 클래스를 상속하는 클래스 
class MultiThread extends Thread {
	int num;
	
	public MultiThread(int num) {
		this.num = num;
	}
	
	/* Thread 클래스를 상속 받는 클래스는 아래와 같이 run() 메서드를 오버라이딩
	 * 해야 한다. 스레드는 run() 메서드가 호출 되면서 시작되고 이 메서드가 종료되면
	 * 스레드 또한 종료된다. 만약 run() 메서드를 오버라이딩 하지 않으면 부모 클래스인
	 * Thread 클래스의 run() 메서드가 호출되는데 Thread 클래스의 run() 메서드는
	 * 특별한 작업을 하는 코드가 없기 때문에 스레드가 바로 종료된다. 
	 **/
	@Override
	public void run() {
		for(int i = 1; i <= num; i++) {
			ThreadExtends.mainNum += i;
			System.out.println(currentThread() 
					+ " - num 1 : " + ThreadExtends.mainNum);

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

