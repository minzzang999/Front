package com.javastudy.ch11.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

// DatagramSocket과 DatagramPacket 클래스로 UDP 서버 구현하기
public class UDPServer {

	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		
		try {			
			/* 1. UDP 통신을 통해 데이터를 송수신할 DatagramSocket 객체를
			 * 생성한다. 기본 생성자를 호출하거나 생성자의 인수로 0을 전달하면
			 * 자바가 사용가능한 임의의 포트를 선택해 객체를 생성한다. 
			 **/
			socket = new DatagramSocket(8888);
			//socket = new DatagramSocket(8888);
			
			// 2. 송수신 데이터가 저장될 byte 배열을 생성한다.
			byte[] requestBuf = new byte[1024];
			byte[] responseBuf = "안녕 UDP 클라이언트".getBytes();

			// 3. 클라이언트이 요청 데이터를 담을 DatagramPacket 객체를 생성한다.  
			/* DatagramPacket 클래스의 생성자 중에서 byte 배열과 int 형으로
			 * 구성된 파라미터를 가진 생성자는 네트워크로부터 데이터를 받기 위한
			 * 객체를 생성할 때 사용하는 생성자 이다.
			 **/ 
			DatagramPacket request = 
					new DatagramPacket(requestBuf, requestBuf.length);
			
			// 4. 클라이언트의 요청 데이터를 받는다.
			/* UDP 클라이언트와 다르게 먼저 클라이언트의 요청 데이터를 수신하고
			 * 응답 데이터를 작성해 데이터를 클라이언트로 전송하면 된다.
			 **/
			socket.receive(request);
			
			// 5. 클라이언트로부터 요청 받은 데이터를 DatagramPacket에서 읽는다.			
			String data = new String(request.getData());
			System.out.println("클라이언트에서 받은 요청 : " + data);			
			
			/* 위에서 출력 결과를 보면 클라이언트 요청으로 받은 실제 데이터 보다
			 * 수신 DatagramPacket 객체의 버퍼가 크기 때문에 데이터 뒤 쪽에
			 * 모두 0으로 채워져 받게 된다. 0을 다시 String으로 변화하는 과정에서
			 * 유니코드 첫 번째 문자('\u0000')로 변환되어 출력된다.
			 * 실제 클라이언트의 요청 데이터만 출력하기 위해 아래와 같이 처리했다.
			 **/
			int len = request.getLength();
			byte[] result = new byte[len];						
			System.arraycopy(request.getData(), 0, result, 0, len);
			System.out.println(new String(result));
			
			/* 6. 응답 데이터를 보내기 위해 클라이언트의 요청 데이터를 담고 있는
			 * DatagramPacket 객체로 부터 클라이언트의 IP 주소와 포트를 구한다.
			 **/
			InetAddress clientAddr = request.getAddress();
			int port = request.getPort();
			
			// 7. 클라이언트로 전송할 데이터를 담을 DatagramPacket 객체를 생성한다.
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
			DatagramPacket response = 
					new DatagramPacket(responseBuf, 
							responseBuf.length, clientAddr, port);
			
			// 8. 클라이언트로 응답 데이터를 전송한다.
			socket.send(response);
			
		} catch(SocketException e) {
			e.printStackTrace();
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();		
			
		} finally {
			// 9. 모든 작업이 끝나면 소켓을 닫는다.
			if(socket != null) socket.close();
		}
	}
}
