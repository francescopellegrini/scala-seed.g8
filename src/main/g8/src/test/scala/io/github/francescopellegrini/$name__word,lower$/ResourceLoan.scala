package io.github.francescopellegrini.$name;format="word,lower"$

object ResourceLoan {

  /**
    * Base trait for resource to loan.
    */
  trait Resource

}

/**
  * Trait to implement the loaner pattern.
  *
  * @tparam R loaned resource type
  */
trait ResourceLoan[R <: ResourceLoan.Resource] {

  /**
    * Closure to provide resource to a test scenario.
    *
    * @param body the function to execute, given the provided loaned resource
    * @tparam T   the return type of the executed function
    */
  def withResource[T](body: R => T): T

}
