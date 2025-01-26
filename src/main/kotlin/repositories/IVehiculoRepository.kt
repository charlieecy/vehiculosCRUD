package dev.carloscy.repositories

import dev.carloscy.models.Vehiculo

interface IVehiculoRepository: ICrudRepository <Vehiculo, Int> {
    fun findBy (condition: (Vehiculo) -> Boolean) : Array<Vehiculo>
    fun averageBy (condition: (Vehiculo) -> Boolean) : Number
    fun countby (condition: (Vehiculo) -> Boolean) : Int
    fun maxBy (selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean) : Number
    fun minBy (selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean) : Number
}