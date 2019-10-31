package io.github.francescopellegrini.$name;format="word,lower"$.config

import pureconfig.generic.auto._

final case class AppConfig(
  db: DbConfig
)

object AppConfig {

  def apply(): AppConfig = pureconfig.loadConfigOrThrow[AppConfig]

}
