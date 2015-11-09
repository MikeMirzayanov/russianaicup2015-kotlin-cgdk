package model

/**
 * Базовый класс для определения прямоугольных объектов. Содержит также все свойства юнита.
 */
abstract class RectangularUnit protected constructor(
        id: Long, mass: Double,
        x: Double, y: Double,
        speedX: Double, speedY: Double,
        angle: Double, angularSpeed: Double,
        /**
         * @return Возвращает ширину объекта.
         */
        val width: Double,
        /**
         * @return Возвращает высоту объекта.
         */
        val height: Double
) : Unit(id, mass, x, y, speedX, speedY, angle, angularSpeed)
