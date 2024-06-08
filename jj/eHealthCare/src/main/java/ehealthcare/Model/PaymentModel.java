package ehealthcare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ehealthcare.Bean.PaymentBean;
import ehealthcare.Bean.UserBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Utility.JDBCDataSource;

public class PaymentModel {

	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM payment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}
	public long add(PaymentBean bean) throws Exception {
		System.out.println("in add");
		Connection conn = null;
		int pk = 0;

		PaymentModel model = new PaymentModel();
		/*
		 * UserBean existbean = findByLogin(bean.getLogin()); if (existbean != null) {
		 * throw new DuplicateRecordException("Login Id already exite"); }
		 */

		try {

			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getCardnumber());
			ps.setString(3, bean.getCardexpairy());
			ps.setString(4, bean.getCvv());
			ps.setLong(5, bean.getUserid());
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
	
	
	public List<PaymentBean> list() throws Exception {
		System.out.println("in model list");
		ArrayList<PaymentBean> list = new ArrayList<PaymentBean>();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from payment");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setCardnumber(rs.getString(2));
			bean.setCardexpairy(rs.getString(3));
			bean.setCvv(rs.getString(4));
			list.add(bean);
		}
		return list;
	}
	
	public List<PaymentBean> Showlist(long userid) throws Exception {
		System.out.println("in model list");
		ArrayList<PaymentBean> list = new ArrayList<PaymentBean>();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from payment where userid=?");
		pstmt.setLong(1, userid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setCardnumber(rs.getString(2));
			bean.setCardexpairy(rs.getString(3));
			bean.setCvv(rs.getString(4));
			list.add(bean);
		}
		return list;
	}
	
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from payment where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
