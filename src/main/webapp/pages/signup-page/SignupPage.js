/**
 * 
 */

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

// Call the function when the document is ready
document.addEventListener('DOMContentLoaded', loadContent("pages/login-page/LoginPage.jsp"));