package ${package.Controller};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${table.entityName};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * CreateTime: ${date}
 * ClassName: ${table.controllerName}
 * Package: ${package.Controller}
 * Describe:
 * ${table.comment!} 前端控制器
 * @author YWH
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if controllerMappingHyphenStyle??>${table.controllerName}<#else>${controllerMappingHyphen}</#if>")
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceName},${table.entityName}> {
<#else>
public class ${table.controllerName} {
</#if>
    private static final Logger log = LoggerFactory.getLogger(${table.controllerName}.class);
    @Autowired
    private ${table.serviceName} service;
}
