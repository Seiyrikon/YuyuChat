package org.yuyuchat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.yuyuchat.model.SignUpModel;

public class SignUpControllerAction extends Action {

    SignUpModel signupService = new SignUpModel();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Retrieve form data using the Struts form bean
        SignUpModel body = (SignUpModel) form;

        // Ensure that signUpService is initialized
        if (signupService == null) {
            // Log an error or throw an exception
            System.err.println("ERROR: SignUpService is not initialized.");
            throw new IllegalStateException("SignUpService is not initialized.");
        }

        // Process signup logic
        if (signupService.signup(body)) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }

}

