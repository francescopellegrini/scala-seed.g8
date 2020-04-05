import sbt._

object Dependencies {

  object CustomResolvers {

    lazy val resolvers: Seq[Resolver] = Nil

  }

  object Versions {

    val Scala               = "$scala_version$"
    val ScalafixSortImports = "0.3.2"
    val LogbackClassic      = "1.2.3"
    val PureConfig          = "0.12.3"
    val ScalaLogging        = "3.9.2"
    val ScalaTest           = "$scalatest_version$"
//    val Slf4j               = "1.7.30"

  }

  object Logging {

    lazy val prodDeps: Seq[ModuleID] = Seq(
      "ch.qos.logback"             % "logback-classic" % Versions.LogbackClassic, // required by scala-logging
      "com.typesafe.scala-logging" %% "scala-logging"  % Versions.ScalaLogging
//      "org.slf4j"                  % "log4j-over-slf4j" % Versions.Slf4j // mandatory when log4j gets excluded
    )

    lazy val excludeDeps: Seq[ExclusionRule] = Seq(
//      ExclusionRule("org.slf4j", "slf4j-log4j12")
//      ExclusionRule("log4j", "log4j")
    )

  }

  lazy val scalafixDeps: Seq[ModuleID] = Seq(
    "com.nequissimus" %% "sort-imports" % Versions.ScalafixSortImports
  )

  lazy val prodDeps: Seq[ModuleID] = Seq(
    "com.github.pureconfig" %% "pureconfig" % Versions.PureConfig
  ) ++ Logging.prodDeps

  lazy val testDeps: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % Versions.ScalaTest
  ).map(_ % Test)

  lazy val excludeDeps: Seq[ExclusionRule] = Nil ++ Logging.excludeDeps

}
