# 学习实践记录

## 工具清单

| 依赖工具              | 用途         |
| --------------------- | ------------ |
| Pipenv                | 依赖包管理  |
| fastapi（python3.8+） | 后端接口实现 |
| pytest                | 单元测试     |
| sentry                | 异常监控     |
| Github Action         | CI/CD        |
| Vue 3.0 (typescript)  | 前端实现     |
| MongoDB               | 数据存储     |
| PostgreSQL            | 数据存储     |
| Prometheus            | 服务监控     |

### 工具安装使用

#### 自搭建sentry服务端（windows）

> docker desktop for windows 自带了 docker compose

- 拉取相应的镜像

  ```shell
  >$ docker pull sentry
  >$ docker pull redis
  >$ docker pull postgres
  ```

- 启动服务

  ```shell
  $ docker run -d --name sentry-redis --restart=always redis
  $ docker run -d --name sentry-postgres -e POSTGRES_PASSWORD=secret -e POSTGRES_USER=sentry --restart=always postgres
  ```

- 生成sentry密钥

  ```shell
  $ docker run --rm sentry config generate-secret-key
  ```

- 账户初始化(这一步在windows上卡了半天。。。)

  ```shell
  $ docker run -it --rm -e SENTRY_SECRET_KEY='2@by=5v8b=@j1gf533cxpfc6cy&o+@((_a^^s+b+mq9e1)=br%' --link sentry-postgres:postgres --link sentry-redis:redis sentry upgrade
  
  ```

- 服务启动

  ```shell
  $ docker run -d -p 9000:9000 --name my-sentry -e SENTRY_SECRET_KEY='2@by=5v8b=@j1gf533cxpfc6cy&o+@((_a^^s+b+mq9e1)=br%' --link sentry-redis:redis --link sentry-postgres:postgres --restart=always sentry
  $ docker run -d --name sentry-cron -e SENTRY_SECRET_KEY='2@by=5v8b=@j1gf533cxpfc6cy&o+@((_a^^s+b+mq9e1)=br%' --link sentry-postgres:postgres --link sentry-redis:redis sentry run cron
  $ docker run -d --name sentry-worker-1 -e SENTRY_SECRET_KEY='2@by=5v8b=@j1gf533cxpfc6cy&o+@((_a^^s+b+mq9e1)=br%' --link sentry-postgres:postgres --link sentry-redis:redis sentry run worker
  ```

#### 自搭建sentry服务端（Linux）

> 参考: https://develop.sentry.dev/self-hosted/

- 安装docker以及docker-compose

  ```text
  安装方式（以arch linux为例，更具体的安装方式可以通过搜索引擎解决，这里就不详细赘述）
  $ sudo pacman -S docker
  $ sudo pacman -S docker-compose
  ```

  > 注意：安装完成后重新启动下，后续在执行脚本时，报"Fail: Expected minimum RAM available to Docker to be 2400 MB but found MB"，后通过重启解决。如果报“Fail: Expected minimum RAM available to Docker to be 2400 MB but found 1024 MB"，说明docker提供的内存不够，要调整内存大小

- 从GitHub上clone下官方提供的[安装脚本项目](https://github.com/getsentry/onpremise)(可指定相应的版本)

  ```shell
  $ git clone -b <tags> git@github.com:getsentry/onpremise.git
  ```

- 执行 ***install.sh*** 脚本

  ```shell
  $ ./install.sh
  ```

- 等待脚本安装完成，中间会有提示需要初始化用户名和密码，供后续sentry服务端网页登录使用，然后执行 ***docker-compose up d*** 命令，创建并开启容器服务

  > Notes: 这里的操作要在git clone下来的目录中执行，本例是在./onpremise目录中

- 通过http://localhost:9000访问sentry

#### MongoDB (Docker)

> $ docker pull mongo
