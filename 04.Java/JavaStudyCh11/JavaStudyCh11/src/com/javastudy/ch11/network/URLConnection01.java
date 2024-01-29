package com.javastudy.ch11.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

// URLConnection 클래스를 이용해 네이버 검색 요청하기
public class URLConnection01 {

	public static void main(String[] args) {		

		BufferedReader reader = null;
		
		try {			
			/* 네이버 검색 페이지는 https 프로토콜을 사용하는 
			 * 웹페이지로 https는 http 보다 보안이 강화된 프로토콜 이다.
			 **/
			URL naver = new URL("https://search.naver.com:443/");
			String keyword = "코로나19";
			
			/* 한글 등의 유니코드 문자는 웹 페이지의 주소에 사용할 수 없기 때문에 
			 * 주소에 사용할 수 있는 영문자, 숫자, 일부 특수 문자로 변환해야 하는데
			 * 이를 URLEncoding 이라고 한다. 
			 **/
			String encKeyword = URLEncoder.encode(keyword, "utf-8");
			System.out.println("encKeyword : " + encKeyword);
			
			// 아래와 같이 상대경로 방식으로 URL 객체를 생성할 수 있다.
			URL url = new URL(naver, "search.naver?query=" + encKeyword);
		
			/* URL 클래스의 openConnection() 메서드를 이용해 URLConnection 
			 * 클래스의 자식 클래스인 HttpURLConnection 클래스 타입의 객체를 구한다.
			 * 
			 * HttpURLConnection 클래스를 사용하면 다양한 옵션을 설정할 수 있다.
			 * 아래와 같이 요청 방식을 GET 또눈 POST로 설정할 수도 있고, Timeout
			 * 설정과 UserAgent 등을 지정해 보다 세밀하게 구현할 수 있다는 장점이 있다.
			 **/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();			
			conn.setRequestMethod("GET");
			conn.setReadTimeout(1000);
			conn.connect();
			
			/* 서버의 응답을 읽어오기 위해 스트림을 생성하고 있다.
			 * 서버와 연결된 커넥션 객체로부터 InputStream 객체를 구해 바이트
			 * 스트림을 문자 스트림으로 변환해 주는 InputStreamReader의
			 * 생성자 인수로 지정해 InputStreamReader 객체를 생성한 후
			 * 이 객체를 BufferedReader의 생성자 인수로 지정하고 있다.
			 **/
			reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			String line = "";
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}	
		} catch(IOException e) {
			e.printStackTrace();			
			
		} finally {
			try {				
				if(reader != null) reader.close();
			} catch(IOException e) { }
		}
	}
}
