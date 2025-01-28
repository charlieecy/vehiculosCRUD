package dev.carloscy.repositories
import dev.carloscy.models.Vehiculo

interface IVehiculoRepository: ICrudRepository <Vehiculo, Int> {
    fun findBy (condition: (Vehiculo) -> Boolean = {true}) : Array<Vehiculo>
    fun averageBy (condition: (Vehiculo) -> Boolean = {true}) : Number
    fun countby (condition: (Vehiculo) -> Boolean = {true}) : Int
    fun maxBy (selector: (Vehiculo) -> Number = {0}, condition: (Vehiculo) -> Boolean = {true}) : Vehiculo?
    fun minBy (selector: (Vehiculo) -> Number = {0}, condition: (Vehiculo) -> Boolean = {true}) : Vehiculo?
    fun sortedBy (
        selector: (Vehiculo) -> Number,
        mode: OrdenationMode = OrdenationMode.ASC
    ) : Array<Vehiculo>
}

enum class OrdenationMode {
    ASC,
    DESC
}