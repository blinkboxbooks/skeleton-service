package com.blinkbox.books.purchasing

import spray.routing._
import Directives._

class PublicApi {
  val route = get {
    path("my" / "purchasing" / "foo") {
      complete("bar")
    }
  }
}
