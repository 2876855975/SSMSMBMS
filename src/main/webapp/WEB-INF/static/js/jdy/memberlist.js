

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)

function deleteMemberInfo(obj){
    $.ajax({
        type:"get",
        url:path+"/member/deleteMember/"+obj.getAttribute("data-mid"),
        dataType:"text",
        success:function(data){
            if(data=="0"){//删除成功：移除删除行
                 alert("删除失败(该会员的购买记录还未清空)");
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



$(function(){
    var mgrade = $("#mgrade");
    $.ajax({

        type:"get",//请求类型
        url:path+"/mgrade/getmembergradejson",//请求的url
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            if(data != null){
                mgrade.html("");
                var options = "<option value=\"0\">请选择</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].gid+"\" >"+data[i].mgrade+"</option>";
                }
                mgrade.html(options);
            }
        },
        error:function(data){//当访问时候，404，500 等非200的错误状态码
            alert("错误");
        }
    });



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
});