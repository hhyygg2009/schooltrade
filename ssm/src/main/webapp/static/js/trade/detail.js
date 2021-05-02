//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function () {
    var element = layui.element;

    //…
});

function getmessage(data) {
    return `
<h3>留言内容</h3>
<div>
    <img style="height:50px;width: 50px;border-radius: 50%" src="${upload}/${avatar}" alt="">${username}
    <p>价格已经很便宜了，需要直接拍</p>                        
    <a href="">回复</a> <a href="">举报</a>
    <hr>
</div>`
}


$("#messagebroad").append(getmessage(null));
$("#messagebroad").append(getmessage(null));

layui.use('carousel', function () {
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#carousel'
        , width: '100%' //设置容器宽度
        , arrow: 'always' //始终显示箭头
        //,anim: 'updown' //切换动画方式
    });
});