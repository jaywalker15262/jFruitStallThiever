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
        // traveling to Kourend.
        if (Game.floor() != 1) {
            if (Players.local().distanceTo(Constants.TILE_HOSIDIUS).toInt() > 100
                || Constants.AREA_PLOUGHING.contains(Players.local())) {
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

                    var draynorChatOption = Chat.stream().text("Draynor Village").first()
                    for (i in 1..17) {
                        if (draynorChatOption.valid())
                            break

                        Condition.sleep(Random.nextGaussian(270, 450, 300, 30.0))
                        draynorChatOption = Chat.stream().text("Draynor Village").first()
                    }

                    if (!draynorChatOption.valid()) {
                        script.info("Failed to find chat options after rubbing the amulet.")
                        return
                    }

                    if (!draynorChatOption.select()) {
                        script.info("Failed to select the option to teleport to draynor village.")
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

                    if (!Condition.wait({ !Chat.canContinue() },
                            Condition.sleep(Random.nextGaussian(270, 450, 300, 30.0)), 17)) {
                        script.info("Failed to find that we started chatting.")
                        return
                    }

                    if (!Chat.clickContinue()) {
                        script.info("Failed to start the dialogue.")
                        return
                    }

                    if (!Condition.wait({ Chat.getChatMessage() == Constants.VEOS_DIALOGUE_1 },
                            Condition.sleep(Random.nextGaussian(270, 450, 300, 30.0)), 17)) {
                        script.info("Failed to find that we arrived at diaolgue 1.")
                        return
                    }

                    if (!Chat.clickContinue()) {
                        script.info("Failed to continue the dialogue 1.")
                        return
                    }

                    var veosChatOption = Chat.stream().text("That's great, can you take me there please?").first()
                    for (i in 1..17) {
                        if (veosChatOption.valid())
                            break

                        Condition.sleep(Random.nextGaussian(270, 450, 300, 30.0))
                        veosChatOption = Chat.stream().text("That's great, can you take me there please?").first()
                    }

                    if (!veosChatOption.valid()) {
                        script.info("Failed to find the first chat options.")
                        return
                    }

                    if (!veosChatOption.select()) {
                        script.info("Failed to select the first chat option.")
                        return
                    }

                    if (!Condition.wait({ !Chat.canContinue() },
                            Condition.sleep(Random.nextGaussian(270, 450, 300, 30.0)), 17)) {
                        script.info("Failed to find that we started dialogue 2.")
                        return
                    }

                    if (!Chat.clickContinue()) {
                        script.info("Failed to continue dialogue 2.")
                        return
                    }

                    if (!Condition.wait({ Chat.getChatMessage() == Constants.VEOS_DIALOGUE_2 },
                            Condition.sleep(Random.nextGaussian(270, 450, 300, 30.0)), 17)) {
                        script.info("Failed to find that we arrived at diaolgue 2.")
                        return
                    }

                    if (!Condition.wait({ Players.local().distanceTo(Constants.TILE_PORT_PISCARILIUS).toInt() < 7 },
                            Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 50)) {
                        script.info("Failed to find that we arrived at port piscarilius.")
                        return
                    }
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

        // traveling to the fruit stall house entrance.
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