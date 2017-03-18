# spring-netflix-docker
spring-netflix-docker deploy example

## normal deploy
```
git clone https://github.com/cyuanxin/spring-netflix-docker.git
cd spring-netflix-docker/eureka-server
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=peer1"
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=peer2"
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=peer3"
```

> Open the browser, enter "localhost:8761" or "localhost:8762" or "localhost:8763"  , check whether the correct start
> Enter the project client
```
 mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=client1"
 mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=client1"
  ```
 > run client nodes

 > Open the browser, enter "localhost:8761" or "localhost:8762" or "localhost:8763"  , can see two instances of client and three instances of eureka-server

## docker deploy
> enter eureka-server
  ```
mvn package docker:build
  ```
> enter client
```
mvn package docker:build
docker run -e "SPRING_PROFILES_ACTIVE=peer1" -net=host -t fsp/eureka-server
docker run -e "SPRING_PROFILES_ACTIVE=peer2" -net=host -t fsp/eureka-server
docker run -e "SPRING_PROFILES_ACTIVE=peer3" -net=host -t fsp/eureka-server
docker run -e "SPRING_PROFILES_ACTIVE=client1" --net=host fsp/client
docker run -e "SPRING_PROFILES_ACTIVE=client2" --net=host fsp/client
```
