package com.blinkbox.books.purchasing.admin

import com.blinkbox.books.config.ApiConfig
import com.typesafe.config.Config

case class AppConfig(api: ApiConfig)

object AppConfig {
  val apiConfigKey: String = "service.purchasing.api.admin"
  def apply(appConfig: Config) =
    new AppConfig(ApiConfig(appConfig, apiConfigKey))
}
