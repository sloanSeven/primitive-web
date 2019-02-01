name := """primitive-web"""
organization := "com.primitive"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(

guice,
// https://mvnrepository.com/artifact/com.google.guava/guava
"com.google.guava" % "guava" % "19.0",

)
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "1.0.0"

