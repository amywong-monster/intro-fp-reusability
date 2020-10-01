package org.jinilover.resuability

object ProposedConstraintToOption {
  def pure[A](a: A): Option[A] = Option(a)
  def bind[A, B](ma: Option[A], f: A => Option[B]): Option[B] = ma.flatMap(f)
  def fmap[A, B](ma: Option[A], f: A => B): Option[B] = ma.map(f)
}
