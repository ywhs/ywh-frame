
# YwhFrame

ywh个人学习开发框架，搭建笔记：[SpringBoot2.1个人开发框架](https://blog.csdn.net/qq_36956154/article/details/84036199)

## 整合

- 数据连接池 Druid
- 使用MyBatisPlus作为持久层
- 集成Redis
- 实现SpringSecurity作为安全框架管理账户

## 环境

- JDK1.8
- mysql
- Redis  ====> 安装参考笔记:[Redis学习 安装与简单命令的使用（一）](https://blog.csdn.net/qq_36956154/article/details/84339285) 
- node.js ====> 安装参考笔记:[node.js 安装与环境变量配置](https://blog.csdn.net/qq_36956154/article/details/79468078)


## 启动

- 创建数据库导入表结构
```bash
在项目根目录中有sys_user.sql文件，在mysql数据库中创建ywh_code数据库，并导入该sql文件即可。
```

- 前端启动服务
```bash
# 克隆项目
git clone https://github.com/ywhs/YwhFrame.git

# 进入前端项目目录安装依赖
cd ywh-vue-admin
npm install

# 建议不要用 cnpm 安装 会有各种诡异的bug 可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动前端服务
npm run dev

```
浏览器访问http://localhost:9527
前端开发我是使用vscode开发


- 后端启动服务

```bash

# 使用IDEA导入项目，选择maven导入

# 找到ywh-starter-core中\src\main\java\com\ywh\core\CoreApplication.java启动类，启动即可
# 或者右上角有绿色三角启动

```

如果redis的登陆密码没有或者不是123456，可在\YwhFrame\ywh-starter-cache\src\main\resources\application-redis.yml中修改


## 部署

暂时多模块的SpringBoot项目部署还没有研究，
