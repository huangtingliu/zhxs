<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>菜品表</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="repastFoodForm">
    <form:form id="repastFoodForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>菜品名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="foodName" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>菜品类目:</label>
		            </td>
					<td class="width-35">
						<%--<form:select path="typeId" htmlEscape="false" class="form-control"    datatype="*"    />--%>
						<form:select path="typeId" id="typeId" cssClass="form-control">
							<form:option value="">无</form:option>
							<form:options items="${typeId}" itemLabel="typeName" itemValue="id"/>
						</form:select>
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>价格:</label>
		            </td>
					<td class="width-35">
						<form:input path="price" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>菜品描述:</label>
		            </td>
					<td class="width-35">
						<form:input path="foodDesc" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
		      
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
</body>
</html>