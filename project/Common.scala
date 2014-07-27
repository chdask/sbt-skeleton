import sbt._
import Keys._

object Common {
  val settings : Seq[Setting[_]] = {
    organization := "com.chdask"
    version := "1.0"
  }
 
  val testDependencies = List("org.scalatest" %% "scalatest" % "1.9.1" % "test")
}
