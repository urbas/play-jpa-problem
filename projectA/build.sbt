name := "projectA"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache
)     

play.Project.playJavaSettings

sources in doc in Compile := Nil

publishArtifact in(Compile, packageDoc) := true

publishArtifact in(Compile, packageSrc) := true

sources in doc in Test := Nil

publishArtifact in(Test, packageBin) := true

publishArtifact in(Test, packageSrc) := true