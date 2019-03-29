import sbt._

object Dependencies {

  object CustomResolvers {

    lazy val resolvers: Seq[Resolver] = Nil

  }

  object Version {

    lazy val Scala          = "2.12.8"
    lazy val LogbackClassic = "1.2.3"
    lazy val PureConfig     = "0.10.2"
    lazy val ScalaLogging   = "3.9.2"
    lazy val ScalaTest      = "3.0.7"
//    lazy val Slf4j          = "1.7.26"

  }

  object Logging {

    lazy val prodDeps: Seq[ModuleID] = Seq(
      "ch.qos.logback"             % "logback-classic"  % Version.LogbackClassic, // required by scala-logging
      "com.typesafe.scala-logging" %% "scala-logging"   % Version.ScalaLogging
//      "org.slf4j"                  % "log4j-over-slf4j" % Version.Slf4j // mandatory when log4j gets excluded
    )

    lazy val excludeDeps: Seq[ExclusionRule] = Seq(
//      ExclusionRule("org.slf4j", "slf4j-log4j12")
//      ExclusionRule("log4j", "log4j")
    )

  }

  lazy val prodDeps: Seq[ModuleID] = Seq(
    "com.github.pureconfig" %% "pureconfig" % Version.PureConfig
  ) ++ Logging.prodDeps

  lazy val testDeps: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % Version.ScalaTest
  ).map(_ % Test)

  lazy val excludeDeps: Seq[ExclusionRule] = Nil ++ Logging.excludeDeps

}
