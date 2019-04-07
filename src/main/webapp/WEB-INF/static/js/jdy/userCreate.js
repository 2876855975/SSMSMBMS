var userCode = null;
var userName = null;
var userPassword = null;
var ruserPassword = null;
var phone = null;
var birthday = null;
var userRole = null;
var addBtn = null;
var backBtn = null;


jQuery(function(){
	userCode = jQuery("#userCode");
	userName = jQuery("#userName");
	userPassword = jQuery("#userPassword");
    addBtn = jQuery("#add");
    backBtn = jQuery("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	
	jQuery.ajax({
		type:"POST",//请求类型
		url:path+"/index",//请求的url
		data:{method:"getrolelist"},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data != null){
				userRole.html("");
				var options = "<option value=\"0\">请选择</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].roleName);
					options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
				}
				userRole.html(options);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			validateTip2(userRole.next(),{"color":"red"},imgNo+" 获取用户角色列表error",false);
		}
	});
	
	
	
	/*
	 * 验证
	 * 失焦\获焦
	 * jQuery的方法传递
	 */
	userCode.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		//user.do?method=ucexist&userCode=**
		jQuery.ajax({
			type:"GET",//请求类型
			url:path+"/user/getCode.json",//请求的url
			data:{userCode:userCode.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.userCode == "exist"){//账号已存在，错误提示
					validateTip2(userCode.prev(),{"color":"red"},imgNo+ " 该用户账号已存在",false);
				}else{//账号可用，正确提示
					validateTip2(userCode.prev(),{"color":"green"},imgYes+" 该账号可以使用",true);
				}
			},
			// error:function(data){//当访问时候，404，500 等非200的错误状态码
			// 	validateTip2(userCode.prev(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
			// }
		});
		
		
	}).bind("focus",function(){
		//显示友情提示
		validateTip2(userCode.prev(),{"color":"#666666"},"* 用户编码是您登录系统的账号",false);
	}).focus();
	
	userName.bind("focus",function(){
		validateTip2(userName.prev(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
	}).bind("blur",function(){
		if(userName.val() != null && userName.val().length > 1
				&& userName.val().length < 10){
			validateTip2(userName.prev(),{"color":"green"},imgYes,true);
		}else{
			validateTip2(userName.prev(),{"color":"red"},imgNo+" 用户名输入的不符合规范，请重新输入",false);
		}
		
	});
	
	userPassword.bind("focus",function(){
		validateTip2(userPassword.prev(),{"color":"#666666"},"* 密码长度必须是大于6小于20",false);
	}).bind("blur",function(){
		if(userPassword.val() != null && userPassword.val().length > 6
				&& userPassword.val().length < 20 ){
			validateTip2(userPassword.prev(),{"color":"green"},imgYes,true);
		}else{
			validateTip2(userPassword.prev(),{"color":"red"},imgNo + " 密码输入不符合规范，请重新输入",false);
		}
	});
	

	
	addBtn.click(function(){
		if(userCode.attr("validateStatus") != "true"){
			userCode.blur();
		}else if(userName.attr("validateStatus") != "true"){
			userName.blur();
		}else if(userPassword.attr("validateStatus") != "true"){
			userPassword.blur();
		}else{
			if(confirm("是否确认提交数据")){
				// jQuery("#userForm").submit();
                // var datas= jQuery("#userForm").serialize();
                jQuery.ajax({
                    type:"POST",//请求类型
                    url:path+"/user/userCreate.json",//请求的url
                    data:{userCode:userCode.val(),userName:userName.val(),userPassword:userPassword.val()},//请求参数
                    dataType:"json",//ajax接口（请求url）返回的数据类型
                    success:function(data){//data：返回数据（json对象）
                        if(data.userCode == "false"){//是否注册成功
                            validateTip3(jQuery("#error"),{"color":"red"},imgNo+ "注册失败，请稍后再试...",false);
                        }else{//账号可用，正确提示
                            validateTip3(jQuery("#error"),{"color":"green"},imgYes+" 注册成功！",true);
                        }
                    },
                    // error:function(data){//当访问时候，404，500 等非200的错误状态码
                    // 	validateTip2(userCode.prev(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
                    // }
                });



			}
		}
	});
	
	backBtn.on("click",function(){
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