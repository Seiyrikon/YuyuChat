/**
 * 
 */

function showMessage() {
	alert("wow");
}

function onSignUp() {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200) {
                // Handle the response here
                // You can use responseText to access the content returned by the server
                document.body.innerHTML = this.responseText;
            } else {
                // Handle error or other status codes
                console.error("Error: " + this.status);
            }
        }
    };

    xhttp.open("GET", "pages/signup-page/SignupPage.jsp", true);
    xhttp.send();
}

function onLogin() {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200) {
                // Handle the response here
                // You can use responseText to access the content returned by the server
                document.body.innerHTML = this.responseText;
            } else {
                // Handle error or other status codes
                console.error("Error: " + this.status);
            }
        }
    };

    xhttp.open("GET", "pages/login-page/LoginPage.jsp", true);
    xhttp.send();
}

function onAboutUs() {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200) {
                // Handle the response here
                // You can use responseText to access the content returned by the server
                document.body.innerHTML = this.responseText;
            } else {
                // Handle error or other status codes
                console.error("Error: " + this.status);
            }
        }
    };

    xhttp.open("GET", "pages/aboutus-page/AboutusPage.jsp", true);
    xhttp.send();
}

function onFeatures() {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200) {
                // Handle the response here
                // You can use responseText to access the content returned by the server
                document.body.innerHTML = this.responseText;
            } else {
                // Handle error or other status codes
                console.error("Error: " + this.status);
            }
        }
    };

    xhttp.open("GET", "pages/features-page/FeaturesPage.jsp", true);
    xhttp.send();
}


function onHome() {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            if (this.status == 200) {
                // Handle the response here
                // You can use responseText to access the content returned by the server
                document.body.innerHTML = this.responseText;
            } else {
                // Handle error or other status codes
                console.error("Error: " + this.status);
            }
        }
    };

    xhttp.open("GET", "pages/landing-page/LandingPage.jsp", true);
    xhttp.send();
}
