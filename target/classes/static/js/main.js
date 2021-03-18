$(document).ready(function () {
    $('.eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #id').val(user.id)
            $('.myForm #username').val(user.username)
            $('.myForm #password').val(user.password)
            $('.myForm #roles').val(user.roles)

        });
        $('.myForm #exampleModal').modal();
    });
});