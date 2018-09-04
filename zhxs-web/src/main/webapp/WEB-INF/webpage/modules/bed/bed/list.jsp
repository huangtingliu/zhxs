<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>床位列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="床位">
<grid:grid id="bedGridId" url="${adminPath}/bed/bed/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button groupname="opt" function="delete" />--%>
    <grid:column label="床位编号"  name="bedNo"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="床位类型"  name="bedType"  query="true"  queryMode="select"  condition="eq"  dict="bed_type"/>
	<%--<grid:toolbar function="create"/>--%>
	<grid:toolbar function="update"/>
	<%--<grid:toolbar function="delete"/>--%>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>