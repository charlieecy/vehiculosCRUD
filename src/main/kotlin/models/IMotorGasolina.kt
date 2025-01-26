package dev.carloscy.models

interface IMotorGasolina: IMotor {

    var consumo: Int

    override fun arrancar() {
        println("Arrancando motor de gasolina.")
    }

    override fun parar() {
        println("Parando motor de gasolina.")
    }
}