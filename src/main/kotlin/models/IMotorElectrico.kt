package dev.carloscy.models

/**
 * Interfaz que representa el motor de un vehículo eléctrico.
 * @property tiempoCarga tiempo de carga del motor.
 */
interface IMotorElectrico: IMotor {

    var tiempoCarga: Int

    override fun arrancar() {
        println("Arrancando motor eléctrico.")
    }

    override fun parar() {
        println("Parando motor eléctrico.")
    }
}