package org.jinilover.resuability

object TemplateCode {
  // This is already available in open sourced libraries such as cats
  def genericFlip[M[_]](xs: List[M[Int]])(implicit m: Constraint[M]): M[List[Int]] =
    xs.foldLeft(m.pure(List.empty[Int])) { (accmulator, ma) =>
      m.bind[List[Int], List[Int]](accmulator, accV => m.fmap[Int, List[Int]](ma, v => accV ++ List(v)))
    }

  // same as `genericFlip` if you want to make the signature more concise
  // !!note that if you want to call the `M` directly, you should include
  // `addCompilerPlugin("org.augustjune" %% "context-applied" % "0.1.2")` in `build.sbt`
  def simplifyGenericFlip[M[_]: Constraint](xs: List[M[Int]]): M[List[Int]] =
    xs.foldLeft(M.pure(List.empty[Int])) { (accmulator, ma) =>
      M.bind[List[Int], List[Int]](accmulator, accV => M.fmap[Int, List[Int]](ma, v => accV ++ List(v)))
    }
}
