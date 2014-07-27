sbt-skeleton
============

This is an sbt-skeleton project.
It consists of 3 branches: 
1. master: contains a basic sbt configuration using a build.sbt file
2. options/withSBT: using .sbt files to demonstrate a multi-project setup
3. options/withScala: using Build.scala to demonstrate a multi-project setup

### Basic SBT commands
- clean
- compile
- assembly (using the assembly plugin)
- test

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
