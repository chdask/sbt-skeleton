package sampleproject

import sbt._
import Keys._

/**
 * Multi-project build configuration
 */
object SampleProjectBuild extends Build {

  // Versions & dependency groups
  val slf4jVersion = "1.6.6" // module dependency - multi use
  val testDependencies = List("org.scalatest" %% "scalatest" % "1.9.1" % "test") //global group of test deps

  //removed: ++ assemblySettings ++ scalariformSettings
  val sharedSettings = Project.defaultSettings ++ Seq(
    organization := "com.chdask",
    scalaVersion := "2.10.4"
  )

  def module(name: String) = {
    val id = "sampleproject-%s".format(name)
    Project(
      id = id,
      base = file(id),
      settings = sharedSettings ++ Seq(Keys.name := id)
    )
  }

  lazy val sampleprojectModule1 = module("module1").settings(
    libraryDependencies ++= testDependencies
  )

  lazy val sampleprojectModule2 = module("module2").settings(
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % slf4jVersion,
      "org.slf4j" % "slf4j-log4j12" % slf4jVersion % "provided"
    ) ++ testDependencies
  )
  .dependsOn(sampleprojectModule1)

  lazy val sampleproject = Project(
    id="sampleproject",
    base= file("."),
    settings = sharedSettings
  ).aggregate(
      sampleprojectModule1,
      sampleprojectModule2
    )

}