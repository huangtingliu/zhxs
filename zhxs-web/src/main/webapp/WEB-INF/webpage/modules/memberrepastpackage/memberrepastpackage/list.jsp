<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>会员餐饮套餐信息列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="会员餐饮套餐信息">
<grid:grid id="memberRepastPackageGridId" url="${adminPath}/memberrepastpackage/memberrepastpackage/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="套餐id"  name="packageId" />
    <grid:column label="收费标准"  name="price" />
    <grid:column label="套餐详情"  name="packageDetail" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>