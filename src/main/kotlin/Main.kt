package dev.carloscy

import com.github.ajalt.mordant.rendering.TextColors
import dev.carloscy.extensions.ModoOrdenamiento
import dev.carloscy.factories.VehiculosFactory
import dev.carloscy.models.*
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
    val v11 = factory.vehiculoRandom()

    //Rellenamos la lista
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
    repository.save(v11)

    println(TextColors.blue("Imprimimos todos los vehículos"))
    repository.findAll().forEach { println(it) }

    println()

    println(TextColors.blue("Buscamos por ID"))
    println(TextColors.blue("ID: 3 (existe)"))
    println(repository.findById(3))

    println(TextColors.blue("ID: 13 (no existe)"))
    println(repository.findById(13))

    println()

    println(TextColors.blue("Actualizamos un vehículo"))
    println(TextColors.blue("ID: 1 (existe)"))
    repository.findById(1)?.let { repository.update(1, it) }
    println(repository.findById(1))

    println(TextColors.blue("ID: 13 (no existe), al no encontrarlo no se ejecuta update()"))
    repository.findById(13)?.let { repository.update(13, it) }

    println()

    println(TextColors.blue("Borramos un vehículo"))
    println(TextColors.blue("ID: 4 (existe)"))
    repository.delete(4)
    println(repository.findById(4))
    println(TextColors.blue("ID: 13 (no existe)"))
    repository.delete(13)

    println()

    println(TextColors.blue("Vehículos con fecha de matriculación > 1980"))
    repository.findBy{it.anoMatriculacion > 1980}.forEach { println(it) }

    println()

    println(TextColors.blue("Coches de gasolina"))
    repository.findBy{it is CocheGasolina}.forEach { println(it) }

    println()

    println(TextColors.blue("Coches híbridos"))
    repository.findBy{it is CocheHibrido}.forEach { println(it) }

    println()

    println(TextColors.blue("Coches eléctricos"))
    repository.findBy{it is CocheElectrico}.forEach { println(it) }

    println()

    println(TextColors.blue("Motocicletas"))
    repository.findBy{it is Motocicleta}.forEach { println(it) }

    println()

    println(TextColors.blue("Motocicleta más nueva"))
    println(repository.maxBy ({ it.anoMatriculacion }, {it is Motocicleta}))

    println()

    println(TextColors.blue("Vehículo con el máximo de kms"))
    println(repository.maxBy ({ it.kms }, {true}))

    println()

    println(TextColors.blue("Vehículo más antiguo"))
    println(repository.minBy ({ it.anoMatriculacion }, {true}))

    println()

    println(TextColors.blue("Nº de vehículos con más de 200.000 kms "))
    println(repository.countby({it.kms > 200000}))

    println()

    println(TextColors.blue("Vehículos ordenados por kms en orden asdcendente"))
    repository.sortedBy(){it.kms}.forEach { println(it) }

    println()

    println(TextColors.blue("Vehículos ordenados por año de matriculación en orden descendente"))
    repository.sortedBy(ModoOrdenamiento.DESCENDENTE) {it.anoMatriculacion}.forEach { println(it) }

    println()

    println(TextColors.blue("Coches híbridos más antiguos de 2000 ordenados de forma ascendente"))
    repository.findBy{it is CocheHibrido && it.anoMatriculacion < 2000}.sortedBy { it.anoMatriculacion }.forEach { println(it) }
}