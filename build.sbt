name := "xke-lightbend-kstream"

maintainer := "Loïc DIVAD <ldivad@xebia.fr>"

description :=
  """
    |
  """.stripMargin

organizationHomepage := Some(url("http://blog.xebia.fr"))

coverageEnabled := true

val kafkaVersion = "1.0.0"
val cpVerison = "4.0.0"
val lbVersion = "0.1.0"

lazy val common = Seq(

  version := "0.1.0-SNAPSHOT",

  isSnapshot := false,

  scalaVersion := "2.12.4",

  organization := "fr.xebia",

  libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.1",
    "joda-time" % "joda-time" % "2.9.7",
    "com.sksamuel.avro4s" % "avro4s-core_2.12" % "1.8.0",
    "ch.qos.logback" % "logback-classic" % "1.2.0" force()
  ),

  logLevel in doc := Level.Error
)

lazy val `xke-lightbend-kstream` = (project in file("."))
  .aggregate(`kstream-java`, `kstream-scala`, `kstream-scala-ligthbend`)

lazy val `kstream-java` = project
  .settings(common: _*)
  .settings(kafkaDependencies: _*)

lazy val `kstream-scala` = project
  .settings(common: _*)
  .settings(kafkaDependencies: _*)

lazy val `kstream-scala-ligthbend` = project
  .settings(common: _*)
  .settings(lightbendDependencies: _*)

lazy val `lbs-business-api` = project
  .settings(common: _*)

lazy val `xke-bladibla-actors` = project
  .settings(common: _*)

lazy val kafkaDependencies = Seq(
  resolvers ++= Seq("confluent" at "http://packages.confluent.io/maven/"),

  libraryDependencies ++= Seq(
    "org.apache.kafka" % "kafka-clients" % kafkaVersion,
    "org.apache.kafka" % "kafka-streams" % kafkaVersion,
    "io.confluent" % "kafka-avro-serializer" % cpVerison,
    "io.confluent" % "kafka-streams-avro-serde" % cpVerison
  )
)

lazy val lightbendDependencies = Seq(

  libraryDependencies ++= Seq(
    "com.lightbend" %% "kafka-streams-scala" % lbVersion
  )

)

