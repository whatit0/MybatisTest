$(document).ready(function () {
    $('#deleteButton').on('click', function () {
        const boardNo = $('#number').val();

        if(confirm('정말 삭제하시겠습니까?')) {
            $.ajax({
                url: `/board/delete/${boardNo}`,
                type: 'GET',
                success: function (response) {
                    alert('게시글이 삭제되었습니다.');
                    window.location.href = '/board/list';
                },
                error: function () {
                    alert('삭제에 실패했습니다.');
                    console.log(boardNo);
                }
            })
        }
    })
})