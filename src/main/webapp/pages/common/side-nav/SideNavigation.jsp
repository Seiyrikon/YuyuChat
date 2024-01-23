<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
      margin: 0;
      font-family: 'Arial', sans-serif;
      background-color: #121212;
      color: #fff;
    }

    #chat-container {
      display: flex;
      height: 100vh;
    }

    #sidebar {
      width: 250px;
      background-color: #1e1e1e;
      padding: 20px;
    }

    #main-content {
      flex: 1;
      padding: 20px;
      overflow-y: auto;
    }

    .section-heading a {
      color: #fff;
      text-decoration: none;
      font-size: 18px;
      display: block;
      padding: 10px 0;
      transition: background-color 0.3s;
    }

    .section-heading a:hover {
      background-color: #333;
    }

    .chat-list {
      list-style: none;
      padding: 0;
      margin: 0;
    }

    .chat-list-item {
      padding: 10px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .chat-list-item:hover {
      background-color: #333;
    }
    
    .content-container {
    margin: 20px;
    padding: 20px;
    background-color: #333;
    border-radius: 8px;
    width: 100%;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}
    
    .card-container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
        }

        .chat {
        	display: flex;
        	justify-content: space-between;
            background-color: #000;
            color: #fff;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            width: 100%;
            margin: 5px;
            border-radius: 8px;
        }

        .card-title {
            margin: 0;
        }

        .btn-chat {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            margin-top: 10px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .btn-chat:hover {
            background-color: #555;
        }
        
        .info-container {
        	display: flex;
        	flex-direction: column;
        }
        
        .name {
        	display: flex;
        }
        
        .name p{
        	margin: 3px;
        }

    /* Add your own styles for the chat window, message input, etc. */
  </style>
</head>
<body>
<jsp:useBean id="userDao" class="org.yuyuchat.model.tbl_userModel"/>  
<jsp:useBean id="userModel" class="org.yuyuchat.model.UserModel"/>  
	<div id="chat-container" class="container-fluid">
    <div id="sidebar" class="bg-dark text-light">
      <div class="section-heading mt-3"><a href="#" onclick="onChat()">Chats</a></div>

      <div class="section-heading mt-3"><a href="#" onclick="onFriends()">Friends</a></div>

      <div class="section-heading mt-3"><a href="#" onclick="onRequests()">Requests</a></div>

      <div class="section-heading mt-3"><a href="#" onclick="onConfirmRequests()">Confirm Requests</a></div>
      <div class="section-heading mt-3"><a href="#" onclick="onLogout()">Logout</a></div>
    </div>

    <div id="content-container" class="content-container" class="p-4">
      <%-- Display the userId from the session --%>
        <%
            // Get the session
            HttpSession currentSession = request.getSession(false); // false means do not create a new session if it doesn't exist

            // Check if the session exists and if the userId attribute is present
            if (currentSession != null && currentSession.getAttribute("userId") != null) {
                // Display the userId
                Long principal_id = Long.parseLong(currentSession.getAttribute("userId").toString());
                userModel = userDao.getUserModelByUserId(principal_id);
                out.println("<h1>Welcome " + "<strong>" + userModel.getFirst_name() + "</strong>" + "</h1>");
            } else {
                // Display a message if the userId is not in the session
                out.println("<p>User ID not found in the session</p>");
            }
        %>

    </div>
  </div>
  
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <script>
  function loadContent(url) {
	    const xhttp = new XMLHttpRequest();

	    xhttp.onreadystatechange = function() {
	        if (this.readyState == 4) {
	            if (this.status == 200) {
	                // Handle the response here
	                // Use a specific container to load the content
	                document.getElementById('content-container').innerHTML = this.responseText;
	            } else {
	                // Handle error or other status codes
	                console.error("Error: " + this.status);
	            }
	        }
	    };

	    xhttp.open("GET", url, true);
	    xhttp.send();
	}

	function onChat() {
	    loadContent("/YuyuChat/pages/dashboard/chat-page/ChatSuccess.jsp");
	}

	function onFriends() {
		loadContent("/YuyuChat/pages/dashboard/friends-page/FriendsPage.jsp");
	}

	function onRequests() {
		loadContent("/YuyuChat/pages/dashboard/requests-page/RequestsPage.jsp");
	}

	function onConfirmRequests() {
		loadContent("/YuyuChat/pages/dashboard/confirm-requests-page/ConfirmRequestsPage.jsp");
	}
	
	function onLogout() {
		loadContent("/YuyuChat/pages/dashboard/LogoutHandler.jsp");
	}

  </script>
</body>
</html>