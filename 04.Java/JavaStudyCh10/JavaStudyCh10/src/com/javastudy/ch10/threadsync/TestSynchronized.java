package com.javastudy.ch10.threadsync;

public class TestSynchronized {
	
	String str = new String();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public synchronized void multiCalculator() {
		
		/* synchronized 키워드로 메서드 전체가 임계영역으로 설정된다.
		 * 스레드는 이 메서드가 호출된 시점부터 이 메서드가 포함된 객체의
		 * Lock을 얻어 작업을 수행하고 작업이 끝나면 Lock을 반환한다.
		 **/
		
	}
	
	public void multiply() {
		
		/* 아래 동기화 블록(synchronized(this) 블록)에서 파라미터에 this를 지정했는데
		 * 항상 this가 되는 것이 아니라 동기화 대상 즉 락(Lock)을 걸 객체의 참조를
		 * 파라미터로 지정해야 한다.
		 **/
		
		synchronized(this) { 
			
			/* 이 synchronized(this) { } 블록만 임계영역으로 설정된다.
			 * () 안에는 잠금(Lock)을 할 객체의 참조변수를 지정하면 된다.
			 * 이 블록 안으로 들어오면서 부터 스레드는 지정된 객체의 Lock을
			 * 얻게 되고 블록을 벗어나면 Lock을 반납하게 된다. Lock의 획득과
			 * 반납은 자동으로 이루어지므로 적절히 임계영역만 설정해 주면 된다.
			 **/
			
		}
	}

}
