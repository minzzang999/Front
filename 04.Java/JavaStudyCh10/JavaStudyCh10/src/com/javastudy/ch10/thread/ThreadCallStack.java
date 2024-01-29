package com.javastudy.ch10.thread;

// start() 메서드와 run() 메서드
public class ThreadCallStack {	
	
	public static void main(String[] args) {		
		
		Thread t = new TestThread01(10);
		
		/* 스레드 인스턴스를 생성하고 start() 메서드를 호출하면 새로운 스레드가
		 * 시작된다. 이때 작업에 필요한 호출스택(Call Stack)을 생성한 후 start()
		 * 메서드 안에서  run() 메서드를 호출한다. 모든 스레드는 자신만의 독립적인
		 * 작업을 위해서 호출스택을 필요로 한다. 그래서 새로운 스레드를 생성하고
		 * 실행할 때 마다 항상 새로운 호출스택이 만들어 진다.
		 * 
		 * t.start()가 호출되면 새로운 스레드가 실행되면서 새로운 호출스택을
		 * 생성하기 때문에 start() 메서드 안에서 호출된 TestThread01 클래스의
		 * run() 메서드는 새로운 호출스택에서 첫 번째 메서드로 자리를 잡고 이 run() 
		 * 메서드에서 호출한 add() 메서드가 그 위에 자리를 잡는다.
		 **/ 
		t.start();
		
		/* 스레드의 인스턴스를 생성하고 run() 메서드를 호출하면 단지 참조 변수가
		 * 가리키는 인스턴스의 run() 메서드를 호출하는 것이 되므로 아래와 같이
		 * t.run() 메서드를 호출하면 새로운 스레드가 실행되는 것이 아니기 때문에
		 * main() 메서드가 실행되는 main 스레드의 호출스택에 자리하게 된다.
		 **/
		t.run();
		
		 /* main() 메서드가 종료되어도
		  * 현재 실행중인 스레드가 존재하면 프로그램은 종료되지 않는다.
		  **/
		System.out.println("main() 메서드 종료");
	}
}

class TestThread01 extends Thread {
	int num;
	int sum;
	
	public TestThread01(int num) {		
		this.num = num;
	}
	
	@Override
	public void run() {
		add(num);		
	}
	
	public void add(int num) {
		try {
			// 강제로 Exception 발생시키기
			throw new Exception();			
		} catch(Exception e) {			
			// Excepiton이 발생한 CallStack를 추적해 출력
			e.printStackTrace();
		}		
		
		for(int i = 1; i <= num; i++) {
			sum += i;
			
			// 현재 실행중인 스레드 정보를 콘솔에 출력한다.
			System.out.println(Thread.currentThread() + " - sum : " + sum);

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
