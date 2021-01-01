function reloadcode() {
    console.log("111");
    $("#code").attr("src", `${webroot}/passport/code.jsp?rnd=${Math.random()}`);
}

//一般直接写在一个js文件中
layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;
    form.on('submit(login)', function (data) {
        // console.log(data);
        console.log(data.field);
        login(data.field);
        return false;
    })

});

function login(data) {
    $.ajax({
        type: 'POST',
        url: 'loginaction',
        dataType: 'json',
        async: true,
        data: data,
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                layui.use('layer', function () {
                    layui.layer.msg(data.msg);
                })
                window.location.href = `${webroot}/trade/my`;
            } else {
                layui.use('layer', function () {
                    layui.layer.msg(data.msg);
                })
            }

        }

    })
}