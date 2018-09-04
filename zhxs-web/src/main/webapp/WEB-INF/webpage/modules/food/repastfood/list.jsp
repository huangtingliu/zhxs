<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>菜品表列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="菜品管理">
<grid:grid id="repastFoodGridId" url="${adminPath}/food/repastfood/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button groupname="opt" function="delete" />--%>
    <grid:column label="菜品名称"  name="foodName"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="菜品类目"  name="typeName"  query="true"  queryMode="input"  condition="like"/>
    <grid:column label="价格"  name="price" />
    <grid:column label="菜品描述"  name="foodDesc" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>