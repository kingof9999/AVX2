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

import common.CheckData;
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
 * Modification Logs: DATE AUTHOR DECRIPTION
 * ------------------------------------------- 22/05/2017 TinLQ Create
 */
public class GetInfoStokAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// call form StokForm to use
		StokForm stokForm = (StokForm) form;
		// call session class to use
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
			// check iTEMMSTOK if null
			if (iTEMMSTOK == null) {
				iTEMMSTOK = "";
			}
			// try catch to catch error while trim
			try {
				// check null and "" to trim
				if (iTEMMSTOK != null && !"".equals(iTEMMSTOK)) {
					// trim space iTEMSTOK
					iTEMMSTOK = CheckData.chuanHoa(iTEMMSTOK);
				}
			} catch (Exception e) {
				// add message error
				actionErrors.add("reloadPageError", new ActionMessage("error.update.reloadPageError"));
				saveErrors(request, actionErrors);
				// return to updateJ1JR.jsp
				return mapping.findForward("loi");
			}
			// set session iTEMMSTOK
			session.setAttribute("iTEMMSTOK", iTEMMSTOK);
			// call pagenum from stokForm
			int pagenum = stokForm.getPagenum();
			// try catch to get message from throw Exception
			try {
				if ("".equals(iTEMMSTOK)) {
					listStok = stokBO.getInfoStok(pagenum);
				} else {
					// get information of stok
					listStok = stokBO.getInfoStok(iTEMMSTOK, pagenum);
				}
				// set listStok to form
				stokForm.setListStok(listStok);
				// get iTEMMSTOK in session and set it to iTEMMSTOK
				iTEMMSTOK = (String) session.getAttribute("iTEMMSTOK");
			} catch (Exception e) {
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
			// check size of listStok is 0 or not
			if (listStok.size() == 0) {
				// add message error
				actionErrors.add("nullStokError", new ActionMessage("error.getStok.nullValue"));
				saveErrors(request, actionErrors);
			}
			String mYITEMMSTOK = null;
			try {
				mYITEMMSTOK = stokForm.getListStok().get(0).getiTEMMSTOK();
			} catch (Exception e) {
				return mapping.findForward("search");
			}
			// try catch to get message from throw Exception
			try {
				// check iTEMMMKCD
				stok = stokBO.checkITEMMMKCD(mYITEMMSTOK);
				// set element mAKERDATA from Stok Bean to form
				stokForm.setmAKERDATA(stok.getmAKERDATA());
			} catch (Exception e) {
				return mapping.findForward("loi");
			}
			// try catch to get message from throw Exception
			try {
				// check iTEMMSYCD
				stok = stokBO.checkITEMMSYCD(mYITEMMSTOK);
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
