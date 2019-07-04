/**菜单跳转**/
function rightMain(url){
	$('#rightMain').attr('src', url);
}

/** 异步加载楼号列表 * */
function getFyLhListByFyXqCode() {
	var communityId = $("#fyXq").val();
	if (communityId == "" || communityId == null) {
		$("#fyDh").html('<option value="">--请选择--</option>');
	} else {
		/** 异步加载栋号列表 * */
		$.ajax({
			type : "POST",
			url : "/testMaven/house/houseNum",
			data : {
				"communityId" : communityId
			},
			dataType : "json",
			success : function(data) {
				// 如果返回数据不为空，更改“房源信息”
				if (data.result.length == 0 || data.result == '') {// 如果为空
					alert("该小区下暂无楼号列表，请联系\n管理员维护数据哦！！！");
					$("#fyLh").html('<option value="">--请选择--</option>');
				} else {
					var str = '<option value="">--请选择--</option>';
					// 将返回的数据赋给zTree
					for (var i = 0; i < data.result.length; i++) {
						str += '<option value="' + data.result[i].id + '">'
								+ data.result[i].num+'号楼' + '</option>';
					}
					// alert(str);
					$("#fyLh").html(str);
				}
			}
		});
	}
}

/** 异步加载栋号列表 * */
function getFyDhListByFyXqCode() {
	var communityId = $("#fyXq").val();
	var houseNum = $("#fyLh").val();
	if (communityId == "" || communityId == null) {
		$("#fyDh").html('<option value="">--请选择--</option>');
	}else if(houseNum == "" || houseNum == null){
		$("#fyDh").html('<option value="">--请选择--</option>');
	}else {
		/** 异步加载栋号列表 * */
		$.ajax({
			type : "POST",
			url : "/testMaven/house/buildNo",
			data : {
				"communityId" : communityId,
				"houseNum" : houseNum
			},
			dataType : "json",
			success : function(data) {
				// 如果返回数据不为空，更改“房源信息”
				if (data.result.length == 0 || data.result == '') {// 如果为空
					alert("该小区下暂无栋号列表，请联系\n管理员维护数据哦！！！");
					$("#fyDh").html('<option value="">--请选择--</option>');
				} else {
					var str = '<option value="">--请选择--</option>';
					// 将返回的数据赋给zTree
					for (var i = 0; i < data.result.length; i++) {
						str += '<option value="' + data.result[i].id + '">'
								+ data.result[i].no+'栋' + '</option>';
					}
					// alert(str);
					$("#fyDh").html(str);
				}
			}
		});
	}
}
/*
 * 是否全选
 */
function selectOrClearAllCheckbox(obj) {
	var checkStatus = $(obj).attr("checked");
	if (checkStatus == "checked") {
		$("input[type='checkbox']").attr("checked", true);
	} else {
		$("input[type='checkbox']").attr("checked", false);
	}
}

/** 日期函数，加几天，减几天 **/
function getNextDay(dd, dadd) {
	// 可以加上错误处理
	var a = new Date(dd);
	a = a.valueOf();
	a = a + dadd * 24 * 60 * 60 * 1000;
	a = new Date(a);
	var m = a.getMonth() + 1;
	if (m.toString().length == 1) {
		m = '0' + m;
	}
	var d = a.getDate();
	if (d.toString().length == 1) {
		d = '0' + d;
	}
	return a.getFullYear() + "-" + m + "-" + d;
}

/** table鼠标悬停换色* */
$(function() {
	// 如果鼠标移到行上时，执行函数
	
	
	
	$(".table tr").mouseover(function() {
		$(this).css({background : "#CDDAEB"});
		$(this).children('td').each(function(index, ele){
			$(ele).css({color: "#1D1E21"});
		});
	}).mouseout(function() {
		$(this).css({background : "#FFF"});
		$(this).children('td').each(function(index, ele){
			$(ele).css({color: "#909090"});
		});
	});
});
