import AssemblyKeys._

name := "purchasing-service"

scalaVersion in ThisBuild := "2.11.4"

lazy val buildSettings = Seq(
  organization := "com.blinkbox.books.agora",
  version := scala.io.Source.fromFile("VERSION").mkString.trim,
  scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-target:jvm-1.7", "-Xfatal-warnings", "-Xcheckinit", "-Xlint:-adapted-args"))

lazy val artifactSettings = addArtifact(artifact in (Compile, assembly), assembly).settings

lazy val common = (project in file("common")).settings(buildSettings: _*)

lazy val root = (project in file(".")).
  dependsOn(public, admin).aggregate(public, admin).
  settings(publish := {})

lazy val public = (project in file("public")).
  dependsOn(common % "compile->compile;test->test").aggregate(common).
  settings(aggregate in publish := false).
  settings(buildSettings: _*).
  settings(rpmPrepSettings: _*).
  settings(artifactSettings: _*).
  settings(publish := {})

lazy val admin = (project in file("admin")).
  dependsOn(common % "compile->compile;test->test").aggregate(common).
  settings(aggregate in publish := false).
  settings(buildSettings: _*).
  settings(rpmPrepSettings: _*).
  settings(artifactSettings: _*).
  settings(publish := {})
