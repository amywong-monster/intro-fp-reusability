name := "intro-fp-reusability"

version := "0.1"

scalaVersion := "2.13.3"

organization := "org.jinilover"

lazy val zioV = "1.0.1"

// dependencies for compilation to application
libraryDependencies += "dev.zio"       %% "zio"              % zioV
libraryDependencies += "dev.zio"       %% "zio-interop-cats" % "2.1.4.0"
libraryDependencies += "org.typelevel" %% "cats-core"        % "2.2.0"

addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.10.3")
addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1")
addCompilerPlugin("org.augustjune" %% "context-applied" % "0.1.2")

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Xfatal-warnings"
)

// required for running zio test
testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
