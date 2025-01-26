package dev.carloscy.models

interface IMotorElectrico: IMotor {

    var tiempoCarga: Double

    override fun arrancar() {
        println("Arrancando motor eléctrico.")
    }

    override fun parar() {
        println("Parando motor eléctrico.")
    }
}