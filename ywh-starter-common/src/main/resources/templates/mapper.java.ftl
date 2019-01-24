package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.springframework.stereotype.Repository;



/**
 * CreateTime: ${date}
 * ClassName: ${table.mapperName}
 * Package: ${package.Mapper}
 * Describe:
 * ${table.comment!} Dao 接口
 * @author YWH
 */
@Repository
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
