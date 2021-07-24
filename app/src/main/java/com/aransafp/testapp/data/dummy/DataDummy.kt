package com.aransafp.testapp.data.dummy

import com.aransafp.testapp.data.model.Event

object DataDummy {

    fun getListEvent(): List<Event> =
        listOf(
            Event(
                "ANIMELAND",
                "https://creativedisc.com/web/wp-content/uploads/2021/07/animeland.jpg",
                "21 Agustus 2021"
            ),
            Event(
                "INSPIRAFEST 2021",
                "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20200317113658_5e7053ea37fd6.jpg",
                "14 Agustus 2021"
            ),
            Event(
                "Quarantine Talse",
                "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20201211052245.jpg",
                "28 November 2021"
            ),
            Event(
                "Virtual Traveling Ohayou Japan!",
                "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20210629170409_60daf019a106b.jpg",
                "31 Juli 2021"
            ),
        )
}