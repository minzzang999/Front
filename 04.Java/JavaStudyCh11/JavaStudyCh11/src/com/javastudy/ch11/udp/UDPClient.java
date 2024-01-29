package com.javastudy.ch11.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

// DatagramSocket과 DatagramPacket 클래스로 UDP 클라이언트 구현하기
public class UDPClient {

	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		
		try {			
			/* 1. UDP 통신을 통해 데이터를 송수신할 DatagramSocket 객체를
			 * 생성한다. 기본 생성자를 호출하거나 생성자의 인수로 0을 전달하면
			 * 자바가 사용가능한 임의의 포트를 선택해 객체를 생성한다. 
			 **/
			socket = new DatagramSocket();
			//socket = new DatagramSocket(8888);
			
			// 2. 호스트명을 이용해 서버의 IP 주소를 구한다.
			InetAddress serverAddr = InetAddress.getByName("localhost");
			System.out.println("server IP : " + serverAddr.getHostAddress());
			
			// 3. 송수신 데이터가 저장될 byte 배열을 생성한다.
			byte[] inBuf = new byte[1024];
			byte[] outBuf = "안녕 UDP 서버".getBytes();
			
			// 4. 서버로 전송할 데이터를 담을 DatagramPacket 객체를 생성한다.
			/* DatagramPacket 클래스의 생성자 중에서 InetAddress나 SocketAddress
			 * 타입의 파라미터를 가진 생성자는 네트워크를 통해 데이터를 보내기
			 * 위한 객체를 생성할 때 사용하는 생성자 이다.
			 * UDP 통신을 사용하는 대부분의 소프트웨어는 데이터그램당 8,192Byte를
			 * 초과하지 않는다. 이론적으로 IPv4의 데이터그램은 65,507Byte로 제안하고
			 * 있으며 DatagramPacket 객체는 이 크기까지 데이터를 손실없이 받을 수
			 * 있다. 하지만 많은 운영체제에서 8KByte 이상의 UDP 데이터그램을 지원하지
			 * 않으며 이 보다 클 경우 패킷을 잘라 버린다. 이런 경우 패킷이 버려진 것을
			 * 통보 받을 수 없기 때문에 UDP 통신 프로그램을 작성할 경우에는 8KByte
			 * 보다 큰 DatagramPacket 객체를 생성하지 않도록 주의해야 한다.    
			 **/ 
			DatagramPacket outPacket = 
					new DatagramPacket(outBuf, outBuf.length, serverAddr, 8888);			
			System.out.println("서버 IP : " + outPacket.getAddress().getHostAddress()
					+ ", 서버 포트 : " + outPacket.getPort());
			
			// 5. 서버의 응답 데이터를 담을 DatagramPacket 객체를 생성한다.  
			/* DatagramPacket 클래스의 생성자 중에서 byte 배열과 int 형으로
			 * 구성된 파라미터를 가진 생성자는 네트워크로부터 데이터를 받기 위한
			 * 객체를 생성할 때 사용하는 생성자 이다.
			 **/ 
			DatagramPacket inPacket = new DatagramPacket(inBuf, inBuf.length);
			
			// 6. 송수신할 준비가 끝나면 소켓을 통해 데이터를 보내고 응답을 받는다.
			/* 소켓의 연결 타임아웃을 설정한다. 지정한 시간동안 연결이
			 * 되지 않으면 SocketTimeoutException이 발생한다.
			 **/
			socket.setSoTimeout(10000);
			socket.send(outPacket);
			socket.receive(inPacket);
			
			// 7. 서버로부터 응답 받은 데이터를 DatagramPacket에서 읽는다.
			String data = new String(inPacket.getData());
			System.out.println("서버에서 받은 응답 : " + data);
			
		} catch(SocketException e) {
			e.printStackTrace();
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();	
			
		} finally {
			// 8. 모든 작업이 끝나면 소켓을 닫는다.
			if(socket != null) socket.close();
		}
	}
}
