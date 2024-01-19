<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    /* Add your own styles for the chat window, message input, etc. */
  </style>
</head>
<body>
	<div id="chat-container" class="container-fluid">
    <div id="sidebar" class="bg-dark text-light">
      <div class="section-heading mt-3"><a href="#" onclick="onChat()">Chats</a></div>

      <div class="section-heading mt-3"><a href="#" onclick="onFriends()">Friends</a></div>

      <div class="section-heading mt-3"><a href="#" onclick="onRequests()">Requests</a></div>

      <div class="section-heading mt-3"><a href="#" onclick="onConfirmRequests()">Confirm Requests</a></div>
    </div>

    <div id="content-container" class="p-4">
      <!-- Add your chat window, message input, etc. -->
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
	    loadContent("/YuyuChat/pages/dashboard/chat-page/ChatPage.jsp");
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

  </script>
</body>
</html>