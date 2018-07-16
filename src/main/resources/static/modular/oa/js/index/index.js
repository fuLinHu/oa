$(function(){
    var setting = {
        async: {
            enable: true,
            url: "main/tree",
            autoParam: ["id"]
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: 0,
                data:"data"
            }
        },
        callback:{ //回调函数
            onClick: zTreeOnClick
        }
    };
    function zTreeOnClick(event, treeId, treeNode) {
        var url = treeNode.data.url;
        var title=treeNode.name;
        if(url){
            addTab(title, url);
        }
    };
    function addTab(title, url){
        if ($('#tt').tabs('exists', title)){
            $('#tt').tabs('select', title);
        } else {
            var url="main/test";
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
            $('#tt').tabs('add',{
                title:title,
                content:content,
                closable:true
            });
        }
    }
    $.fn.zTree.init($("#tree"), setting);
})
