
name := "PQ2NT"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.0",
  "org.apache.spark" %% "spark-sql" % "2.4.0"
)
libraryDependencies += "org.xerial.snappy" % "snappy-java" % "1.1.8.4" % "test"

libraryDependencies += "org.apache.jena" % "apache-jena-libs" % "3.13.1" // exclude("org.slf4j", "slf4j-api" )

// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.0"
