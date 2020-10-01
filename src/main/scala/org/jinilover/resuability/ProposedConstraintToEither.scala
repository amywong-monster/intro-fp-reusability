package org.jinilover.resuability

object ProposedConstraintToEither {
  def pure[A](a: A): Either[String, A] = Right(a)
  def bind[A, B](ma: Either[String, A], f: A => Either[String, B]): Either[String, B] = ma.flatMap(f)
  def fmap[A, B](ma: Either[String, A], f: A => B): Either[String, B] = ma.map(f)
}
