package io.github.francescopellegrini.$name;format="word,lower"$

import org.scalatest.{Matchers, fixture}

/**
  * Base trait for testing classes.
  * Example:
  *
  * {{{
  * // Override FixtureParam type definition
  * case class FixtureParam(???)
  *
  * override def withFixture(test: OneArgTest): Outcome = {
  *   // Build the fixture
  *   val theFixture = FixtureParam(???)
  *
  *   try {
  *     withFixture(test.toNoArgTest(theFixture)) // "loan" the fixture to the test
  *   } finally {
  *     // Eventually cleanup lonaned resources
  *   }
  * }
  * }}}
  */
trait BaseSpec extends fixture.WordSpecLike with Matchers
