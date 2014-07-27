sbt-skeleton with build.sbt
============================

sbt skeleton

In this branch: 

module1 - has it's own build.sbt to override parent's. 
module2 - does not have any adittional file so inherits from the parent. 

In parent build.sbt the 2 modules have been declared as projects. 

Parent project/Common.scala is available to all modules.
