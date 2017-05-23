package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.CheckDbConnection;
import form.StokForm;
import model.bean.Stok;
import model.bo.StokBO;

/**
 * GetInfoStokAction
 * 
 * Version 1.0
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
public class GetInfoStokAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// call form StokForm to use
		StokForm stokForm = (StokForm) form;
		//call session class to use
		HttpSession session = request.getSession();
		// call class AcyionErrors to use
		ActionErrors actionErrors = new ActionErrors();
		// check database connection
		if (!CheckDbConnection.checkConnect()) {
			// add message error
			actionErrors.add("dbError", new ActionMessage("error.db.connectDatabase"));
			saveErrors(request, actionErrors);
			// return to error page
			return mapping.findForward("loi");
		} else {
			// call class StokBO to use
			StokBO stokBO = new StokBO();
			// call class Stok to use
			ArrayList<Stok> listStok = null;
			Stok stok;
			// call iTEMMSTOK from stokForm
			String iTEMMSTOK = stokForm.getiTEMMSTOK();
			session.setAttribute("iTEMMSTOK", iTEMMSTOK);
			//call pagenum from stokForm
			int pagenum = stokForm.getPagenum();
			// try catch to get message from throw Exception
			try {
				if ("".equals(iTEMMSTOK)) {
					listStok = stokBO.getInfoStok(pagenum);
				} else {
					System.out.println("pass");
					// get information of stok
					listStok = stokBO.getInfoStok(iTEMMSTOK,pagenum);
				}
				//set listStok to form
				stokForm.setListStok(listStok);
				//get iTEMMSTOK in session and set it to iTEMMSTOK
				iTEMMSTOK = (String) session.getAttribute("iTEMMSTOK");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				if (e.getMessage() == null) {
					// add message error
					actionErrors.add("nullStokError", new ActionMessage("error.getStok.nullValue"));
					saveErrors(request, actionErrors);
					// return updateJ1JR.jsp
					return mapping.findForward("upDate");
				} else {
					// return updateJ1JR.jsp
					return mapping.findForward("search");
				}
			}
			// try catch to get message from throw Exception
			try {
				// check iTEMMMKCD
				stok = stokBO.checkITEMMMKCD(iTEMMSTOK);
				// set element mAKERDATA from Stok Bean to form
				stokForm.setmAKERDATA(stok.getmAKERDATA());
			} catch (Exception e) {
				return mapping.findForward("loi");
			}
			// try catch to get message from throw Exception
			try {
				// check iTEMMSYCD
				stok = stokBO.checkITEMMSYCD(iTEMMSTOK);
				// set element cARNMNAME from Stok Bean to form
				stokForm.setcARNMNAME(stok.getcARNMNAME());
			} catch (Exception e) {
				return mapping.findForward("loi");
			}
			// return to update jsp
			return mapping.findForward("thanhCong");
		}
	}
}
