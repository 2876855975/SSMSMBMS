
var flag1=null;
var flag2=null;
var flag3=null;

userPassword=$("#userpassword");
reuserPassword=$("#reuserpassword");
sid=$("#sid");
oldUserPassword=$("#olduserpassword")
save=$("#save");
    back=$("#back");

       oldUserPassword.blur(function () {
          if(oldUserPassword.val() != null && oldUserPassword.val().length >= 6
              && oldUserPassword.val().length < 10){

              $.ajax({
                   type:"post",
                  data:"sid="+sid.val()+"&userpassword="+oldUserPassword.val(),
                  dataType:"text",
                  url:"/user/validateUserPassword",
                  success:function(data){
                       if(data=="1"){
                           oldUserPassword.next().css("color","red").text("旧密码输入错误");
                            flag1=false;
                       }else{
                           oldUserPassword.next().css("color","green").text("用户旧密码正确");
                           flag1=true;
                       }
                  },
                  error:function(x,j,r){
                      alert(r);
                     flag1=false;
                  }
              });
          }else{
              oldUserPassword.next().css("color","red").text("用户密码不规范");
                 flag1=false;
          }
     });

    reuserPassword.blur(function () {
          if(reuserPassword.val() != null && reuserPassword.val().length >= 6
          && reuserPassword.val().length < 10){
              if(userPassword.val()==reuserPassword.val()){
                  reuserPassword.next().css("color","green").text("密码可以使用");
                  flag2=true;
              }else{
                  reuserPassword.next().css("color","red").text("两次密码输入不一致");
                  flag2=false;
              }
          }else {
              reuserPassword.next().css("color","red").text("密码不符合规范");
              flag2=false;
          }

    });


    userPassword.blur(function () {
         if(userPassword.val() != null && userPassword.val().length >= 6
             && userPassword.val().length < 10){
             userPassword.next().css("color","green").text("密码规范正确");
             flag3=true;
         }else{
             userPassword.next().css("color","red").text("密码规范不正确");
             flag3=false;
         }
    })

    save.click(function () {
       oldUserPassword.blur();
       userPassword.blur();
       reuserPassword.blur();
       if(flag1==true && flag2==true && flag3==true){
           $("#userForm").submit();
       }else{
           alert("凉了");
       }

    })

    back.click(function () {
        history.forward();
    })

