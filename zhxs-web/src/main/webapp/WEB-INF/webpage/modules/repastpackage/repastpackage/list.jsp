<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>饮食套餐列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="饮食套餐">
<grid:grid id="repastPackageGridId" url="${adminPath}/repastpackage/repastpackage/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/repastpackage/repastpackage/delete" />--%>
    <grid:column label="套餐名称"  name="packageName"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="菜品类目搭配"  name="foodTypeDesc" />
    <grid:column label="价格区间（元）"  name="priceRange" />
    <grid:column label="收费标准（元/月）"  name="price" />
    <grid:column label="套餐描述"  name="packageDesc" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>