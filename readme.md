# 目的 #
 
 通过Demo，演示jpa-redis操纵NoSQL数据库（Redis）
	
# 基本操作 #

## 0.安装redis server ##
	参考链接：http://jingyan.baidu.com/article/0f5fb099045b056d8334ea97.html

## 1.数据库定义DDL ##
### 1.1.自动生成DDL ###
	step1.在start.spring.io中生成一个支持spring-boot-starter-data-redis的demo；
	step2.在application.properties 中配置数据库ip、port、database、password；
	step3.在ProjectConfig.java中，配置ORM映射对应的domain model，配置RestTemplate。

## 2.数据库操纵DML ##
	step1.利用泛型，生成操作模型的RestTemplate（bean）；
	step2.使用RestTemplate的opsForValue方法，可以在内存中操作数据库对象（类似dao操作）；
	step3.opsForValue的操作方法是过程式的，可以通过封装成dao的操作类xxxRepository来，使得DML更加对象化。

# 多数据源&数据库连接 #

## 1.多数据源 ##
	step1.不同领域的模型，放在不同的package下；
	step2.每个数据源配置一个xxxConfig.java；
	step3.使用@Primary注解，定义有且仅有一个数据源为主数据源；
	step4.在confi.properties中配置多个数据库，使用前缀区分；
	step5.xxxConfig.java文件中，定义每个数据源ORM对应的模型的package名、数据库配置信息的前缀。


## 2.多数据库连接 ##
	似乎不用关注

# 事务 #
	ACID、事务性、回滚，需要充电

# 性能 #
	数据库的性能调优工具，需要持续去学习，加油

# 运维 #
	redis集群、主备倒换，不要气馁，未来你就是一个DBA，路还很长

# reference #
	http://jingyan.baidu.com/article/0f5fb099045b056d8334ea97.html
