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
                rootPId: 0
            }
        }
    };
    $.fn.zTree.init($("#tree"), setting);
})
