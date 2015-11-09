package model

/**
 * Стратегия игрока может управлять кодемобилем посредством установки свойств объекта данного класса.
 */
class Move {
    /**
     * Задаёт установку режима работы двигателя кодемобиля.
     *
     * Установка режима работы является относительной и должна лежать в интервале от `-1.0` до `1.0`.
     * Значения, выходящие за указанный интервал, будут приведены к ближайшей его границе.
     *
     * Реальный режим работы двигателя может отличаться от установки, так как его изменение происходит не мгновенно, а
     * со скоростью не более `game.carEnginePowerChangePerTick` за тик. Режим работы двигателя фактически
     * определяет ускорение в направлении, совпадающем с углом поворота кодемобиля. Абсолютное значение ускорения
     * равномерно изменяется на интервале от `-1.0` до `0.0` и на интервале от `0.0` до `1.0`.
     */
    var enginePower: Double = 0.0

    /**
     * Задаёт текущее положение педали тормоза.
     *
     * При утопленной педали тормоза значение силы трения вдоль направления, совпадающего с углом поворота кодемобиля,
     * возрастает с `game.carLengthwiseMovementFrictionFactor` до `game.carCrosswiseMovementFrictionFactor`.
     */
    var isBrake: Boolean = false

    /**
     * Задаёт относительный угол поворота колёс (или руля, что эквивалентно) кодемобиля.
     *
     * Относительный угол должен лежать в интервале от `-1.0` до `1.0`.
     * Значения, выходящие за указанный интервал, будут приведены к ближайшей его границе.
     *
     * Реальный поворот колёс может отличаться от установки, так как его изменение происходит не мгновенно, а
     * со скоростью не более `game.carWheelTurnChangePerTick` за тик. Поворот колёс создаёт добавочную угловую
     * скорость кодемобиля (помимо угловой скорости, вызванной соударениями объектов и другими причинами), значение
     * которой прямо пропорционально текущему относительному углу поворота колёс кодемобиля (`car.wheelTurn`),
     * коэффцициенту `game.carAngularSpeedFactor`, а также скалярному произведению вектора скорости кодемобиля и
     * единичного вектора, направление которого совпадает с направлением кодемобиля.
     */
    var wheelTurn: Double = 0.0

    /**
     * Устанавливает значение указания метнуть снаряд.
     *
     * Указание может быть проигнорировано, если у кодемобиля не осталось снарядов
     * либо прошло менее `game.throwProjectileCooldownTicks` тиков с момента запуска предыдущего снаряда.
     */
    var isThrowProjectile: Boolean = false

    /**
     * Устанавливает значение указания использовать <<нитро>>.
     *
     * Указание может быть проигнорировано, если у кодемобиля не осталось зарядов для системы закиси азота
     * либо прошло менее `game.useNitroCooldownTicks` тиков с момента предыдущего ускорения.
     */
    var isUseNitro: Boolean = false

    /**
     * Устанавливает значение указания разлить канистру с мазутом.
     *
     * Указание может быть проигнорировано, если у кодемобиля не осталось канистр с мазутом
     * либо прошло менее `game.spillOilCooldownTicks` тиков с момента предыдущего использования данного действия.
     */
    var isSpillOil: Boolean = false
}