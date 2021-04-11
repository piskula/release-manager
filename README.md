# Release Manager
- works like a store for detailed versions of services under 1 global version number, which is increased on every change
  (on every deploy).

### How to start
1. start an instance of database, I used MariaDB, you can use [docker-compose](docker-compose.yaml) I prepared
  for starting it inside docker just by running `docker-compose up`
2. build the app by running `./gradlew clean build`, this will create a jar inside [build/libs](build/libs)
3. start the jar by running `java -jar build/libs/{name-of-the-jar}`, this should start the app on default port 8080

### How to run
you can call 2 endpoints, prefixed with `api/release/`:
* `POST` to `http://localhost:8080/api/release/deploy` with body
  ```json
  {
      "name": "Service A",
      "version": 1
  }
  ```
  which will respond with new/current system version number


* `GET` to `http://localhost:8080/api/release/services?systemVersion=1` which will respond with all services and their
  respective versions related to specified system version (in a query param)

### Limitations (what to fix, what is not covered although should be)
- no tests
- no proper exception handling and no exception serialization
- no detail documentation on endpoints (swagger?)
- business-logic limitation: for now, if there will be rollback (deploy with older version) this solution will need
  to be updated
- business-logic limitation: for now, you can also deploy newer version and then deploy older one which has not been
  deployed yet, but in such case [retrieval query](src/main/kotlin/sk/momosilabs/releasemanager/persistence/repository/service_version/ServiceVersionRepository.kt)
  needs to be changed.
