package com.aransafp.testapp.data.dummy

import com.aransafp.testapp.data.model.Event

object DataDummy {

    fun getListEvent(): List<Event> =
        listOf(
            Event(
                "ANIMELAND",
                "https://creativedisc.com/web/wp-content/uploads/2021/07/animeland.jpg",
                "21 Agustus 2021",
                "#nutricia",
                "Perusahaan event management PK Entertainment bersama platform ticketing GoTix, yang menjadi bagian dari ekosistem Gojek, mengumumkan bakal menghadirkan Festival Animeland"
            ),
            Event(
                "INSPIRAFEST 2021",
                "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20200317113658_5e7053ea37fd6.jpg",
                "14 Agustus 2021",
                "#nutricia",
                "Pelajari bagaimana para Top Content Creator membangun Contentnya dari awal hingga sukses seperti saat ini."
            ),
            Event(
                "Talkshow DUM Anniversary #5",
                "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20210716220612_60f1a06457aeb.jpg",
                "26 Juli 2021",
                "#event",
                "Toleransi saat ini masih menjadi topik hangat dan terus kita gaungkan. Mengingat Indonesia terdiri dari bermacam-macam suku, agama, ras dan budaya. Sehingga, adanya toleransi di masyarakat sangat diperlukan agar tercipta hubungan yang harmonis dan diharapkan bisa memperkuat persatuan Indonesia. Berdasarkan hal tersebut, Diberi Untuk Memberi akan mengadakan talkshow dengan tema toleransi \"Strenghtning Tolerance in The Digital Age\". Dalam talkshow ini akan membahas bagaimana peekembangan dan isu-isu toleransi di era milenial saat ini."
            ),
            Event(
                "Virtual Traveling Ohayou Japan!",
                "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20210629170409_60daf019a106b.jpg",
                "31 Juli 2021",
                "#highlight F3",
                "Atourin berkolaborasi dengan Loket dan Gotix untuk menyelenggarakan rangkaian virtual traveling di Jepang yang didukung oleh rekan pemandu wisata yang saat ini sedang berada langsung di Jepang dengan tema Ohayou Japan!"
            ),
        )
}