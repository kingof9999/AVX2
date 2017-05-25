package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Stok;

/**
 * StokDAO
 * 
 * Version 3.0
 * 
 * Date: 18/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 22/05/2017		TinLQ			Create
 */
public class StokDAO {
	// call class DBconnection to use
	DBConnection connect = new DBConnection();
	// set method getConnect() from DBconnection class to use Connection
	Connection conn = DBConnection.getConnect();
	Statement stmt;

	/**
	 * get data from database and set to list
	 * 
	 * @param iTEMMSTOK
	 * @param pagenum
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Stok> getInfoStok(String iTEMMSTOK, int pagenum) throws Exception {
		// select data from table AUTITEMM, AUTEMPFL, AUTDCCFL
		String sql = "SELECT *"
				+ " FROM (SELECT ROW_NUMBER() OVER(ORDER BY ITEMM_STOK) AS ct,COUNT(1) OVER(ORDER BY ITEMM_HNKB) AS cc, AUTITEMM.*, AUTEMPFL.EMPFL_EMPNM, AUTDCCFL.DCCFL_NAME"
				+ " FROM AUTITEMM, AUTEMPFL, AUTDCCFL" + " WHERE AUTEMPFL.EMPFL_EMPNO = AUTITEMM.ITEMM_EMPNO"
				+ " AND AUTDCCFL.DCCFL_DCCD1 = AUTITEMM.ITEMM_DCCD1" + " AND ITEMM_STOK LIKE '" + iTEMMSTOK + "%'"
				+ " AND (ITEMM_HNKB = 0 OR ITEMM_HNKB = 1))" + " sub WHERE ( ct = " + pagenum + ")";
		ResultSet rs;
		Statement stmt = null;
		// catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// throw exception if error
			throw new Exception("Error occur: " + e.getMessage());
		}
		ArrayList<Stok> list = new ArrayList<Stok>();
		Stok stok;
		try {
			// check exist in database
			if (rs.next()) {
				stok = new Stok();
				// set all element to Stok Bean
				stok.setAllpage(rs.getInt("cc"));
				stok.setiTEMMSTOK(rs.getString("ITEMM_STOK").trim());
				stok.setiTEMMSKCD(rs.getString("ITEMM_SKCD").trim());
				stok.setiTEMMTNTO(rs.getString("ITEMM_TNTO1").trim() + rs.getString("ITEMM_TNTO2").trim());
				stok.seteMPFLEMPNM(rs.getString("EMPFL_EMPNM").trim());
				stok.setdCCFLNAME(rs.getString("DCCFL_NAME").trim());
				stok.setiTEMMHNME(rs.getString("ITEMM_HNME").trim());
				stok.setiTEMMMKCD(rs.getString("ITEMM_MKCD").trim());
				stok.setiTEMMSYCD(rs.getString("ITEMM_SYCD").trim());
				stok.setiTEMMTNKMK(rs.getString("ITEMM_TNKMK").trim());
				stok.setiTEMMPART(rs.getInt("ITEMM_PART"));
				list.add(stok);
			}
		} catch (Exception e) {
			throw new Exception("Error occur: " + e.getMessage());
		} finally {
			// close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
		return list;
	}

	/**
	 * get data from database and set to list
	 * 
	 * @param pagenum
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Stok> getInfoStok(int pagenum) throws Exception {
		// select data from table AUTITEMM, AUTEMPFL, AUTDCCFL
		String sql = String.format("SELECT *"
				+ " FROM (SELECT ROW_NUMBER() OVER(ORDER BY ITEMM_STOK) AS ct,COUNT(1) OVER(ORDER BY ITEMM_HNKB) AS cc, AUTITEMM.*, AUTEMPFL.EMPFL_EMPNM, AUTDCCFL.DCCFL_NAME"
				+ " FROM AUTITEMM, AUTEMPFL, AUTDCCFL" + " WHERE AUTEMPFL.EMPFL_EMPNO = AUTITEMM.ITEMM_EMPNO"
				+ " AND AUTDCCFL.DCCFL_DCCD1 = AUTITEMM.ITEMM_DCCD1" + " AND (ITEMM_HNKB = 0 OR ITEMM_HNKB = 1))"
				+ " sub WHERE ( ct = %s)", pagenum);
		ResultSet rs;
		Statement stmt = null;
		// catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// throw exception if error
			throw new Exception("Error occur: " + e.getMessage());
		}
		ArrayList<Stok> list = new ArrayList<Stok>();
		Stok stok;
		try {
			// check exist in database
			while (rs.next()) {
				stok = new Stok();
				// set all element to Stok Bean
				stok.setAllpage(rs.getInt("cc"));
				stok.setiTEMMSTOK(rs.getString("ITEMM_STOK").trim());
				stok.setiTEMMSKCD(rs.getString("ITEMM_SKCD").trim());
				stok.setiTEMMTNTO(rs.getString("ITEMM_TNTO1").trim() + rs.getString("ITEMM_TNTO2").trim());
				stok.seteMPFLEMPNM(rs.getString("EMPFL_EMPNM").trim());
				stok.setdCCFLNAME(rs.getString("DCCFL_NAME").trim());
				stok.setiTEMMHNME(rs.getString("ITEMM_HNME").trim());
				stok.setiTEMMMKCD(rs.getString("ITEMM_MKCD").trim());
				stok.setiTEMMSYCD(rs.getString("ITEMM_SYCD").trim());
				stok.setiTEMMTNKMK(rs.getString("ITEMM_TNKMK").trim());
				stok.setiTEMMPART(rs.getInt("ITEMM_PART"));
				list.add(stok);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occur: " + e.getMessage());
		} finally {
			// close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
		return list;
	}

	/**
	 * get data from database and set to iTEMMMKCD
	 * 
	 * @param iTEMMSTOK
	 * @return
	 * @throws Exception
	 */
	public Stok checkITEMMMKCD(String iTEMMSTOK) throws Exception {
		// select data from table AUTITEMM
		String sql = String.format("SELECT m.MAKER_DATA" + " FROM AUTITEMM i"
				+ " INNER JOIN AUTMAKER m ON i.ITEMM_STOK = '%s' AND i.ITEMM_MKCD = m.MAKER_ID", iTEMMSTOK);
		ResultSet rs;
		Statement stmt = null;
		// catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// throw exception if error
			throw new Exception("Error occur: " + e.getMessage());
		}
		Stok stok = new Stok();
		try {
			// check exist in database
			if (rs.next()) {
				// set MAKER_DATA to Stok(mAKERDATA) Bean
				stok.setmAKERDATA(rs.getString("MAKER_DATA"));
			} else {
				// set "æŒ‡å®šç„¡ã�—" to Stok(mAKERDATA) Bean
				stok.setmAKERDATA("指定無し");
			}
		} catch (Exception e) {
			throw new Exception("Error occur: " + e.getMessage());
		} finally {
			// close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
		return stok;
	}

	/**
	 * get data from database and set to iTEMMSYCD
	 * 
	 * @param iTEMMSTOK
	 * @return
	 * @throws Exception
	 */
	public Stok checkITEMMSYCD(String iTEMMSTOK) throws Exception {
		// select data from table AUTITEMM
		String sql = String.format("SELECT c.CARNM_NAME" + " FROM AUTITEMM i"
				+ " INNER JOIN AUTCARNM c ON i.ITEMM_STOK = '%s' AND i.ITEMM_SYCD = c.CARNM_SHSYCD", iTEMMSTOK);
		ResultSet rs;
		Statement stmt = null;
		// catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// throw exception if error
			throw new Exception("Error occur: " + e.getMessage());
		}
		Stok stok = new Stok();
		try {
			// check exist in database
			if (rs.next()) {
				// set MAKER_DATA to Stok(mAKERDATA) Bean
				stok.setcARNMNAME(rs.getString("CARNM_NAME"));
			} else {
				// set "æŒ‡å®šç„¡ã�—" to Stok(mAKERDATA) Bean
				stok.setcARNMNAME("指定無し");
			}
		} catch (Exception e) {
			throw new Exception("Error occur: " + e.getMessage());
		} finally {
			// close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
		return stok;
	}

	/**
	 * get data from database and check it if exist
	 * 
	 * @param iTEMMSTOK
	 * @param iTEMMSKCD
	 * @return
	 * @throws Exception
	 */
	public boolean isExistITEMMSKCD(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		// select data from table AUTITEMM
		String sql = String.format(
				"SELECT ITEMM_STOK" + " FROM AUTITEMM" + " WHERE ITEMM_STOK LIKE '%s' AND ITEMM_SKCD = '%s'", iTEMMSTOK,
				iTEMMSKCD);
		ResultSet rs;
		Statement stmt = null;
		// catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// throw exception if error
			throw new Exception("Error occur: " + e.getMessage());
		}
		try {
			// check exist in database
			return rs.next();
		} catch (Exception e) {
			throw new Exception("Error occur: " + e.getMessage());
		} finally {
			// close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
	}

	/**
	 * update value to database
	 * 
	 * @param iTEMMSTOK
	 * @param iTEMMSKCD
	 * @return
	 * @throws Exception
	 */
	public boolean updateInfoStok(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		// insert data to table
		String sql = String.format("UPDATE AUTITEMM SET ITEMM_SKCD = '%s' WHERE ITEMM_STOK = '%s'", iTEMMSKCD,
				iTEMMSTOK);
		int rs;
		Statement stmt = null;
		// catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
			return (rs == 1);
		} catch (Exception e) {
			// throw exception if error
			throw new Exception("Error occur: " + e.getMessage());
		} finally {
			// close all connect
			stmt.close();
			DBConnection.disConnect();
		}
	}
}
