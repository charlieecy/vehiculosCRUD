package dev.carloscy.models

/**
 * Interfaz que representa el motor de un vehículo de gasolina.
 * @property consumo consumo de combustible del motor.
 */
interface IMotorGasolina: IMotor {

    var consumo: Int

    override fun arrancar() {
        println("Arrancando motor de gasolina.")
    }

    override fun parar() {
        println("Parando motor de gasolina.")
    }
}