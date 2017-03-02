# 目的 #
 
 通过Demo，演示jpa-MongoDB操纵NoSQL数据库（MongoDB）
	
# 基本操作 #

## 1.数据库定义DDL ##
### 1.1.自动生成DDL ###

## 2.数据库操纵DML ##

# 多数据源&数据库连接 #

## 1.多数据源 ##
- 当需要同时操纵多个数据库时，就需要多数据源。
- step1.在配置文件application.properties中配置多个数据库的url、username、password，通过键值来区分，例如本例中，project数据库的数据源的键值是"spring.datasource.project"，scenario数据库的数据源的键值是"spring.datasource.scenario"。
- step2.在DataSourceConfig.java中为每个数据源DataSource定义一个bean，使用@ConfigurationProperties(prefix="xxx")与step1中定义的数据源键值绑定。
- step3.每个数据源定义一个xxxConfig.java，用于定义该数据源的EntityManager、TransactionManager和映射的模型的package路径，hibernate启动时会扫描这个package下所有的模型来定义数据库。所以，不同数据库下的模型要放在不同的package下，例如本例中，project数据库的模型放在package com.huawei.domain.project，scenario数据库的模型放在package com.huawei.domain.scenario。

*遗留问题：
1.以上是静态配置多数据源，下一步要研究动态配置多数据源，包括动态创建数据库，动态配置数据源。
2.数据库必须先创建好，hibernate启动时才会建立数据源和数据连接，在import.sql中增加创建数据库的sql无效，因为hibernate启动的时候，是先扫描bean生成datasource，后执行import.sql。*

## 2.多数据库连接 ##
- 似乎不用关注

# 事务 #

# 性能 #

# 运维 #

# reference #
http://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features-mongodb
http://bolg.withword.com/2015/07/02/spring-boot-mongodb多数据源配置/
http://www.jincon.com/archives/95/
