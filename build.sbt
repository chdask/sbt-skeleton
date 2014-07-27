import Common._

name := "sample-name"

lazy val `sampleproject-module1` = project
lazy val `sampleproject-module2` = project

Common.settings

libraryDependencies ++= testDependencies 
