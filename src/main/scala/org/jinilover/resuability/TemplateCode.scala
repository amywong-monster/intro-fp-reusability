package org.jinilover.resuability

object TemplateCode {
  // This is already available in open sourced libraries such as cats
  def genericFlip[M[_]](xs: List[M[Int]])(implicit m: Constraint[M]): M[List[Int]] =
    xs.foldLeft(m.pure(List.empty[Int])) { (accmulator, ma) =>
      m.bind[List[Int], List[Int]](accmulator, accV => m.fmap[Int, List[Int]](ma, v => accV ++ List(v)))
    }
}
