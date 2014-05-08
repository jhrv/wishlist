package com.horvi.wishlist

import unfiltered.response.{ResponseHeader, ResponseString}
import unfiltered.request.{Seg, Path, GET}
import argonaut._, Argonaut._

object Backend {

    import unfiltered.jetty._

    def main(args: Array[String]) = {
        val port: Int = 1337
        println("Running a server here on port %s!".format(port))

        val data = """
        [
            { "title": "Dagstursekk", "link": "http://norrona.no/" },
            { "title": "Sommerdekk + felg", "link": "https://dekk.no"}
        ]
                   """

        val wishes: List[Wish] = data.decodeOption[List[Wish]].getOrElse(Nil)

        val echo = unfiltered.filter.Planify {
            case GET(Path("/wishes")) => ResponseHeader("Access-Control-Allow-Origin", List("*")) ~> ResponseString(wishes.asJson.spaces4)
            case GET(Path(Seg("wishes" :: id :: Nil))) =>
                ResponseString(
                    wishes(id.toInt).asJson.spaces4
                )
        }

        Http.apply(port).filter(echo).run()
    }
}

