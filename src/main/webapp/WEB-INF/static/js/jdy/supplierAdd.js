var userName = null;
var birthday = null;
var phone = null;
var userRole = null;
var saveBtn = null;
var backBtn = null;

$(function(){
    userName = $("#userName");
    phone = $("#phone");
    saveBtn = $("#save");
    backBtn = $("#back");
    email = $("#email");






    userName.on("focus",function(){
        validateTip(userName.next(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
    }).on("blur",function(){
        if(userName.val() != null && userName.val().length > 1
            && userName.val().length < 10){

            $.ajax({
                type:"post",
                dataType:"text",
                data:"dname="+userName.val(),
                url:"/supplier/existsName",
                success:function(result){
                    if(parseInt(result)>0){
                        validateTip(userName.next(),{"color":"green"},imgYes,true);
                    }else{
                        validateTip(userName.next(),{"color":"red"},imgNo + "姓名不可重复！",false);
                    }
                },
                error:function(){
                    alert("错误");
                }
            })
        }else{
            validateTip(userName.next(),{"color":"red"},imgNo+" 用户名输入的不符合规范，请重新输入",false);
        }

    });


    phone.on("focus",function(){
        validateTip(phone.next(),{"color":"#666666"},"* 请输入手机号",false);
    }).on("blur",function(){
        var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
        if(phone.val().match(patrn)){
            $.ajax({
                type:"get",
                dataType:"text",
                url:"/supplier/existsTel/"+phone.val(),
                success:function(result){

                    if(parseInt(result)>0){
                        validateTip(phone.next(),{"color":"green"},imgYes,true);
                    }else{
                        validateTip(phone.next(),{"color":"red"},imgNo + "联系电话不可重复！",false);
                    }
                },
                error:function(){
                    alert("错误");
                }
            })
        }else{
            validateTip(phone.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
        }
    });


    email.on("focus",function(){
        validateTip(email.next(),{"color":"#666666"},"* 请输入邮箱",false);
    }).on("blur",function(){
        var patrn=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
        if(email.val().match(patrn)){
            $.ajax({
                type:"post",
                dataType:"text",
                data:"demail="+email.val(),
                url:"/supplier/existsEmail",
                success:function(result){
                    if(parseInt(result)>0){
                        validateTip(email.next(),{"color":"green"},imgYes,true);
                    }else{
                        validateTip(email.next(),{"color":"red"},imgNo + "邮箱不可重复！",false);
                    }
                },
                error:function(){
                    alert("错误");
                }
            })
        }else{
            validateTip(email.next(),{"color":"red"},imgNo + " 你输入的邮箱格式不正确",false);
        }
    });


    saveBtn.on("click",function(){
        userName.blur();
        phone.blur();
        email.blur;
        if(userName.attr("validateStatus") == "true"
            && phone.attr("validateStatus") == "true"
            && email.attr("validateStatus") ==  "true"

        ){
            $("#userForm").submit();

        }
    });

    backBtn.on("click",function(){
        //alert("modify: "+referer);
        if(referer != undefined
            && null != referer
            && "" != referer
            && "null" != referer
            && referer.length > 4){
            window.location.href = referer;
        }else{
            history.back(-1);
        }
    });



});