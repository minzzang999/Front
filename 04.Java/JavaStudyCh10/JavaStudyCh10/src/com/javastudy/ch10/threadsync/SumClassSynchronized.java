package com.javastudy.ch10.threadsync;

// SumClass의 add() 메서드에 synchronized 키워드로 동기화 설정하기
public class SumClassSynchronized {

	public static void main(String[] args) {
		
		Calculator ca = new Calculator();
		Thread t1 = new Thread(ca, "t1");
		Thread t2 = new Thread(ca, "t2");		
		
		/* 두 스레드가 시작되면 SumClass의 add() 메서드를 통해 sum에 접근하게 되는데
		 * 이때 t1이 add() 메서드를 호출하고 다음 호출 전에 t2가 add() 메서드를 호출하는
		 * 문제가 발생할 수 있다. 즉 하나의 스레드에서 작업하는 자원에 다른 스레드가
		 * 접근해 그 자원의 값을 변경할 수 있는 문제가 발생하게 된다. 그래서 하나의
		 * 스레드가 공유 자원에 접근할 때 다른 스레드가 동시에 접근할 수 없도록 Lock을
		 * 걸어야 하는데 이를 스레드 동기화라고 한다.
		 **/
		t1.start();
		t2.start();
	}
}

class SumClass {
	private int sum;
	
	/* synchronized 키워드로 아래 메서드 전체가 임계영역으로 설정된다.
	 * 스레드는 이 메서드가 호출된 시점부터 이 메서드가 포함된 객체의
	 * Lock을 얻어 작업을 수행하고 작업이 끝나면 Lock을 반환한다.	
	 **/
	public synchronized int add(int num) {
		if(sum <= 300) {
			sum += num;
			try { 
				// 현재 실행 중인 스레드를 1초 잠재운다.
				Thread.sleep(1000);
			} catch(InterruptedException e) { }			
		}		
		return sum;
	}
	
	public int getSum() {
		return sum;
	}
}

class Calculator implements Runnable {
	SumClass sc = new SumClass();
	
	@Override
	public void run() {
		
		/* SumClass 클래스의 add() 메서드에 synchronized로 임계영역을 설정하지 않으면
		 * t1이 add() 메서드에 접근해 값을 더 하고 동시에 t2가 접근해 값을 더 하여
		 * t1이 add() 메서드를 호출해 값을 더 하고 출력할 당시 합계는 t1이 더한 값과
		 * t2가 더한 값이 출력된다. 또한 t2가 add() 메서드를 호출해 값을 더 하고
		 * 출력할 당시 합계는 t1과 t2가 한 번씩 더한 값이 되어야 하지만 t1이 추가로
		 * 한 번 더 더한 값이 출력되는 현상이 발생한다. 이렇게 멀티 스레드가 하나의 자원에
		 * 접근해 작업하는 경우 의도하지 못한 동기화 문제가 발생한다. 
		 *
		 * 그러므로 하나의 스레드가 SumClass의 add() 메서드에 접근해 작업을 할 때
		 * 다른 스레드가 SumClass의 add() 메서드에 접근하지 못하도록 해야 한다.
		 * 다시 말해 t1이 add() 메서드를 호출하고 실행이 끝나기 전에 t2가 add() 메서드를
		 * 호출하면 t1이 호출한 add() 메서드가 완전히 종료될 때 까지 두 번째 스레드인
		 * t2가 add() 메서드에 접근하지 못하도록 대기시켜야 한다. 그래서 synchronized 
		 * 키워드를 add() 메서드에 적용해 동기화 설정을 했다. 
		 **/
		while(sc.getSum() <= 300) {

			// 10 ~ 100 사이의 난수를 발생해 add() 메서드 인수로 지정 
			int num = (int) (Math.random() * 10 + 1) * 10;
			System.out.println(Thread.currentThread().getName() 
					+ " num : " + num + ",  sum : " + sc.add(num));
		}
	}
}




