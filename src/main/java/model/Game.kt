package model

/**
 * Предоставляет доступ к различным игровым константам.
 */
class Game(
        /**
         * @return Возвращает некоторое число, которое ваша стратегия может использовать для инициализации генератора
         * случайных чисел. Данное значение имеет рекомендательный характер, однако позволит более точно
         * воспроизводить прошедшие игры.
         */
        val randomSeed: Long,
        /**
         * @return Возвращает базовую длительность игры в тиках.
         * Реальная длительность может отличаться от этого значения в меньшую сторону.
         * Поле может быть определено как `game.initialFreezeDurationTicks + game.lapCount * game.lapTickCount`.
         * Значение поля не меняется в процессе игры. Эквивалентно `world.tickCount`.
         */
        val tickCount: Int,
        /**
         * @return Возвращает ширину игрового мира в тайлах.
         */
        val worldWidth: Int,
        /**
         * @return Возвращает высоту игрового мира в тайлах.
         */
        val worldHeight: Int,
        /**
         * @return Возвращает размер (ширину и высоту) одного тайла.
         */
        val trackTileSize: Double,
        /**
         * @return Возвращает отступ от границы тайла до границы прямого участка трассы, проходящего через этот тайл.
         * Радиусы всех закруглённых сочленений участков трассы также равны этому значению.
         */
        val trackTileMargin: Double,
        /**
         * @return Возвращает количество кругов (циклов прохождения списка ключевых точек `world.waypoints`),
         * которое необходимо пройти для завершения трассы.
         */
        val lapCount: Int,
        /**
         * @return Возвращает количество тиков, которое выделяется кодемобилям на прохождение одного круга.
         * Значение является составной частью выражения для нахождения базовой длительности игры (`game.tickCount`) и
         * не используется в целях ограничения на прохождение одного отдельного круга.
         */
        val lapTickCount: Int,
        /**
         * @return Возвращает количество тиков в начале игры, в течение которых кодемобиль не может изменять своё положение.
         * Значение является составной частью выражения для нахождения базовой длительности игры (`game.tickCount`).
         */
        val initialFreezeDurationTicks: Int,
        /**
         * @return Возвращает коэффициент, определяющий количество тиков до завершения игры после финиширования трассы
         * очередным кодемобилем. Для получения более подробной информации смотрите документацию к
         * `world.lastTickIndex`.
         */
        val burningTimeDurationFactor: Double,
        finishTrackScores: IntArray,
        /**
         * @return Возвращает количество баллов, зарабатываемых кодемобилем при прохождении одного круга.
         * Баллы начисляются не единовременно, а постепенно, по мере прохождения ключевых точек.
         */
        val finishLapScore: Int,
        /**
         * @return Возвращает долю от баллов за круг (`game.finishLapScore`), которую кодемобиль заработает при
         * прохождении всех ключевых точек круга, кроме последней. Баллы равномерно распределены по ключевым точкам.
         */
        val lapWaypointsSummaryScoreFactor: Double,
        /**
         * @return Возвращает количество баллов, зарабатываемых кодемобилем при нанесении `1.0` урона кодемобилю
         * другого игрока. При нанесении меньшего урона количество баллов пропорционально падает. Результат всегда
         * округляется в меньшую сторону.
         */
        val carDamageScoreFactor: Double,
        /**
         * @return Возвращает количество баллов, зарабатываемых кодемобилем при уничтожении кодемобиля другого игрока.
         */
        val carEliminationScore: Int,
        /**
         * @return Возвращает ширину кодемобиля.
         */
        val carWidth: Double,
        /**
         * @return Возвращает высоту кодемобиля.
         */
        val carHeight: Double,
        /**
         * @return Возвращает максимальное значение, на которое может измениться относительная мощность двигателя кодемобиля
         * (`car.enginePower`) за один тик.
         */
        val carEnginePowerChangePerTick: Double,
        /**
         * @return Возвращает максимальное значение, на которое может измениться относительный угол поворота колёс
         * кодемобиля (`car.wheelTurn`) за один тик.
         */
        val carWheelTurnChangePerTick: Double,
        /**
         * @return Возвращает коэффициент, используемый для вычисления составляющей угловой скорости кодемобиля, порождаемой
         * движением кодемобиля при ненулевом относительном угле поворота колёс. Для получения более подробной информации
         * смотрите документацию к `move.wheelTurn`.
         */
        val carAngularSpeedFactor: Double,
        /**
         * @return Возвращает относительную потерю модуля скорости кодемобиля за один тик.
         */
        val carMovementAirFrictionFactor: Double,
        /**
         * @return Возвращает относительную потерю модуля угловой скорости кодемобиля за один тик. Относительная потеря
         * применяется только к составляющей угловой скорости кодемобиля, не порождаемой движением кодемобиля при ненулевом
         * относительном угле поворота колёс. Для получения более подробной информации смотрите документацию к
         * `move.wheelTurn`.
         */
        val carRotationAirFrictionFactor: Double,
        /**
         * @return Возвращает абсолютную потерю составляющей скорости кодемобиля, направленной вдоль продольной оси
         * кодемобиля, за один тик.
         */
        val carLengthwiseMovementFrictionFactor: Double,
        /**
         * @return Возвращает абсолютную потерю составляющей скорости кодемобиля, направленной вдоль поперечной оси
         * кодемобиля, за один тик.
         */
        val carCrosswiseMovementFrictionFactor: Double,
        /**
         * @return Возвращает абсолютную потерю модуля угловой скорости кодемобиля за один тик. Абсолютная потеря
         * применяется только к составляющей угловой скорости кодемобиля, не порождаемой движением кодемобиля при ненулевом
         * относительном угле поворота колёс. Для получения более подробной информации смотрите документацию к
         * `move.wheelTurn`.
         */
        val carRotationFrictionFactor: Double,
        /**
         * @return Возвращает длительность задержки в тиках, применяемой к кодемобилю после метания им снаряда.
         * В течение этого времени кодемобиль не может метать новые снаряды.
         */
        val throwProjectileCooldownTicks: Int,
        /**
         * @return Возвращает длительность задержки в тиках, применяемой к кодемобилю после использования им ускорения
         * <<нитро>>. В течение этого времени кодемобиль не может повторно использовать систему закиси азота.
         */
        val useNitroCooldownTicks: Int,
        /**
         * @return Возвращает длительность задержки в тиках, применяемой к кодемобилю после использования им канистры с
         * мазутом. В течение этого времени кодемобиль не может разлить ещё одну канистру.
         */
        val spillOilCooldownTicks: Int,
        /**
         * @return Возвращает относительную мощность двигателя кодемобиля, мгновенно устанавливаемую при использовании
         * системы закиси азота для ускорения кодемобиля.
         */
        val nitroEnginePowerFactor: Double,
        /**
         * @return Возвращает длительность ускорения <<нитро>> в тиках.
         */
        val nitroDurationTicks: Int,
        /**
         * @return Возвращает длительность интервала в тиках, по прошествии которого сильно повреждённый кодемобиль
         * (значение `car.durability` равно нулю) будет восстановлен.
         */
        val carReactivationTimeTicks: Int,
        /**
         * @return Возвращает массу кодемобиля типа багги (`CarType.BUGGY`).
         */
        val buggyMass: Double,
        /**
         * @return Возвращает максимальную мощность двигателя кодемобиля типа багги (`CarType.BUGGY`) в направлении,
         * совпадающем с направлением кодемобиля.
         */
        val buggyEngineForwardPower: Double,
        /**
         * @return Возвращает максимальную мощность двигателя кодемобиля типа багги (`CarType.BUGGY`) в направлении,
         * противоположном направлению кодемобиля.
         */
        val buggyEngineRearPower: Double,
        /**
         * @return Возвращает массу кодемобиля типа джип (`CarType.JEEP`).
         */
        val jeepMass: Double,
        /**
         * @return Возвращает максимальную мощность двигателя кодемобиля типа джип (`CarType.JEEP`) в направлении,
         * совпадающем с направлением кодемобиля.
         */
        val jeepEngineForwardPower: Double,
        /**
         * @return Возвращает максимальную мощность двигателя кодемобиля типа джип (`CarType.JEEP`) в направлении,
         * противоположном направлению кодемобиля.
         */
        val jeepEngineRearPower: Double,
        /**
         * @return Возвращает размер (ширину и высоту) бонуса.
         */
        val bonusSize: Double,
        /**
         * @return Возвращает массу бонуса.
         */
        val bonusMass: Double,
        /**
         * @return Возвращает количество баллов, мгновенно получаемых игроком, кодемобиль которого подобрал бонусные баллы
         * (`BonusType.PURE_SCORE`).
         */
        val pureScoreAmount: Int,
        /**
         * @return Возвращает радиус шайбы (`ProjectileType.WASHER`).
         */
        val washerRadius: Double,
        /**
         * @return Возвращает массу шайбы (`ProjectileType.WASHER`).
         */
        val washerMass: Double,
        /**
         * @return Возвращает начальную скорость шайбы (`ProjectileType.WASHER`).
         */
        val washerInitialSpeed: Double,
        /**
         * @return Возвращает урон шайбы (`ProjectileType.WASHER`).
         */
        val washerDamage: Double,
        /**
         * @return Возвращает модуль отклонения направления полёта двух шайб от направления кодемобиля.
         * Направление третьей шайбы совпадает с направлением кодемобиля.
         */
        val sideWasherAngle: Double,
        /**
         * @return Возвращает радиус шины (`ProjectileType.TIRE`).
         */
        val tireRadius: Double,
        /**
         * @return Возвращает массу шины (`ProjectileType.TIRE`).
         */
        val tireMass: Double,
        /**
         * @return Возвращает начальную скорость шины (`ProjectileType.TIRE`).
         */
        val tireInitialSpeed: Double,
        /**
         * @return Возвращает количество урона, которое шина нанесёт неподвижно стоящему кодемобилю при попадании в него с
         * начальной скоростью (`game.tireInitialSpeed`) и под прямым углом к поверхности кодемобиля. Движение
         * кодемобиля в направлении, совпадающем с направлением движения шины, уменьшает урон, движение в противоположном
         * направлении --- увеличивает.
         */
        val tireDamageFactor: Double,
        /**
         * @return Возвращает отношение текущей скорости шины к начальной (`game.tireInitialSpeed`), при превышении
         * которого в момент столкновения с другим объектом шина отскакивает и продолжает свой полёт. В противном случае
         * шина убирается из игрового мира.
         */
        val tireDisappearSpeedFactor: Double,
        /**
         * @return Возвращает расстояние между ближайшими точками лужи мазута и кодемобиля при использовании канистры с
         * мазутом.
         */
        val oilSlickInitialRange: Double,
        /**
         * @return Возвращает радиус лужи мазута.
         */
        val oilSlickRadius: Double,
        /**
         * @return Возвращает длительность высыхания лужи мазута в тиках.
         */
        val oilSlickLifetime: Int,
        /**
         * @return Возвращает максимально возможную длительность высыхания кодемобиля, центр которого попал в лужу мазута.
         * При этом, длительность высыхания лужа мазута сокращается на то же количество тиков. Таким образом, реальная
         * длительность высыхания кодемобиля не может превышать оставшуюся длительность высыхания лужи.
         */
        val maxOiledStateDurationTicks: Int
) {
    /**
     * @return Возвращает 0-индексированный массив, содержащий количество баллов, зарабатываемых кодемобилями при
     * завершении трассы. Кодемобиль, финишировавший первым, приносит владельцу `finishTrackScores[0]` баллов,
     * вторым --- `finishTrackScores[1]` и так далее.
     */
    val finishTrackScores: IntArray = finishTrackScores.copyOf()
}