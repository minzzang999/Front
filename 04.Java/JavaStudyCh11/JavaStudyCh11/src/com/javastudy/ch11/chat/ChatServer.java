package com.javastudy.ch11.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 채팅 서버
public class ChatServer {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		
		try {			
			// 클라이언트가 연결될 포트를 지정해 서버 소켓을 생성한다.
			server = new ServerSocket(9999);
			System.out.println("채팅 서버를 시작합니다.");
			
			/* 클라이언트 연결 요청을 기다린다.
			 * accept() 메서드는 클라이언트의 연결이 올 때까지 계속 기다린다.
			 * 클라이언트 요청이 들어오면 연결을 수락하고 클라이언트와 통신할
			 * 새로운 Socket 객체를 생성해 반환한다. 이때 새로 생성되는 
			 * Socket 객체의 포트 번호는 9999번이 아니고 자동으로 할당된다. 
			 **/
			client = server.accept();			
			System.out.println("클라이언트가 채팅방에 입장했습니다.");
			
			// 메시지 송수신 스레드 객체를 생성한다.
			SendMessage send = new SendMessage(client, "서버");
			ReceiveMessage receive = new ReceiveMessage(client, send);
			
			// 메시지 송수신 스레드를 시작한다.
			send.start();
			receive.start();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				/* 소켓 통신이 완료되면 서버 소켓을 닫는다.
				 * 소켓을 닫으면 소켓에서 사용한 입출력 스트림도 같이 닫힌다.
				 **/
				if(server != null) server.close();
			} catch(IOException e) { }
		}
		System.out.println("ChatServer main() 종료");
	}
}
