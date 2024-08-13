
function convertToXML(data) {
    let xml = '<?xml version="1.0" encoding="UTF-8"?>\n<customer>\n';
    xml+= `  <id>${data.get("username")}</login_id>\n`;
    xml+= `  <password>${data.get("password")}</password>\n`;
    xml += '</customer>';
    return xml;
}

function convertToRegisterXML(formData) {
    console.log(formData.get("name"));
    let xml = '<?xml version="1.0" encoding="UTF-8"?>\n<customer>\n';
   
    xml+= `  <email>${formData.get("email")}</email>\n`;
    xml+= `  <name>${formData.get("name")}</name>\n`;
    xml+= `  <phone>${formData.get("contactnumber")}</phone>\n`;
    xml+= `  <address>${formData.get("address")}</address>\n`;
    xml+= `  <login_id>${formData.get("login_id")}</login_id>\n`;
    xml+= `  <password>${formData.get("password")}</password>\n`;
    xml+= `  <country>${formData.get("country")}</country>\n`;
    xml+= `  <state>${formData.get("state")}</state>\n`;
    
    xml += '</customer>';
    return xml;
}

document.addEventListener("DOMContentLoaded", function() {

    
   
    
    const messageDiv = document.getElementById("message");

    const registerForm = document.getElementById("registerForm");
    

    registerForm.addEventListener("submit", function(event) {
        event.preventDefault();
        const formData = new FormData(registerForm);

        const xmlData = convertToRegisterXML(formData);
        console.log(formData.get("name"));
  

        console.log(xmlData);


    fetch("http://localhost:8080/Banking_Backend/RegisterController",{
        method : 'POST',
      
        headers: new Headers(
            {'Content-Type': 'text/xml; charset=utf-8'}
        ),
        body: xmlData
    })
    .then(response => response.text())  // Read the response as text
    .then(data => {
        console.log(data);
        if (data.trim() === "Register successful") {
            window.location.href = "http://127.0.0.1:5500/Login.html";
        } else {
            messageDiv.textContent = "Register failed. Please check your credentials.";
            messageDiv.style.color = "red";
        }
    })
    .catch(error => {
        console.error("Error:", error);
        messageDiv.textContent = "An error occurred. Please try again later.";
        messageDiv.style.color = "red";
    });
   
});
});
document.addEventListener("DOMContentLoaded", function() {

    const userForm = document.getElementById("userForm");
    const messageDiv = document.getElementById("message");
    userForm.addEventListener("submit", function(event) {
        event.preventDefault();
        const formData = new FormData(userForm);

        // const xmlData = convertToXML(formData);
        // console.log(formData.get("username"));
        // console.log(formData.get("password"));

        const xmlData = {
            "login_id": formData.get("username"),
            "password": formData.get("password"),
        }
        

        console.log(xmlData);


    fetch("http://localhost:8080/customercrudapi/find",{
        method : 'POST',
        headers: new Headers(
            {'Content-Type': 'application/json'}
        ),
        body: JSON.stringify(xmlData)
    })
    .then(response => response.json())  // Read the response as text
    .then(data => {
        console.log(data);
        if (data.trim() === "Login successful") {
            messageDiv.textContent = "Login successful!";
            messageDiv.style.color = "green";
        } else {
            messageDiv.textContent = "Login failed. Please check your credentials.";
            messageDiv.style.color = "red";
        }
    })
    .catch(error => {
        console.error("Error:", error);

    });
   
});
});
