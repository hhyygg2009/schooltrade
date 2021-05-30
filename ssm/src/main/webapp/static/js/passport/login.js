layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;

    form.on('submit(login)', function (data) {
        // console.log(data);
        // console.log(data.field);
        login(data.field);
        return false;
    })

    function login(data) {
        $.ajax({
            type: 'POST',
            url: `${api}/user/login`,
            dataType: 'json',
            async: true,
            data: data,
            success: function (res) {
                // console.log(res);
                layer.msg(res.msg);
                if (res.code === 0) {
                    window.location.href = `${webroot}/my`;
                }
            }
        })
    }

});

