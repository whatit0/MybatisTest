$(document).ready(function () {
    $('#boardForm').on('submit', function(event) {
        event.preventDefault();

        var data = {
            boardTitle : $('#boardTitle').val(),
            boardContent: $('#boardContent').val()
        }

        $.ajax({
            url: '/board/write',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response){
                alert('게시글이 작성되었습니다.')
                window.location.href = "/board/list";
            }
        })
    })
})