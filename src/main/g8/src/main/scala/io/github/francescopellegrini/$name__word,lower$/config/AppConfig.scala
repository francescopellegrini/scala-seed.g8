package io.github.francescopellegrini.$name;format="word,lower"$.config

import pureconfig.generic.auto._

final case class AppConfig(
  dao: DaoConfig
)

object AppConfig {

  def load: AppConfig = pureconfig.loadConfigOrThrow[AppConfig]

}
