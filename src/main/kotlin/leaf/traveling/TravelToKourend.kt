package com.jay.fruitstallthiever.leaf.traveling

import com.jay.fruitstallthiever.Constants
import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Condition
import org.powbot.api.Random
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf

class TravelToKourend(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Traveling To Kourend") {
    override fun execute() {
        if (Game.floor() != 1) {
            if (Players.local().distanceTo(Constants.TILE_VEOS).toInt() > 54 &&
                Players.local().distanceTo(Constants.TILE_DRAYNOR_VILLAGE).toInt() > 6) {
                val skillsNecklace = Inventory.stream().name("Amulet of glory(6)", "Amulet of glory(5)",
                    "Amulet of glory(4)", "Amulet of glory(3)", "Amulet of glory(2)", "Amulet of glory(1)").first()
                if (!skillsNecklace.valid()) {
                    script.info("We were unable to find a charged amulet of glory in our inventory.")
                    return
                }

                if (!skillsNecklace.interact("Rub")) {
                    script.info("Failed to rub the amulet.")
                    return
                }

                if (!Condition.wait({ Chat.chatting() },
                        Random.nextGaussian(270, 450, 300, 30.0), 17)) {
                    script.info("Failed to find that we are chatting after rubbing the amulet.")
                    return
                }

                if (!Chat.completeChat("Draynor Village")
                    || !Condition.wait({ !Chat.chatting() },
                        Random.nextGaussian(270, 450, 300, 30.0), 17)) {
                    script.info("Failed to complete the conversation after rubbing the amulet.")
                    return
                }

                if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_DRAYNOR_VILLAGE).toInt() < 7 },
                        Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 35)) {
                    script.info("Failed to find that we teleported to draynor village.")
                    return
                }
            }

            Constants.PATH_VEOS.traverse()
            if (Players.local().distanceTo(Constants.TILE_VEOS).toInt() > 8
                || !Condition.wait({ !Players.local().inMotion()
                        || Players.local().distanceTo(Constants.TILE_VEOS).toInt() < 4 }, 50, 80))
                return

            if (!Variables.veosTileMatrix.valid()) {
                Variables.veosTileMatrix = Constants.TILE_VEOS.matrix()
                return
            }

            if (!Variables.veosTileMatrix.inViewport()) {
                Camera.turnTo(Variables.veosTileMatrix)
                Condition.wait({ Variables.veosTileMatrix.inViewport() }, 50, 50)
            }

            if (Players.local().distanceTo(Constants.TILE_VEOS).toInt() != 0) {
                if (!Movement.step(Constants.TILE_VEOS)) {
                    script.info("Failed to step towards the veos tile.")
                    return
                }

                if (!Condition.wait({ Players.local()
                        .distanceTo(Constants.TILE_VEOS).toInt() == 0 }, 50, 80))
                    script.info("Failed to find that we are on the veos tile.")
            }

            val veosNpc = Npcs.stream().within(10).name("Veos").first()
            if (!veosNpc.valid()) {
                script.info("We were unable to find Veos to travel to kourend.")
                return
            }

            if (veosNpc.actions().contains("Port Piscarilius")) {
                if (!veosNpc.interact("Port Piscarilius", true)) {
                    script.info("We were unable to travel to Port Piscarilius.")
                    return
                }

                if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_PORT_PISCARILIUS_BOAT).toInt() < 7 },
                        Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 50)) {
                    script.info("Failed to find that we arrived at port piscarilius.")
                    return
                }
            } else {
                if (!veosNpc.interact("Talk-to")) {
                    script.info("Failed to talk to veos.")
                    return
                }

                if (!Condition.wait({ Chat.chatting() },
                        Random.nextGaussian(270, 450, 300, 30.0), 17)) {
                    script.info("Failed to find that we are chatting after talking to Veos.")
                    return
                }

                if (!Chat.completeChat(*arrayOf("That's great, can you take me there please?"))
                    || !Condition.wait({ !Chat.chatting() },
                        Random.nextGaussian(270, 450, 300, 30.0), 17)) {
                    script.info("Failed to complete the conversation after talking to Veos.")
                    return
                }

                if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_PORT_PISCARILIUS).toInt() < 7 },
                        Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 50)) {
                    script.info("Failed to find that we arrived at port piscarilius.")
                    return
                }
            }
        }
        else {
            val gangPlank = Objects.stream(10).name("Gangplank").first()
            if (!gangPlank.valid()) {
                script.info("Failed to find the gangplank.")
                return
            }

            gangPlank.bounds(-26, 26, -18, 0, -32, -32)
            if (!gangPlank.interact("Cross")) {
                script.info("Failed to cross the gangplank.")
                return
            }

            if (!Condition.wait({ Game.floor() == 0 },
                    Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 30)) {
                script.info("Failed to find that we walked across the gangplank.")
                return
            }
        }
    }
}