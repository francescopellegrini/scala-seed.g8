package io.github.francescopellegrini.$name;format="word,lower"$

import org.scalatest.{AsyncTestSuite, TestSuite}
import org.scalatest.matchers.should.Matchers

trait SuiteOps extends Matchers

/**
  * Base trait for test suites
  */
trait Suite extends SuiteOps {
  this: TestSuite =>
}

/**
  * Base trait for async test suites
  */
trait AsyncSuite extends SuiteOps {
  this: AsyncTestSuite =>
}
