package sampleproject

import sbt._
import Keys._
import sbtassembly.Plugin._

/**
 * Multi-project build configuration with assemply plugin.
 */
object SampleProjectBuild extends Build {

  // Versions & dependency groups
  /* add versions that are used multiple times example*/
  val slf4jVersion = "1.6.6"
  /* global group of test dependencies example */
  val testDependencies = List("org.scalatest" %% "scalatest" % "1.9.1" % "test")

  /*
   * shared settings are common settings for all the modules.
   * Project.defaultSettings is provided by the sbt api.
   * assemblySettings is provided by the assembly plugin settings.
   * also added the keys for our specific project.
   * -deprecation Emit warning and location for usages of deprecated APIs.
   * -unchecked   Enable additional warnings where generated code depends on assumptions.
   */
  val sharedSettings = Project.defaultSettings ++ assemblySettings ++ Seq(
    organization := "com.chdask",
    scalaVersion := "2.10.4",
    scalacOptions ++= Seq("-unchecked", "-deprecation")
  )

  /*
   * sampleproject is to declare the parent project definition.
   * .aggregate is used to declare the modules.
   */
  lazy val sampleproject = Project(
    id="sampleproject",
    base= file("."),
    settings = sharedSettings
  ).aggregate(
      sampleprojectModule1,
      sampleprojectModule2
    )

  /* module1 definition */
  lazy val sampleprojectModule1 = module("module1").settings(
    libraryDependencies ++= testDependencies
  )

  /* module2 definition */
  lazy val sampleprojectModule2 = module("module2").settings(
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % slf4jVersion,
      "org.slf4j" % "slf4j-log4j12" % slf4jVersion % "provided"
    ) ++ testDependencies
  )
  .dependsOn(sampleprojectModule1)

  /*
   * module function is used to declare the subProjects.
   * it uses the Project api to initialize the modules with the sharedSettings.
   * it provides a name prefix - which is optional if naming policy is not used.
  */
  def module(name: String) = {
    val id = "sampleproject-%s".format(name)
    Project(
      id = id,
      base = file(id),
      settings = sharedSettings ++ Seq(Keys.name := id)
    )
  }
}