package com.javastudy.ch08.list;

import java.sql.Date;

// ValueObject - VO
/* DB 테이블의 한 행의 정보를 저장할 수 있는 클래스를 만들어 사용함
 * 이렇게 DB 테이블로부터 읽어온 데이터를 저장하는 객체를 VO(Value Object),
 * DTO(Data Transfer Object), 도메인 객체(Domain Object) 등으로 부른다.   
 **/
public class Employee {

	// 테이블로부터 읽어와 저장할 데이터를 인스턴스 변수로 선언
	private int empno;
	private String name;
	private String gender;
	private String job;
	private Date hiredate;
	private int sal;
	
	public Employee() {}
	
	public Employee(int empno, String name, 
			String gender, String job, Date hiredate, int sal) {
		this.empno = empno;
		this.name = name;
		this.gender = gender;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}		
}
