package com.javastudy.ch11.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// ServerSocket 클래스로 TCP 서버 구현하기
public class TCPServer {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		try {
			// 1. 클라이언트가 연결될 포트를 지정해 서버 소켓을 생성한다.
			server = new ServerSocket(9999);
			System.out.println("클라이언트 요청 대기중...");
			
			// 2. 클라이언트 연결 요청을 기다린다.
			/* accept() 메서드는 클라이언트의 연결이 올 때까지 계속 기다린다.
			 * 클라이언트 요청이 들어오면 연결을 수락하고 클라이언트와 통신할
			 * 새로운 Socket 객체를 생성해 반환한다. 이때 새로 생성되는 
			 * Socket 객체의 포트 번호는 7777번이 아니고 자동으로 할당된다. 
			 **/
			client = server.accept();
			System.out.println("클라이언트 접속 수락...");
			
			// 3. 클라이언트와 네트워크 입출력을 위한 스트림을 생성한다.			
			/* 클라이언트와 연결된 소켓이 생성되면 소켓 객체의 getInputStream()
			 * 메서드를 이용해 클라이언트의 요청 데이터를 받을 입력 스트림을 개설하고
			 * getOutputStream() 메서드를 이용해 클라이언트로 응답할 출력 스트림을
			 * 개설할 수 있다. 이 처럼 Socket 클래스를 이용하면 복잡한 네트워크 
			 * 프로그래밍을 스트림을 사용하는 것과 동일하게 처리할 수 있다.
			 **/
			BufferedReader request = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			BufferedWriter response = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
			
			// 4. 클라이언트로부터 들어온 요청 데이터를 읽어온다.
			String line = request.readLine();
			System.out.println("클라이언트의 요청 데이터 : " + line);
			
			// 5. 클라이언트로 보낼 응답 데이터를 스트림에 쓰고 클라이언트로 전송한다.			
			/* flush() 메서드는 스트림을 통해 데이터를 서버로 흘려보낸다. 
			 * 명시적으로 flush() 메서드나 close() 메서드를 호출해야 클라이언트로
			 * 데이터가 전달된다. 그렇지 않으면 클라이언트는 데이터를 받지 못한다. 
			 **/			
			response.write("Hi Client\r\n");
			response.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				// 5. 소켓 통신이 완료되면 소켓을 닫는다.
				/* 소켓을 닫으면 소켓의 입출력 스트림도 같이 닫힌다.
				 * 클라이언트와 통신한 통신 소켓을 먼저 닫고 서버 소켓을 닫는다.
				 **/
				if(client != null) client.close();
				if(server != null) server.close();
			} catch(IOException e) {}
		}
	}
}
