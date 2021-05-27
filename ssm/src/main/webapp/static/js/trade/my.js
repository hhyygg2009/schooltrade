var currPage = 1
loadItems()
getHistory(1)

layui.use('element', function () {
    var element = layui.element;
    element.on('nav(demo)', function (elem) {
        //console.log(elem)
        layer.msg(elem.text());
    });
});

var layer
layui.use('layer', function () {
    this.layer = layui.layer
})

function loadItems() {
    $("#items").empty();
    getItemByUserId(currPage)
}

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
                        currPage = obj.curr
                        if (!first) {
                            loadItems()
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
                    <p><a href="#" onclick="return deleteconfirm(${item.id},'delete');">彻底删除</a></p>
                    <p><a href="${webroot}/newitem?id=${item.id}">修改</a></p>
                    <p><a href="#" onclick="itemOper(${item.id},'on')">上架/下架</a></p>                
            </div>
        </div>
    </div>
</div>`;
}

function deleteconfirm(id, oper) {
    if (confirm("是否删除")) {
        itemOper(id, oper)
    } else {
        layer.msg("操作已取消");
    }
}

function itemOper(id, oper) {
    $.ajax({
        type: 'POST',
        url: `${api}/item/${id}/${oper}`,
        dataType: 'json',
        async: true,
        success: function (resp) {
            console.log(resp);
            var msg
            if (resp.code === 0) {
                msg = "成功"
            } else {
                msg = resp.msg
            }
            layer.msg(msg, function () {
                // location.reload()
                loadItems()
            });
        }
    })
}