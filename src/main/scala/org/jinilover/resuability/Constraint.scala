package org.jinilover.resuability

// This is already available in open sourced libraries such as cats, scalaz
trait Constraint[M[_]] {
  def pure[A](a: A): M[A]
  def bind[A, B](ma: M[A], f: A => M[B]): M[B]
  def fmap[A, B](ma: M[A], f: A => B): M[B] =
    bind[A, B](ma, a => pure(f(a)))
}
