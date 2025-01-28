package dev.carloscy

import dev.carloscy.factories.VehiculosFactory
import dev.carloscy.models.CocheGasolina
import dev.carloscy.models.IMotorGasolina
import dev.carloscy.repositories.VehiculoRepositoryImpl

fun main() {

    //Instanciamos el repositorio y la "fábrica" de vehículos aleatorios
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

    //Rellenamos el array por completo (10 de tamaño máximo)
    repository.save(v1)
    repository.save(v2)
    repository.save(v3)
    repository.save(v4)
    repository.save(v5)
    repository.save(v6)
    repository.save(v7)
    repository.save(v8)
    repository.save(v9)
    repository.save(v10)

    //Creamos otro vehículo para ver si funciona la redimensión en la función save
    val v11 = factory.vehiculoRandom()
    repository.save(v11)

    //Imprimimos todos los vehículos
    repository.findAll().forEach { println(it) }

    //Buscamos por ID
    //EXISTE, imprime el vehículo
    println(repository.findById(3))
    //NO EXISTE, imprime null
    println(repository.findById(13))

    //Actualizamos un vehículo
    //EXISTE, imprimimos para ver si se ha actualizado
    repository.findById(1)?.let { repository.update(1, it) }
    println(repository.findById(1))
    //NO existe, al no encontrarlo no se debe ejecutar el update
    repository.findById(13)?.let { repository.update(13, it) }

    //Borrado lógico de un vehículo
    //EXISTE, imprimimos para ver si se ha borrado
    repository.delete(4)
    println(repository.findById(4))
    //NO EXISTE, el logger debería avisarnos de que no ha podido borrarse
    repository.delete(13)

    //Filtramos por una condicion
    //Aquellos vehículos cuyo año de matriculación sea posterior a 1980
    repository.findBy{it.anoMatriculacion > 1980}.forEach { println(it) }
    //Aquellos coches de gasolina
    repository.findBy{it is CocheGasolina}.forEach { println(it) }
    repository.findBy{it is IMotorGasolina}.forEach { println(it) }
}