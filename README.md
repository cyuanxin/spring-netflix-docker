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

> Open the browser, enter "localhost:8761" or "localhost:8762" or "localhost:8763"  , check whether the correct start .

> Enter the module client

```
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=client1"
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=client2"
```
> run client nodes

> Open the browser, enter "localhost:8761" or "localhost:8762" or "localhost:8763"  , can see two instances of client and three instances of eureka-server
 
> now we exposure external interface. enter module openAPI
  
```
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=openAPI1"
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=openAPI2"
```

> open the browser, enter "localhost:63793/hello" , you may see "HellWorld now env:client1" or "HellWorld now env:client2" in turn

## docker deploy
> enter eureka-server
```
mvn package docker:build
```
> enter client
```
mvn package docker:build
```
> enter openAPI
```
mvn package docker:build
```

```
docker run -e "SPRING_PROFILES_ACTIVE=peer1" --net=host -t fsp/eureka-server
docker run -e "SPRING_PROFILES_ACTIVE=peer2" --net=host -t fsp/eureka-server
docker run -e "SPRING_PROFILES_ACTIVE=peer3" --net=host -t fsp/eureka-server
docker run -e "SPRING_PROFILES_ACTIVE=client1" --net=host -t fsp/client
docker run -e "SPRING_PROFILES_ACTIVE=client2" --net=host -t fsp/client
docker run -e "SPRING_PROFILES_ACTIVE=openAPI1" --net=host -t fsp/openAPI
```
