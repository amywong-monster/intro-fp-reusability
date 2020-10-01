package org.jinilover.resuability

/**
 * Solution is to specify constraints on a type constructor, why?
 * because `Option`, `Either[String, ]`, `Task` are type constructors
 * I can define template code on these constraints satisfied by these type constructors.
 * Then the same template code can be reused for different type constructors which satisfy these constraints
 */
object EnforceConstraintToOption {
  def pure[A](a: A): Option[A] = Option(a)
  def bind[A, B](ma: Option[A], f: A => Option[B]): Option[B] = ma.flatMap(f)
  def fmap[A, B](ma: Option[A], f: A => B): Option[B] = ma.map(f)
}

object EnforceConstraintToEither {
  def pure[A](a: A): Either[String, A] = Right(a)
  def bind[A, B](ma: Either[String, A], f: A => Either[String, B]): Either[String, B] = ma.flatMap(f)
  def fmap[A, B](ma: Either[String, A], f: A => B): Either[String, B] = ma.map(f)
}

