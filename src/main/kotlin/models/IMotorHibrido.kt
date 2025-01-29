package dev.carloscy.models

/**
 * Interfaz que representa el motor de un vehículo híbrido.
 * Combinación de un motor de gasolina y uno eléctrico.
 */
interface IMotorHibrido : IMotorGasolina, IMotorElectrico {

    override fun arrancar() {
        println("Arrancando motor híbrido.")
    }

    override fun parar() {
        println("Parando motor híbrido.")
    }
}