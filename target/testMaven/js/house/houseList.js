$(document).ready(function(){
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
	        		$("#fyHx").append(html);
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
			        		$("#fyStatus").append(html);
			        	}else{
			        		alert("还没有维护状态字典");
			        	}
			        }
			    });
		 //错误
		 function erryFunction(XMLHttpRequest,textStatus,errorThrown) {
		     alert("请输入正确的用户名和密码");
		 }
		/** 新增   **/
	    $("#addBtn").fancybox({
	    	'href'  : '../testMaven/jsp/house_edit.jsp',
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href = '../testMaven/jsp/house_list.jsp';
	        }
	    });

	    /**编辑   **/
	    $("a.edit").fancybox({
	    	'width' : 733,
	        'height' : 530,
	        'type' : 'iframe',
	        'hideOnOverlayClick' : false,
	        'showCloseButton' : false,
	        'onClosed' : function() { 
	        	window.location.href = 'house_list.html';
	        }
	    });
	});
	/** 用户角色   **/
	var userRole = '';

	//错误
	 function erryFunction(XMLHttpRequest,textStatus,errorThrown) {
	     alert("请输入正确的用户名和密码");
	 }
	/** 模糊查询来电用户  **/
	function search(){
		var community = $("#fyXq").val();
		var houseNum = $("#fyLh").val();
		var building =  $("#fyDh").val();
		var apartmentType =  $("#fyHx").val();
		var communityStatus =  $("#fyStatus").val();
		var locate =  $("#fyZldz").val();
		$.ajax({
		    async : false,
	        type: 'post',
	        data: {'community':community,'houseNum':houseNum, 'building':building,'apartmentType':apartmentType,'communityStatus':communityStatus,'locate':locate},
	        url: '/testMaven/house/basicInfo',
	        error: erryFunction,  //错误执行方法
	        success : function(result) {
	        	var json = eval(result); //数组    	
	        	var html = "";
	        	$(".table  tr:not(:first)").empty("");
	    		for(var i=0;i<json.length;i++){
	    			html += "<tr>";
	    			html += "<td><input type='checkbox' name='IDCheck' value='"+json[i].id+"' class='acb' /></td>";
	    			html += "<td>"+json[i].locate+"</td>";/**位置  **/
	    			html += "<td>"+json[i].houseNo+"</td>";/**房源**/
	    			html += "<td>"+json[i].area+"</td>";/**面积  **/
	    			html += "<td>"+json[i].calculate_area+"</td>";/**计租面积  **/
	    			html += "<td>"+json[i].typeName+"</td>";/**户型  **/
	    			html += "<td>"+json[i].sturcture+"</td>";/**建筑结构  **/
	    			html += "<td>"+json[i].nature+"</td>";/**租赁性质  **/
	    			html += "<td>"+json[i].status+"</td>";/**状态  **/
	    			html += "<td><a class='edit'>"+"编辑"+"</a> ";
	    			html += "<a class='del'>"+"删除"+"</a> </td></tr>";
	    		}    		
	    		$(".table").append(html);
	        }
	    });
	}
   //删除表格里面某一行
	$(".del").click(function (){
		//单机后要执行的操作
		window.location.href="跳转的地址";
		});
	/** 导入  **/
	function importExcel(){
	    var files = $("#upload")[0].files;
	    if(files.length<=0){
	    	art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一个文件', ok:true,});
	    	return;
	    }else{
	    	var file = files[0];
	    	var form = new FormData();
	    	form.append("file", file);
	    	$.ajax({
	    		cache: false,
	    		async: false, 
	    		contentType: false,  
	            processData: false,  //必须要
		        type: 'post',
		        url: '/testMaven/house/createHouseInfo',
		        dataType: 'json',//服务器返回的数据类型
		        data:form,
		        success : function(result) {
		        	
		        }
		    });
	    }
	}
	/** 新增   **/
	function add(){
		$("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();	
	}
	 
	/** Excel导出  **/
	function exportExcel(){
		if($("input[name='IDCheck']:checked").size()<=0){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一条', ok:true,});
			return;
		}
		var allIDCheck = "";
		
		var houseList = new Array();
		$("input[name='IDCheck']:checked").each(function(index, domEle){
			var houseInfo = {};
            allIDCheck += $(domEle).val() + ",";
            var location = $(this).parent("td").parent("tr").children("td").next()[0].innerHTML;
			var communityName = $(this).parent("td").parent("tr").children("td").next()[1].innerHTML;
			var houseArea = $(this).parent("td").parent("tr").children("td").next()[2].innerHTML;
			var calculateArea = $(this).parent("td").parent("tr").children("td").next()[3].innerHTML;
			var apartmentType = $(this).parent("td").parent("tr").children("td").next()[4].innerHTML;
			var structure = $(this).parent("td").parent("tr").children("td").next()[5].innerHTML;
			var leaseNature = $(this).parent("td").parent("tr").children("td").next()[6].innerHTML;
			var status = $(this).parent("td").parent("tr").children("td").next()[7].innerHTML;
			houseInfo.location = location;
			houseInfo.communityName = communityName;
			houseInfo.houseArea = houseArea;
			houseInfo.calculateArea = calculateArea;
			houseInfo.apartmentType = apartmentType;
			houseInfo.structure = structure;
			houseInfo.leaseNature = leaseNature;
			houseInfo.status = status;
			houseList.push(houseInfo);
		});
		if(allIDCheck.length>0) {
			if( confirm('您确定要导出吗？') ){
				//提交后台打包成excel
				$.ajax({
					contentType:"application/json;charset=utf-8",
				    async : true,
			        type: 'post',
			        url: '/testMaven/tool/exportHouse',
			        data:JSON.stringify(houseList),
			        dataType : "json",
			        success : function(result) {
			        	var json = eval(result); //数组    
			        	if(json.result.length>0){
			        		var html = "";
			        		for(var i=0;i<json.result.length;i++){
			        			html += "<option value= '"+json.result[i].id+"'>"+json.result[i].type_name+"</option>";
			        		}
			        		$("#fyHx").append(html);
			        	}else{
			        		alert("还没有维护户型字典");
			        	}
			        }
			    });
			}
		}
	}
	
	
	/** 删除 **/
	function del(fyID){
		// 非空判断
		if(fyID == '') return;
		if(confirm("您确定要删除吗？")){
			$("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();			
		}
	}
	
	/** 批量删除 **/
	function batchDel(){
		if($("input[name='IDCheck']:checked").size()<=0){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一条', ok:true,});
			return;
		}
		// 1）取出用户选中的checkbox放入字符串传给后台,form提交
		var allIDCheck = "";
		$("input[name='IDCheck']:checked").each(function(index, domEle){
			bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
			// 用户选择的checkbox, 过滤掉“已审核”的，记住哦
			if($.trim(bjText)=="已审核"){
// 				$(domEle).removeAttr("checked");
				$(domEle).parent("td").parent("tr").css({color:"red"});
				$("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
			}else{
				allIDCheck += $(domEle).val() + ",";
			}
		});
		// 截掉最后一个","
		if(allIDCheck.length>0) {
			allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
			// 赋给隐藏域
			$("#allIDCheck").val(allIDCheck);
			if(confirm("您确定要批量删除这些记录吗？")){
				// 提交form
				$.ajax({
				    async : false,
			        type: 'post',
			        url: '/testMaven/house/deleteHouseList',
			        data:{"allIDCheck":allIDCheck},
			        error: erryFunction,  //错误执行方法
			        success : function(result) {
			        	var json = eval(result); //数组    
			        	if(json==null){
			        		art.dialog({
                               icon:'succeed', 
                               title:'友情提示', 
                               drag:false, 
                               resize:false, 
                               content:'删除成功', 
                               ok:function(){
                            	   search();
                               },
                               });
			        	}
			        }
			    });
			}
		}
	}

	/** 普通跳转 **/
	function jumpNormalPage(page){
		$("#submitForm").attr("action", "house_list.html?page=" + page).submit();
	}
	
	/** 输入页跳转 **/
	function jumpInputPage(totalPage){
		// 如果“跳转页数”不为空
		if($("#jumpNumTxt").val() != ''){
			var pageNum = parseInt($("#jumpNumTxt").val());
			// 如果跳转页数在不合理范围内，则置为1
			if(pageNum<1 | pageNum>totalPage){
				art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
				pageNum = 1;
			}
			$("#submitForm").attr("action", "house_list.html?page=" + pageNum).submit();
		}else{
			// “跳转页数”为空
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
			$("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
		}
	}