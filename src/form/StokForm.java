package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import common.CheckData;
import model.bean.Stok;

/**
 * StokForm
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
 * 23/05/2017		TinLQ			Create
 */
public class StokForm extends ActionForm {
	private String iTEMMSTOK;
	private String iTEMMSKCD;
	private String iTEMMTNTO;
	private String eMPFLEMPNM;
	private String dCCFLNAME;
	private String iTEMMHNME;
	private String mAKERDATA;
	private String iTEMMMKCD;
	private String cARNMNAME;
	private String iTEMMSYCD;
	private String iTEMMTNKMK;
	private int iTEMMPART;
	private ArrayList<Stok> listStok;
	private int pagenum = 1;
	private int allpage;

	/**
	 * @return the allpage
	 */
	public int getAllpage() {
		return allpage;
	}

	/**
	 * @param allpage
	 *            the allpage to set
	 */
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}

	/**
	 * @return the iTEMMSTOK
	 */
	public String getiTEMMSTOK() {
		return iTEMMSTOK;
	}

	/**
	 * @param iTEMMSTOK
	 *            the iTEMMSTOK to set
	 */
	public void setiTEMMSTOK(String iTEMMSTOK) {
		this.iTEMMSTOK = CheckData.chuanHoa(iTEMMSTOK);
	}

	/**
	 * @return the iTEMMSKCD
	 */
	public String getiTEMMSKCD() {
		return iTEMMSKCD;
	}

	/**
	 * @param iTEMMSKCD
	 *            the iTEMMSKCD to set
	 */
	public void setiTEMMSKCD(String iTEMMSKCD) {
		this.iTEMMSKCD = iTEMMSKCD;
	}

	/**
	 * @return the iTEMMTNTO
	 */
	public String getiTEMMTNTO() {
		return iTEMMTNTO;
	}

	/**
	 * @param iTEMMTNTO
	 *            the iTEMMTNTO to set
	 */
	public void setiTEMMTNTO(String iTEMMTNTO) {
		this.iTEMMTNTO = iTEMMTNTO;
	}

	/**
	 * @return the eMPFLEMPNM
	 */
	public String geteMPFLEMPNM() {
		return eMPFLEMPNM;
	}

	/**
	 * @param eMPFLEMPNM
	 *            the eMPFLEMPNM to set
	 */
	public void seteMPFLEMPNM(String eMPFLEMPNM) {
		this.eMPFLEMPNM = eMPFLEMPNM;
	}

	/**
	 * @return the dCCFLNAME
	 */
	public String getdCCFLNAME() {
		return dCCFLNAME;
	}

	/**
	 * @param dCCFLNAME
	 *            the dCCFLNAME to set
	 */
	public void setdCCFLNAME(String dCCFLNAME) {
		this.dCCFLNAME = dCCFLNAME;
	}

	/**
	 * @return the iTEMMHNME
	 */
	public String getiTEMMHNME() {
		return iTEMMHNME;
	}

	/**
	 * @param iTEMMHNME
	 *            the iTEMMHNME to set
	 */
	public void setiTEMMHNME(String iTEMMHNME) {
		this.iTEMMHNME = iTEMMHNME;
	}

	/**
	 * @return the mAKERDATA
	 */
	public String getmAKERDATA() {
		return mAKERDATA;
	}

	/**
	 * @param mAKERDATA
	 *            the mAKERDATA to set
	 */
	public void setmAKERDATA(String mAKERDATA) {
		this.mAKERDATA = mAKERDATA;
	}

	/**
	 * @return the iTEMMMKCD
	 */
	public String getiTEMMMKCD() {
		return iTEMMMKCD;
	}

	/**
	 * @param iTEMMMKCD
	 *            the iTEMMMKCD to set
	 */
	public void setiTEMMMKCD(String iTEMMMKCD) {
		this.iTEMMMKCD = iTEMMMKCD;
	}

	/**
	 * @return the cARNMNAME
	 */
	public String getcARNMNAME() {
		return cARNMNAME;
	}

	/**
	 * @param cARNMNAME
	 *            the cARNMNAME to set
	 */
	public void setcARNMNAME(String cARNMNAME) {
		this.cARNMNAME = cARNMNAME;
	}

	/**
	 * @return the iTEMMSYCD
	 */
	public String getiTEMMSYCD() {
		return iTEMMSYCD;
	}

	/**
	 * @param iTEMMSYCD
	 *            the iTEMMSYCD to set
	 */
	public void setiTEMMSYCD(String iTEMMSYCD) {
		this.iTEMMSYCD = iTEMMSYCD;
	}

	/**
	 * @return the iTEMMTNKMK
	 */
	public String getiTEMMTNKMK() {
		return iTEMMTNKMK;
	}

	/**
	 * @param iTEMMTNKMK
	 *            the iTEMMTNKMK to set
	 */
	public void setiTEMMTNKMK(String iTEMMTNKMK) {
		this.iTEMMTNKMK = iTEMMTNKMK;
	}

	/**
	 * @return the iTEMMPART
	 */
	public int getiTEMMPART() {
		return iTEMMPART;
	}

	/**
	 * @param iTEMMPART
	 *            the iTEMMPART to set
	 */
	public void setiTEMMPART(int iTEMMPART) {
		this.iTEMMPART = iTEMMPART;
	}

	/**
	 * @return the listStok
	 */
	public ArrayList<Stok> getListStok() {
		return listStok;
	}

	/**
	 * @param listStok
	 *            the listStok to set
	 */
	public void setListStok(ArrayList<Stok> listStok) {
		this.listStok = listStok;
	}

	/**
	 * @return the pagenum
	 */
	public int getPagenum() {
		return pagenum;
	}

	/**
	 * @param pagenum
	 *            the pagenum to set
	 */
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
