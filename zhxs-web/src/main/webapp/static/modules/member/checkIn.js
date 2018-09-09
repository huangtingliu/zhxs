function toCheckIn(id,step){
    debugger
    window.location.href = adminPath+"/membermanager/member/"+id+"/toCheckIn?step="+step;
}

function submitCheckiInInit(func,selector){
    var element = selector ||$("#window-btn.layui-layer-btn a#btnOk");
    element.click(function(){
        doSubmit(func);
    });
}

function closeTabInit(func,selector){
    var element = selector ||$(".layui-layer-btn a#btnClose");
    element.click(function(){
        childCloseTab();
    });
}

