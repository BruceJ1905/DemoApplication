package com.example.mylibrary

fun main(args : Array<String>) {

//    infix fun Int.times(str: String) = str.repeat(this)        // 1
//    println(3 times "Bye ")                                    // 2


//
//    val pair = "Ferrari" to "Katrina" to "utubu" to "mac"                        // 3
//    println(pair)
//
//    infix fun String.onto(other: String) = Pair(this, other) to "p"  // 4
//    val myPair = "McLaren" onto "Lucas"
//    println(myPair)
//
//    val sophia = Person("Sophia")
//    val claudia = Person("Claudia")
//    sophia likes claudia                                       // 5
//
//
//    operator fun Int.times(str: String) = str.repeat(this)       // 1
//    println(2 * "Bye ")                                          // 2

//    println(double(3))
    val r1 = double(3)
//    val  r2 = double(r1)
//    print(r2)

    Person("jack").add(1.2, 2.3).let { print(trible(it)) }
//    print(trible(r))

}

fun double(x : Int) : Int {
    return x * 2
}

fun trible(x : Double) : Double {
    return x * 2
}



class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6


    fun add(p1 : Double, p2 : Double) : Double {
        return p1 + p2
    }
}