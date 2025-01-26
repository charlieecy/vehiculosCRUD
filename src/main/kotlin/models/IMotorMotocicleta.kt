package dev.carloscy.models

interface IMotorMotocicleta: IMotor {

    var cilindrada: Int

    override fun arrancar() {
        println("Arrancando motor de motocicleta.")
    }

    override fun parar() {
        println("Parando motor de motocicleta.")
    }
}