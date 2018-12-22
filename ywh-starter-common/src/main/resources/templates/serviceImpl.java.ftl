package ${package.ServiceImpl};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Mapper}.${table.mapperName};


/**
 * CreateTime: ${date}
 * ClassName: ${table.serviceImplName}
 * Package: ${package.ServiceImpl}
 * Describe:
 * ${table.comment!} 业务逻辑接口的实现类
 * @author YWH
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    private static final Logger log = LoggerFactory.getLogger(${table.serviceImplName}.class);

    @Autowired
    private ${table.mapperName} dao;

}
