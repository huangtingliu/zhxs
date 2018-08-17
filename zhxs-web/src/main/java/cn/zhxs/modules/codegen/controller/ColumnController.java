package cn.zhxs.modules.codegen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhxs.core.common.controller.BaseCRUDController;
import cn.zhxs.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.zhxs.modules.codegen.entity.Column;
@Controller
@RequestMapping("${admin.url.prefix}/codegen/column")
@RequiresPathPermission("codegen:column")
public class ColumnController extends BaseCRUDController<Column, String> {
 
}
