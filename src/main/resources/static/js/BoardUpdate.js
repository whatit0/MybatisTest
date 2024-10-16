$(document).ready(function () {

    $('#backList').on('click', function () {
        location.href = '/board/list';
    })

    $('#updateButton').click(function () {
        const boardNo = $('#boardNo').val();
        window.location.href = `/board/update/${boardNo}`;
    })

    $('#updateBoard').on('submit', function (event) {
        event.preventDefault();

        var data = {
            boardNo: $('#boardNo').val(),
            boardTitle: $('#boardTitle').val(),
            boardContent: $('#boardContent').val()
        };

        $.ajax({
            url: '/board/update',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                alert('게시글 수정 되었습니다.');
                window.location.href = '/board/detail/' + response.boardNo;
            }
        })
    })
})