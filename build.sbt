ThisBuild / organization := "com.jbbrissaud"
ThisBuild / name         := "LaminarMaterialButtonExample"
ThisBuild / scalaVersion := "3.2.0"
ThisBuild / version      := "0.1.0"

val zioVersion        = "2.0.0"
val zioHttpVersion    = "2.0.0-RC5"
val zioJsonVersion    = "0.3.0-RC5"
//todo remove this if I end up not using it
val zioProcessVersion = "0.7.0-RC5"
val laminarVersion    = "0.14.2"

lazy val backend = project
  .in(file("backend"))
  .settings(
    name    := "backend",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "dev.zio"              %% "zio-json"   % zioJsonVersion,
      "io.d11"               %% "zhttp"      % zioHttpVersion,
      "com.github.jwt-scala" %% "jwt-core"   % "9.0.5",
      "io.d11"               %% "zhttp-test" % zioHttpVersion % Test,
    )
  )

lazy val frontend = project
  .in(file("frontend"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    name                            := "frontend",
    version                         := "0.1.0-SNAPSHOT",
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule) //.CommonJSModule)  //.ESModule)
    },
    scalaJSLinkerConfig ~= {
      _.withSourceMap(false)
    },
    scalaJSUseMainModuleInitializer := true,
    //gitHub repository
    githubOwner := "uosis",
    githubRepository := "laminar-web-components",
    githubSuppressPublicationWarning := true,
    resolvers += Resolver.githubPackages("uosis"),
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time"           % "2.3.0",
      "io.github.cquiroz" %%% "scala-java-time-tzdb"      % "2.3.0",
      "org.scala-js"      %%% "scalajs-java-securerandom" % "1.0.0" cross CrossVersion.for3Use2_13,
      //laminar
      "com.raquo"         %%% "laminar"                   % laminarVersion,
      //laminar Google UI Components in gitHub repository
      "com.github.uosis" %%% "laminar-web-components-material" % "0.1.0" cross CrossVersion.for3Use2_13
    ),
    /*Compile / npmDependencies ++= Seq(
      "@material/mwc-button" -> "0.27.0"
    )*/
  )

