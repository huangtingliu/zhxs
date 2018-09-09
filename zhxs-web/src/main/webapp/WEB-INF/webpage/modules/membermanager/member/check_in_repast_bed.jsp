<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
	<title>member</title>
	<meta name="decorator" content="form"/>
	<html:css name="bootstrap-fileinput" />
	<html:css name="simditor,layer" />
	<link rel="stylesheet" href="${staticPath}/vendors/layer/skin/layer.css" />
</head>

<body class="white-bg"  formid="memberRepastBedForm">
<form:form id="memberRepastBedForm" action="${adminPath}/membermanager/member/checkInRepastBed" modelAttribute="memberRepastBed" method="post" class="form-horizontal">
	<form:hidden path="memberId"/>
	<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		<tbody>
		<tr>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>选择套餐:</label>
			</td>
			<td class="width-35">
				<form:select path="packageId" id="packageId" cssClass="form-control">
					<form:option value="">无</form:option>
					<form:options items="${repastPackage}" itemLabel="packageName" itemValue="id"/>
				</form:select>
				<label class="Validform_checktip"></label>
			</td>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>收费标准:</label>
			</td>
			<td class="width-35">
				<form:input path="packagePrice" htmlEscape="false" class="form-control"  datatype="*" />
				<label class="Validform_checktip"></label>
			</td>
		</tr>
		<tr>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>套餐详情:</label>
			</td>
			<td class="width-35">
				<form:input path="packageDetail" htmlEscape="false" class="form-control"      />
				<label class="Validform_checktip"></label>
			</td>
		</tr>
		<tr>
			<td  class="width-15 active text-right">
				<label>房间类型:</label>
			</td>
			<td class="width-35">
				<form:select path="roomType" htmlEscape="false" class="form-control"  dict="room_type"      />
				<label class="Validform_checktip"></label>
			</td>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>是否包房:</label>
			</td>
			<td class="width-35">
				<form:radiobuttons path="isPrivate" htmlEscape="false" class="form-control"  dict="sf"      cssClass="i-checks required"/>
				<label class="Validform_checktip"></label>
			</td>
		</tr>
		<tr>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>床位类型:</label>
			</td>
			<td class="width-35">
				<form:select path="bedType" htmlEscape="false" class="form-control"  dict="bed_type"      />
				<label class="Validform_checktip"></label>
			</td>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>床位编号:</label>
			</td>
			<td class="width-35">
				<form:input path="bedNo" htmlEscape="false" class="form-control" />
				<label class="Validform_checktip"></label>
			</td>
		</tr>
		<tr>
			<td  class="width-15 active text-right">
				<label><font color="red">*</font>床位费用:</label>
			</td>
			<td class="width-35">
				<form:input path="bedPrice" htmlEscape="false" class="form-control"/>元/月
				<label class="Validform_checktip"></label>
			</td>
		</tr>

		</tbody>
	</table>
	<div id="window-btn" class="layui-layer-btn">
		<a id="btnOk" class="layui-layer-btn0">保存</a>
		<a id="btnClose" class="layui-layer-btn1">关闭</a>
	</div>
</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor,layer" />
<script src="${staticPath}/common/js/contabs.js"></script>
<script src="${staticPath}/modules/member/checkIn.js"></script>
<script>
    var adminPath = "${adminPath}";
    debugger
    submitCheckiInInit(function(){
        toCheckIn('${memberRepastBed.memberId}',6);
    });
</script>
</body>
</html>