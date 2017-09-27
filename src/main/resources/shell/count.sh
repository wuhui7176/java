#!/usr/bin/env bash

# 统计3306 有多少连接数
while("true")
   do
        sleep 1
        netstat -apn |grep 3306 |wc -l
    done