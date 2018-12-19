package io.github.francescopellegrini.$name;format="word,lower"$

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.{AsyncWordSpecLike, Matchers}

/**
  * Base trait for test classes.
  */
trait BaseSpec extends AsyncWordSpecLike with Matchers with LazyLogging
