package dev.carloscy.repositories
import dev.carloscy.extensions.ModoOrdenamiento
import dev.carloscy.models.Vehiculo

/**
 * Interfaz que contiene las funciones que tendrá que implementar nuestro repositorio de vehículos.
 */
interface IVehiculoRepository: ICrudRepository <Vehiculo, Int> {
    fun findBy (condition: (Vehiculo) -> Boolean = {true}) : List<Vehiculo>
    fun averageBy (condition: (Vehiculo) -> Boolean = {true}) : Number
    fun countby (condition: (Vehiculo) -> Boolean = {true}) : Int
    fun maxBy (selector: (Vehiculo) -> Int = {0}, condition: (Vehiculo) -> Boolean = {true}) : Vehiculo?
    fun minBy (selector: (Vehiculo) -> Int = {0}, condition: (Vehiculo) -> Boolean = {true}) : Vehiculo?
    fun sortedBy (
        mode: ModoOrdenamiento = ModoOrdenamiento.ASCENDENTE,
        selector: (Vehiculo) -> Int
    ) : List<Vehiculo>
}

