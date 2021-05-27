function reloadcode() {
    $("#code").attr("src", `${webroot}/passport/code?rnd=${Math.random()}`);
}

//一般直接写在一个js文件中
layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;
    form.on('submit(login)', function (data) {
        // console.log(data);
        // console.log(data.field);
        login(data.field);
        return false;
    })

});

function login(data) {
    $.ajax({
        type: 'POST',
        url: `${api}/user/login`,
        dataType: 'json',
        async: true,
        data: data,
        success: function (res) {
            console.log(res);
            if (res.code === 0) {
                layui.use('layer', function () {
                    layui.layer.msg(res.msg);
                })
                window.location.href = `${webroot}/my`;
            } else {
                layui.use('layer', function () {
                    layui.layer.msg(res.msg);
                })
            }

        }

    })
}