package com.javastudy.ch10.thread;

// 스레드 스케줄링과 우선순위
public class ThreadPriority01 {
	
	/* 스레드는 실행에 대한 우선순위(Priority) 속성을 가지고 있다.
	 * 이 우선순위에 따라서 스레드가 실행되는 시간이 달라진다.
	 * 중요도가 높은 스레드에 우선순위 값을 높게 지정해 그 스레드가 프로세스로 부터
	 * 실행 시간을 더 많이 할당 받을 수 있도록 할 수 있다.
	 * 스레드의 우선순위는 1 ~ 10까지 지정할 수 있으며 숫자가 클수록 우선순위가
	 * 높다. 또한 스레드 우선순위 값은 스레드를 생성한 스레드의 우선순위 값을 상속
	 * 받는다. 참고로 main() 메서드를 수행하는 메인 스레드의 우선순위는 5이다.
	 * 그래서 main() 메서드에서 생성된 스레드는 우선순위 값이 5로 자동 지정된다.
	 * 스레드의 우선순위가 같으면 각각의 스레드에 같은 실행 시간이 주어진다.
	 * 하지만 이 우선순위가 스레드의 실행시간을 반드시 보장해 주는 것은 아니다.
	 * 그 이유는 OS의 프로세스 스케줄러에 따라 다르고 JVM 마다 다를 수 있기
	 * 때문이다. 하지만 JVM은 스레드 스케줄링 시 기본적으로 우선순위가 높은 스레드를
	 * 우선적으로 선택해 실행해 준다. 
	 **/
	public static void main(String[] args) {		
		
		Thread t0 = new PriorityThread("/");
		Thread t1 = new PriorityThread("*");
				
		System.out.println(t0.getName() + " - [/]: " + t0.getPriority());
		System.out.println(t1.getName() + " - [*]: " + t1.getPriority());
		
		System.out.println("스레드의 최소 우선순위 값 : " + Thread.MIN_PRIORITY);		
		System.out.println("스레드의 기본 우선순위 값 : " + Thread.NORM_PRIORITY);
		System.out.println("스레드의 최대 우선순위 값 : " + Thread.MAX_PRIORITY);
		
		/* 스레드의 최소 우선순위 값부터 최대 우선순위 값 사이의 정수를
		 * 지정해도 되고 바로 위의 상수를 사용해 우선순위를 지정할 수도 있다.
		 **/
		// t2.setPriority(10);
		t1.setPriority(Thread.MAX_PRIORITY);
		
		t0.start();
		t1.start();
	}
}

// Thread 클래스를 상속한 스레드 클래스
class PriorityThread extends Thread {
	private String pattern;
	
	public PriorityThread(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 500; i++) {
			System.out.print(pattern);
			for(int j = 0; j <=1000000; j++); 
		}
	}
}


