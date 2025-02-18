package ehealthcare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ehealthcare.Bean.ContactBean;
import ehealthcare.Exception.ApplicationException;
import ehealthcare.Utility.JDBCDataSource;

public class ContactModel {

	
	
	public Integer nextpk() throws Exception {

		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM contact");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(ContactBean bean) throws Exception {
		System.out.println("in add");
		Connection conn = null;
		int pk = 0;

		ContactModel model = new ContactModel();
		/*
		 * UserBean existbean = findByLogin(bean.getLogin()); if (existbean != null) {
		 * throw new DuplicateRecordException("Login Id already exite"); }
		 */

		try {

			conn = JDBCDataSource.getConnection();
			pk = nextpk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO contact VALUES(?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getSubject());
			ps.setString(5, bean.getMessage());
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
	
	
	
}

