

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)

function deleteSupplierInfo(obj) {
       if(confirm("确定要删除吗")){

           $.ajax({
               type: "get",
               url: path + "/supplier/removeSupplier/" + obj.getAttribute("data-did"),
               dataType: "text",
               success: function (data) {
                   if (data == "0") {//删除成功：移除删除行
                       alert("删除失败(该供应商采购记录还未清空)");
                   } else if (data == "1") {//删除失败
                       alert("删除成功");
                       $(obj).parents("tr").remove();
                   } else if (data == "2") {
                       alert("删除失败");
                   }
               },
               error: function (data) {
                   //alert("对不起，删除失败");
                   alert("凉了");
               }
           });
       }


};





    /*$(".deleteUser").on("click",function(){
        var obj = $(this);
        if(confirm("你确定要删除用户【"+obj.attr("username")+"】吗？")){
            $.ajax({
                type:"GET",
                url:path+"/jsp/user.do",
                data:{method:"deluser",uid:obj.attr("userid")},
                dataType:"json",
                success:function(data){
                    if(data.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                        obj.parents("tr").remove();
                    }else if(data.delResult == "false"){//删除失败
                        alert("对不起，删除用户【"+obj.attr("username")+"】失败");
                    }else if(data.delResult == "notexist"){
                        alert("对不起，用户【"+obj.attr("username")+"】不存在");
                    }
                },
                error:function(data){
                    alert("对不起，删除失败");
                }
            });
        }
    });*/
