$(document).ready(function () {
    $('.eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #id').val(user.id)
            $('.myForm #name').val(user.username)
            $('.myForm #lastName').val(user.password)
            $('.myForm #age').val(user.role)

        });
        $('.myForm #exampleModal').modal();
    });
});