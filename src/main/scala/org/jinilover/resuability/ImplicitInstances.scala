package org.jinilover.resuability

import zio.Task

// These implicit instances are already available in open sourced libraries such as cats
object ImplicitInstances {
  implicit val optionConstraint: Constraint[Option] = new Constraint[Option] {
    override def pure[A](a: A): Option[A] = Option(a)
    override def bind[A, B](ma: Option[A], f: A => Option[B]): Option[B] = ma.flatMap(f)
  }

  type Disjunction[A] = Either[String, A]
  implicit def eitherStringConstraint: Constraint[Disjunction] =
    new Constraint[Disjunction] {
      override def pure[A](a: A): Disjunction[A] = Right(a)
      override def bind[A, B](ma: Disjunction[A], f: A => Disjunction[B]): Disjunction[B] = ma.flatMap(f)
    }

  implicit def taskConstraint: Constraint[Task] =
    new Constraint[Task] {
      override def pure[A](a: A): Task[A] = Task.effect(a)
      override def bind[A, B](ma: Task[A], f: A => Task[B]): Task[B] = ma.flatMap(f)
    }
}
