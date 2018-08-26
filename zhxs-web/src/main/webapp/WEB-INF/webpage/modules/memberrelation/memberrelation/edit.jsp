<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>member_relation</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="memberRelationForm">
    <form:form id="memberRelationForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>姓名:</label>
		            </td>
					<td class="width-35">
						<form:input path="personName" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
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
		              <label>性别:</label>
		            </td>
					<td class="width-35">
						<form:select path="sex" htmlEscape="false" class="form-control"  dict="sex"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>身份证:</label>
		            </td>
					<td class="width-35">
						<form:input path="idCard" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>与老人关系:</label>
		            </td>
					<td class="width-35">
						<form:select path="relationType" htmlEscape="false" class="form-control"  dict="relation_type"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>是否监护人:</label>
		            </td>
					<td class="width-35">
						<form:radiobuttons path="isGuardian" htmlEscape="false" class="form-control"  dict="sf"      cssClass="i-checks required"/>
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>联系地址:</label>
		            </td>
					<td class="width-35">
						<form:input path="address" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td class="width-15 active text-right"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		      
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
</body>
</html>