/**
 * 
 */

function passwordsMatch() {
    var password1 = document.getElementById("password").value;
    var password2 = document.getElementById("rePassword").value;
    var mobile = document.getElementById("mobileNo").value;
    console.log(password1);
    console.log(password2);
    let re = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9!#@$%&?]{8,20}$/;

    if (mobile.length != 10) {
        alert("invalid mobile number");
        return false;
    }
    else if (password1.length < 8) {
        alert("password too short");
        return false;
    }
    else if (!re.test(password1)) {
        alert("password too weak ");
        return false;
    }
    else if (password1 != password2) {
        alert("passwords do not match");
        return false;
    }
    else { 
        return true; 
    }

}