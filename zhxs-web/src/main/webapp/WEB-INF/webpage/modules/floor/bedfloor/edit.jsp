<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>楼层</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="bedFloorForm">
    <form:form id="bedFloorForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">
						<label><font color="red">*</font>楼宇:</label>
					</td>
					<td class="width-35">
						<c:if test="${empty data.houseId}">
							<form:select path="houseId" id="house_id" cssClass="form-control" onchange="loadFloorInfo(this)">
								<form:option value="">无</form:option>
								<form:options items="${bedHouses}" itemLabel="houseName" itemValue="id"/>
							</form:select>
						</c:if>
						<c:if test="${not empty data.houseId}">
							<form:select path="houseId" id="house_id" cssClass="form-control readonly" onchange="loadFloorInfo(this)" readonly="true" disabled="true">
								<form:option value="">无</form:option>
								<form:options items="${bedHouses}" itemLabel="houseName" itemValue="id"/>
							</form:select>
						</c:if>
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">
						<label><font color="red">*</font>区域类别:</label>
					</td>
					<td class="width-35">
						<form:select path="areaType" htmlEscape="false" class="form-control"  dict="floor_area_type"      />
						<label class="Validform_checktip"></label>
					</td>

				</tr>
				<tr>
					<td  class="width-15 active text-right">
						<label><font color="red">*</font>楼层:</label>
					</td>
					<td class="width-35">
						<form:input path="floor" htmlEscape="false" class="form-control" readonly="true" datatype="*"  />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">
						<label><font color="red">*</font>楼层编号:</label>
					</td>
					<td class="width-35">
						<form:input path="floorNo" htmlEscape="false" class="form-control" readonly="true" />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">
						<label><font color="red">*</font>房间数:</label>
					</td>
					<td class="width-35">
						<form:input path="roomNumber" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">
						<label>备注信息:</label>
					</td>
					<td class="width-35">
						<form:input path="remarks" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
		  		</tr>
		      
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
<script>
	function loadFloorInfo(obj){
		console.log(obj)
		console.log($(obj).val());
		if(!$(obj).val()){
		    $("#floor").val("");
		    $("#floorNo").val("");
		    return;
		}
		$.ajax({
			url:"${adminPath}/house/bedhouse/get",
			type:"post",
			data:{"id":$(obj).val()},
			dataType:"json",
			success:function(json){
			    if(json.ret==0){
					$("#floor").val(json.data.floorNumber+1+"层");
					$("#floorNo").val(json.data.floorNumber+1);
				}
			}
		});
	}
</script>
</body>
</html>