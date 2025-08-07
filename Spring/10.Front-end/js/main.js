let currentPage = 0;
const pageSize = 10;

function loadJobs(page) {
    $.ajax({
        type: 'GET',
        url: `http://localhost:8080/api/v1/job/getPage?page=${page}&size=${pageSize}`,
        contentType: 'application/json',
        success: function(response) {
            $('#jobsTableBody').empty(); // clear existing rows

            response.forEach(job => {
                const row = `
                    <tr>
                        <td>${job.id}</td>
                        <td>${job.job_title}</td>
                        <td>${job.company}</td>
                        <td>${job.location}</td>
                        <td>${job.type}</td>
                        <td><button class="deactivate-btn" data-id="${job.id}">Deactivate</button></td>
                        <td><button class="delete-btn" data-id="${job.id}">Delete</button></td>
                    </tr>
                `;
                $('#jobsTableBody').append(row);
            });

            $('#currentPage').text(`Page: ${currentPage + 1}`);
        },
        error: function(error) {    
            console.error('Error loading jobs:', error);
        }
    });
}

$(document).ready(function() {
    loadJobs(currentPage);

    $('#prevPage').click(function() {
        if (currentPage > 0) {
            currentPage--;
            loadJobs(currentPage);
        }
    });

    $('#nextPage').click(function() {
        currentPage++;
        loadJobs(currentPage);
    });
});



$('#saveJobBtn').on('click', function() {
    let jobTitle = $('#jobTitle').val();
    let company = $('#companyName').val();
    let location = $('#jobLocation').val();
    let type = $('#jobType').val();
    let jobDescription = $('#job-desc').val();

    const job = {
        jobTitle: jobTitle,
        company: company,
        location: location,
        type: type,
        jobDescription: jobDescription,
        status:'Active'
    }

    console.log(job.jobDescription)

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/v1/job/create',
        data: JSON.stringify(job),
        contentType: 'application/json', // tell the server it's JSON
        success: function(response) {
            clearForm();
            console.log('Job saved successfully:', response);
            // Optionally, redirect or update the UI
        },
        error: function(error) {
            console.error('Error saving job:', error);
            // Optionally, show an error message to the user
        }
    });
})

$(document).ready(function() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/v1/job/getPage?page=0&size=10',
        contentType: 'application/json',
        success: function(response) {
            console.log('Job get successfully:', response);

            response.forEach(response => {
                const row = `{
                 <tr>
                        <td>${response.id}</td>
                        <td>${response.job_title}</td>
                        <td>${response.company}</td>
                        <td>${response.location}</td>
                        <td>${response.type}</td>
                        <td><button class="deactivate-btn" id="deactive-btn" data-id="${response.id}">Deactivate</button></td>
                        <td><button class="delete-btn" data-id="${response.id}">Delete</button></td>
                    </tr>
            }`

                $('#jobsTableBody').append(row);
            });

        },
        error: function(error) {
            console.error('Error saving job:', error);

        }
    });
})

// $(document).ready(function () {
//     const pageSize = 10;
//     let currentPage = 1;
//     let allJobs = [];
//
//     // Fetch all jobs
//     $.ajax({
//         type: 'GET',
//         url: 'http://localhost:8080/api/v1/job/get',
//         contentType: 'application/json',
//         success: function (response) {
//             console.log('Job get successfully:', response);
//             allJobs = response;
//             displayPage(currentPage);
//             renderPagination();
//         },
//         error: function (error) {
//             console.error('Error getting job:', error);
//         }
//     });
//
//     // Display a single page
//     function displayPage(page) {
//         $('#jobsTableBody').empty();
//         let start = (page - 1) * pageSize;
//         let end = start + pageSize;
//         let pageItems = allJobs.slice(start, end);
//
//         pageItems.forEach(job => {
//             const row = `
//                 <tr>
//                     <td>${job.id}</td>
//                     <td>${job.jobTitle}</td>
//                     <td>${job.company}</td>
//                     <td>${job.location}</td>
//                     <td>${job.type}</td>
//                     <td><button class="deactivate-btn" data-id="${job.id}">Deactivate</button></td>
//                     <td><button class="delete-btn" data-id="${job.id}">Delete</button></td>
//                 </tr>
//             `;
//             $('#jobsTableBody').append(row);
//         });
//     }
//
//     // Render pagination buttons
//     function renderPagination() {
//         let totalPages = Math.ceil(allJobs.length / pageSize);
//         let paginationHTML = '';
//
//         for (let i = 1; i <= totalPages; i++) {
//             paginationHTML += `<button class="pagination-btn btn btn-sm btn-primary m-1" data-page="${i}">${i}</button>`;
//         }
//
//         $('#paginationControls').html(paginationHTML);
//     }
//
//     // Handle page click
//     $(document).on('click', '.pagination-btn', function () {
//         currentPage = parseInt($(this).data('page'));
//         displayPage(currentPage);
//     });
// });


$('#jobsTableBody').on('click', 'tr', function(event) {

    if ($(event.target).closest('button').length > 0) {
        return;
    }

    let job = {
        id: $(this).find('td:eq(0)').text(),
        title: $(this).find('td:eq(1)').text(),
        company: $(this).find('td:eq(2)').text(),
        location: $(this).find('td:eq(3)').text(),
        type: $(this).find('td:eq(4)').text()
    };

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/v1/job/getDesc/' + job.id,
        contentType: 'application/json',
        success: function(response) {
            console.log('Job get successfully:', response);

            $('#editJobId').val(job.id);
            $('#editJobTitle').val(job.title);
            $('#editCompanyName').val(job.company);
            $('#editJobLocation').val(job.location);
            $('#editJobType').val(job.type);
            $('#editJobDescription').val(response);

            $('#editJobModal').modal('show');

        },
        error: function(error) {
            console.error('Error saving job:', error);
        }
    });
})

$('#updateJobBtn').on('click', function() {
    let id = $('#editJobId').val();
    let jobTitle = $('#editJobTitle').val();
    let company = $('#editCompanyName').val();
    let location = $('#editJobLocation').val();
    let type = $('#editJobType').val();
    let jobDescription = $('#editJobDescription').val();

    const job = {
        id: id,
        jobTitle: jobTitle,
        company: company,
        location: location,
        type: type,
        jobDescription: jobDescription,
        status:'Active'
    }

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/api/v1/job/update',
        data: JSON.stringify(job),
        contentType: 'application/json', // tell the server it's JSON
        success: function(response) {
            clearForm();
            console.log('Job saved successfully:', response);
            // Optionally, redirect or update the UI
        },
        error: function(error) {
            console.error('Error saving job:', error);
            // Optionally, show an error message to the user
        }
    });
})


$('#jobsTableBody').on('click', '.deactivate-btn', function(event) {
    event.stopPropagation(); // prevent row click modal open

    console.log('deactive button clicked');

    let id = $(this).data('id');
    let status = 'Deactivate';

    $.ajax({
        type: 'PATCH',
        url: 'http://localhost:8080/api/v1/job/status/' + id,
        data: status,
        contentType: 'text/plain',
        success: function(response) {
            clearForm();
            console.log('Job patched successfully:', response);
            // Optionally, update UI or reload list
        },
        error: function(error) {
            console.error('Error saving job:', error);
        }
    });
});


$('#searchInput').on('input', function() {

    let input = $('#searchInput').val();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/v1/job/search/'+input,
        contentType: 'application/json',
        success: function(response) {
            console.log('Job search successfully:', response);

            $('#searchResults').empty();

            if (response.length === 0) {
                $('#searchResults').hide();
                return;
            }

            response.forEach(response    => {
                $('#searchResults').append(`
                    <a href="#" class="list-group-item list-group-item-action">
                        ${response.jobTitle} (${response.status})
                    </a>
                `);
            });

            $('#searchResults').show();

        },
        error: function(error) {
            console.error('Error search job:', error);
        }
    })
})

$('#jobsTableBody').on('click', '.delete-btn', function(event) {
    event.stopPropagation(); // prevent row click modal open

    console.log('delete button clicked');

    let id = $(this).data('id');

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/api/v1/job/delete/' + id,
        success: function(response) {
            console.log('Job delete successfully:', response);
            // Optionally, update UI or reload list
        },
        error: function(error) {
            console.error('Error delete job:', error);
        }
    });
});


function clearForm(){
     $('#jobTitle').val("job_title");
     $('#companyName').val("company");
     $('#jobLocation').val("location");
     $('#jobType').val("");
     $('#job-desc').val("job_description");
}