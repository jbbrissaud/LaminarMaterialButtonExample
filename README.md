This project is a very basic app in Scala 3 + Laminar + LaminarSAPUI5Bindings Components.\
The backend uses zio-http and zio 2.\
The frontend uses Laminar + LaminarSAPUI5Bindings.

## I. Start the app

### 1. Start backend

#### - in a console

```shell
sbt "~backend / run"
```

### 2. Start frontend

#### - in another console

```shell
sbt "~frontend / fastOptJS"
```

### 3. Test the app

Then you can access the frontend at http://localhost:8090 \

It is just an Input. When validated (by Enter), it is displayed on the console of the web page.

Note: The .gitignore file is a little bit unconventional, indicating what to keep and not what to ignore.

