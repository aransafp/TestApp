package com.aransafp.testapp.helper

object Helper {

    //fungsi untuk mendapatkan hari
    private fun getDay(birthday: String): Int {
        val arrBirthday = birthday.split("-")
        val day = arrBirthday[2]

        return day.toInt()

    }

    //fungsi untuk mengembalikkan fitur
    fun getFeature(input: String): String {

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

    fun isPalindrome(input: String): Boolean {
        var i = 0
        var j = input.length - 1

        while (i < j) {

            if (input.get(i) != input.get(j)) {
                return false
            }

            i++
            j--
        }

        return true
    }

    private fun getMonth(birthday: String): Int {
        val arrBirthday = birthday.split("-")
        val month = arrBirthday[1]

        return month.toInt()

    }

    fun isMonthPrime(input: String): Boolean {
        val number = getMonth(input)
        var i = 2
        var flag = false

        while (i <= number / 2) {
            if (number % i == 0) {
                flag = true
                break
            }
            ++i
        }

            return flag
    }
}