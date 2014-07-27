sbt-skeleton using Build.scala
====================================

In this example we use .scala build definition. It is recommended especially if you are more familiar with scala code as it allows you to customise the build script as you like! 

This is a multi-module project having 2 modules. Module2 dependes on Module1. Also Module2 requires some extra dependencies.

### Directory structure

##### The project directory
The project directory is not containing the application source code. It's an sbt config folder to hold the build configuration, plugins, etc.

In this example it contains:

* `Build.scala` must be in the project folder.
* `plugins.sbt` contains the plugins used as part of this skeleton. 

Project dir is located in the base directory:
```
<base_dir>/project
```

##### The subProjects
* The SBT projects follow the Maven directory structure (http://www.scala-sbt.org/release/tutorial/Directories.html). 
* In our case the parent does not containing any source code but common build configuration and project structure definition.
* The subProjects are following the common directory structure but no build definition files. We handle their build from the parent. So the subProjects (or modules) live in their own directory:

```
<base_dir>/sampleproject-module1
<base_dir>/sampleproject-module2
```
### Build.scala
```
<base_dir>/project/Build.scala
```
* In Build.scala we define the `sharedSettings` and dependencies to be used by our modules.
* The parent project definition where we define the subProjects
* The subProject definitions (settings & dependencies)
* A module function to be used to initialize a Project by also having a name prefix (which is optional)

### sbt assembly
We use the assembly plugin to generate jar with dependencies. 
In the base directory do:

> $ sbt assembly

This will generate jars with dependecies for all the modules in their `target` folder. 

See also: https://github.com/sbt/sbt-assembly
