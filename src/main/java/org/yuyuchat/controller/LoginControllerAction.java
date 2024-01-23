package org.yuyuchat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.yuyuchat.model.LoginModel;
import org.yuyuchat.model.UserModel;
import org.yuyuchat.model.tbl_chatsModel;
import org.yuyuchat.model.tbl_userModel;

public class LoginControllerAction extends Action{
	
	LoginModel loginService = new LoginModel();
	tbl_userModel userDao = new tbl_userModel();

	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
       
		LoginModel body = (LoginModel) form;
		

        if (loginService.login(body, request)) {
        	
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }

}
