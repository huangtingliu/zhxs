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

<body class="white-bg"  formid="memberForm">
    <form:form id="memberForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>姓名:</label>
		            </td>
					<td class="width-35">
						<form:input path="memberName" htmlEscape="false" class="form-control"  datatype="s"    />
						<label class="Validform_checktip"></label>
					</td>
					<td rowspan="3"  class="width-15 active text-right">
						<label>头像:</label>
					</td>
					<td  rowspan="3" class="width-35">
						<form:fileinput showType="avatar" fileInputWidth="100px"  fileInputHeight="100px"  path="profilePhoto" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>电话:</label>
		            </td>
					<td class="width-35">
						<form:input path="phone" htmlEscape="false" class="form-control"  datatype="m"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">
						<label>身份证:</label>
					</td>
					<td class="width-35">
						<form:input path="idCard" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>生日:</label>
		            </td>
					<td class="width-35">
						<form:input path="birthday" htmlEscape="false" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"       />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">
		              <label>性别:</label>
		            </td>
					<td class="width-35">
						<form:select path="sex" htmlEscape="false" class="form-control"  dict="sex"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>人员类别:</label>
		            </td>
					<td class="width-35">
						<form:select path="personType" htmlEscape="false" class="form-control"  dict="person_type"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>入住日期:</label>
		            </td>
					<td class="width-35">
						<form:input path="liveTime" htmlEscape="false" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"       />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>合同签订日期:</label>
		            </td>
					<td class="width-35">
						<form:input path="contractTime" htmlEscape="false" class="form-control layer-date"  placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>婚姻状况:</label>
		            </td>
					<td class="width-35">
						<form:select path="marriage" htmlEscape="false" class="form-control"  dict="marriage"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>家庭地址:</label>
		            </td>
					<td class="width-35">
						<form:input path="houseAddress" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>户籍地址:</label>
		            </td>
					<td class="width-35">
						<form:input path="censusRegisterAddress" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>是否本市户籍:</label>
		            </td>
					<td class="width-35">
						<form:radiobuttons path="isLocal" htmlEscape="false" class="form-control"  dict="sf"      cssClass="i-checks required"/>
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>是否外地迁入:</label>
		            </td>
					<td class="width-35">
						<form:select path="isImmigration" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>原居住情况:</label>
		            </td>
					<td class="width-35">
						<form:radiobuttons path="originalLiveStatus" htmlEscape="false" class="form-control"  dict="original_live_status"      cssClass="i-checks required"/>
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>家庭人口:</label>
		            </td>
					<td class="width-35">
						<form:input path="familyNumber" htmlEscape="false" class="form-control"  datatype="n"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>宗教信仰:</label>
		            </td>
					<td class="width-35">
						<form:input path="faith" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>爱好:</label>
		            </td>
					<td class="width-35">
						<form:input path="hobby" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>性格心理:</label>
		            </td>
					<td class="width-35">
						<form:input path="disposition" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>饮食特点:</label>
		            </td>
					<td class="width-35">
						<form:input path="diet" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>文化程度:</label>
		            </td>
					<td class="width-35">
						<form:select path="culture" htmlEscape="false" class="form-control"  dict="culture"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>劳动能力:</label>
		            </td>
					<td class="width-35">
						<form:select path="laborCapacity" htmlEscape="false" class="form-control"  dict="labor_capacity"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>经济来源:</label>
		            </td>
					<td class="width-35">
						<form:input path="pocketbook" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>医疗保障:</label>
		            </td>
					<td class="width-35">
						<form:input path="healthCare" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>医保卡号:</label>
		            </td>
					<td class="width-35">
						<form:input path="healthCareCardNumber" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">
						<label>档案编号:</label>
					</td>
					<td class="width-35">
						<form:input path="memberNo" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
		      
		   </tbody>
		</table>
		<%--<div class="layui-layer-btn">--%>
			<%--<a id="btnOk" class="layui-layer-btn0">确定</a>--%>
			<%--<a id="btnClose" class="layui-layer-btn1">关闭</a>--%>
		<%--</div>--%>
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor,layer" />
<script src="${staticPath}/common/js/contabs.js"></script>
<script>
	$(".layui-layer-btn a#btnOk").click(function(){
        doSubmit(function(){
            reloadTab("/admin//membermanager/member");
            childCloseTab();
		});

	});
	$(".layui-layer-btn a#btnClose").click(function(){
        childCloseTab();
	});
</script>
</body>
</html>