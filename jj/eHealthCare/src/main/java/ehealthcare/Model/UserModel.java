package ehealthcare.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ehealthcare.Bean.UserBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Exception.DuplicateRecordException;
import ehealthcare.Utility.JDBCDataSource;

public class UserModel {

	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM USER");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public UserBean findByLogin(String login) throws Exception {

		UserBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE email=?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setPhoneNo(rs.getString(5));
				bean.setGender(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setRoleid(rs.getLong(8));
				bean.setRolename(rs.getString(9));
				bean.setCreatedby(rs.getString(10));
				bean.setModifiedby(rs.getString(11));
				bean.setCreatedatetime(rs.getTimestamp(12));
				bean.setModifieddatetime(rs.getTimestamp(13));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bean;
	}

	public UserBean findByPk(long pk) throws Exception {

		UserBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setPhoneNo(rs.getString(5));
				bean.setGender(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setRoleid(rs.getLong(8));
				bean.setRolename(rs.getString(9));
				bean.setCreatedby(rs.getString(10));
				bean.setModifiedby(rs.getString(11));
				bean.setCreatedatetime(rs.getTimestamp(12));
				bean.setModifieddatetime(rs.getTimestamp(13));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public UserBean Authenticate(String Email, String Password) throws Exception {
		UserBean bean = null;
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE EMAIL =? AND PASSWORD =?");
		ps.setString(1, Email);
		ps.setString(2, Password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setPhoneNo(rs.getString(5));
			bean.setGender(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setRoleid(rs.getLong(8));
			bean.setRolename(rs.getString(9));
			bean.setCreatedby(rs.getString(10));
			bean.setModifiedby(rs.getString(11));
			bean.setCreatedatetime(rs.getTimestamp(12));
			bean.setModifieddatetime(rs.getTimestamp(13));
		}
		return bean;
	}

	public long add(UserBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;
		UserBean existbean = findByLogin(bean.getEmail());
		if (existbean != null) {
			throw new DuplicateRecordException("Login Id already exite");
		}

		try {
			System.out.println("in add method");
			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("in add method");
			ps.setLong(1, pk);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getPhoneNo());
			ps.setString(6, bean.getGender());
			ps.setDate(7, new Date(bean.getDob().getTime()));
			System.out.println("11111111111111111");
			ps.setLong(8, bean.getRoleid());
			ps.setString(9, bean.getRolename());
			System.out.println("222222222222222");
			ps.setString(10, bean.getCreatedby());
			ps.setString(11, bean.getModifiedby());
			ps.setTimestamp(12, bean.getCreatedatetime());
			ps.setTimestamp(13, bean.getModifieddatetime());
			System.out.println("ookkkkk");
			ps.executeUpdate();
			System.out.println("nooooookkkk");
			conn.commit();
			ps.close();
		} catch (Exception e) {
e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
			}
		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}

	public List<UserBean> list() throws Exception {
		System.out.println("in model list");
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from user");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			UserBean bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setPhoneNo(rs.getString(5));
			bean.setGender(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setRolename(rs.getString(9));
			list.add(bean);
		}
		return list;
	}

	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from USER where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}



	public long Update(UserBean bean) {

		System.out.println("in model update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update user set name=?,email=?,password=?,phoneNo=?,gender=?,dob=?,rolename=? where id=?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getPhoneNo());
			ps.setString(5, bean.getGender());
			ps.setDate(6, new Date(bean.getDob().getTime()));
			ps.setString(7, bean.getRolename());
			ps.setLong(8, bean.getId());
			 ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

	
public List<UserBean> search(UserBean bean) throws Exception {
	System.out.println("name:"+bean.getName());
		StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE 1=1");
		System.out.println("name:" +bean.getId());
		if (bean != null) {
			if (bean.getId()> 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND name like '" + bean.getName() + "%'");
				System.out.println("name:"+bean.getName());
			}
			
			/*
			 * if (bean.getLogin() != null && bean.getLogin().length() > 0) {
			 * sql.append(" AND login like '" + bean.getLogin() + "%'"); } if
			 * (bean.getRoleId() > 0) { sql.append(" AND roleid = " + bean.getRoleId()); }
			 */
		}

		ArrayList<UserBean> list = new ArrayList<UserBean>();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			System.out.println("ssssqqqqqqlllll:"+sql);
			while (rs.next()) {
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setPhoneNo(rs.getString(5));
				bean.setGender(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setRolename(rs.getString(9));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
e.printStackTrace();
		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return list;
		
	}
	
	
	
	
	/*
	 * public List search(UserBean bean) throws Exception {
	 * 
	 * StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE 1=1"); if (bean
	 * != null) {
	 * 
	 * if (bean.getId() > 0) { sql.append(" AND id = " + bean.getId()); } if
	 * (bean.getName() != null && bean.getName().length() > 0) {
	 * sql.append(" AND name like '" + bean.getName() + "%'");
	 * 
	 * System.out.println("First Name" + bean.getName()); }
	 * 
	 * } System.out.println("ooooooooooooooo"); ArrayList list = new ArrayList();
	 * Connection conn = null; try { conn = JDBCDataSource.getConnection();
	 * PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	 * System.out.println("sql:"+sql); ResultSet rs = pstmt.executeQuery(); while
	 * (rs.next()) { System.out.println(",,,,,,,,,,,,,,,,"); bean = new UserBean();
	 * bean.setId(rs.getLong(1)); bean.setName(rs.getString(2));
	 * bean.setEmail(rs.getString(3)); bean.setPassword(rs.getString(4));
	 * bean.setPhoneNo(rs.getString(5)); bean.setGender(rs.getString(6));
	 * bean.setDob(rs.getDate(7)); bean.setRoleid(rs.getLong(8));
	 * bean.setRolename(rs.getString(9)); bean.setCreatedby(rs.getString(10));
	 * bean.setModifiedby(rs.getString(11));
	 * bean.setCreatedatetime(rs.getTimestamp(12));
	 * bean.setModifieddatetime(rs.getTimestamp(13)); list.add(bean); } rs.close();
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * JDBCDataSource.closeconnection(conn); } return list;
	 * 
	 * }
	 */
}
