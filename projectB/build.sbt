import sbt.Artifact.classifierType

name := "projectB"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  "projecta" %% "projecta" % "1.0-SNAPSHOT",
  "projecta" %% "projecta" % "1.0-SNAPSHOT" % "test" classifier "tests",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.1.Final",
  "org.hibernate" % "hibernate-core" % "4.3.1.Final"
)

play.Project.playJavaSettings
