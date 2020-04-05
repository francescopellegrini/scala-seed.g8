package $package$.$name;format="word,lower"$

import com.typesafe.scalalogging.LazyLogging
import $package$.$name;format="word,lower"$.config.AppConfig

/**
  * Application entrypoint
  */
object Main extends App with LazyLogging {
  logger.info("Starting up")

  val config = AppConfig()

  logger.debug(s"Configuration loaded", config)

  logger.info("Shutting down")
}
