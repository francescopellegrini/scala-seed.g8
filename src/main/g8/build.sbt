import Dependencies._
import ReleaseTransformations._

addCommandAlias("fix", "all compile:scalafix test:scalafix")
addCommandAlias("fixCheck", "; compile:scalafix --check ; test:scalafix --check")

lazy val compileSettings = Seq(
  Compile / compile := (Compile / compile)
    .dependsOn(
      Compile / scalafmtSbt,
      Compile / scalafmtAll
    )
    .value,
  scalaVersion := Versions.Scala
) ++ CompilerPlugins.compilerPlugins

lazy val dependenciesSettings = Seq(
  excludeDependencies ++= excludeDeps,
  libraryDependencies ++= prodDeps ++ testDeps,
  ThisBuild / scalafixDependencies ++= scalafixDeps,
  resolvers ++= CustomResolvers.resolvers
)

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

lazy val integrationTestSettings = Defaults.itSettings ++ Seq(
  IntegrationTest / logBuffered := false,
  IntegrationTest / parallelExecution := false
) ++ inConfig(IntegrationTest)(org.scalafmt.sbt.ScalafmtPlugin.scalafmtConfigSettings)

lazy val root = (project in file("."))
  .settings(
    name := "$name;format="normalize"$",
    organization := "$package$"
  )
  .settings(compileSettings: _*)
  .settings(dependenciesSettings: _*)
  .settings(publishSettings: _*)
  .settings(testSettings: _*)
  .configs(IntegrationTest)
  .settings(integrationTestSettings: _*)

/**
  * sbt-native-packager plugin
  */
enablePlugins(JavaAppPackaging, DockerPlugin) // Add AshScriptPlugin if base image is Alpine, i.e. misses bash

dockerBaseImage := "openjdk:8-jre-alpine"
maintainer in Docker := "Francesco Pellegrini"
//dockerExposedPorts := Seq()

// Remove the top level directory for universal package
topLevelDirectory := None
