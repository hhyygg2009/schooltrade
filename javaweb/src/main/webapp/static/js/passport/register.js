layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;
    // var passw=form.password.value;
    //日期

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


    //监听提交
    form.on('submit(demo1)', function (data) {
        layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        return false;
    });


    //表单取值
    layui.$('#LAY-component-form-getval').on('click', function () {
        var data = form.val('example');
        alert(JSON.stringify(data));
    });

});

//一般直接写在一个js文件中
layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;
    form.on('submit(register)', function (data) {
        // console.log(data);
        console.log(data.field);
        login(data.field);
        return false;
    })

});

function login(data) {
    $.ajax({
        type: 'POST',
        url: 'registeraction',
        dataType: 'json',
        async: true,
        data: data,
        success: function (data) {
            console.log(data);
            if (data.code == 1) {
                window.location.href = "login.jsp";
            } else {
                layui.use('layer', function () {
                    layui.layer.msg(data.msg);
                })
            }

        }

    })
}