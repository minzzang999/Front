package com.javastudy.ch11.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// Socket 클래스로 TCP 클라이언트 구현하기
public class TCPClient {

	public static void main(String[] args) {		
		
		Socket client = null;
		
		try {		
			// 1. 접속할 서버의 주소와 포트 번호를 지정해 소켓 객체를 생성한다.			
			/* 아래와 같이 소켓을 생성하면 지정한 서버로 바로 접속을 시도한다.
			 * 이 때 서버가 대기 중이 아니면 ConnectException이 발생한다.
			 **/
			client = new Socket("localhost", 9999);
			System.out.println("서버로 접속 요청함...");
			
			// 2. 서버와 네트워크 입출력을 위한 스트림을 생성한다.			
			/* 소켓이 생성되고 서버와 접속이 이루어지면 소켓 객체의 getInputStream()
			 * 메서드를 이용해 서버로부터 전송되는 데이터를 받을 입력 스트림을 개설하고
			 * getOutputStream() 메서드를 이용해 서버로 데이터를 보낼 출력 스트림을
			 * 개설할 수 있다. 이 처럼 Socket 클래스를 이용하면 복잡한 네트워크 
			 * 프로그래밍을 스트림을 사용하는 것과 동일하게 처리할 수 있다. 
			 **/
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
			
			// 3. 서버로 보낼 요청 데이터를 스트림에 쓰고 서버로 전송한다.			
			/* flush() 메서드는 스트림을 통해 데이터를 서버로 흘려보낸다. 
			 * 명시적으로 flush() 메서드나 close() 메서드를 호출해야 서버로
			 * 데이터가 전달된다. 그렇지 않으면 서버는 데이터를 받지 못한다. 
			 **/			
			writer.write("Hello Server\r\n");
			writer.flush();
			
			// 4. 서버로부터 수신된 데이터를 읽어 콘솔에 출력한다.
			String line = reader.readLine();
			System.out.println("서버의 응답 데이터 : " + line);
		
		} catch(UnknownHostException e) {
			e.printStackTrace();
			System.out.println("알수 없는 호스트 입니다.");
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				// 5. 소켓 통신이 완료되면 소켓을 닫는다.
				// 소켓을 닫으면 소켓의 입출력 스트림도 같이 닫힌다.
				if(client != null) client.close();
			} catch(IOException e) {}
		}
	}
}
