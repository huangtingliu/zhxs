<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>菜品类目列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="菜品类目">
<grid:grid id="repastFoodTypeGridId" url="${adminPath}/foodtype/repastfoodtype/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/foodtype/repastfoodtype/delete" />--%>
    <grid:column label="类目名称"  name="typeName" />
    <grid:column label="价格区间"  name="priceRange" />
    <grid:column label="价格描述"  name="typeDesc" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>