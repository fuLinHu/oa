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
        if(url){
            alert(url);
        }else{
            alert(treeNode.tId + ", " + treeNode.name);
        }
    };
    $.fn.zTree.init($("#tree"), setting);
})
