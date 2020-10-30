# 学习实践记录

## 工具清单

| 依赖工具              | 用途         |
| --------------------- | ------------ |
| fastapi（python3.8+） | 后端接口实现 |
| pytest                | 单元测试     |
| sentry                | 异常监控     |
| Github Action         | CI/CD        |
| Vue 3.0 (typescript)  | 前端实现     |
| MongoDB               | 数据存储     |

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

