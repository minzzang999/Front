package com.javastudy.ch11.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

// TCP 메시지를 전송하는 스레드 클래스
public class SendMessage extends Thread {
	
	Socket socket;
	String name;
	
	public SendMessage(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}
	
	@Override
	public void run() {
		
		try {			
			// 키보드 입력을 받기 위해 System 클래스의 입력 스트림을 사용했다.
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));
			
			/* 소켓 객체의 getOutputStream() 메서드를 이용해
			 * 소켓에 연결된 출력 스트림을 구할 수 있다.
			 **/
			BufferedWriter writer = new BufferedWriter(					
					new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				
				// 키보드로부터 입력된 데이터를 읽어 들인다.
				String msg = reader.readLine();
				Thread.sleep(10);
				
				// 키보드 입력이 "bye"라면 스레드를 종료한다.
				if(msg.equals("bye")) {
					System.out.println("Send - 채팅을 종료합니다.");
					break;
				}
				
				/* 키보드로 입력된 데이터를 스트림으로 출력하고
				 * 원격지 컴퓨터로 흘려보낸다. 
				 **/				
				writer.write("[" + name + "] : " + msg + "\r\n");
				writer.flush();
			}			
		} catch(IOException e) {
			e.printStackTrace();	
			
		} catch(InterruptedException e) {
			System.out.println("Interrupted - 채팅을 종료합니다.");
			return;
			
		}catch(Exception e) {
			System.out.println("excepton 발생");
			e.printStackTrace();
			
		} finally {
			try {
				// 소켓을 닫으면 스트림도 닫힌다.
				if(socket != null) socket.close();
			} catch(IOException e) { }
		}		
	}
}
