import model.Car
import model.Game
import model.Move
import model.World

class MyStrategy : Strategy {
    override fun move(self: Car, world: World, game: Game, move: Move) {
        move.enginePower = 1.0
        move.isThrowProjectile = true
        move.isSpillOil = true

        if (world.tick > game.initialFreezeDurationTicks) {
            move.isUseNitro = true
        }
    }
}
