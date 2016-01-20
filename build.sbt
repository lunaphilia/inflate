
name := """inflate"""

version := "1.0"

scalaVersion := "2.11.7"

val forServer = Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.typesafe.play" % "play_2.11" % "2.4.6",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.scalikejdbc" % "scalikejdbc_2.11" % "2.3.4",
  "org.json4s" % "json4s-native_2.11" % "3.3.0")

lazy val server = (project in file("./server")).enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= forServer,
    routesGenerator := InjectedRoutesGenerator
  )

lazy val main = (project in file(".")).aggregate(server)

// Change this to another test framework if you prefer

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

