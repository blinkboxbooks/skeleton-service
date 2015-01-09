name := "purchasing-service-common"

libraryDependencies ++= {
  Seq(
    "com.blinkbox.books"          %% "common-spray"             % "0.21.0",
    "com.blinkbox.books"          %% "common-spray-auth"        % "0.7.5",
    "com.blinkbox.books"          %% "common-config"            % "2.0.1",
    "com.blinkbox.books"          %% "common-slick"             % "0.3.2",
    "io.spray"                    %% "spray-testkit"            % "1.3.2" % Test,
    "com.blinkbox.books"          %% "common-scala-test"        % "0.3.0" % Test,
    "io.spray"                    %% "spray-testkit"            % "1.3.2" % Test,
    "com.github.tototoshi"        %% "slick-joda-mapper"        % "1.2.0",
    "mysql"                        % "mysql-connector-java"     % "5.1.34",
    "org.apache.commons"           % "commons-dbcp2"            % "2.0.1",
    "joda-time"                    % "joda-time"                % "2.5",
    "org.joda"                     % "joda-money"               % "0.10.0",
    "com.h2database"               % "h2"                       % "1.4.182" % Test
  )
}

parallelExecution in Test := false
