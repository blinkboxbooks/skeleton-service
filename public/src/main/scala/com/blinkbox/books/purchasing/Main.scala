package com.blinkbox.books.purchasing

import akka.actor.{ ActorRefFactory, ActorSystem, Props }
import akka.util.Timeout
import com.blinkbox.books.config.Configuration
import com.blinkbox.books.logging.Loggers
import com.blinkbox.books.spray.{ HealthCheckHttpService, HttpServer }
import com.typesafe.scalalogging.StrictLogging
import spray.can.Http
import spray.http.Uri.Path
import spray.routing.HttpServiceActor

import scala.concurrent.duration._

object Main extends App with Configuration with Loggers with StrictLogging {
  logger.info("App starting")
  val system = ActorSystem("purchasing-service")
  val service = system.actorOf(Props(classOf[PublicApiActor], new PublicApi), "purchasing")
  val interface = config.getString("public.listen.address")
  val port = config.getInt("public.listen.port")
  logger.info("App Started")
  HttpServer(Http.Bind(service, interface = interface, port = port)) (system, system.dispatcher, Timeout(10.seconds))
}

class PublicApiActor(publicApi: PublicApi) extends HttpServiceActor {
  val healthService = new HealthCheckHttpService {
    override val basePath: Path = Path("/")
    override implicit def actorRefFactory: ActorRefFactory = PublicApiActor.this.actorRefFactory
  }

  override def receive = runRoute(healthService.routes ~ publicApi.route)
}
