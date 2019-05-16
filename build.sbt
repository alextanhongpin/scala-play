name := """play-scala-seed"""
organization := "com.alextanhongpin"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.alextanhongpin.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.alextanhongpin.binders._"
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

// Enable bash for alpine docker build.
/* enablePlugins(AshScriptPlugin) */

/* dockerBaseImage       := "openjdk:jre-alpine" */
dockerBaseImage       := "openjdk:jre"
/* mainClass in Compile := Some("com.alextanhongpin.QuickstartServer") */

dockerExposedPorts ++= Seq(9000, 9001)
dockerExposedUdpPorts += 4444
