package com.example.quizenglish

object Fixed {
    fun getQuestions(): ArrayList<Questions> {
        val liste : ArrayList<Questions> = ArrayList<Questions>()
        val soru1 : Questions = Questions(
            1,
            "what color is pikachu ?",
            R.drawable.pikachu,
            "A) Yellow",
            "B) Blue",
            "C) Green",
            "D) Red",
            "a"
        )
        liste.add(soru1)
        liste.add(
            Questions(
                2,
                "what color is shrek ?",
                R.drawable.shrek,
                "A) Yellow",
                "B) Blue",
                "C) Green",
                "D) Red",
                "c"
            )
        )
        return liste
    }
}