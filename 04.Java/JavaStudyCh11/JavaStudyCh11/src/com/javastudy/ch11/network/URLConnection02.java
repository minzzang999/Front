package com.javastudy.ch11.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

// URLConnection 클래스를 이용해 POST 방식 로그인 요청하기
public class URLConnection02 {

	public static void main(String[] args) {
		
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		
		try {		
			/* 접속할 URL 객체를 생성하고 openConnection() 메서드를
			 * 이용해 URLConnection 객체를 구한다.
			 **/
			//URL url = new URL("http://localhost:8080/JavaNetworkTest/postTestJson.jsp");
			URL url = new URL("http://localhost:8080/JavaNetworkTest/postTestHtml.jsp");
			URLConnection conn = url.openConnection();
			
			/* 서버로 데이터를 보내기 위해 setDoOutput(true) 메서드를 호출했다.
			 * 이 메서드에 true를 지정하면 요청이 GET에서 POST 방식으로 변경된다.
			 **/
			conn.setDoOutput(true);			
			
			/* 서버로 데이터를 보내기 위해 서버와 연결된 커넥션 객체로부터 
			 * OutputStream 객체를 구해 바이트 스트림을 문자 스트림으로 변환해
			 * 주는 OutputStreamWriter의 생성자 인수로 지정하고 있다.
			 **/
			writer = new OutputStreamWriter(conn.getOutputStream());
			
			// 서버로 보낼 데이터를 스트림에 쓴다.
			writer.write("id=java&pass=1234");
			
			/* 스트림을 통해 데이터를 서버로 흘려보낸다. 
			 * 명시적으로 flush() 메서드나 close() 메서드를 호출해야 스트림에 연결된
			 * 서버로 데이터가 전달된다. 그렇지 않으면 서버에서 데이터를 받지 못한다. 
			 **/
			writer.flush();
			
			/* 서버의 응답을 읽어오기 위해 스트림을 생성하고 있다.
			 * 서버와 연결된 커넥션 객체로부터 InputStream 객체를 구해 바이트
			 * 스트림을 문자 스트림으로 변환해 주는 InputStreamReader의
			 * 생성자 인수로 지정해 InputStreamReader 객체를 생성한 후
			 * 이 객체를 BufferedReader의 생성자 인수로 지정하고 있다.
			 **/
			reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line = "";
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}		
		} catch(IOException e) {
			e.printStackTrace();			
			
		} finally {
			try {
				if(writer != null) writer.close();
				if(reader != null) reader.close();
			} catch(IOException e) { }
		}
	}
}
