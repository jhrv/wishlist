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
            { "title": "Dagstursekk", "link": "https://www.norrona.com/nb-NO/Products/4390-12/7760/bitihorn-back-pack-20l/" },
            { "title": "Lett dunjakke", "link": "https://www.norrona.com/nb-NO/Products/3340-14/7718/falketind-primaloft60-jacket-m/" },
            { "title": "Tur/Sykkelshorts", "link": "https://www.norrona.com/nb-NO/Products/7021-10/8851/fjora-shorts-m/" }
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

