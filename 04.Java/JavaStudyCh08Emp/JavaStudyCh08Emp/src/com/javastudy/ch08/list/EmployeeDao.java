package com.javastudy.ch08.list;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO - Data Access Object, DB Access Object
/* 일반적으로 DB 작업을 전담하는 클래스를 별도로 만들어 DB 작업을 구현하는데
 * 이렇게 데이터에 직접 접근해 작업하는 클래스를 DAO(Data Access Object)라고 부른다.
 **/
public class EmployeeDao {
	
	// DB 접속을 위한 드라이버, 오라클 접속 URL, 사용자 인증 정보
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "hr";
	private static final String pass = "hr";
	
	// DB 작업을 위해 DB에 연결할 수 있도록 지원하는 객체
	Connection conn;
	
	// DB에 SQL 쿼리를 발행해주는 객체
	PreparedStatement pstmt;
	
	// SQL 명령을 DB에 발행하여 읽어온 데이터의 결과 집합 - 일종의 가상 테이블
	ResultSet rs;	
	
	
	/* 이 예제는 생성자에서 DB에 접속할 수 있는 드라이버 클래스를 로딩 함
	 * 상황에 따라서 여러 가지 형태로 데이터베이스 접속 드라이버를 로딩 할 수 있음
	 **/
	public EmployeeDao() {
		try {
			Class.forName(driver);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/* 필요한 각각의 기능을 메서드 단위로 정의해 사용함
	 * 테이블에 저장된 사원의 리스트를 DB로부터 읽어와 ArrayList로 반환하는 메서드
	 * 일반적으로 한 번의 기능에서 DB에 접속해 작업하고 접속을 해제하는 형태로 작성함
	 **/
	public ArrayList<Employee> employeeList() {
		ArrayList<Employee> empList = null;
		
		try {
			// DB 접속
			conn = DriverManager.getConnection(url, user, pass);
			
			// 쿼리를 발행하기 위한 준비
			pstmt = conn.prepareStatement("SELECT * FROM emp");
			
			// DB에 SELECT 쿼리를 발행하고 그 결과를 ResultSet 객체로 받음
			rs = pstmt.executeQuery();
			
			// ResultSet에서 사원 정보를 읽어와 저장할 ArrayList 객체 생성
			empList = new ArrayList<Employee>();
			
			/* ResultSet은 테이블에 SELECT 쿼리를 발행하여 읽어온 데이터의 결과
			 * 집합으로 테이블과 비슷한 행과 열로 구성되어 있어 가상 테이블 형식이라고
			 * 하며 커서를 한 행씩 뒤로 이동해 데이터를 추출할 수 있는 구조를 가지고 있다.
			 * 그러므로 아래와 같이 반복문에서 ResultSet이 제공하는 next() 메서드를 
			 * 사용해 커서를 한 행씩 이동하면서 각 행의 데이터를 추출해 Employee 객체로
			 * 만들어서 ArrayList에 담으면 테이블에서 읽어온 사원 리스트를 만들 수 있다. 
			 **/
			while(rs.next()) {		
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				String gender = rs.getString("gender");
				String job = rs.getString("job");				
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				
				Employee e = new Employee(empno, name, gender, job, hiredate, sal);
				empList.add(e);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			// DB 자원 해제 - DB 작업시 생성한 역순으로 닫음
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return empList;
	}
	
	
	// 아래 두 개의 요구사항에 따라서 메서드 선언부만 만들어 보세요
	// 사원 번호에 해당하는 한 명의 사원 정보를 읽어와서 반환하는 메서드 정의		
	
	
	// 부서 번호에 해당하는 사원 리스트를 읽어와서 반환하는 메서드 
	
	
}
