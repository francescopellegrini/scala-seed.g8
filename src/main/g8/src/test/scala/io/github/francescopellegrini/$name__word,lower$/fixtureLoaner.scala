package io.github.francescopellegrini.$name;format="word,lower"$

import org.scalatest.Assertion

import scala.concurrent.Future

trait FixtureLoanerLike[FixtureParam, Outcome] {

  def withFixture(body: FixtureParam => Outcome): Outcome

}

/**
  * Loan pattern for tests.
  *
  * Example of implementation:
  *
  * {
  *   // build resources
  *   val fixture = ...
  *
  *   try {
  *     body(fixture)
  *   } finally {
  *     // clean up resources
  *     ...
  *   }
  * }
  *
  * @tparam FixtureParam
  */
trait FixtureLoaner[FixtureParam] extends FixtureLoanerLike[FixtureParam, Assertion]

/**
  * Loan pattern for async tests.
  *
  * Example of implementation:
  *
  * {
  *   // build resources
  *   val fixture = ...
  *
  *   val result = body(fixture)
  *
  *   result.onComplete {
  *     // clean up resources
  *     ...
  *   }
  *
  *   result
  * }
  *
  * @tparam FixtureParam
  */
trait AsyncFixtureLoaner[FixtureParam] extends FixtureLoanerLike[FixtureParam, Future[Assertion]]
