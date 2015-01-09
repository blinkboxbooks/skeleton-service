package com.blinkbox.books.purchasing.admin

import spray.routing._
import Directives._

class AdminApi{
  val route = get{
    path("admin" / "purchasing" / "foo")
    complete("bar-admin")
  }
}
