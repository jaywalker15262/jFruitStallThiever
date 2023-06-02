package com.jay.fruitstallthiever.leaf.traveling

import com.jay.fruitstallthiever.Constants
import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Condition
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf

class TravelToPlough(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Traveling To Ploughing Area") {
    override fun execute() {
        Constants.PATH_PLOUGHING.traverse()
        if (Players.local().distanceTo(Constants.TILE_PLOUGHING).toInt() > 8
            || !Condition.wait({ !Players.local().inMotion()
                    || Players.local().distanceTo(Constants.TILE_PLOUGHING).toInt() < 4 }, 50, 80))
            return

        if (!Variables.ploughingTileMatrix.valid()) {
            Variables.ploughingTileMatrix = Constants.TILE_PLOUGHING.matrix()
            return
        }

        if (!Variables.ploughingTileMatrix.inViewport()) {
            Camera.turnTo(Variables.ploughingTileMatrix)
            Condition.wait({ Variables.ploughingTileMatrix.inViewport() }, 50, 50)
        }

        if (Players.local().distanceTo(Constants.TILE_PLOUGHING).toInt() != 0) {
            if (!Movement.step(Constants.TILE_PLOUGHING)) {
                script.info("Failed to step towards the ploughing area tile.")
                return
            }

            if (!Condition.wait({ Players.local()
                    .distanceTo(Constants.TILE_PLOUGHING).toInt() == 0 }, 50, 80)) {
                script.info("Failed to find that we are on the ploughing area tile.")
                return
            }
        }
    }
}