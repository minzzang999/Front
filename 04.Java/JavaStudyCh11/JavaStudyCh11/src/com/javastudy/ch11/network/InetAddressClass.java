package com.javastudy.ch11.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

// InetAddress 클래스로 호스트 명과 IP 주소 다루기
public class InetAddressClass {

	public static void main(String[] args) {
		
		try {
			
			/* 지정한 도메인 명(host 명)을 이용해 도메인에 해당하는 
			 * IP 주소 정보를 갖는 InetAddress 객체를 구한다.
			 * InetAddress 클래스는 IP 주소를 다루기 위해 제공되는 클래스 이다. 
			 **/
			InetAddress inetAddr = InetAddress.getByName("www.naver.com");
			String hostName = inetAddr.getHostName();
			String ipAddr = inetAddr.getHostAddress();
			System.out.println("naver.com의 호스트 명 : " + hostName
					+ ", IP 주소 : " + ipAddr);			
			
			/* 호스트에 해당하는 IP 주소를 byte 배열로 구한다.
			 * ip는 1byte의 부호 없는 정수로 0 ~ 255 사이를 표현하고 byte 형은 
			 * -128 ~ 127까지 표현하기 때문에 이 범위를 넘어서는 수는 음수로 표시된다. 
			 **/
			byte[] ips = inetAddr.getAddress();
			System.out.println("ip : " + Arrays.toString(ips));
			for(int i = 0; i < ips.length; i++) {
				System.out.print(ips[i] < 0 ? ips[i] + 256 : ips[i]);
				System.out.print(i < ips.length - 1 ? "." : "\n");
			}			
			
			/* 지정한 도메인 명(host 명)을 이용해 도메인에 해당하는
			 * 모든 IP 주소 정보를 갖는 InetAddress 객체 배열을 구한다. 
			 **/
			InetAddress[] inetAddrs = InetAddress.getAllByName("www.naver.com");
			System.out.println("naver.com의 모든 호스트 명과 IP 주소");
			for(InetAddress inet : inetAddrs) {
				System.out.println("호스트 명 : " + inet.getHostName() 
						+ ", IP 주소 : " + inet.getHostAddress());
			}
			
			/* 프로그램이 실행되는 현재 컴퓨터의
			 * IP 주소 정보를 갖는 InetAddress 객체를 구한다.
			 **/
			InetAddress localInet  = InetAddress.getLocalHost();
			System.out.println(localInet.getHostName() + ", " 
						+ localInet.getHostAddress());
			
			/* 컴퓨터는 자신의 호스트 명과 IP 주소를 지칭할 때 localhost와 
			 * 127.0.0.1을 부여하게 되는데 이를 Loopback Address라고 한다. 
			 **/
			System.out.println(InetAddress.getLoopbackAddress());
						
			/* UnknownHostException 클래스는 
			 * IOException 클래스를 상속해 구현한 예외처리 클래스이다.
			 **/
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
