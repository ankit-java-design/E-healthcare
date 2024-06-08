package ehealthcare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ehealthcare.Bean.DoctoreBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Utility.JDBCDataSource;

public class DoctorModel {

	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM doctor");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(DoctoreBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO doctor VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getLocation());
			ps.setString(5, bean.getGender());
			ps.setString(6, bean.getCategory());
			ps.setObject(7, bean.getFrom());
			ps.setString(8, bean.getFees());
			ps.setString(9, bean.getExperience());
			ps.setString(10, bean.getStatus());
			ps.setObject(11, bean.getTo());
			ps.executeUpdate();
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
	public List list() throws Exception {
		System.out.println("in model list");
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from doctor");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			DoctoreBean bean = new DoctoreBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setLocation(rs.getString(4));
			bean.setGender(rs.getString(5));
			bean.setCategory(rs.getString(6));
			bean.setFrom(rs.getTime(7).toLocalTime());
			bean.setFees(rs.getString(8));
			bean.setExperience(rs.getString(9));
			bean.setStatus(rs.getString(10));
			bean.setTo(rs.getTime(11).toLocalTime());
			list.add(bean);
		}
		return list;
	}
	
	public List Doctorlist(long userid) throws Exception {
		System.out.println("in model list");
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from doctor where userid=?");
		pstmt.setLong(1, userid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			DoctoreBean bean = new DoctoreBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setLocation(rs.getString(4));
			bean.setGender(rs.getString(5));
			bean.setCategory(rs.getString(6));
			bean.setFrom(rs.getTime(7).toLocalTime());
			bean.setFees(rs.getString(8));
			bean.setExperience(rs.getString(9));
			bean.setStatus(rs.getString(10));
			bean.setTo(rs.getTime(11).toLocalTime());
			list.add(bean);
		}
		return list;
	}
	
	
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from doctor where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public List<DoctoreBean> search(DoctoreBean bean) throws Exception {
			StringBuffer sql = new StringBuffer("SELECT * FROM doctor WHERE 1=1");
			System.out.println("name:" +bean.getId());
			if (bean != null) {
				if (bean.getId()> 0) {
					sql.append(" AND id = " + bean.getId());
				}
				if (bean.getLocation() != null && bean.getLocation().length() > 0) {
					sql.append(" AND location like '" + bean.getLocation() + "%'");
				}
				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" AND name like '" + bean.getName() + "%'");
				}
				
				/*
				 * if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				 * sql.append(" AND login like '" + bean.getLogin() + "%'"); } if
				 * (bean.getRoleId() > 0) { sql.append(" AND roleid = " + bean.getRoleId()); }
				 */
			}

			ArrayList<DoctoreBean> list = new ArrayList<DoctoreBean>();
			Connection conn = null;
			try {
				conn = JDBCDataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					bean.setId(rs.getLong(1));
					bean.setName(rs.getString(2));
					bean.setEmail(rs.getString(3));
					bean.setLocation(rs.getString(4));
					bean.setGender(rs.getString(5));
					bean.setCategory(rs.getString(6));
					bean.setFrom(rs.getTime(7).toLocalTime());
					bean.setFees(rs.getString(8));
					bean.setExperience(rs.getString(9));
					bean.setStatus(rs.getString(10));
					bean.setTo(rs.getTime(11).toLocalTime());
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
		
	public DoctoreBean findByPk(long pk) throws Exception {
		DoctoreBean bean = null;
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM doctor WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new DoctoreBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setLocation(rs.getString(4));
				bean.setGender(rs.getString(5));
				bean.setCategory(rs.getString(6));
				bean.setFrom(rs.getTime(7).toLocalTime());
				bean.setFees(rs.getString(8));
				bean.setExperience(rs.getString(9));
				bean.setStatus(rs.getString(10));
				bean.setTo(rs.getTime(11).toLocalTime());
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	public long Update(DoctoreBean bean) {
		System.out.println("in model update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps =
					conn.prepareStatement("update doctor set name=?,email=?,location=?,gender=?,category=?,fromtime=?,fees=?,experience=?,status=?,totime=? where id=?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getLocation());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getCategory());
			ps.setObject(6, bean.getFrom());
			ps.setString(7, bean.getFees());
			ps.setString(8, bean.getExperience());
			ps.setString(9, bean.getStatus());
			ps.setObject(10, bean.getTo());
			ps.setLong(11, bean.getId());
			 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	public long Booked(String status, long Bid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update doctor set status='" + status + "' where id=?");
			ps.setLong(1, Bid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	public long UBooked(long userid, long Uid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update doctor set userid='" + userid + "' where id=?");
			ps.setLong(1, Uid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}



}
