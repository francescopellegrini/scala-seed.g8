package io.github.francescopellegrini.$name;format="word,lower"$

import org.scalatest.{AsyncWordSpecLike, Matchers, WordSpecLike}

trait SuiteOps extends Matchers

/**
  * Base trait for test suites
  */
trait Suite extends WordSpecLike with SuiteOps

/**
  * Base trait for async test suites
  */
trait AsyncSuite extends AsyncWordSpecLike with SuiteOps
