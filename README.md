```
# Install sbt
$ brew install sbt

# Scala seed template
$ sbt new playframework/play-scala-seed.g8

$ sbt
# Inside sbt
$ ~run

# Build docker 
$ sbt docker:publishLocal
```

References:
- https://medium.com/jeroen-rosenberg/lightweight-docker-containers-for-scala-apps-11b99cf1a666
- http://guilhebl.github.io/scala/backend/docker/play/2017/08/23/scala-play-docker-sbt-native-packager-example/

## Dockerizing

At `project/plugins.sbt`, add the following:

```
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.1")
```

Enable two plugins in `build.sbt`:
```
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
```


## Running Docker

If you hit this error:
```
Oops, cannot start the server.
  java.nio.file.AccessDeniedException: /opt/docker/RUNNING_PID
  ...
```
Set this `-Dplay.server.pidfile.path=/dev/null`:

```bash
$ docker run -d -p 9000:9000 play-scala-seed:1.0-SNAPSHOT  -Dplay.http.secret.key=ad31779d4ee49d5ad5162bf1429c32e2e9933f3b -Dplay.server.pidfile.path=/dev/null
```
