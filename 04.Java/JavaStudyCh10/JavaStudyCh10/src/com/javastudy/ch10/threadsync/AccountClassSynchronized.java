package com.javastudy.ch10.threadsync;

// Account 클래스에 synchronized 키워드로 동기화 블럭 설정하기
public class AccountClassSynchronized {

	public static void main(String[] args) {
		
		// 계좌 클래스의 인스턴스를 생성하면서 계좌 잔액을 5000원으로 설정 
		Runnable r = new Withdraw(new Account(5000));
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		
		/* 두 스레드가 시작되면 Account의 withdraw() 메서드를 통해 balance에 접근하게
		 * 되는데 이때 t1이 withdraw() 메서드를 호출하고 다음 호출 전에 t2가 withdraw()
		 * 메서드를 호출하는 문제가 발생할 수 있다. 즉 하나의 스레드에서 작업하는 자원에
		 * 다른 스레드가 접근해 그 자원의 값을 변경할 수 있는 문제가 발생하게 된다. 
		 * 그래서 하나의 스레드가 공유 자원에 접근할 때 다른 스레드가 동시에 접근할 수 
		 * 없도록 Lock을 걸어야 하는데 이를 스레드 동기화라고 한다.
		 **/
		t1.start();
		t2.start();
	}
}

//계좌 클래스
class Account {
	
	// 계좌 잔액
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	// 계좌에서 지정한 금액 만큼 인출하는 메서드
	public int withdraw(int amount) {
		
		/* 아래와 같이 synchronized(this) { } 블록을 사용해 메서드 
		 * 전체가 아닌 메서드 안의 특정 코드만 임계영역으로 설정할 수 있다.
		 * () 안에는 잠금(Lock)을 할 객체의 참조변수를 지정하면 된다.
		 * 이 블록 안으로 들어오면서 부터 스레드는 지정된 객체의 Lock을 얻게 되고 
		 * 블록을 벗어나면 Lock을 반납하게 된다. Lock의 획득과 반납은 JVM에 의해
		 * 자동으로 이루어지므로 적절히 임계영역만 설정해 주면 된다.
		 **/
		synchronized(this) {
			if(balance >= amount) {
				try {
					// 현재 실행 중인 스레드를 1초 잠 재운다.
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				balance -= amount;
			}
		}
		return balance;
	}
}

//계좌에 있는 돈을 인출하는 클래스 
class Withdraw implements Runnable {	
	Account account;
	
	public Withdraw(Account account) {
		this.account = account;	
	}
	
	@Override
	public void run() {
		
		/* Account 클래스의 withdraw() 메서드에 synchronized로 임계영역을 설정하지
		 * 않으면 t1이 출금하는 동시에 t2가 출금하는 문제가 발생해 잔액이 마이너스가
		 * 되거나 잔액이 정확하게 계산되지 못하는 문제가 발생한다. 그러므로 withdraw()
		 * 메서드에 synchronized 키워드로 임계영역을 설정해 t1이 출금하는 동안
		 * 또 다른 스레드인 t2는 withdraw() 메서드에 접근하지 못하도록 대기시켜야 한다.
		 *
		 * 이번 예제는 앞의 예제와 다르게 메서드 전체를 동기화 한 것이 아니라
		 * Account 클래스의 withdraw() 메서드 안에서 필요한 부분만 동기화를
		 * 하기 위해서 synchronized(this) {} 블럭을 사용해 동기화 하였다.
		 **/
		while(account.getBalance() > 0){
			
			// 한 번에 1000씩 차감
			int amount = 1000;			
			System.out.println(Thread.currentThread().getName() + 
					" : " + amount + ", 잔액 : " + account.withdraw(amount));
		}
	}
}











