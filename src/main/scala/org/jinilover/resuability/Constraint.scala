package org.jinilover.resuability

import zio.Task

// TODO
trait Constraint[M[_]] {
  def pure[A](a: A): M[A]
  def bind[A, B](ma: M[A], f: A => M[B]): M[B]
  def fmap[A, B](ma: M[A], f: A => B): M[B] =
    bind[A, B](ma, a => pure(f(a)))
}

object UseConstraint {
  // TODO comments cats sequence
  def genericFlip[M[_]](xs: List[M[Int]])(implicit m: Constraint[M]): M[List[Int]] =
    xs.foldLeft(m.pure(List.empty[Int])) { (accmulator, ma) =>
      m.bind[List[Int], List[Int]](accmulator, accV => m.fmap[Int, List[Int]](ma, v => accV ++ List(v)))
    }
}

object Implicits {
  //TODO comments cats instances
  implicit val optionConstraint: Constraint[Option] = new Constraint[Option] {
    override def pure[A](a: A): Option[A] = Option(a)
    override def bind[A, B](ma: Option[A], f: A => Option[B]): Option[B] = ma.flatMap(f)
  }

  type Disjunction[A] = Either[String, A]
  implicit def eitherStringConstraint: Constraint[Disjunction] = new Constraint[Disjunction] {
    override def pure[A](a: A): Disjunction[A] = Right(a)
    override def bind[A, B](ma: Disjunction[A], f: A => Disjunction[B]): Disjunction[B] = ma.flatMap(f)
  }

  implicit def taskConstraint: Constraint[Task] = new Constraint[Task] {
    override def pure[A](a: A): Task[A] = Task.effect(a)
    override def bind[A, B](ma: Task[A], f: A => Task[B]): Task[B] = ma.flatMap(f)
  }
}

object GenericFlipExample {
  import UseConstraint.genericFlip
  import Implicits.optionConstraint
  genericFlip(List(Option(1), Option(2), Option(3)))

}
