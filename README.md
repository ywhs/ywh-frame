
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

**注意**

在正式打包开始之前，要把后端数据库连接的IP地址、logback.xml的日志文件地址、redis的连接地址都要修改为自己服务器的相应IP和地址。
数据库连接地址我填的是内网地址，redis的我填的公网IP.

在打包前端项目之前需要修改 config->prod.env.js中的BASE_APIIP为自己服务器的IP地址，
我填的是公网IP，为了确保可以把dev.env.js中的BASE_API也修改了。


部署环境：
- 阿里云服务器（Centos7）
- Liunx安装docker：[centos7下Docker CE安装](https://juejin.im/post/5cad7187e51d456e651b644c#heading-5)
- Liunx安装mysql8.0 ：[docker安装mysql 8](https://www.jianshu.com/p/000fee62e786)
- Liunx安装Redis：[docker安装Redis](https://juejin.im/post/5cad7187e51d456e651b644c#heading-9)
- Liunx安装Nginx：[docker安装Nginx](https://juejin.im/post/5cad7187e51d456e651b644c#heading-7)

### 后端部署
后端是8082端口，所以要在阿里云的安全组中把8082端口开启。
这里以IDEA编辑器打包方式记录，使用IDEA编辑器中右边的Maven Projects先点击clean没有报错后点击package，
最上面的箭头点击后代表打包过程中跳过test阶段，记得点上。

![打包](https://user-images.githubusercontent.com/34649300/55859409-968b8180-5ba4-11e9-822e-29d2755d9ab8.png)

![打包成功](https://user-images.githubusercontent.com/34649300/55859037-bf5f4700-5ba3-11e9-9fbb-5a7cd8d30a62.png)

两个都点击后没有报错，正常打包成功会在core模块的target文件下有我们的jar包了，以artifactId和版本号命名。

![jar包](https://user-images.githubusercontent.com/34649300/55859625-0568da80-5ba5-11e9-969b-f839688f413a.png)

创建[Dockerfile](https://github.com/ywhs/ywh-frame/blob/master/ywh-starter-core/src/main/resources/Dockerfile)文件

```bash
# 基础镜像 表示基镜像是java8
FROM java:8
# 表示 指定临时文件目录为/tmp。其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp。该步骤是可选的
VOLUME /tmp
# 表示将jar包添加到镜像中，并重命名app.jar
ADD core-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
# 代表的是jvm的参数，如果有需要可以写在这里
ENV JAVA_OPTS=""
# 表示启动时运行 java -jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```

把jar包和Dockerfile文件上传到我们的服务器中，位置自己定，通过 rz 命令上传，这两个文件在同一个文件夹中就可以了。运行命令

```bash
# 在上传后的文件夹中开始构建，指定了镜像的名字为ywh-frame
$ docker build -t ywh-frame .
# 等待构建成功后，可通过命令查看
$ docker images
# 运行此镜像文件
$ docker run -d --name ywh-frame --restart always -p 8082:8082  -v /ywh/projectwork/spring/logs:/usr/local/logs  ywh-frame
```

### vue部署

```bash
$ npm install
$ npm run build
```

服务器上要安装Nginx，安装方法已经在笔记的开头有链接介绍,也是以docker来启动的，这时把生成的静态文件打包上传到Liunx服务器Nginx的root目录下即可，
主要是Nginx的安装和配置，页面无非是静态页面。


更详细的部署笔记：[使用docker打包与部署](https://blog.csdn.net/qq_36956154/article/details/89174804)


