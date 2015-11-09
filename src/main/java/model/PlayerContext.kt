package model

class PlayerContext(cars: Array<Car>, val world: World) {
    val cars: Array<Car> = cars.copyOf()
}
