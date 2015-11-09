package model

/**
 * Класс, определяющий бонус --- неподвижный полезный объект. Содержит также все свойства прямоугольного юнита.
 */
class Bonus(
        id: Long, mass: Double,
        x: Double, y: Double,
        speedX: Double, speedY: Double,
        angle: Double, angularSpeed: Double,
        width: Double, height: Double,
        /**
         * @return Возвращает тип бонуса.
         */
        val type: BonusType
) : RectangularUnit(id, mass, x, y, speedX, speedY, angle, angularSpeed, width, height)
