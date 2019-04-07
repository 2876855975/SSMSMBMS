

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)

function deleteGoodsInfo(obj){
     if(confirm("确定要删除该商品吗?")){
         $.ajax({
             type:"get",
             url:path+"/goods/removeGoodsInfo",
             dataType:"text",
             data:"gid="+obj.getAttribute("data-gid"),
             success:function(data){
                 if(data=="0"){//删除成功：移除删除行
                     alert("删除失败(该商品还未售完)");
                 }else if(data=="1"){//删除失败
                     alert("删除成功");
                     $(obj).parents("tr").remove();
                 }else if(data== "2"){
                     alert("删除失败");
                 }
             },
             error:function(data){
                 //alert("对不起，删除失败");
                 alert("凉了");
             }
         });
     }
}



$(function(){

    var id = $("#id");
    $.ajax({

        type:"get",//请求类型
        url:"/categroy/getcategoryjson",//请求的url
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            if(data != null){
                id.html("");
                var options = "<option value=\"0\">请选择</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].id+"\" >"+data[i].name+"</option>";
                }
                id.html(options);
            }
        },
        error:function(data){//当访问时候，404，500 等非200的错误状态码
            alert("错误");
        }
    });




});