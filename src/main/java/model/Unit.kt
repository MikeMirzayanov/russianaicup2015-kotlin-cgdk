package model

import java.lang.StrictMath.*

/**
 * Базовый класс для определения объектов (<<юнитов>>) на игровом поле.
 */
abstract class Unit protected constructor(
        /**
         * @return Возвращает уникальный идентификатор объекта.
         */
        val id: Long,
        /**
         * @return Возвращает массу объекта в единицах массы.
         */
        val mass: Double,
        /**
         * @return Возвращает X-координату центра объекта. Ось абсцисс направлена слева направо.
         */
        val x: Double,
        /**
         * @return Возвращает Y-координату центра объекта. Ось ординат направлена свеху вниз.
         */
        val y: Double,
        /**
         * @return Возвращает X-составляющую скорости объекта. Ось абсцисс направлена слева направо.
         */
        val speedX: Double,
        /**
         * @return Возвращает Y-составляющую скорости объекта. Ось ординат направлена свеху вниз.
         */
        val speedY: Double,
        /**
         * @return Возвращает угол поворота объекта в радианах. Нулевой угол соответствует направлению оси абсцисс.
         * Положительные значения соответствуют повороту по часовой стрелке.
         */
        val angle: Double,
        /**
         * @return Возвращает скорость вращения объекта.
         * Положительные значения соответствуют вращению по часовой стрелке.
         */
        val angularSpeed: Double
) {
    /**
     * @param x X-координата точки.
     *
     * @param y Y-координата точки.
     *
     * @return Возвращает ориентированный угол [`-PI`, `PI`] между направлением
     * данного объекта и вектором из центра данного объекта к указанной точке.
     */
    fun getAngleTo(x: Double, y: Double): Double {
        val absoluteAngleTo = atan2(y - this.y, x - this.x)
        var relativeAngleTo = absoluteAngleTo - angle

        while (relativeAngleTo > PI) {
            relativeAngleTo -= 2.0 * PI
        }

        while (relativeAngleTo < -PI) {
            relativeAngleTo += 2.0 * PI
        }

        return relativeAngleTo
    }

    /**
     * @param unit Объект, к центру которого необходимо определить угол.
     *
     * @return Возвращает ориентированный угол [`-PI`, `PI`] между направлением
     * данного объекта и вектором из центра данного объекта к центру указанного объекта.
     */
    fun getAngleTo(unit: Unit): Double {
        return getAngleTo(unit.x, unit.y)
    }

    /**
     * @param x X-координата точки.
     *
     * @param y Y-координата точки.
     *
     * @return Возвращает расстояние до точки от центра данного объекта.
     */
    fun getDistanceTo(x: Double, y: Double): Double {
        return hypot(x - this.x, y - this.y)
    }

    /**
     * @param unit Объект, до центра которого необходимо определить расстояние.
     *
     * @return Возвращает расстояние от центра данного объекта до центра указанного объекта.
     */
    fun getDistanceTo(unit: Unit): Double {
        return getDistanceTo(unit.x, unit.y)
    }
}
