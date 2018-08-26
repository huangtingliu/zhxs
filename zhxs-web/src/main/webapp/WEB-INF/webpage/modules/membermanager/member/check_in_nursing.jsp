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

<body class="white-bg"  formid="memberNursingForm">
<form:form id="memberNursingForm" action="${adminPath}/membermanager/member/checkInNursing" modelAttribute="nursing" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<form:hidden path="memberId"/>
	<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		<tbody>
        <tr>
            <td  class="width-15 active text-right">
                <label><font color="red">*</font>护理级别:</label>
            </td>
            <td class="width-35">
                <form:select path="nursingLevel" htmlEscape="false" class="form-control"  dict="nursing_level"      />
                <label class="Validform_checktip"></label>
            </td>
            <td  class="width-15 active text-right">
                <label><font color="red">*</font>护理费用:</label>
            </td>
            <td class="width-35">
                <form:input path="nursingFee" htmlEscape="false" class="form-control"  datatype="n"    />
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>
            <td  class="width-15 active text-right">
                <label><font color="red">*</font>级别说明:</label>
            </td>
            <td colspan="3" class="width-35">
                <form:input path="levelDesc" htmlEscape="false" class="form-control"      />
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>
            <td  class="width-15 active text-right">
                <label>定制服务:</label>
            </td>
            <td colspan="3" class="width-35">
                <form:input path="customService" htmlEscape="false" class="form-control"    />
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>
            <td  class="width-15 active text-right">
                <label><font color="red">*</font>私人定制费用:</label>
            </td>
            <td class="width-35">
                <form:input path="CustomFee" htmlEscape="false" class="form-control"  datatype="n"    />
                <label class="Validform_checktip"></label>
            </td>
            <td  class="width-15 active text-right">
                <label><font color="red">*</font>护理总费用:</label>
            </td>
            <td class="width-35">
                <form:input path="totalFee" htmlEscape="false" class="form-control"  datatype="n" />
                <label class="Validform_checktip"></label>
            </td>
        </tr>
        <tr>

            <td  class="width-15 active text-right">
                <label>备注说明:</label>
            </td>
            <td colspan="3" class="width-35">
                <form:textarea path="remarks" rows="4" htmlEscape="false" class="form-control" />
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
    submitCheckiInInit(function(){
        toCheckIn('${nursing.memberId}',5);
	});

</script>
</body>
</html>