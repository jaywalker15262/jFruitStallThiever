package com.jay.fruitstallthiever.leaf.traveling

import com.jay.fruitstallthiever.Constants
import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Condition
import org.powbot.api.Random
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class TravelToFruitStall(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Traveling To Fruit Stall") {
    override fun execute() {
        if (!Constants.AREA_FRUIT_STALL_HOUSE.contains(Players.local())) {
            Constants.PATH_HOSIDIUS.traverse()
            if (Players.local().distanceTo(Constants.TILE_HOSIDIUS).toInt() > 8
                || !Condition.wait({ !Players.local().inMotion()
                        || Players.local().distanceTo(Constants.TILE_HOSIDIUS).toInt() < 4
                }, 50, 80))
                return

            if (!Variables.hosidiusTileMatrix.valid()) {
                Variables.hosidiusTileMatrix = Constants.TILE_HOSIDIUS.matrix()
                return
            }

            if (!Variables.hosidiusTileMatrix.inViewport()) {
                Camera.turnTo(Variables.hosidiusTileMatrix)
                Condition.wait({ Variables.hosidiusTileMatrix.inViewport() }, 50, 50)
            }

            if (Players.local().distanceTo(Constants.TILE_HOSIDIUS).toInt() != 0) {
                if (!Movement.step(Constants.TILE_HOSIDIUS)) {
                    script.info("Failed to step towards the fruit stall house entrance tile.")
                    return
                }

                if (!Condition.wait({ Players.local()
                        .distanceTo(Constants.TILE_HOSIDIUS).toInt() == 0 }, 50, 80)) {
                    script.info("Failed to find that we are on the fruit stall house entrance tile.")
                    return
                }
            }
        }

        val door = Objects.stream().at(Constants.TILE_FRUIT_STALL_DOOR).id(7452, 7453).first()
        if (!door.valid()) {
            script.info("We were unable to find the door to the fruit stall.")
            return
        }

        if (door.id() == 7452) {
            if (!door.interact("Open")) {
                script.info("We were unable to open the door to the fruit stall area.")
                return
            }

            if (!Condition.wait({ !door.valid() },
                    Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 30)) {
                script.info("Failed to find that the door to the fruit stall area was opened.")
                return
            }
        }

        if (!Movement.running() && Movement.running())
            Condition.wait({ Movement.running() }, 50, 50)

        if (!Movement.step(Constants.TILE_FRUIT_STALL)) {
            script.info("Failed to step towards the fruit stall house entrance tile.")
            return
        }

        if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_FRUIT_STALL).toInt() == 0 }, 50, 80))
            script.info("Failed to find that we are on the fruit stall tile.")

        Variables.timeSinceLastThieft = ScriptManager.getRuntime(true) + 3000
    }
}