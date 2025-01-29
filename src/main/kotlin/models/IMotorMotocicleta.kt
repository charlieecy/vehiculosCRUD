package dev.carloscy.models

/**
 * Interfaz que representa el motor de una motocicleta.
 * @property cilindrada cilindrada del motor.
 */
interface IMotorMotocicleta: IMotor {

    var cilindrada: Int

    override fun arrancar() {
        println("Arrancando motor de motocicleta.")
    }

    override fun parar() {
        println("Parando motor de motocicleta.")
    }
}