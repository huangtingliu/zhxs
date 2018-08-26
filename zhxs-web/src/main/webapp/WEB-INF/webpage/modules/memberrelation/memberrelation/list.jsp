<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>member_relation列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="member_relation">
<grid:grid id="memberRelationGridId" url="${adminPath}/memberrelation/memberrelation/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="姓名"  name="personName" />
    <grid:column label="电话"  name="phone" />
    <grid:column label="身份证"  name="idCard" />
    <grid:column label="联系地址"  name="address" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>