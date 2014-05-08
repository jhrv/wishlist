package com.horvi.wishlist

import argonaut._, Argonaut._


case class Wish(title: String, link: String)

object Wish {
    implicit def WishCodecJson: CodecJson[Wish] =
        casecodec2(Wish.apply, Wish.unapply)("title", "link")
}


object Testing extends App {
    val input = """
    [
      { "title": "dagstursekk", "link": "http://norrona.no/" },
      { "title": "Sommerdekk + felg", "link": "https://dekk.no"}
    ]
    """

    val wishes = input.decodeOption[List[Wish]].getOrElse(Nil)

    wishes.foreach(println)


    val wishes2 = List(new Wish("a", "b"), new Wish("1", "2"))

    println(wishes2.asJson.spaces4)
}