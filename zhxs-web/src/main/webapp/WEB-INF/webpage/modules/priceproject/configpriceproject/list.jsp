<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>费用项目列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="费用项目">
<grid:grid id="configPriceProjectGridId" url="${adminPath}/priceproject/configpriceproject/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="费用项目"  name="projectName"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="费用子项"  name="priceItems" />
    <grid:column label="费用类别"  name="priceType"  dict="price_type"/>
    <grid:column label="收费标准"  name="price" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>