package com.ywh.cloudcore.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * CreateTime: 2019-06-16 20:46
 * ClassName: CodeGenerator
 * Package: com.ywh.common.utils
 * Describe:
 * MybatisPlus的代码生成器
 *
 * @author YWH
 */
public class CodeGenerator {

    private static  GlobalConfig gc = new GlobalConfig();

    /**
     * 代码生成器
     */
    private static AutoGenerator mpg = new AutoGenerator();
    /**
     * 数据源配置
     */
    private static DataSourceConfig dsc = new DataSourceConfig();
    /**
     * 策略配置
     */
    private static StrategyConfig strategy = new StrategyConfig();
    /**
     * 包配置
     */
    private static PackageConfig pc = new PackageConfig();
    /**
     * 以下变量都是多变的变量配置在配置文件中
     */
    private static String outPutDir;
    private static boolean fileOverride = false;
    private static String url;
    private static String driverClass;
    private static String userName;
    private static String passWord;
    private static String setParent;
    private static String mapperPath;
    private static String projectPath;


    static{
        // 获取myBatisPlus的配置文件
        ResourceBundle resource = ResourceBundle.getBundle("myBatisPlus");
        outPutDir = resource.getString("outputDir");

        String flag = "true";
        String fileOverrideString = "fileOverride";
        if(flag.equals(resource.getString(fileOverrideString))){
            fileOverride = true;
        }
        url = resource.getString("url");
        driverClass = resource.getString("driverClass");
        userName = resource.getString("userName");
        passWord = resource.getString("passWord");
        setParent = resource.getString("setParent");
        mapperPath = resource.getString("mapperPath");
        // 生成的文件输出到哪
        projectPath = System.getProperty("user.dir");
    }

    /**
     * 获取控制台上的内容
     * @return 要生成代码的表名
     */
    private static String scanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + "表名" + ":"));
        if(scanner.hasNext()){
            String ipt = scanner.next();
            if(StringUtils.isNotEmpty(ipt)){
                //输入的不是空就返回
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + "表名" +"! ");
    }

    public static void main(String[] args) {

        // 全局配置
        customGlobalConfig();

        // 数据源配置
        customDataSourceConfig();

        // 包配置
        customPackageConfig();

        //模板配置
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/controller.java")
                .setEntity("/templates/entity.java")
                .setMapper("/templates/mapper.java")
                .setService("/templates/service.java")
                .setServiceImpl("/templates/serviceImpl.java")
                .setXml(null);
        mpg.setTemplate(tc);

        // 策略配置
        customStrategy();
    }


    /**
     * 全局配置
     */
    private static void customGlobalConfig(){
        gc.setOutputDir(projectPath + outPutDir);
        gc.setIdType(IdType.AUTO);
        gc.setOpen(false);
        gc.setFileOverride(fileOverride);
        gc.setAuthor("YWH");
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);

        gc.setEntityName("%sEntity");
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
    }

    /**
     * 数据源配置
     */
    private static void customDataSourceConfig(){
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(url);
        dsc.setDriverName(driverClass);
        dsc.setUsername(userName);
        dsc.setPassword(passWord);
        mpg.setDataSource(dsc);
    }

    /**
     * 策略配置
     */
    private static void customStrategy(){
        // 下划线到驼峰的命名方式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 使用lombok
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner());
        strategy.setControllerMappingHyphenStyle(true);
        // 继承自定义的controller，service，impl，entity
        strategy.setSuperControllerClass("com.ywh.common.base.BaseController");
        strategy.setSuperServiceClass("com.ywh.common.base.BaseService");
        strategy.setSuperServiceImplClass("com.ywh.common.base.BaseServiceImpl");
        strategy.setSuperMapperClass("com.ywh.common.base.BaseDao");
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setStrategy(strategy);
        mpg.execute();
    }

    /**
     * 包配置
     */
    private static void customPackageConfig(){
        pc.setParent(setParent);
        pc.setMapper("entity")
                .setService("service")
                .setController("controller")
                .setEntity("entity");
        mpg.setPackageInfo(pc);
        //自定义配置
        if(StringUtils.isNotEmpty(mapperPath)){
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            List<FileOutConfig> focList = new ArrayList<>();
            //mapper.xml
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return projectPath + mapperPath
                            + tableInfo.getMapperName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
        }
    }


}
