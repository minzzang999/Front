package com.jspstudych03.classes;

import java.util.Calendar;

public class ClassesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object 
		String msg = "안녕하세요";
		String name = new String("홍길동");// object java.lang.pkg // 기본패키지 // import를 하지 않아도 컴파일러가 자동으로 써줌
		System.out.println(name + "님" + msg); 
		
		Calendar cal = Calendar.getInstance(); //  util에 있음 원 형식은 java.util을 기재해야 하나  import를 통해 자동으로 컴파일 해줌
	}

}
