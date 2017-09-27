#!/usr/bin/env bash


#awk 'NR>1{print $1}' 1.txt  取第二行开始


#awk '{RN>1}'

echo $@


ps -ef |grep java

ps -ef |grep java |awk '{print NR}'


ps -ef |grep java |awk '{for(i=0;i<NR;++i) ++sum}END {print sum}'




# wc   = wordcount
# wc -l 统计行数



