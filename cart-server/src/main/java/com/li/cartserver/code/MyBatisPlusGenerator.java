package com.li.cartserver.code;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author lihaodong
 * @Description
 * @Date 14:22 2019/1/21
 * @Param
 * @return
 **/

public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("/Users/lihaodong/Desktop/LiHaoDong/shop/cart-server/src/main/java");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);//生成基本的resultMap
        gc.setBaseColumnList(false);//生成基本的SQL片段
        gc.setAuthor("lihaodong");// 作者
        mpg.setGlobalConfig(gc);

        //2. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/shop");
        mpg.setDataSource(dsc);

        //3. 策略配置globalConfiguration中
        StrategyConfig strategy = new StrategyConfig();
        /**
         * @Author lihaodong
         * @Description 此处可以修改为您的表前缀
         * @Date 14:26 2019/1/21
         * @Param [args]
         * @return void
         **/
        strategy.setTablePrefix("sys_");
        /**
         * @Author lihaodong
         * @Description 表名生成策略
         * @Date 14:26 2019/1/21
         * @Param [args]
         * @return void
         **/
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.li.cartserver.model");
        /**
         * @Author lihaodong
         * @Description 需要生成的表
         * @Date 14:27 2019/1/21
         * @Param [args]
         * @return void
         **/
        strategy.setInclude("sys_shop_cart");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        //4. 包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.li.cartserver");
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }
}
