import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.ifc.figssamel",
      scalaVersion := "2.12.3",
      version      := "0.0.1"
    )),
    name := "study_area_characteristics",
    libraryDependencies += scalaTest % Test
  )
