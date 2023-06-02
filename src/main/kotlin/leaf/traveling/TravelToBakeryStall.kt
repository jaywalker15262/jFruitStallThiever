package com.jay.fruitstallthiever.leaf.traveling

import com.jay.fruitstallthiever.Constants
import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Condition
import org.powbot.api.Random
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class TravelToBakeryStall(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Traveling To Bakery Stall") {
    override fun execute() {
        if (Players.local().distanceTo(Constants.TILE_ARDOUNGE).toInt() > 100
            && Players.local().distanceTo(Constants.TILE_FISHING_GUILD).toInt() > 6) {
            val skillsNecklace = Equipment.stream().name("Skills necklace(6)", "Skills necklace(5)",
                "Skills necklace(4)", "Skills necklace(3)", "Skills necklace(2)", "Skills necklace(1)").first()
            if (!skillsNecklace.valid()) {
                script.info("We were unable to find a charged skills necklace equipped.")
                return
            }

            if (!skillsNecklace.interact("Fishing Guild")) {
                script.info("Failed to teleport to the fishing guild.")
                return
            }

            if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_FISHING_GUILD).toInt() < 7 },
                    Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 35)) {
                script.info("Failed to find that we teleported to the fishing guild.")
                return
            }
        }

        Constants.PATH_ARDOUNGE.traverse()
        if (Players.local().distanceTo(Constants.TILE_ARDOUNGE).toInt() > 8 ||
            !Condition.wait({ !Players.local().inMotion()
                    || Players.local().distanceTo(Constants.TILE_ARDOUNGE).toInt() < 4 }, 50, 80))
            return

        if (!Variables.ardoungeTileMatrix.valid()) {
            Variables.ardoungeTileMatrix = Constants.TILE_ARDOUNGE.matrix()
            return
        }

        if (!Variables.ardoungeTileMatrix.inViewport()) {
            Camera.turnTo(Variables.ardoungeTileMatrix)
            Condition.wait({ Variables.ardoungeTileMatrix.inViewport() }, 50 ,50)
        }

        if (Players.local().distanceTo(Constants.TILE_ARDOUNGE).toInt() != 0) {
            if (!Movement.step(Constants.TILE_ARDOUNGE)) {
                script.info("Failed to step towards the ardounge thieving tile.")
                return
            }

            if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_ARDOUNGE).toInt() == 0 }, 50, 80))
                script.info("Failed to find that we are on the ardounge thieving tile.")
        }

        Variables.timeSinceLastThieft = ScriptManager.getRuntime(true) + 3000
    }
}