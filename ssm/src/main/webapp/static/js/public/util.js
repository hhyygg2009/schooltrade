function dateFormat(fmt, date) {
    let ret;
    const opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
    };
    for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length === 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")));
        }
    }

    return fmt;
}

class Pager {

    keyword = ""
    selectedItem = {}

    constructor(url, pager, pageOpertor) {
        this.curPage = 1
        this.api_url = url
        this.pager = pager
        this.pageOpertor = pageOpertor
    }


    loadPage() {
        this.getItems(this.curPage);
    }

    getItems() {
        var pageInfo = {'pageNum': this.curPage, 'keyword': this.keyword, 'selectedItem': this.selectedItem}

        $.ajax({
            type: 'POST',
            url: this.api_url,
            dataType: 'json',
            // contentType: "application/json",
            async: true,
            data: pageInfo,
            success: (res) => {
                // console.log(data);
                this.pageOpertor(res)
                this.renderPager(res)
            }
        });
    }

    renderPager(res) {
        layui.use(['layer', 'laypage', 'laymock', 'layfilter'], () => {
            var laypage = layui.laypage
            var layer = layui.laypage
            var laymock = layui.laymock
                , layfilter = layui.layfilter


            //执行一个laypage实例
            laypage.render({
                elem: this.pager //注意，这里的 test1 是 ID，不用加 # 号
                , count: res.data.count //数据总数，从服务端得到
                , curr: this.curPage
                // ,limit: res.data.pageinfo.limit
                , jump: (obj, first) => {
                    // console.log(obj.curr)
                    // console.log(obj.limit)
                    if (!first) {
                        this.curPage = obj.curr
                        this.loadPage()
                    }
                }
            });
        })
    }
}