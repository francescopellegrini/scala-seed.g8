package $package$.$name;format="word,lower"$.config

import pureconfig.ConfigReader.Result
import pureconfig.ConfigSource
import pureconfig.generic.auto._

final case class AppConfig(
    db: DbConfig
)

object AppConfig {

  def load: Result[AppConfig] = ConfigSource.default.load[AppConfig]

}
