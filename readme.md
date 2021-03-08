### set up local environment

``` sh
git clone -b develop https://vault.sify.net/onesify/poc/streamprocessing.git spring-kafka-trans
cd spring-kafka-trans
```
### start zookeeper and kafka server
``` sh
bin/zookeeper-server-start.sh config/zookeeper.properties &
bin/kafka-server-start.sh config/server.properties &
```
### create necessary topic
``` sh
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic user --create
```
### start kafka consumer
``` sh
clear && bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic user
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
### [cleanup] delete topic
``` sh
clear && bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic user --delete
```
### [cleanup] stop kafka and zookeeper server
``` sh
bin/kafka-server-stop.sh
bin/zookeeper-server-stop.sh
```