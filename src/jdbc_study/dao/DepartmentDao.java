package jdbc_study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_study.dto.Department;
import jdbc_study.jdbc.DBCon;
import jdbc_study.jdbc.JdbcUtil;

public class DepartmentDao {
	private static final DepartmentDao instance = new DepartmentDao();

	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	private DepartmentDao() {
	}

	public static DepartmentDao getInstance() {
		return instance;
	}

	public List<Department> selectDepartmentByAll() {
		List<Department> lists = new ArrayList<>();

		sql = "select deptno, deptname, floor from department";
		con = DBCon.getInstance().getConn();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int deptNo = rs.getInt("deptno");
				String deptName = rs.getString("deptname");
				int floor = rs.getInt("floor");
				lists.add(new Department(deptNo, deptName, floor));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return lists;
	}

	public Department selectDepartmentByNo(Department searchDept) {
		sql = "select * from department where deptno=?";

		Department department = null;
		return department;
	}

	public void insertDepartment(Department dept) {
		sql = "insert into department values(?,?,?)";
		try {
			pstmt = DBCon.getInstance().getConn().prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getFloor());

			int res = pstmt.executeUpdate();
			if (res < 0) {
				System.out.println("삽입 실패");
				return;
			}
			JOptionPane.showMessageDialog(null, dept + "추가하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public void updateDepartment(Department updateDept) {
		sql = "update department set deptName=?, floor=? where deptno=?";
		try {
			pstmt = DBCon.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, updateDept.getDeptName());
			pstmt.setInt(2, updateDept.getFloor());
			pstmt.setInt(3, updateDept.getDeptNo());

			int res = pstmt.executeUpdate();
			if (res < 0) {
				System.out.println("수정 실패");
				return;
			}
			JOptionPane.showMessageDialog(null, updateDept + "를 수성하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public void deleteDepartment(Department delDept) {
		sql = "delete from department where deptno=?";
		try {
			pstmt = DBCon.getInstance().getConn().prepareStatement(sql);
			pstmt.setInt(1, delDept.getDeptNo());
			int res = pstmt.executeUpdate();
			if (res < 0) {
				System.out.println("삭제 실패");
				return;
			}
			JOptionPane.showMessageDialog(null, delDept + "번 부서를 삭제하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}
