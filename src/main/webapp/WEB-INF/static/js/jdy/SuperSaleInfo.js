

    function removeBySaleid(i) {
        if(confirm("确定要删除该订单项吗（该订单项下所有信息会一起删除）")){
            $.ajax({
                type:"get",
                dataType:"text",
                url:"/supersaleinfo/removeBySaleId?saleid="+i.getAttribute("data-saleid"),
                success:function (data) {
                    if(data=="1"){
0.+
alert("删除成功");
                        $(i).parents("tr").remove();
                    }else{
                        alert("删除失败！");
                    }
                },
                error:function (x,j,r) {
                    alert(r);
                }
            })
        }

    }







