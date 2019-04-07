var mname=$("#mname");
var mtel=$("#mtel");
var flag=null;
var flag=null;
var back=$("#back");
var save=$("#save");
mname.blur(function () {
     if(mname.val()!=null && mname.val().length>1 && mname.length<10){
           mname.next().css("color","green").text("会员姓名可用");
           flag=true;
     }else{
            mname.next().css("color","red").text("会员姓名不符合规范");
            flag=false;
     }
})

mtel.blur(function () {
    var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
    if(mtel.val().match(patrn)){
      mtel.next().css("color","green").text("手机号码可以使用");
      flag1=true;
    }else{
       mtel.next().css("color","red").text("手机号码格式错误");
       flag1=false;
    }

})


save.click(function () {
      mtel.blur();
      mname.blur();
      if(flag==true && flag1==true){
            $("#userForm").submit();
      }
})

back.click(function () {
     history.forward();
})




