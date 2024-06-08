package ehealthcare.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ehealthcare.Bean.AppointmentBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Utility.JDBCDataSource;

public class AppointmentModel {

	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM appointment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(AppointmentBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO appointment VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getPatientname());
			ps.setString(3, bean.getDisease());
			ps.setDate(4, new Date(bean.getAppointmentdate().getTime()));
			ps.setObject(5, bean.getAppointmenttime());
			ps.setString(6, bean.getAppointmentdescription());
			ps.setLong(7, bean.getUserid());
			ps.setString(8, bean.getDoctorName());
			ps.setString(9, bean.getStatus());
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
		try {
			Connection conn = null;
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * from  appointment");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AppointmentBean bean = new AppointmentBean();
				bean.setId(rs.getLong(1));
				bean.setPatientname(rs.getString(2));
				bean.setDisease(rs.getString(3));
				bean.setAppointmentdate(rs.getDate(4));
				bean.setAppointmenttime(rs.getTime(5).toLocalTime());
				bean.setAppointmentdescription(rs.getString(6));
				bean.setUserid(rs.getLong(7));
				bean.setDoctorName(rs.getString(8));
				bean.setStatus(rs.getString(9));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List Showlist(long userid) throws Exception {
		System.out.println("in model list");
		ArrayList list = new ArrayList();
		try {
			Connection conn = null;
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * from  appointment where userid=?");
			pstmt.setLong(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AppointmentBean bean = new AppointmentBean();
				bean.setId(rs.getLong(1));
				bean.setPatientname(rs.getString(2));
				bean.setDisease(rs.getString(3));
				bean.setAppointmentdate(rs.getDate(4));
				bean.setAppointmenttime(rs.getTime(5).toLocalTime());
				bean.setAppointmentdescription(rs.getString(6));
				bean.setUserid(rs.getLong(7));
				bean.setDoctorName(rs.getString(8));
				bean.setStatus(rs.getString(9));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from appointment where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<AppointmentBean> search(AppointmentBean bean) throws Exception {
		StringBuffer sql = new StringBuffer(
				"SELECT * from  appointment WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getPatientname() != null && bean.getPatientname().length() > 0) {
				sql.append(" AND patient like '" + bean.getPatientname() + "%'");
				System.out.println("name:" + bean.getPatientname());
			}
			/*
			 * if (bean.getLogin() != null && bean.getLogin().length() > 0) {
			 * sql.append(" AND login like '" + bean.getLogin() + "%'"); } if
			 * (bean.getRoleId() > 0) { sql.append(" AND roleid = " + bean.getRoleId()); }
			 */
		}
		ArrayList<AppointmentBean> list = new ArrayList<AppointmentBean>();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean.setId(rs.getLong(1));
				bean.setPatientname(rs.getString(2));
				bean.setDisease(rs.getString(3));
				bean.setAppointmentdate(rs.getDate(4));
				bean.setAppointmenttime(rs.getTime(5).toLocalTime());
				bean.setAppointmentdescription(rs.getString(6));
				bean.setUserid(rs.getLong(7));
				bean.setDoctorName(rs.getString(8));
				bean.setStatus(rs.getString(9));
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
	
	public long Confirm(String status, long Cid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update appointment set status='" + status + "'  where id=?");
			ps.setLong(1, Cid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	public long cancle(String status, long Rid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update appointment set status='" + status + "' where id=?");
			ps.setLong(1, Rid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	public long Paid(String status, long Pid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update appointment set status='" + status + "'  where id=?");
			ps.setLong(1, Pid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

}
