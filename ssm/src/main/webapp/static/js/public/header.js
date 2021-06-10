webroot = "";
upload = webroot + "/uploads";
api = webroot + "/api"

layui.config({
    base: '/static/layui_exts/' //配置 layui 第三方扩展组件存放的基础目录
}).extend({
    laymock: 'laymock/laymock', //mock数据
    layfilter: 'layfilter/layfilter'
});

//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function () {
    var element = layui.element;
});