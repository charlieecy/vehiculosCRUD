package dev.carloscy.repositories

import dev.carloscy.models.*
import org.lighthousegames.logging.logging

class VehiculoRepositoryImpl: IVehiculoRepository {
    val logger = logging()
    private var maxVehiculos: Int = 10
    private var vehiculos: Array<Vehiculo?> = arrayOfNulls<Vehiculo>(maxVehiculos)

    override fun findBy(condition: (Vehiculo) -> Boolean): Array<Vehiculo> {
        TODO("Not yet implemented")
    }

    override fun averageBy(condition: (Vehiculo) -> Boolean): Number {
        TODO("Not yet implemented")
    }

    override fun countby(condition: (Vehiculo) -> Boolean): Int {
        TODO("Not yet implemented")
    }

    override fun maxBy(selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun minBy(selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun sortedBy(selector: (Vehiculo) -> Number, mode: OrdenationMode): Array<Vehiculo> {
        TODO("Not yet implemented")
    }

    override fun save(item: Vehiculo): Vehiculo {
        TODO("Not yet implemented")
    }

    override fun findAll(): Array<Vehiculo> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, item: Vehiculo): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Vehiculo? {
        TODO("Not yet implemented")
    }
}




