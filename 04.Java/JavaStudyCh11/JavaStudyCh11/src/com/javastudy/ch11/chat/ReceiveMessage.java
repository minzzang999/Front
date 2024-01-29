package com.javastudy.ch11.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

// TCP 메시지를 수신하는 스레드 클래스
public class ReceiveMessage extends Thread {
	
	Socket socket;
	Thread t;
	
	public ReceiveMessage(Socket socket, Thread t) {
		this.socket = socket;
		this.t = t;
	}
	
	@Override
	public void run() {
		
		try {			
			/* 소켓 객체의 getInputStream() 메서드를 이용해
			 * 소켓에 연결된 입력 스트림을 구할 수 있다.
			 **/
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				
				/* 원격지 컴퓨터로부터 수신된 데이터를 읽어 들인다.
				 * 현재 소켓에 연결된 원격지 컴퓨터의 소켓이 강제 종료되면
				 * SocketException이 발생한다. 프로그램을 강제로 종료하면 
				 * 소켓이 강제로 닫히기 때문에 SocketException이 발생한다.
				 * 원격지 컴퓨터에서 소켓을 정상적으로 닫으면 null을 받는다.  
				 **/
				String msg = reader.readLine();	
				
				/* 현재 소켓에 연결된 원격지 컴퓨터의 소켓이 정상적으로 닫히면 
				 * readLine() 메서드로 읽어온 데이터는 null이 된다.
				 * 이 때 메시지 수신 스레드만 종료하게 되면 메시지 송신 스레드는
				 * 종료되지 않기 때문에 프로그램은 종료되지 않는다.
				 * 그래서 메시지 송신 스레드에 강제로 인터럽트를 발생시켜 
				 * InterruptedException을 처리하려 했으나 송신 스레드는
				 * reader.readLine() 메서드를 호출해 I/O 작업 상태이기
				 * 때문에 JVM에 의해 BLOCKED된 상태이다. I/O 작업이
				 * 완료될 때까지 대기 상태로 있다가 I/O 작업이 완료되면 다시
				 * RUNNABLE 상태가 된다. BLOCKED된 스레드는 interrupt()
				 * 메서드를 호출해도 InterruptedException이 발생하지
				 * 않기 때문에 프로그램을 종료하는 System.exit(0)를 호출해
				 * 응용프로그램을 종료했다.
				 **/
				if(msg == null) {
					System.out.println("Receive - 채팅을 종료합니다.");
					t.interrupt();					
					System.exit(0);
				}
				System.out.println(msg);
			}
		} catch(SocketException e) {
			e.printStackTrace();
			System.out.println("SecketException - 채팅을 종료 합니다.");
			System.exit(0);	
			
		} catch(IOException e) {
			e.printStackTrace();			
			System.out.println(e.getMessage());
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				// 소켓을 닫으면 스트림도 닫힌다.
				if(socket != null) socket.close();
			} catch(IOException e) { }
		}	
	}
}
