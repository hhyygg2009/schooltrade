layui.use(['laypage', 'layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form
        , laypage = layui.laypage

    loadItems(1)
    getHistory(1)


    function loadItems(currPage) {
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
            success: function (res) {
                console.log(res);
                $.each(res.data.items, function (index, val) {
                    console.log(val);
                    $("#items").append(gethtmlitem(val));

                })
                if (res.code !== 0) {
                    layer.msg(res.msg);
                }
                laypage.render({
                    elem: 'pager' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: res.data.count //数据总数，从服务端得到
                    , curr: page
                    , jump: function (obj, first) {
                        // console.log(obj.curr)
                        // console.log(obj.limit)
                        if (!first) {
                            loadItems(obj.curr)
                        }
                    }
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
            success: function (res) {
                console.log(res);
                $.each(res.data.items, function (index, val) {
                    console.log(val);
                    $("#itemHistory").append(gethtmlitem(val));

                })
                if (res.code !== 0) {
                    layer.msg(res.msg);
                }

                laypage.render({
                    elem: 'itemHistoryPager' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: res.data.count //数据总数，从服务端得到
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
                    <p><a href="#" class="delete" data-id="${item.id}">彻底删除</a></p>
                    <p><a href="${webroot}/edit?id=${item.id}">修改</a></p>
                    <p><a href="#" class="on" data-id="${item.id}"">上架/下架</a></p>                
            </div>
        </div>
    </div>
</div>`;
    }

    $(document).on("click","a.delete",function (){
        if (confirm("是否删除")) {
            itemOper(this.dataset.id, 'delete')
        } else {
            layer.msg("操作已取消");
        }
        return false
    })

    $(document).on("click","a.on",function (){
        itemOper(this.dataset.id,'on')
        return false
    })



    function itemOper(id, oper) {
        $.ajax({
            type: 'POST',
            url: `${api}/item/${id}/${oper}`,
            dataType: 'json',
            async: true,
            success: function (res) {
                console.log(res);
                var msg
                if (res.code === 0) {
                    msg = "成功"
                } else {
                    msg = res.msg
                }
                layer.msg(msg, function () {
                    // location.reload()
                    loadItems()
                });
            }
        })
    }

})