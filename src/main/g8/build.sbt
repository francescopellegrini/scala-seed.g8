import Dependencies._

lazy val compileSettings = Seq(
  scalacOptions ++= Seq("-deprecation",
    "-encoding", "utf8",
    "-Xlint:missing-interpolator",
    "-Xlint:private-shadow",
    "-Xlint:type-parameter-shadow",
    "-Ywarn-dead-code",
    "-Ywarn-unused"
  ),
  scalafmtOnCompile := true,
  scalaVersion := Version.Scala
)

lazy val dependenciesSettings = Seq(
  excludeDependencies ++= excludeDeps,
  libraryDependencies ++= prodDeps ++ testDeps,
  resolvers ++= CustomResolvers.resolvers
)

import ReleaseTransformations._

lazy val publishSettings = Seq(
  Test / publishArtifact := false,
  releaseProcess := Seq[ReleaseStep](
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    setNextVersion,
    commitNextVersion,
    pushChanges
  )
)

lazy val testSettings = Seq(
  Test / logBuffered := false,
  Test / parallelExecution := false
)

lazy val root = (project in file("."))
  .settings(
    name := "$name;format="normalize"$",
    organization := "io.github.francescopellegrini"
  )
  .settings(compileSettings: _*)
  .settings(dependenciesSettings: _*)
  .settings(publishSettings: _*)
  .settings(testSettings: _*)

/**
  * sbt-native-packager plugin
  */
enablePlugins(JavaAppPackaging, DockerPlugin) // Add AshScriptPlugin if base image is Alpine, i.e. misses bash

dockerBaseImage := "openjdk:8-jre-alpine"
maintainer in Docker := "Francesco Pellegrini"
//dockerExposedPorts := Seq()
