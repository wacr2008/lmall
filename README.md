# 项目简介
基于SpringCloud的分布式电商购物商城 前后端分离 
前台商城:Vue全家桶 
后端服务:SpringCloud全家桶
## 使用技术
1. Hikari连接池:（号称java平台最快的,替换Druid）
2. undertow: (网上数据显示Undertow在性能和内存使用方面是最好的,替换Tomcat)
3. Mybatis-Plus
4. SpringCloud Eureka: 服务治理,用于服务注册发现
5. SpringCloud Feign: 分装了ribbon的使用，直接使用注解的方式，进行调用
6. SpringCloud Zuul : 网关服务，用来聚合和管理底层微服务接口
7. SpringCloud Config : 集中配置管理，整合各个微服务下的不同配置文件
## 项目分级
### 业务分级
此项目分为四个核心模块:
1. 用户模块(user-server):
2. 商品模块(goods-server):
3. 购物车模块(cart-server)
4. 订单模块(order-server):
5. 支付模块(pay-server):
6. 信息模块(message-server)
7. 网关模块(zuul-server)




