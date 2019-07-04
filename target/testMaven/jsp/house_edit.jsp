<%@ pagelanguage="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href=" <%=basePath%>"> 
<script type="text/javascript" src="js/jquery/jquery-1.7.1.js"></script>
<link href="css/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="css/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/authority/commonAll.js"></script>
<script type="text/javascript" src="js/jquery/jquery-1.4.4.min.js"></script>
<script src="js/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="js/artDialog/artDialog.js?skin=default"></script>
<script type="text/javascript" src="js/house/houseEdit.js"></script>
</head>
<body>
<form id="submitForm" name="submitForm" method="post">
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">房源编辑</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="80">小区</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.fyXqCode" id="fyXq" class="ui_select01" onchange="getFyLhListByFyXqCode();">
                            <option value="">--请选择--</option>                         
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt" width="80">楼号</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.fyLhCode" id="fyLh" class="ui_select01" onchange="getFyDhListByFyXqCode();">
                            <option value="">--请选择--</option>                         
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">栋号</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.fyDhCode" id="fyDh" class="ui_select01">
                            <option value="">--请选择--</option>                       
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">层号</td>
					<td class="ui_text_lt">
						<input type="text" id="fyCh" name="fangyuanEntity.fyCh" class="ui_input_txt01"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房号</td>
					<td class="ui_text_lt">
						<input type="text" id="fyFh" name="fangyuanEntity.fyFh"  class="ui_input_txt01" onkeyup="checkFyFh();"/>室
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房源面积</td>
					<td class="ui_text_lt">
						<input type="text" id="fyZongMj" name="fangyuanEntity.fyZongMj"   class="ui_input_txt01"/>㎡
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">计租面积</td>
					<td class="ui_text_lt">
						<input type="text" id="fyJizuMj" name="fangyuanEntity.fyJizuMj" class="ui_input_txt01"/>㎡
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">户型</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.fyHxCode" id="submitForm_fangyuanEntity_fyHxCode" class="ui_select01">
                            <option value="">--请选择--</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">建筑结构</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.fyJianzhuJiegou" id="submitForm_fangyuanEntity_fyJianzhuJiegou" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="38" selected="selected">混凝土</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">座落</td>
					<td class="ui_text_lt">
						<input type="text" id="fyZldz" name="fangyuanEntity.fyZldz"  class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">位置</td>
					<td class="ui_text_lt">
						<input type="text" id="fyPsdz" name="fangyuanEntity.fyPsdz" class="ui_input_txt02"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">性质</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.zulinXingzhi" id="submitForm_fangyuanEntity_zulinXingzhi" class="ui_select01">
                            <option value="">--请选择--</option>
                            <option value="40" selected="selected">公租房</option>
                            <option value="41">廉租房</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">状态</td>
					<td class="ui_text_lt">
						<select name="fangyuanEntity.fyStatus" id="submitForm_fangyuanEntity_fyStatus" class="ui_select01">
                            <option value="">--请选择--</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="button" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>

</body>
</html>