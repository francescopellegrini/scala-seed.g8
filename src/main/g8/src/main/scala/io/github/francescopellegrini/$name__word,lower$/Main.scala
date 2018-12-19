package io.github.francescopellegrini.$name;format="word,lower"$

import io.github.francescopellegrini.$name;format="word,lower"$.config.AppConfig
import com.typesafe.scalalogging.LazyLogging
import pureconfig.generic.auto._

/**
  * Application entrypoint
  */
object Main extends App with LazyLogging {
  logger.info("Starting up")

  val config = pureconfig.loadConfigOrThrow[AppConfig]

  logger.debug(s"Configuration loaded", config)

  logger.info("Shutting down")
}
