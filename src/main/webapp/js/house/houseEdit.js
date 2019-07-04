$(document).ready(function() {
	/** 进入页面加载小区数据**/
	$.ajax({
	    async : false,
        type: 'post',
        url: '/testMaven/house/communityList',
        error: erryFunction,  //错误执行方法
        success : function(result) {
        	var json = eval(result); //数组    
        	if(json.result.length>0){
        		var html = "";
        		for(var i=0;i<json.result.length;i++){
        			html += "<option value= '"+json.result[i].id+"'>"+json.result[i].name+"</option>";
        		}
        		$("#fyXq").append(html);
        	}else{
        		alert("还没有维护小区");
        	}
        }
    });
	//加载户型
	$.ajax({
	    async : false,
        type: 'post',
        url: '/testMaven/dict/apartmentType',
        error: erryFunction,  //错误执行方法
        success : function(result) {
        	var json = eval(result); //数组    
        	if(json.result.length>0){
        		var html = "";
        		for(var i=0;i<json.result.length;i++){
        			html += "<option value= '"+json.result[i].id+"'>"+json.result[i].type_name+"</option>";
        		}
        		$("#submitForm_fangyuanEntity_fyHxCode").append(html);
        	}else{
        		alert("还没有维护户型字典");
        	}
        }
    });
	//加载状态
			$.ajax({
			    async : false,
		        type: 'post',
		        url: '/testMaven/dict/communityStatus',
		        error: erryFunction,  //错误执行方法
		        success : function(result) {
		        	var json = eval(result); //数组    
		        	if(json.result.length>0){
		        		var html = "";
		        		for(var i=0;i<json.result.length;i++){
		        			html += "<option value= '"+json.result[i].id+"'>"+json.result[i].name+"</option>";
		        		}
		        		$("#submitForm_fangyuanEntity_fyStatus").append(html);
		        	}else{
		        		alert("还没有维护状态字典");
		        	}
		        }
		    });
	 //错误
	 function erryFunction(XMLHttpRequest,textStatus,errorThrown) {
	     alert("请输入正确的用户名和密码");
	 }
		/*
		 * 提交
		 */
		$("#submitbutton").click(function() {
			if(validateForm()){
				checkFyFhSubmit();
			}
		});
		
		/*
		 * 取消
		 */
		$("#cancelbutton").click(function() {
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		});
		
		var result = 'null';
		if(result =='success'){
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		}
	});

	/** 检测房源房号是否存在  **/
	function checkFyFh(){
		// 分别获取小区编号、栋号、层号、房号
		var fyXqCode = $("#fyXq").val();
		var fyLh = $("#fyLh").val();
		var fyDh = $("#fyDh").val();
		var fyCh = $("#fyCh").val();	
		var fyFh = $("#fyFh").val();
		if(fyXqCode!=""&& fyLh!="" && fyDh!="" && fyCh!="" && fyFh!=""){
			// 给房屋坐落地址赋值
			$("#fyZldz").val($('#fyDh option:selected').text() + fyCh + "-" + fyFh);
			// 异步判断该房室是否存在，如果已存在，给用户已提示哦
			$.ajax({
				type:"POST",
				url:"/testMaven/house/checkFyFhIsExists",
				data:{"fyXqCode":fyXqCode,"fyLh":fyLh,"fyDh":fyDh,  "fyCh":fyCh, "fyFh":fyFh},				
				success:function(data){
// 					alert(data);
					// 如果返回数据不为空，更改“房源信息”
					if(data.result=="true"){
						 art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'该房室在系统中已经存在哦，\n请维护其他房室数据', ok:true,});
						 $("#fyFh").css("background", "#EEE");
						 $("#fyFh").focus();
						 return false;
					}
				}
			});
		}
	}
	
	/** 检测房源房号是否存在并提交form  **/
	function checkFyFhSubmit(){
		// 分别获取小区编号、栋号、层号、房号
		var houseInfo = {};
		var fyXqCode = $("#fyXq").val();
		var fyLh = $("#fyLh").val();
		var fyDh = $("#fyDh").val();
		var fyCh = $("#fyCh").val();	
		var fyFh = $("#fyFh").val();
		var fyZongMj = $("#fyZongMj").val();//建筑面加
		var fyJizuMj = $("#fyJizuMj").val();//计算面积
		var fyHxCode = $("#submitForm_fangyuanEntity_fyHxCode").val();//户型
		var fyJianzhuJiegou = $("#submitForm_fangyuanEntity_fyJianzhuJiegou option:selected").text();//建筑结构
		var fyZldz = $("#fyZldz").val();//坐落
		var fyPsdz = $("#fyPsdz").val();//位置
		var zulinXingzhi = $("#submitForm_fangyuanEntity_zulinXingzhi option:selected").text();//租赁性质
		var fyStatus = $("#submitForm_fangyuanEntity_fyStatus").val();//状态
		houseInfo.community = parseInt(fyXqCode);
		houseInfo.house_num = parseInt(fyLh);
		houseInfo.building = parseInt(fyDh);
		houseInfo.floor_num = fyCh;
		houseInfo.num = fyFh;
		houseInfo.house_area = parseFloat(fyZongMj);
		houseInfo.calculate_area = parseFloat(fyJizuMj);
		houseInfo.apartment_type = parseInt(fyHxCode);
		houseInfo.structure = fyJianzhuJiegou;
		houseInfo.locate = fyZldz;
		houseInfo.position = fyPsdz;
		houseInfo.lease_nuture = zulinXingzhi;
		houseInfo.community_status = parseInt(fyStatus);
		
		if(fyXqCode!="" && fyDh!="" && fyCh!="" && fyFh!=""){
			// 给房屋坐落地址赋值
			$("#fyZldz").val($('#fyDh option:selected').text()  + fyCh + "-" + fyFh);
			// 异步判断该房室是否存在，如果已存在，给用户已提示哦
			$.ajax({
				type:"POST",
				url:"/testMaven/house/checkFyFhIsExists",
				data:{"fyXqCode":fyXqCode,"fyLh":fyLh, "fyDh":fyDh, "fyCh":fyCh, "fyFh":fyFh},
				success:function(data){
// 					alert(data);
					// 如果返回数据不为空，更改“房源信息”
					if(data.result=="true"){
						 art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'该房室在系统中已经存在哦，\n请维护其他房室数据', ok:true,});
						 $("#fyFh").css("background", "#EEE");
						 $("#fyFh").focus();
						 return false;
					}else{
						$.ajax({
							contentType:"application/json;charset=utf-8",
							type:"POST",
							traditional:true,
							async: false,
							url:"/testMaven/house/saveHouseInfo",
							data:JSON.stringify(houseInfo),				
							dataType : "json",
							success:function(data){
//			 					alert(data);
								// 如果返回数据不为空，更改“房源信息”
								if(data!=null){
									 art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'该房室在系统中已经存在哦，\n请维护其他房室数据', ok:true,});
									 $("#fyFh").css("background", "#EEE");
									 $("#fyFh").focus();
									 return false;
								}else{
									 art.dialog({
                                       icon:'succeed', 
                                       title:'友情提示',
                                       drag:false, 
                                       resize:false, 
                                       content:'新增房源成功', 
                                       ok:function(){
                                    	   window.parent.$.fancybox.close();
                                       },
                                       });
								}
							}
						});
					}
				}
			});
		}
		return true;
	}
	
	/** 表单验证  **/
	function validateForm(){
		if($("#fyXqName").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源小区', ok:true,});
			return false;
		}
		if($("#fyDh").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源栋号', ok:true,});
			return false;
		}
		if($("#fyCh").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源层号', ok:true,});
			return false;
		}
		if($("#fyFh").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源房号', ok:true,});
			return false;
		}
		if($("#fyZongMj").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源面积', ok:true,});
			return false;
		}
		if($("#fyJizuMj").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写计租面积', ok:true,});
			return false;
		}
		if($("#fyZldz").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源座落地址', ok:true,});
			return false;
		}
		return true;
	}