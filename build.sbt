name := "scalann"

version := "1.0"
val nd4jVersion = "0.8.0"

scalaVersion := "2.12.2"
classpathTypes += "maven-plugin"

libraryDependencies += "org.nd4j" % "nd4j-native-platform" % nd4jVersion
libraryDependencies += "org.nd4j" % "nd4s_2.11" % nd4jVersion