# Install Sunloginclient

when sunloginclient is installed successfully, we also need to execute the following commands to start the service so that the software runs.

```shell
Start SunloginClient Service
$ systemctl start runsunloginclient
Enable Remote Control
$ xhost +
```

# python virutal

启动virtual

```shell
$ source /usr/bin/virtualenvwrapper.sh
```

进入指定的虚拟环境

```shell
$ workon envname
```

退出环境

```shell
$ deactivate
```

