package org.jinilover.resuability

import zio.Task

object DuplicatedCodeExample3 {
  def flip(tasks: List[Task[Int]]): Task[List[Int]] =
    tasks.foldLeft[Task[List[Int]]](Task.effect(List.empty[Int])) { (accumlator, task) =>
      accumlator.flatMap(accV => task.map(v => accV ++ List(v)))
    }

}
