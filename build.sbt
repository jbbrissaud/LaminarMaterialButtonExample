ThisBuild / organization := "com.jbbrissaud"
ThisBuild / name         := "LaminarMaterialButtonExample"
ThisBuild / scalaVersion := "3.2.0"
ThisBuild / version      := "0.1.0"

val zioVersion        = "2.0.0"
val zioHttpVersion    = "2.0.0-RC5"
val laminarVersion    = "0.14.2"

lazy val backend = project
  .in(file("backend"))
  .settings(
    name    := "backend",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "io.d11"               %% "zhttp"      % zioHttpVersion,
      "com.github.jwt-scala" %% "jwt-core"   % "9.0.5",
      "io.d11"               %% "zhttp-test" % zioHttpVersion % Test,
    )
  )

lazy val frontend = project
  .in(file("frontend"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(EsbuildPlugin)  // for components
  .settings(
    name                            := "frontend",
    version                         := "0.1.0-SNAPSHOT",
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
    },
    scalaJSLinkerConfig ~= {
      _.withSourceMap(true)
    },
    scalaJSUseMainModuleInitializer := true,
    resolvers += "jitpack" at "https://jitpack.io",  // for components
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time"           % "2.3.0",
      "io.github.cquiroz" %%% "scala-java-time-tzdb"      % "2.3.0",
      "org.scala-js"      %%% "scalajs-java-securerandom" % "1.0.0" cross CrossVersion.for3Use2_13,
      //laminar
      "com.raquo"         %%% "laminar"                   % laminarVersion,
      //laminar SAP UI Components
      "com.github.sherpal" % "LaminarSAPUI5Bindings" % "1.3.0-8f02a832",
    ),
    // for components
    Compile / npmDependencies ++= Seq(
      "@ui5/webcomponents" -> "^1.3.0",
      "@ui5/webcomponents-fiori" -> "^1.3.0",
      "@ui5/webcomponents-icons" -> "^1.3.0",
      "highlight.js" -> "^11.6.0"
    ),
    esPackageManager := Npm
  )

