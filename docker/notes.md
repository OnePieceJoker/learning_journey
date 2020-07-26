## docker

run mysql image
> docker run -d --rm --name mysql57 -v F:\docker\mysql:/var/lib/mysql -v F:\docker\mysqlConf:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=PASSWORD -p 3306:3306 mysql:5.7

run redis image
> docker run -d -p 6379:6379 --name redis-server redis redis-server --appendonly ye

## 在WSL中安装docker

```text
Linux version: Ubuntu 20.04 LTS

sudo apt-get install software-properties-common
```
