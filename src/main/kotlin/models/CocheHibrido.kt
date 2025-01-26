package dev.carloscy.models

import java.time.LocalDateTime

class CocheHibrido(
    id: Int,
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    motor: IMotorHibrido,
    createdAt: LocalDateTime,
    updatedAt: LocalDateTime,
    isActive: Boolean,
) : Vehiculo (id, matricula, kms, anoMatriculacion, motor, createdAt, updatedAt, isActive) {
}