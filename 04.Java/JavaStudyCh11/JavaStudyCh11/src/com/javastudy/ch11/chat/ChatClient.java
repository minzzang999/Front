package com.javastudy.ch11.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 채팅 클라이언트
public class ChatClient {	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Socket socket = null;		
		Scanner scan = null;
		
		try {
			// 사용자 입력을 받을 Scanner 클래스의 인스턴스 생성
			scan = new Scanner(System.in);
			System.out.print("이름을 입력해 주세요 : ");
			String name =  scan.nextLine();
			
			/* 접속할 서버의 주소와 포트 번호를 지정해 소켓 객체를 생성한다.			
			 * 아래와 같이 소켓을 생성하면 지정한 서버로 바로 접속을 시도한다.
			 * 이 때 서버가 대기 중이 아니면 ConnectException이 발생한다.
			 **/
			socket = new Socket("127.0.0.1", 9999);		
			
			// 메시지 송수신 스레드 객체를 생성한다.
			SendMessage send = new SendMessage(socket, name);
			ReceiveMessage receive = new ReceiveMessage(socket, send);
			
			// 메시지 송수신 스레드를 시작한다.
			send.start();
			receive.start();			
			
			/*
			// 메시지 수신 스레드가 종료될 때까지 기다린다.
			receive.join();			
			if(socket.isClosed()) {
				System.exit(0);
			}
			*/
			
		} catch(IOException e) {
			e.printStackTrace();
			
		/*
		} catch(InterruptedException e) {
			e.printStackTrace();
		*/
		} finally {
			// Scanner 자원을 해제 한다.
			//if(scan != null) scan.close();
			
			try {
				/* 소켓 통신이 완료되면 클라이언트 소켓을 닫는다.
				 * 소켓을 닫으면 소켓에서 사용한 입출력 스트림도 같이 닫힌다.
				 **/
				if(socket != null) socket.close();
			} catch(IOException e) { }
		}
		System.out.println("ChatClient main() 종료");
	}
}
