$('#signInBtn').on('click', function() {
    let role = 'USER';
    let username = $('#username').val();
    let password = $('#password').val();

    const registerDto = {
        userName: username,
        password: password,
        role: role
    }

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/auth/register',
        data: JSON.stringify(registerDto),
        contentType: 'application/json',
        success: function(response) {
            console.log('Registration successful:', response);
            alert('Registration successful! Please log in.');
            window.location.href = '../pages/signIn.html';
        }
        , error: function(xhr, status, error) {
            console.error('Registration failed:', error);
            alert('Registration failed: ' + xhr.responseText);
        }
    })

})

