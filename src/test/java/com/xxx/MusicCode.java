package com.xxx;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.junit.platform.commons.util.StringUtils;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

public class MusicCode {
    public static void main(String[] args) {

        // 数据库配置
        DataSourceConfig dataSourceConfig =
                new DataSourceConfig
                        .Builder("jdbc:mysql://localhost:3306/tp_music?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456")
                        .dbQuery(new MySqlQuery())
                        .build();

        // 创建代码生成器对象
        AutoGenerator generator = new AutoGenerator(dataSourceConfig);


        // 全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig
                .Builder()
                .fileOverride()
//                .outputDir(scanner("请输入你的项目路径") + "/src/main/java")
                .outputDir(projectPath + "/src/main/java")
                .author("公瑾")
                .disableOpenDir()
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();

        generator.global(globalConfig);

        // 包配置
        PackageConfig packageConfig
                = new PackageConfig
                .Builder()
                .parent("com.xxx")
                .moduleName("customer")
                .entity("pojo")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper")
                .controller("controller")
                .build();

        generator.packageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .addInclude("list_song")
                // .addTablePrefix("")  // 去掉表中前缀
                .build();

        strategyConfig.entityBuilder()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleted")
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                .idType(IdType.AUTO)
                .formatFileName("%s")
                .build();

        strategyConfig.controllerBuilder()
                .enableRestStyle()
                .formatFileName("%sController")
                .enableHyphenStyle()
                .build();

        strategyConfig.serviceBuilder()
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImpl")
                .build();

        strategyConfig.mapperBuilder()
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper")
                .build();

        generator.strategy(strategyConfig);

        generator.execute();

    }


//    // 读取控制台内容
//    private static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入"+tip+":");
//        System.out.println(help.toString());
//        if (scanner.hasNext()){
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)){
//                return ipt;
//            }
//        }
//        throw  new MybatisPlusException("请输入正确的"+tip+"!");
//    }
}
