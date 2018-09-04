<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>房间列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="房间">
<grid:grid id="bedRoomGridId" url="${adminPath}/room/bedroom/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button groupname="opt" function="delete" />--%>
    <grid:column label="房间编号"  name="roomNo"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="房间类别"  name="roomType"  query="true"  queryMode="select"  condition="eq"  dict="room_type"/>
    <grid:column label="床位数"  name="bedNumber" />
    <grid:column label="护理类别"  name="nursingType"  query="true"  queryMode="input"  condition="eq"  dict="nursing_type"/>
	<%--<grid:toolbar function="create"/>--%>
	<grid:toolbar function="update"/>
	<%--<grid:toolbar function="delete"/>--%>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>