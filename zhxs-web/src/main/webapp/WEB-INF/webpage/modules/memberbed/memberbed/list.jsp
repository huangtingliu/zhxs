<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>会员床位信息列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="会员床位信息">
<grid:grid id="memberBedGridId" url="${adminPath}/memberbed/memberbed/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="房间类型"  name="roomType"  dict="room_type"/>
    <grid:column label="是否包房"  name="isPrivate"  dict="sf"/>
    <grid:column label="床位类型"  name="bedType"  dict="bed_type"/>
    <grid:column label="床位编号"  name="bedNo" />
    <grid:column label="床位费用"  name="bedPrice" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>