package org.jinilover.resuability

import zio._

object DuplicatedCodeExamples {
  def flipOptions(options: List[Option[Int]]): Option[List[Int]] =
    options.foldLeft[Option[List[Int]]](Option(List.empty[Int])) { (accumulator, opt) =>
      accumulator.flatMap(accV => opt.map(v => accV ++ List(v)))
    }

  def flipEithers(eithers: List[Either[String, Int]]): Either[String, List[Int]] =
    eithers.foldLeft[Either[String, List[Int]]](Right(List.empty[Int])) { (accmulator, either) =>
      accmulator.flatMap(accV => either.map(v => accV ++ List(v)))
    }

  def flipTasks(tasks: List[Task[Int]]): Task[List[Int]] =
    tasks.foldLeft[Task[List[Int]]](Task.effect(List.empty[Int])) { (accumlator, task) =>
      accumlator.flatMap(accV => task.map(v => accV ++ List(v)))
    }

}


