package com.javastudy.ch08.list;

import java.util.ArrayList;

public class EmployeeManagement {

	public static void main(String[] args) {
		
		// DB에 있는 필요한 데이터를 EmployeeDao를 이용해서 가져와 출력
		EmployeeDao dao = new EmployeeDao();
		ArrayList<Employee> empList = dao.employeeList();
		
		System.out.println("\t##### 사원 리스트 #####");
		System.out.println("사번\t\t이름\t\t직책\t\t급여");
		for(int i = 0; i < empList.size(); i++) {
			Employee emp = empList.get(i);
			System.out.println(emp.getEmpno() + "\t\t" + emp.getName()
					+ "\t\t" + emp.getJob() + "\t\t" + emp.getSal());
			
		}		
	}
}








