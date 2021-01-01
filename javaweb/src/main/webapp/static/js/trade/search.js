querypage(1);

function querypage(currpage) {
    pageInfo = {'curr': currpage, 'keyword': keyword}

    $.ajax({
        type: 'POST',
        url: webroot + '/trade/items',
        dataType: 'json',
        async: true,
        data: pageInfo,
        success: function (resp) {
            // console.log(data);
            $.each(resp.data.items, function (index, val) {
                // console.log(val);
                $("#items").append(gethtmlitem(val));
            })
            if (resp.code != 0) {
                layui.use('layer', function () {
                    layui.layer.msg(resp.msg);
                })
            }
            layui.use('laypage', function () {
                var laypage = layui.laypage;
                //执行一个laypage实例
                laypage.render({
                    elem: 'page' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: resp.data.count //数据总数，从服务端得到
                    , curr: currpage
                    // ,limit: resp.data.pageinfo.limit
                    , jump: function (obj, first) {
                        // console.log(obj.curr)
                        // console.log(obj.limit)
                        if (!first) {
                            $("#items").empty();
                            querypage(obj.curr);
                        }
                    }
                });
            })
        }


    });
}


function gethtmlitem(item) {
    return `
<a href="detail?id=${item.id}" class="goodsitem">
    <div class="goods">
        <div class="item">
            <div class="user"> <img src="${upload}/${item.user.avatar}" alt="头像" class="touxiang"> <p
                    style="line-height: 40px;">${item.user.username}</p></div>
            <img src="${upload}/${item.pic1}" alt="商品" class="goodstu"> <p style="font-size: 20px; color: red;">
            ￥${item.price}</p>
            <p class="info">${item.name}</p></div>
    </div>
</a>`

}