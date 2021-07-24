package com.aransafp.testapp.helper

object Helper {

    //fungsi untuk mendapatkan hari
    private fun getDay(birthday: String): Int {
        val arrBirthday = birthday.split("-")
        val day = arrBirthday[2]

        return day.toInt()

    }

    //fungsi untuk mengembalikkan fitur
    fun getFeature(input: String):String {

        val number = getDay(input)

        return if (number % 2 == 0 && number % 3 == 0) {
            "IOS"
        } else if (number % 2 == 0) {
            "blackberry"
        } else if (number % 3 == 0) {
            "android"
        } else {
            "feature phone"
        }

    }
}