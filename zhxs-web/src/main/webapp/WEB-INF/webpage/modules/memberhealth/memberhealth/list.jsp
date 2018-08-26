<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>member_health列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="member_health">
<grid:grid id="memberHealthGridId" url="${adminPath}/memberhealth/memberhealth/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="health_id"  name="id" />
    <grid:column label="老人Id"  name="memberId" />
    <grid:column label="视力"  name="vision" />
    <grid:column label="主治医院"  name="mainHospital"  query="true"  queryMode="input"  condition="in" />
    <grid:column label="主治医师"  name="mainPhysician"  query="true"  queryMode="input"  condition="in" />
    <grid:column label="医院电话"  name="hospitalPhone"  query="true"  queryMode="input"  condition="in" />
    <grid:column label="过敏药物"  name="drugAllergy" />
    <grid:column label="入驻前病史"  name="diseaseHistory" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>