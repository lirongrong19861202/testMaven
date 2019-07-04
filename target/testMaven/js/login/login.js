
//首先进入的判断
$(function() {
	$('.login_btn').click(function (){
		var name = $(".username").val();
		var password = $(".pwd").val();
        //非空判断
		emptyJudge(name,password);
		//提交登陆
		login(name,password);
	});
});

/*回车事件*/
function EnterPress(e){ //传入 event 
	var e = e || window.event; 
	if(e.keyCode == 13){ 
		$("#submitForm").attr("action", "index.jsp").submit();
	} 
} 
/**字段为空判断**/
function emptyJudge(userName,password){
	if(userName==''||password==''){
		alert('用户名密码不能为空！');
	}
}
//登陆
function login(name,password){
	
	 $.ajax({
		    async : false,
	        type: 'post',
	        url: '/testMaven/user/login',
	        data: {'name':name, 'password':password},
	        error: erryFunction,  //错误执行方法
	        success : function(data) {
	        	if(data=="success"){
	        		window.location="../testMaven/jsp/main.jsp";
	        	}else{
	        		alert("请输入正确的用户名和密码");
	        	}
	        }
	    });
	 //错误
	 function erryFunction(XMLHttpRequest,textStatus,errorThrown) {
		 alert(XMLHttpRequest.toString);
		 alert(textStatus);
         alert("请输入正确的用户名和密码");
     }
}