package io.github.francescopellegrini.$name;format="word,lower"$.config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

final case class AppConfig(
    db: DbConfig
)

object AppConfig {

  def apply(): AppConfig = ConfigSource.default.loadOrThrow[AppConfig]

}
