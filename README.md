sbt-skeleton using Build.scala
====================================

In this example we use .scala build definition. It is recommended especially if you are more familiar with scala code as it allows you to customise the build script as you like! 

This is a multi-module project having 2 modules. Module2 dependes on Module1. Also Module2 requires some extra dependencies.

### Folder structure

##### The project folder
project folder is not relevant to the source code. It's an sbt config folder to hold the build configuration, plugins, etc.

`Build.scala` must be in the project folder.
`plugins.sbt` contains the plugins used as part of this skeleton. 

##### The subProjects
* The SBT projects follow the Maven directory structure. 
* In our case the parent does not containing any source code but common build configuration and project structure definition.
* The subProjects are following the common directory structure but no build definition files. We handle their build from the parent. So the subProjects (or modules) live in their own directory:

```
<base_dir>/sampleproject-module1
<base_dir>/sampleproject-module2
```
### Build.scala
todo
