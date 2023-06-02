package com.jay.fruitstallthiever

import org.powbot.api.Random
import org.powbot.api.rt4.Npc

object Variables {
    var stopAtLvl = 99
    var stopAfterMinutes = 0
    var thievingArea = 0
    var dropAtcount = Random.nextGaussian(1, 4, 4, 1.0)
    var lastKnownThievingXp = 0
    var timeSinceLastThievingXp: Long = 0
    var timeSinceLastThieft: Long = 0

    var ardoungeTileMatrix = Constants.TILE_ARDOUNGE.matrix()
    var hosidiusTileMatrix = Constants.TILE_HOSIDIUS.matrix()
    var veosTileMatrix = Constants.TILE_VEOS.matrix()

    // Hosidius favour - Ploughing
    var favour = 0
    var favourPercent = 0.0f
    var ploughXCoord = 0
    var timeSinceLastPlough: Long = 0
    var ploughWest = true
    var plough = Npc.Nil
    var ploughingTileMatrix = Constants.TILE_PLOUGHING.matrix()

    // World-hopping
    var worldId = 0
}