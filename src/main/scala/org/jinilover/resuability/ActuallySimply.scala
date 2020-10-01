package org.jinilover.resuability

object ActuallySimply {
  // import all required template code, syntactic sugar and implicit instances of Option, Either to make it
  // compile
  import cats.implicits._
  // same as TemplateCode.genericFlip(List(Option(1), Option(2), Option(3))) but they are all provided by
  // the cats library
  List(Option(1), Option(2), Option(3)).sequence
  List[Either[String, Int]](Right(1), Right(2), Right(3)).sequence

  // zio is not developed by cats community, but the `List(..).sequence` template code is
  // to apply the handy function of `List(..).sequence`
  // the following import provided implicit instances of zio types that inter-operate with cats template code
  import zio.interop.catz._
  import zio.Task
  List(1, 2, 3).map(n => Task.effect(n)).sequence

}
