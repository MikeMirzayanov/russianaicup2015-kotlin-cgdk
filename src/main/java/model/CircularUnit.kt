package model

/**
 * Базовый класс для определения круглых объектов. Содержит также все свойства юнита.
 */
abstract class CircularUnit protected constructor(
        id: Long, mass: Double,
        x: Double, y: Double,
        speedX: Double, speedY: Double,
        angle: Double, angularSpeed: Double,
        /**
         * @return Возвращает радиус объекта.
         */
        val radius: Double
) : Unit(id, mass, x, y, speedX, speedY, angle, angularSpeed)
