package io.github.francescopellegrini.$name;format="word,lower"$

import org.scalatest.Assertion

import scala.concurrent.Future

/**
 * Base trait for fixture loaners.
 *
 * Implement this as a case class, so it can be adapted to different scenarios
 * and it can be one-lined in tests.
 *
 * Example:
 *
 * {{{
 * "this test" should {
 *   "work" in MyFixtureLoaner(param1, param2).withFixture {
 *     case MyFixtureParam(foo, bar) =>
 *       // test body
 *   }
 * }
 * }}}
 *
 * @tparam FixtureParam The fixture to loan. Case classes are common implementations.
 * @tparam Outcome The result of the test. Could be [[Any]] or a more specific type.
 *                 Look at provided implementations as well.
 */
trait FixtureLoanerLike[FixtureParam, Outcome] {

  /**
   * Loans a fixture to a test, taking whole responsibility on its lifecycle.
   * This means both opening it and closing it, even in case of an [[Exception]]
   * being thrown.
   *
   * Example:
   *
   * {{{
   * {
   *   // build resources to loan
   *   val fixture = ...
   *
   *   try {
   *     body(fixture)
   *   } finally {
   *     // clean up or close loaned resources
   *     ...
   *   }
   * }
   * }}}
   *
   * @param body The test to execute
   * @return The result of the test
   */
  def withFixture(body: FixtureParam => Outcome): Outcome

}

/**
 * Base trait for loaning fixtures to [[Any]]-result tests.
 * Useful when dealing with testing libraries which do not return [[Assertion]]s,
 * e.g. `Akka`'s `TestKitBase.expectMsg()`.
 *
 * @tparam FixtureParam
 */
trait FixtureLoanerAnyResult[FixtureParam] extends FixtureLoanerLike[FixtureParam, Any]

/**
 * Base trait for loaning fixtures to async tests.
 * Useful when testing with libraries like [[org.scalatest.AsyncTestSuite]].
 *
 * Example:
 *
 * {{{
 * {
 *   // build resources to loan
 *   val fixture = ...
 *
 *   val result = body(fixture)
 *
 *   result.onComplete { _ =>
 *     // clean up or close loaned resources
 *     ...
 *   }
 *
 *   result
 * }
 * }}}
 *
 * @tparam FixtureParam
 */
trait AsyncFixtureLoaner[FixtureParam] extends FixtureLoanerLike[FixtureParam, Future[Assertion]]
