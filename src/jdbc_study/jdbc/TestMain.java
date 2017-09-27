package jdbc_study.jdbc;

import java.sql.SQLException;
import java.util.List;

import jdbc_study.dao.DepartmentDao;
import jdbc_study.dto.Department;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		/*
		 * DBCon dbCon=DBCon.getInstance(); System.out.println(dbCon);
		 * System.out.println(dbCon.getConn());
		 * 
		 * DBCon dbCon1=DBCon.getInstance(); System.out.println(dbCon1);
		 * System.out.println(dbCon1.getConn());
		 * 
		 * dbCon.connClose();
		 */
		DepartmentDao dao =DepartmentDao.getInstance();
		
		
		//insert
		/*Department dept=new Department(5, "마케팅", 10);
		dao.insertDepartment(dept);
		showDepartmentList(dao);*/
		
		//update
		/*Department updateDept=new Department(5, "인사", 30);
		dao.updateDepartment(updateDept);
		showDepartmentList(dao);*/
		
		//delete
		/*Department delDept=new Department(5);
		dao.deleteDepartment(delDept);
		showDepartmentList(dao);*/
		
		//search
		Department searchDept=new Department(2);
		dao.selectDepartmentByNo(searchDept);
	}

	private static DepartmentDao showDepartmentList(DepartmentDao dao) {
//		DepartmentDao dao = DepartmentDao.getInstance();
		List<Department> lists = dao.selectDepartmentByAll();
		for (Department dept : lists) {
			System.out.println(dept);
		}
		return dao;
	}

}
