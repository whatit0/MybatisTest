$(document).ready(function () {
    $('#boardForm').on('submit', function(event) {
        event.preventDefault();

        let boardTitle = $('#boardTitle').val().trim();
        let boardContent = $('#boardContent').val().trim();

        if (!boardTitle || !boardContent) {
            alert('글자를 입력해주세요!');
            return;
        }

        let data = {
            boardTitle : boardTitle,
            boardContent: boardContent
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