// $(document).ready(function() {
//     loadDashboard()
// })
//
// function loadDashboard() {
//     let token = localStorage.getItem('token');
//     const tokenPart2 = token.split('.')[1];
//     const decodedToken = JSON.parse(atob(tokenPart2));
//
//     if (decodedToken.role === 'ADMIN') {
//         $.ajax({
//             type: 'GET',
//             url: 'http://localhost:8080/test/admin',
//             headers: {
//                 'Authorization': 'Bearer ' + token
//             },
//             contentType: 'application/json',
//             success: function(response) {
//                 console.log('Admin dashboard loaded:', response);
//                 $('#nav-bar').html(response);
//
//             }
//             , error: function(xhr, status, error) {
//                 console.error('Registration failed:', error);
//                 alert('Registration failed: ' + xhr.responseText);
//             }
//         })
//
//
//     } else if (decodedToken.role === 'USER') {
//
//         $.ajax({
//             type: 'GET',
//             url: 'http://localhost:8080/test/user',
//             headers: {
//                 'Authorization': 'Bearer ' + token
//             },
//             contentType: 'application/json',
//             success: function(response) {
//                 console.log('User dashboard loaded:', response);
//                 $('#nav-bar').html(response);
//
//             }
//             , error: function(xhr, status, error) {
//                 console.error('Registration failed:', error);
//             }
//         })
//
//     }
// }
//
// $('#logout-btn').click(function() {
//     localStorage.removeItem('token');
//     window.location.href = '../pages/signIn.html';
// })
//
//
//
//
$(document).ready(function() {
    validateAndLoadDashboard();
});

function validateAndLoadDashboard() {
    let token = localStorage.getItem('token');

    if (!token) {
        redirectToLogin();
        return;
    }

    const tokenParts = token.split('.');

    if (tokenParts.length !== 3) {
        redirectToLogin();
        return;
    }

    try {
        const tokenPayload = JSON.parse(atob(tokenParts[1]));

        // Check expiration
        const currentTimestamp = Math.floor(Date.now() / 1000); // current time in seconds
        if (tokenPayload.exp && currentTimestamp >= tokenPayload.exp) {
            alert('Session expired. Please login again.');
            redirectToLogin();
            return;
        }

        loadDashboard(tokenPayload.role, token);

    } catch (error) {
        console.error('Invalid token:', error);
        redirectToLogin();
    }
}

function redirectToLogin() {
    localStorage.removeItem('token');
    window.location.href = '../pages/signIn.html';
}

function loadDashboard(role, token) {
    let url;

    if (role === 'ADMIN') {
        url = 'http://localhost:8080/test/admin';
    } else if (role === 'USER') {
        url = 'http://localhost:8080/test/user';
    } else {
        console.error('Unknown role:', role);
        redirectToLogin();
        return;
    }

    $.ajax({
        type: 'GET',
        url: url,
        headers: {
            'Authorization': 'Bearer ' + token
        },
        contentType: 'application/json',
        success: function(response) {
            console.log(role + ' dashboard loaded:', response);
            $('#nav-bar').html(response);
        },
        error: function(xhr, status, error) {
            console.error('Dashboard loading failed:', error);
            alert('Error loading dashboard: ' + xhr.responseText);
            redirectToLogin(); // optional: handle errors
        }
    });
}

$('#logout-btn').click(function() {
    localStorage.removeItem('token');
    window.location.href = '../pages/signIn.html';
});
