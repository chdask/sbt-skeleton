sbt-skeleton
============

This is an sbt-skeleton project.
It consists of 3 branches: 

* master: contains a basic sbt configuration using a build.sbt file
* options/withSBT: using .sbt files to demonstrate a multi-project setup
* options/withScala: using Build.scala to demonstrate a multi-project setup

### Basic SBT commands
- clean
- compile
- assembly (using the assembly plugin)
- test

### .sbt vs .scala Build Definition
* An sbt build definition can contain files ending in .sbt, located in the base directory of a project,  
* files ending in .scala, located in the project/ subdirectory of the base directory. 
* The .scala files are typically used for sharing code across .sbt files and for more complex build definitions.
* Settings must be separated by blank lines. sbt needs some kind of delimiter to tell where one expression stops and the next begins, .sbt files contain a list of Scala expressions, not a single Scala program. These expressions have to be split up and passed to the compiler individually.


### Multi-module project in SBT
Using sbt with a multi-module project, by default it uses the parent project eg. sampleproject
You can navigate among children projects eg. sampleproject-module1: 
> sbt

> project  sampleproject-module1

You can see the versions of the projects:
> sbt

> show versions 

### Intellij
To transform the project to intelliJ project, you require the idea plugin for sbt. 
Then type:
$ sbt gen-idea 

In order to use the intelliJ you can either add it to your global SBT plugins or to the project specific plugins as follows:
- sbt gen-idea - as plugin to sbt set to local environment: `~/.sbt/0.13/plugins/build.sbt`
- sbt gen-idea - as plugin to sbt project : `<base_dir>/project/plugins.sbt`

### TODO
* publish & deploy

### References
http://www.scala-sbt.org/release/tutorial/index.html
