<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Chat Interface</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #000;
            color: #fff;
            margin: 0;
            padding: 20px;
        }

        .chat-container {
            max-width: 600px;
            margin: auto;
            background-color: #111;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        .chat-header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
            font-size: 18px;
        }

        .chat-messages {
            padding: 10px;
            overflow-y: scroll;
            max-height: 300px;
        }

        .message {
            margin-bottom: 10px;
        }

        .message .user {
            font-weight: bold;
            color: #3498db;
        }

        .message .content {
            margin-left: 10px;
        }

        .chat-input {
            display: flex;
            margin-top: 10px;
        }

        .input-field {
            flex: 1;
            padding: 8px;
            border: none;
            border-radius: 4px;
            margin-right: 5px;
        }

        .send-button {
           background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        
        .send-button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8">
                <div class="chat-container">
                    <div class="chat-header">
                        Chat Interface
                    </div>
                    <div class="chat-messages" id="chatMessages">
                        <!-- Messages will be displayed here -->
                    </div>
                    <div class="chat-input">
                        <input type="text" class="input-field" id="messageInput" placeholder="Type your message...">
                        <button class="send-button" onclick="sendMessage()">Send</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        function sendMessage() {
            var messageInput = document.getElementById("messageInput");
            var chatMessages = document.getElementById("chatMessages");

            var message = messageInput.value.trim();
            if (message !== "") {
                var newMessage = document.createElement("div");
                newMessage.className = "message";
                newMessage.innerHTML = '<span class="user">You:</span><span class="content">' + message + '</span>';
                chatMessages.appendChild(newMessage);

                // Clear the input field after sending the message
                messageInput.value = "";

                // Scroll to the bottom to show the latest message
                chatMessages.scrollTop = chatMessages.scrollHeight;
            }
        }
    </script>
</body>
</html>
