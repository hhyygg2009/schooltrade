//upload的启用
layui.use('upload', function () {
    var $ = layui.jquery,
        upload = layui.upload;

    //多图片上传
    var uploadInst = upload.render({
        elem: '#test2',
        url: `${api}/image/upload`, //改成您自己的上传接口
        field: 'image',
        multiple: true,
        before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#headperview').prop("src", result)
            });
        },
        done: function (res) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功
            // console.log(res);
            // console.log(res.data);

            let pic = res.data.picaddr;
            var user = {
                // id:${user.id},
                avatar: pic
            }
            insert(JSON.stringify(user))


        }
        , error: function () {
            //演示失败状态，并实现重传
            layui.use('layer', function () {
                layui.layer.msg(data.msg);
            })

        },
    });
})


layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;

    form.on('submit(*)', function (data) {
        // console.log(data);
        // console.log(JSON.stringify(data.field));
        insert(JSON.stringify(data.field));
        return false;

    })

    function insert(data) {
        $.ajax({
            type: 'POST',
            url: `${api}/users/update`,
            dataType: 'json',
            async: true,
            data: {"user": data},
            success: function (res) {
                // console.log(res);
                if (res.code === 0) {
                    window.location.href = "myprofile";
                } else {
                    layer.msg(res.msg);
                }
            }

        })
    }
});