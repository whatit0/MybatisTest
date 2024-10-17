$(document).ready(function () {

    $('#backList').click(function () {
        window.location.href = '/board/list';
    })

    $('#updateButton').click(function () {
        const boardNo = $('#number').val();
        window.location.href = `/board/update/${boardNo}`;
    })

    $('#updateBoard').on('submit', function (event) {
        event.preventDefault();

        var boardNo = $('#boardNo').val();
        var boardTitle = $('#boardTitle').val().trim();
        var boardContent = $('#boardContent').val().trim();

        if (!boardTitle || !boardContent) {
            alert('글자를 입력해주세요!');
            return;
        }

        var data = {
            boardNo: boardNo,
            boardTitle: boardTitle,
            boardContent: boardContent
        };

        $.ajax({
            url: '/board/update',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                alert('게시글 수정 되었습니다.');
                window.location.href = '/board/detail/' + response.boardNo;
            },
            error: function () {
                alert('수정 실패하였습니다.');
            }
        })
    })
})