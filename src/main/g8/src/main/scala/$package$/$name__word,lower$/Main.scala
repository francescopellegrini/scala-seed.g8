package $package$.$name;format="word,lower"$

import com.typesafe.scalalogging.LazyLogging
import $package$.$name;format="word,lower"$.config.AppConfig

/**
  * Application entrypoint
  */
object Main extends LazyLogging {

  def main(args: Array[String]): Unit = {
    logger.info("Starting up")

    AppConfig.load.fold(
      errors => logger.error(s"Error loading configuration: \${errors.prettyPrint()}"),
      config => logger.debug(s"Configuration loaded", config)
    )

    logger.info("Shutting down")
  }
}
