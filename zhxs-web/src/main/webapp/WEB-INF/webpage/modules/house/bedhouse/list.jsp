<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>楼宇列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="楼宇">
<grid:grid id="bedHouseGridId" url="${adminPath}/house/bedhouse/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/house/bedhouse/delete" />--%>
    <grid:column label="楼宇名称"  name="houseName"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="楼层数"  name="floorNumber" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>