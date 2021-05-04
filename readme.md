### set up local environment

``` sh
git clone https://github.com/navayuvan/kafka-spring-boot.git spring-kafka-trans
cd spring-kafka-trans
clear && mvn clean test spring-boot:run
```
### start zookeeper and kafka server
``` sh
cd /media/nandha/AppData/LinuxApps/kafka_2.13-2.7.0
bin/zookeeper-server-start.sh config/zookeeper.properties &
bin/kafka-server-start.sh config/server.properties &
```
### list all topic
``` sh
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```
### create necessary topic
``` sh
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic tmp --partitions 3
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic person --partitions 3
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic person_out --partitions 3
```
### start kafka consumer
``` sh
clear && bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic tmp --partition 2 --offset 2
clear && bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic person --partition 2 --offset 0
clear && bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic person_out --partition 2 --offset 0
```
### [approach1] commit a kafka transaction
``` sh
clear ; echo; echo; curl 'http://localhost:8080/send?key=nandha&value=kumar&fail=false'; echo; echo;
```
### [approach1] fail a kafka transaction
``` sh
clear ; echo; echo; curl 'http://localhost:8080/send?key=nandha&value=kumar&fail=true'; echo; echo;
```
### [approach2] commit a kafka transaction
``` sh
clear ; echo; echo; curl 'http://localhost:8080/send2?key=nandha&value=kumar&fail=false'; echo; echo;
```
### [approach2] fail a kafka transaction
``` sh
clear ; echo; echo; curl 'http://localhost:8080/send2?key=nandha&value=kumar&fail=true'; echo; echo;
```
### [streams] send data to streams
``` sh
clear ; echo; echo; curl --request POST --header 'Content-Type: application/json' --data-raw '{"firstname": "Nandha", "lastname": "Kumar", "username": "nandhaviswa", "email": "nandha@yopmail.com", "age": 27 }' 'http://localhost:8080/send3?key=nandha'; echo; echo;
```
### [cleanup] delete topic
``` sh
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic person,person_out,tmp
```
### [cleanup] stop kafka and zookeeper server
``` sh
bin/kafka-server-stop.sh
bin/zookeeper-server-stop.sh
```
