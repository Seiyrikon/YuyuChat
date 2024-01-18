package org.yuyuchat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.yuyuchat.model.LoginModel;
import org.yuyuchat.model.SignUpModel;

public class LoginControllerAction extends Action{
	
	LoginModel loginService = new LoginModel();

	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Retrieve form data using the Struts form bean
		LoginModel body = (LoginModel) form;

        // Ensure that signUpService is initialized
        if (loginService == null) {
            // Log an error or throw an exception
            System.err.println("ERROR: SignUpService is not initialized.");
            throw new IllegalStateException("SignUpService is not initialized.");
        }

        // Process signup logic
        if (loginService.login(body)) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }

}
