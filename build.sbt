name := "xke-cloud-fighter"

maintainer := "Loïc DIVAD <ldivad@xebia.fr>"

description :=
  """
    |
  """.stripMargin

organizationHomepage := Some(url("http://blog.xebia.fr"))

coverageEnabled := true

val kafkaVersion = "1.0.1"
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
    "org.scalatest" %% "scalatest" % "3.0.5" % "test",
    "ch.qos.logback" % "logback-classic" % "1.2.0" force()
  ),

  logLevel in doc := Level.Error
)

lazy val `xke-cloud-fighter` = (project in file("."))
  .aggregate(`xcf-event-generator`, `xcf-stream-processing`, `xcf-batch-analytics`)

lazy val `xcf-event-generator` = project
  .settings(common: _*)

lazy val `xcf-stream-processing` = project
  .settings(common: _*)
  .settings(kafkaDependencies: _*)

lazy val `xcf-batch-analytics` = project
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

