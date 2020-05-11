package cn.elmi.example.ddd

import io.micronaut.runtime.Micronaut

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut
            .build()
            .packages("cn.elmi.example.ddd")
            .mainClass(javaClass)
            .start()
    }
}