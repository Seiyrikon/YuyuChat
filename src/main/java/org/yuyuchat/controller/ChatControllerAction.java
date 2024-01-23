package org.yuyuchat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.yuyuchat.model.UserModel;
import org.yuyuchat.model.tbl_chatsModel;
import org.yuyuchat.model.tbl_userModel;

public class ChatControllerAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        tbl_userModel userDao = new tbl_userModel();   
        List<UserModel> users = userDao.getAllUserModel(request);
        
        HttpSession session = request.getSession();
		
		Long principal_id = Long.parseLong(session.getAttribute("userId").toString());
		
		UserModel principal = userDao.getUserModelByUserId(principal_id);
        
        request.setAttribute("users", users);
        request.setAttribute("principal", principal);

        return mapping.findForward("success");
    }
}
