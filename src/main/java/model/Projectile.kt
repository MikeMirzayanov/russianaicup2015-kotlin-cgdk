package model

/**
 * Класс, определяющий метательный снаряд. Содержит также все свойства круглого юнита.
 */
class Projectile(
        id: Long, mass: Double,
        x: Double, y: Double,
        speedX: Double, speedY: Double,
        angle: Double, angularSpeed: Double,
        radius: Double,
        /**
         * @return Возвращает идентификатор кодемобиля, выпустившего данный снаряд.
         */
        val carId: Long,
        /**
         * @return Возвращает идентификатор игрока, кодемобиль которого выпустил данный снаряд.
         */
        val playerId: Long,
        /**
         * @return Возвращает тип метательного снаряда.
         */
        val type: ProjectileType
) : CircularUnit(id, mass, x, y, speedX, speedY, angle, angularSpeed, radius)
