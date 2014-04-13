name := "projectB"

version := "1.0-SNAPSHOT"

resolvers += "Sonatype Public Repository" at "https://oss.sonatype.org/content/groups/public"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  "si.urbas" %% "pless" % "0.0.7-SNAPSHOT",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.1.Final",
  "org.hibernate" % "hibernate-core" % "4.3.1.Final"
)

play.Project.playJavaSettings
