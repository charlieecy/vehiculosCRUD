package dev.carloscy.models

interface IMotorHibrido : IMotorGasolina, IMotorElectrico {

    override fun arrancar() {
        println("Arrancando motor híbrido.")
    }

    override fun parar() {
        println("Parando motor híbrido.")
    }
}