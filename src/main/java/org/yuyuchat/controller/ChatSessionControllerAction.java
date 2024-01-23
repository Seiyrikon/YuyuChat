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

public class ChatSessionControllerAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("ChatSessionControllerAction executed");

        tbl_userModel userDao = new tbl_userModel();
        tbl_chatsModel chatDao = new tbl_chatsModel();

        HttpSession session = request.getSession();

        Long principal_id = Long.parseLong(session.getAttribute("userId").toString());

        String friendId = request.getParameter("userId");
        Long friend_id = null;

        if (friendId != null && !friendId.isEmpty()) {
            friend_id = Long.parseLong(friendId);
        }

        List<tbl_chatsModel> chats = null;
        UserModel friend = null;

        if (friend_id != null) {
            chats = chatDao.getAllChatsOfUserWithFriend(principal_id, friend_id);
            friend = userDao.getUserModelByUserId(friend_id);
        }

        request.setAttribute("friend", friend);
        request.setAttribute("chats", chats);

        return mapping.findForward("success");
    }
}
