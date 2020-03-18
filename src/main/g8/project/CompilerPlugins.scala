import sbt._

object CompilerPlugins {

  lazy val compilerPlugins = Seq(
    addCompilerPlugin(scalafix.sbt.ScalafixPlugin.autoImport.scalafixSemanticdb)
  )

}
