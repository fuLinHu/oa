$(function(){
    var baseUrl="/models";
    var table="#table";
    $(table).datagrid({
        url:baseUrl+"/pageList",
        columns:[[
            {field:'id',title:'ID',width:50},
            {field:'name',title:'流程名字',width:100},
            {field:'key',title:'主键（key）',width:100},
            {field:'version',title:'version',width:100},
            {field:'deploymentId',title:'deploymentId',width:100},
            {field:'editorSourceValueId',title:'editorSourceValueId',width:100},
            {field:'editorSourceExtraValueId',title:'editorSourceExtraValueId',width:100},
            {field:'metaInfo',title:'metaInfo',width:300},
            {field:'tenantId',title:'tenantId',width:100},
            {field:'category',title:'category',width:100},
            {field:'createTime',title:'createTime',width:100,align:'right',
                formatter: function(value,row,index){
                    return dataFormatter(new Date(value));
                }
            }
        ]]
    });
    function dataFormatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    //重新部署单个流程
    function redeploy(){
        var row = $(table).datagrid('getSelected');
        if (row) {
            $.ajax({
                url: '/modelAction/deploy/'+row.id,
                type: 'post',
                dataType: 'json',
                data: {},
                success: function (data) {
                    $.messager.progress("close");
                    if (data.status) {
                        model_datagrid.datagrid("reload"); //reload the process data
                    }
                    $.messager.show({
                        title : data.title,
                        msg : data.message,
                        timeout : 1000 * 2
                    });
                },
                beforeSend:function(){
                    $.messager.progress({
                        title: '提示信息！',
                        text: '数据处理中，请稍后....'
                    });
                },
                complete: function(){
                    $.messager.progress("close");
                }
            });
        } else {
            $.messager.alert("提示", "您未选择任何操作对象，请选择一行数据！");
        }
    }
})