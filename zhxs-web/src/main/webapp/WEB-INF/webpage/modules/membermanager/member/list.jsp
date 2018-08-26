<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>member列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="member">
<grid:grid id="memberGridId" url="${adminPath}/membermanager/member/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<%--<grid:button groupname="opt" function="detail" title="详情"/>--%>
    <grid:column label="姓名"  name="memberName"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="电话"  name="phone"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="身份证"  name="idCard"  query="true"  queryMode="input"  condition="like" />
    <grid:column label="创建时间"  name="createTime" />
    <grid:column label="生日"  name="birthday" />
    <grid:column label="性别"  name="sex"  query="true"  queryMode="select"  condition="eq"  dict="sex"/>
    <grid:column label="入住日期"  name="liveTime"  query="true"  queryMode="date"  condition="between" />

    <grid:column label="不完整档案"  name="incompleteInfo"  query="true" queryMode="select" dict="sf" hidden="true"/>
    <%--<grid:query label="信息不完整档案" name="incompleteInfo" queryMode="hidden" query="true"></grid:query>--%>
	<grid:toolbar function="openAdd" title="添加" url="${adminPath}/membermanager/member/create" btnclass="btn-primary" icon="fa-plus"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	<grid:button groupname="opt" title="登记" function="openEdit" outclass="btn-success" innerclass="fa-file-text-o"
                 url="${adminPath}/membermanager/member/"/>

	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
<script src="${staticPath}/common/js/contabs.js"></script>
<script>
    function openAdd(title,url,gridId,id,width,height){
        openTab(url,title, true);
    }
    function openEdit(title,url,gridId,id,width,height){
        openTab(url+id+'/toCheckIn',title, true);
    }
</script>
</body>
</html>