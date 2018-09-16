<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>护理项目配置</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="configNursingProjectForm">
    <form:form id="configNursingProjectForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>护理项目:</label>
		            </td>
					<td class="width-35">
						<form:input path="nursingProject" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">
		              <label><font color="red">*</font>项目描述:</label>
		            </td>
					<td class="width-35">
						<form:input path="projectDesc" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
		  		</tr>
			   <tr>
				   <td  class="width-15 active text-right">
					   <label><font color="red">*</font>收费标准:</label>
				   </td>
				   <td class="width-35">
					   <form:input path="price" htmlEscape="false" class="form-control"  datatype="n"    />
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