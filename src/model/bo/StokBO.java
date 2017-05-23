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
	StokDAO stokDAO = new StokDAO();

	public ArrayList<Stok> getInfoStok(String iTEMMSTOK,int pagenum) throws Exception {
		return stokDAO.getInfoStok(iTEMMSTOK,pagenum);
	}

	public Stok checkITEMMMKCD(String iTEMMSTOK) throws Exception {
		return stokDAO.checkITEMMMKCD(iTEMMSTOK);
	}

	public Stok checkITEMMSYCD(String iTEMMSTOK) throws Exception {
		return stokDAO.checkITEMMSYCD(iTEMMSTOK);
	}

	public boolean isExistITEMMSKCD(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		return stokDAO.isExistITEMMSKCD(iTEMMSTOK, iTEMMSKCD);
	}

	public void updateInfoStok(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		stokDAO.updateInfoStok(iTEMMSTOK, iTEMMSKCD);
	}

	public ArrayList<Stok> getInfoStok(int pagenum) throws Exception {
		return stokDAO.getInfoStok(pagenum);
	}

}
