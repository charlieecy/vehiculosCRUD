package dev.carloscy

import dev.carloscy.repositories.VehiculoRepositoryImpl

const val COCHE_GASOLINA: Int = 1
const val COCHE_ELECTRICO: Int = 2
const val COCHE_HIBRIDO: Int = 3
const val MOTOCICLETA: Int = 4

fun main() {

    val repository = VehiculoRepositoryImpl()

    val v1 = repository.create()

    println(v1)

    val v2 = repository.create()

    println(v2)

}