# devnoh-spring-boot-cache

## Build
```
$ gradle build
```

## Run
```
$ gradle bootRun

or

$ java -jar ./build/libs/devnoh-spring-boot-cache-0.0.1-SNAPSHOT.jar
```

## Reference
* https://spring.io/guides/gs/caching/
* https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-caching.html


##### Spring Boot tries to detect the following providers (in this order):

* Generic
* JCache (JSR-107) (EhCache 3, Hazelcast, Infinispan, etc)
* EhCache 2.x
* Hazelcast
* Infinispan
* Couchbase
* Redis
* Caffeine
* Guava
* Simple