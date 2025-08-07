$('#logIn-btn').on('click', function (index) {
    let username = $('#username').val();
    let password = $('#password').val();

    const authDto = {
        username: username,
        password: password,
    }

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/auth/login',
        data: JSON.stringify(authDto),
        contentType: 'application/json',
        success: function(response) {
            console.log('LogIn successful:', response);
            alert('Registration successful! Please log in.');
            let token = response.data.accessToken;
            localStorage.setItem('token', token);
            window.location.href = '../pages/dashboard.html';
        }
        , error: function(xhr, status, error) {
            console.error('Registration failed:', error);
            alert('Registration failed: ' + xhr.responseText);
        }
    })

})

