package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Stok;

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
	
	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public ArrayList<Stok> getListStok() {
		return listStok;
	}

	public void setListStok(ArrayList<Stok> listStok) {
		this.listStok = listStok;
	}

	public String getiTEMMSTOK() {
		return iTEMMSTOK;
	}

	public void setiTEMMSTOK(String iTEMMSTOK) {
		this.iTEMMSTOK = iTEMMSTOK;
	}

	public String getiTEMMSKCD() {
		return iTEMMSKCD;
	}

	public void setiTEMMSKCD(String iTEMMSKCD) {
		this.iTEMMSKCD = iTEMMSKCD;
	}

	public String getiTEMMTNTO() {
		return iTEMMTNTO;
	}

	public void setiTEMMTNTO(String iTEMMTNTO) {
		this.iTEMMTNTO = iTEMMTNTO;
	}

	public String geteMPFLEMPNM() {
		return eMPFLEMPNM;
	}

	public void seteMPFLEMPNM(String eMPFLEMPNM) {
		this.eMPFLEMPNM = eMPFLEMPNM;
	}

	public String getdCCFLNAME() {
		return dCCFLNAME;
	}

	public void setdCCFLNAME(String dCCFLNAME) {
		this.dCCFLNAME = dCCFLNAME;
	}

	public String getiTEMMHNME() {
		return iTEMMHNME;
	}

	public void setiTEMMHNME(String iTEMMHNME) {
		this.iTEMMHNME = iTEMMHNME;
	}

	public String getmAKERDATA() {
		return mAKERDATA;
	}

	public void setmAKERDATA(String mAKERDATA) {
		this.mAKERDATA = mAKERDATA;
	}

	public String getiTEMMMKCD() {
		return iTEMMMKCD;
	}

	public void setiTEMMMKCD(String iTEMMMKCD) {
		this.iTEMMMKCD = iTEMMMKCD;
	}

	public String getcARNMNAME() {
		return cARNMNAME;
	}

	public void setcARNMNAME(String cARNMNAME) {
		this.cARNMNAME = cARNMNAME;
	}

	public String getiTEMMSYCD() {
		return iTEMMSYCD;
	}

	public void setiTEMMSYCD(String iTEMMSYCD) {
		this.iTEMMSYCD = iTEMMSYCD;
	}

	public String getiTEMMTNKMK() {
		return iTEMMTNKMK;
	}

	public void setiTEMMTNKMK(String iTEMMTNKMK) {
		this.iTEMMTNKMK = iTEMMTNKMK;
	}

	public int getiTEMMPART() {
		return iTEMMPART;
	}

	public void setiTEMMPART(int iTEMMPART) {
		this.iTEMMPART = iTEMMPART;
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
