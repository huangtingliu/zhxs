<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>member_health</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="memberHealthForm">
    <form:form id="memberHealthForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>自理情况:</label>
		            </td>
					<td class="width-35">
						<form:select path="selfCare" htmlEscape="false" class="form-control"  dict="self_care"  datatype="*"  nullmsg="自理情况不能为空"  />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>视力:</label>
		            </td>
					<td class="width-35">
						<form:input path="vision" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>主治医院:</label>
		            </td>
					<td class="width-35">
						<form:input path="mainHospital" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>主治医师:</label>
		            </td>
					<td class="width-35">
						<form:input path="mainPhysician" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>医院电话:</label>
		            </td>
					<td class="width-35">
						<form:input path="hospitalPhone" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>过敏药物:</label>
		            </td>
					<td class="width-35">
						<form:input path="drugAllergy" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>疾病:</label>
		            </td>
					<td class="width-35">
						<form:checkboxes path="disease" htmlEscape="false" class="form-control"        />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>入驻前病史:</label>
		            </td>
					<td class="width-35">
						<form:textarea path="diseaseHistory" rows="4" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>听力:</label>
		            </td>
					<td class="width-35">
						<form:input path="hearing" htmlEscape="false" class="form-control"      />
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