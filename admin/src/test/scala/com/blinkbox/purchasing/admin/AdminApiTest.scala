package com.blinkbox.books.purchasing.admin

import org.scalatest.FlatSpec
import spray.http.StatusCodes
import spray.routing.HttpService
import spray.testkit.ScalatestRouteTest

class AdminApiTest extends FlatSpec with ScalatestRouteTest with HttpService {
  def actorRefFactory = system
  val route = (new AdminApi().route)

  "The admin service" should "respond to a get request with bar" in {
    Get("/admin/purchasing/foo") ~> route ~> check {
      assert(status == StatusCodes.OK)
      assert(responseAs[String] == "bar-admin")
    }
  }
}
