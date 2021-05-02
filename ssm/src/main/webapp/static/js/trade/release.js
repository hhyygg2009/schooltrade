picnum = 1

function addpic(pic) {
    $('#demo2').append(`<img src=" ${upload} / ${pic} " class="layui-upload-img">`)
    $('#pics').append(`<input type="text" name="pic${picnum}" value="${pic}" hidden>`);
    picnum++;
}


//select的渲染
layui.use(['form', 'layedit'], function () {
    var form = layui.form;
    var layedit = layui.layedit;
    var index = layedit.build('container'); //建立编辑器
    form.verify({
        price: function (value) {
            if (!/^[0-9]+.?[0-9]*$/.test(value))
                return '格式有误，请填入非负整数';
        },
        textarea: function () {
            return layedit.sync(index);
        }

    })
    form.on('submit(release)', function (data) {
        // console.log(data);
        console.log(data.field);
        data.field.id = id
        insert(JSON.stringify(data.field));
        return false;
    })
})

function insert(data) {
    $.ajax({
        type: 'POST',
        url: `${api}/item/create`,
        dataType: 'json',
        contentType: 'application/json',
        async: true,
        data: data,
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                window.location.href = "my";
            } else {
                layui.use('layer', function () {
                    layui.layer.msg(data.msg);
                })
            }

        }

    })
}


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
                $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" style="height: 50px;width: 50px;padding-right: 50px">')
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
            $('#pics').append('<input type="text" name="pic' + picnum + '" value="' + pic + '" hidden>');
            picnum++;

        }
        , error: function () {
            //演示失败状态，并实现重传
            layui.use('layer', function () {
                layui.layer.msg(data.msg);
            })

        },
    });
})