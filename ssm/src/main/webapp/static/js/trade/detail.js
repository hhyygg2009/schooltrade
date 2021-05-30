layui.use(['laypage', 'layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form
        , laypage = layui.laypage

    loadComment()

    function loadComment() {
        $("#messagebroad").empty()
        getCommentByItemId(itemId)

    }

    $(document).on("click", "a.reply-btn", function () {
        let commentId = $(this).parents(".comment-line-box")[0].dataset.commentId

        var data = []
        data["commentId"] = commentId
        $(".reply-box").remove()
        $(this).after(getReplyBox(data))

        return false
    })

    $(document).on("click", "a.delete-btn", function () {
        // console.log(event)
        // console.log($(this))
        // console.log($(this).parents(".comment-line-box"))
        let commentId = $(this).parents(".comment-line-box")[0].dataset.commentId
        // console.log(commentId)
        $.post(`${api}/comment/del/${commentId}`, function (res) {
            layer.msg(res.msg)
            loadComment()
        })

        return false
    })

    form.on("submit(message)", function (formData) {
        // console.log(formData)
        var data = formData.field
        data["topicId"] = itemId

        if (data.content) {
            $.post(`${api}/comment/create`, data, function (res) {
                layer.msg(res.msg)
                loadComment()
            }, "json")
        } else {
            layer.msg("内容不可以为空")
        }

        return false
    })

    form.on("submit(replybox)", function (formData) {
        // console.log(formData)
        var dataset = $(formData.form).parents(".comment-line-box")[0].dataset
        var data = formData.field
        data["commentId"] = dataset.commentId
        data["replyId"] = dataset.replyId

        // console.log(formData.form.dataset)
        // console.log(data)
        // console.log($(formData.form).parents(".comment-line-box")[0].dataset.commentId)

        if (data.content) {
            $.post(`${api}/reply/create`, data, function (res) {
                layer.msg(res.msg)
                loadComment()
            }, "json")
        } else {
            layer.msg("内容不可以为空")
        }

        return false
    })


    function getCommentByItemId(itemId) {
        $.ajax({
            type: 'POST',
            url: `${api}/comment/get/${itemId}`,
            dataType: 'json',
            async: true,
            success: function (res) {
                // console.log(res);
                $.each(res.data.comments, function (index, val) {
                    // console.log(val);
                    let data = val
                    data.commentid = val.id
                    data.replyid = null
                    $("#messagebroad").append(getCommentMessage(data));
                    getReply(val.id)
                })
                if (res.code !== 0) {
                    layer.msg(res.msg);
                }

            }
        })
    }

    function getReply(CommentId) {
        $.ajax({
            type: "POST",
            url: `http://localhost:8080/api/reply/get/${CommentId}`,
            dataType: 'json',
            async: true,
            success: function (res) {
                // console.log(res)
                $.each(res.data.replyList, function (index, val) {
                    let data = val
                    data.commentid = CommentId
                    data.replyid = val.id
                    $(`.comment-line-box[data-comment-id='${CommentId}'] .replybroad`).append(getCommentMessage(data))
                    // console.log(`.comment-line-box[data-comment-id='${CommentId}'] .replybroad`)
                })
            }
        })
    }

    function getCommentMessage(data) {
        var commentData = `data-comment-id="${data.commentid}"`
        var replybroad = ""
        if (data.replyid) {
            commentData += ` data-reply-id="${data.replyid}"`
        } else {
            replybroad = "<div class=\"replybroad\"></div>"
        }

        return `
<div class="comment-line-box" ${commentData}>
    <div>
        <img class="avatar" src="/uploads/${data.user.avatar}" alt=""><span>${data.user.username}</span>
        <p>${data.content}</p>                        
        <a href="#" class="reply-btn">回复</a> <a href="#" class="delete-btn">删除</a> <a href="">举报</a>
    </div>
    ${replybroad}
</div>           
        `
    }


//     function getCommentMessage(data) {
//         return `
// <div class="comment-line-box" data-comment-id="${data.id}">
//     <div>
//         <img class="avatar" src="/uploads/${data.user.avatar}" alt=""><span>${data.user.username}</span>
//         <p>${data.content}</p>
//         <a href="#" class="reply-btn">回复</a> <a href="#" class="delete-btn">删除</a> <a href="">举报</a>
//     </div>
//     <div class="replybroad"></div>
// </div>
// `
//     }

    function getReplyBox(data) {
        return `
                <form class="layui-form reply-box">
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <textarea class="layui-textarea" name="content" lay-verify="required"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-filter="replybox" lay-submit>提交</button>
                        </div>
                    </div>
                </form>        
        `
    }


})

layui.use('carousel', function () {
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#carousel'
        , width: '100%' //设置容器宽度
        , arrow: 'always' //始终显示箭头
        //,anim: 'updown' //切换动画方式
    });
});