getItemByUserId(1)
getHistory(1)

function getItemByUserId(page) {
    var data = {"curr": page}
    $.ajax({
        type: 'POST',
        url: `${api}/items/user/gets`,
        dataType: 'json',
        async: true,
        data: data,
        success: function (resp) {
            console.log(resp);
            $.each(resp.data.items, function (index, val) {
                console.log(val);
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
                    elem: 'pager' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: resp.data.count //数据总数，从服务端得到
                    , curr: page
                    , jump: function (obj, first) {
                        // console.log(obj.curr)
                        // console.log(obj.limit)
                        if (!first) {
                            $("#items").empty();
                            getItemByUserId(obj.curr)
                        }
                    }
                });
            });
        }
    })
}

function getHistory(page) {
    data = {"curr": page}
    $.ajax({
        type: 'POST',
        url: `${api}/items/history/gets`,
        dataType: 'json',
        async: true,
        data: data,
        success: function (resp) {
            console.log(resp);
            $.each(resp.data.items, function (index, val) {
                console.log(val);
                $("#itemHistory").append(gethtmlitem(val));

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
                    elem: 'itemHistorypager' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: resp.data.count //数据总数，从服务端得到
                    , curr: page
                    , jump: function (obj, first) {
                        // console.log(obj.curr)
                        // console.log(obj.limit)
                        if (!first) {
                            $("#itemHistory").empty();
                            getItemByUserId(obj.curr)
                        }
                    }
                });
            });
        }
    })
}



function deleteconfirm() {
    return confirm("是否删除");
}


function gethtmlitem(item) {
    var date = new Date(item.createtime);

    return `    
<div class="big-goods">
<input type="checkbox" name="item[]" value="${item.id}">
<div class="info">${dateFormat("YYYY-mm-dd", date)} 订单号：${item.id}</div>
    <div class="goods-info">
        <div class="goods-left"><img src="${upload}/${item.pic1}" alt="">
            <div class="goods-ul">
                <p><a href="detail?id=${item.id}">${item.name}</a></p>
                <p>颜色分类： ${item.category.name}</p>
            </div>
        </div>
        <div class="goods-right">
            <div class="goods-command">
                <p>￥${item.price}</p>
                <p>${item.state.name}</p>
            </div>
            <div  class="goods-command">                
                    <p><a href="${api}/item/${item.id}/delete" onclick="return deleteconfirm();">彻底删除</a></p>
                    <p><a href="${webroot}/newitem?id=${item.id}">修改</a></p>
                    <p><a href="${api}/item/${item.id}/on">上架/下架</a></p>                
            </div>
        </div>
    </div>
</div>`;
}