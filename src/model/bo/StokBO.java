package model.bo;

import java.util.ArrayList;

import model.bean.Stok;
import model.dao.StokDAO;

/**
 * StokBO
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
public class StokBO {
	// call class StokDAO to use
	StokDAO stokDAO = new StokDAO();

	/**
	 * Processing business get list
	 * 
	 * @param iTEMMSTOK
	 * @param pagenum
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Stok> getInfoStok(String iTEMMSTOK, int pagenum) throws Exception {
		return stokDAO.getInfoStok(iTEMMSTOK, pagenum);
	}

	/**
	 * Processing business get value
	 * 
	 * @param iTEMMSTOK
	 * @return
	 * @throws Exception
	 */
	public Stok checkITEMMMKCD(String iTEMMSTOK) throws Exception {
		return stokDAO.checkITEMMMKCD(iTEMMSTOK);
	}

	/**
	 * Processing business get value
	 * 
	 * @param iTEMMSTOK
	 * @return
	 * @throws Exception
	 */
	public Stok checkITEMMSYCD(String iTEMMSTOK) throws Exception {
		return stokDAO.checkITEMMSYCD(iTEMMSTOK);
	}

	/**
	 * Processing business check exist item
	 * 
	 * @param iTEMMSTOK
	 * @param iTEMMSKCD
	 * @return
	 * @throws Exception
	 */
	public boolean isExistITEMMSKCD(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		return stokDAO.isExistITEMMSKCD(iTEMMSTOK, iTEMMSKCD);
	}

	/**
	 * Processing business update value
	 * 
	 * @param iTEMMSTOK
	 * @param iTEMMSKCD
	 * @throws Exception
	 */
	public boolean updateInfoStok(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		return stokDAO.updateInfoStok(iTEMMSTOK, iTEMMSKCD);
	}

	/**
	 * Processing business get list
	 * 
	 * @param pagenum
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Stok> getInfoStok(int pagenum) throws Exception {
		return stokDAO.getInfoStok(pagenum);
	}

}
