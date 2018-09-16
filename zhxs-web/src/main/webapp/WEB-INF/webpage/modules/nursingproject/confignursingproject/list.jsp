<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>护理项目配置列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="护理项目配置">
<grid:grid id="configNursingProjectGridId" url="${adminPath}/nursingproject/confignursingproject/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="护理项目"  name="nursingProject" />
    <grid:column label="项目描述"  name="projectDesc" />
    <grid:column label="收费标准"  name="price" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>