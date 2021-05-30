layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;

    laydate.render({
        elem: '#date'
    });
    laydate.render({
        elem: '#date1'
    });

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //自定义验证规则
    form.verify({
        number: function (value) {
            if (value.length < 5) {
                return '帐号至少得5个字符啊';
            }
        }
        , pass: [
            /^[\S]{3,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
        , content: function (value) {
            layedit.sync(editIndex);
        }
    });


    form.verify({
        rpwd: function (value) {
            var pwd = form.val('password');
            if (pwd != value)
                alert(form.val('password'));
        }

    });
});

layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;

    form.on('submit(register)', function (data) {
        // console.log(data);
        // console.log(data.field);
        register(data.field);
        return false;
    })

    function register(data) {
        $.ajax({
            type: 'POST',
            url: `${api}/user/register`,
            dataType: 'json',
            async: true,
            data: data,
            success: function (res) {
                // console.log(res);
                layer.msg(res.msg);
                if (res.code === 0) {
                    window.location.href = "/passport/login";
                }

            }

        })
    }
});

