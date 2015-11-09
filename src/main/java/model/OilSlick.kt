package model

/**
 * Класс, определяющий лужу мазута. Содержит также все свойства круглого юнита.
 */
class OilSlick(
        id: Long, mass: Double,
        x: Double, y: Double,
        speedX: Double, speedY: Double,
        angle: Double, angularSpeed: Double,
        radius: Double,
        /**
         * @return Возвращает количество тиков, по прошествии которого лужа мазута полностью высохнет.
         */
        val remainingLifetime: Int
) : CircularUnit(id, mass, x, y, speedX, speedY, angle, angularSpeed, radius)
