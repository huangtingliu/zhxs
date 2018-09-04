<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>楼层列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="楼层">
<grid:grid id="bedFloorGridId" url="${adminPath}/floor/bedfloor/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<%--<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>--%>
	<%--<grid:button groupname="opt" function="delete" />--%>
    <grid:column label="楼层"  name="floor" />
    <grid:column label="楼层编号"  name="floorNo" />
    <grid:column label="房间数"  name="roomNumber" />
    <grid:column label="区域类别"  name="areaType"  query="true"  queryMode="select"  condition="eq"  dict="floor_area_type"/>
    <grid:column label="楼宇"  name="houseName" />
    <grid:column label="楼宇"  name="houseId" hidden="true" query="true" queryMode="select" condition="eq" formatterValue="${houseName}"/>
	<%--<grid:toolbar function="create"/>--%>
	<grid:toolbar function="update"/>
	<%--<grid:toolbar function="delete"/>--%>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>