package dev.carloscy

import dev.carloscy.factories.VehiculosFactory
import dev.carloscy.repositories.VehiculoRepositoryImpl

const val COCHE_GASOLINA: Int = 1
const val COCHE_ELECTRICO: Int = 2
const val COCHE_HIBRIDO: Int = 3
const val MOTOCICLETA: Int = 4

fun main() {

    val repository = VehiculoRepositoryImpl()
    val factory = VehiculosFactory()

    val v1 = factory.vehiculoRandom()
    val v2 = factory.vehiculoRandom()
    val v3 = factory.vehiculoRandom()
    val v4 = factory.vehiculoRandom()
    val v5 = factory.vehiculoRandom()
    val v6 = factory.vehiculoRandom()
    val v7 = factory.vehiculoRandom()
    val v8 = factory.vehiculoRandom()
    val v9 = factory.vehiculoRandom()
    val v10 = factory.vehiculoRandom()

}