package com.javastudy.ch11.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

// URL 클래스를 이용해 웹 페이지 읽어오기
public class URLClass {

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
			URL search = new URL(naver, "search.naver?query=" + encKeyword);
			
			System.out.println("호스트 명과 포트 : " + search.getAuthority());
			System.out.println("프로토콜 : " + search.getProtocol());
			System.out.println("호스트 명 : " + search.getHost());
			System.out.println("포트 : " + search.getPort() 
				+ ", 기본포트 : " + search.getDefaultPort());
			System.out.println("경로명 : " + search.getPath());
			System.out.println("파일명 : " + search.getFile());
			System.out.println("쿼리스트링 : " + search.getQuery());
			
			/* URL 객체를 생성했다고 해서 원격지 컴퓨터와 연결된 것이 아니다.
			 * 원격지 컴퓨터와 연결하고 실제 데이터를 읽어오려면 아래와 같이
			 * openStream()을 호출해 원격지 컴퓨터와 연결하고 데이터를
			 * 읽어올 스트림(통로)을 개설해야 한다. 
			 * 
			 * URL 클래스의 openStream() 메서드를 사용하는 방법은 간단하긴 하지만
			 * 컨넥션 문제 등에 대한 여러가지 설정을 할 수 없어 잘 사용되지 않는다.
			 **/
			reader = new BufferedReader(
					new InputStreamReader(search.openStream()));						
			
			// httpbin.org는 여러 유형의 요청을 테스트 할 수 있는 사이트 이다.
			//URL httpBin = new URL("https://httpbin.org/get");
			//reader = new BufferedReader(
			//		new InputStreamReader(httpBin.openStream()));
			String line = "";
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			/* MalformedURLException 클래스는 
			 * IOException 클래스를 상속해 구현한 예외처리 클래스이다.
			 **/
		} catch(MalformedURLException e) {
			e.printStackTrace();
			System.out.println("잘못된 URL 정보 입니다.");
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(reader != null) reader.close();
			} catch(IOException e) { }
		}
	}
}
