import scala.sys.process._
import scala.language.postfixOps

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val mygame =
  (project in file("."))
    .enablePlugins(ScalaJSPlugin, SbtIndigo) // Enable the Scala.js and Indigo plugins
    .settings( // Standard SBT settings
      name := "mygame",
      version := "0.0.1",
      scalaVersion := "3.2.0",
      organization := "org.mygame",
            libraryDependencies ++= Seq(
              "org.scalameta" %%% "munit" % "0.7.29" % Test
            ),
    )
    .settings( // Indigo specific settings
      showCursor := true,
      title := "My Game",
      gameAssetsDirectory := "assets",
      windowStartWidth := 720, // Width of Electron window, used with `indigoRun`.
      windowStartHeight := 480, // Height of Electron window, used with `indigoRun`.
      libraryDependencies ++= Seq(
        "io.indigoengine" %%% "indigo" % "0.14.0",
        "io.indigoengine" %%% "indigo-extras" % "0.14.0",
        "io.indigoengine" %%% "indigo-json-circe" % "0.14.0"
      )
    )

// To use indigoBuild or indigoRun, first comment out the line above that says: `scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }`
addCommandAlias("runGame", ";compile;fastOptJS;indigoRun")
addCommandAlias("buildGame", ";compile;fastOptJS;indigoBuild")

lazy val code =
  taskKey[Unit]("Launch VSCode in the current directory")