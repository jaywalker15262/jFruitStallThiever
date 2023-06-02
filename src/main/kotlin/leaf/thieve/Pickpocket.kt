package com.jay.fruitstallthiever.leaf.thieve

import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Condition
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Skills
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class Pickpocket(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Pickpocketing") {
    override fun execute() {
        if (Skills.level(Skill.Hitpoints) == 1) {
            script.info("We have too little hitpoints to keep pickpocketing.")
            return
        }

        val pickpocketTarget = Npcs.stream().name("Man", "Woman").within(20).reachable().nearest()
            .filtered { !it.inCombat() }.first()
        if (!pickpocketTarget.valid()) {
            script.info("Failed to find any target to pickpocket.")
            return
        }

        if (!pickpocketTarget.inViewport()) {
            Camera.turnTo(pickpocketTarget)
            if (Condition.wait({ pickpocketTarget.inViewport() }, 50, 50)) {
                script.info("Cannot pickpocket, NPC not in viewport.")
                return
            }
        }

        val oldThievingXp = Variables.lastKnownThievingXp
        // We need to set it here, before interacting with the npc, just in case.
        Variables.lastKnownThievingXp = Skills.experience(Skill.Thieving)
        pickpocketTarget.bounds(-16, 16, -16, -16, -16, 16)
        if (!pickpocketTarget.interact("Pickpocket", true)) {
            script.info("Failed to pickpocket the target.")
            Variables.lastKnownThievingXp = oldThievingXp
            return
        }

        Variables.timeSinceLastThievingXp = ScriptManager.getRuntime(true) + 1200     // Failsafe
    }
}

class OpeningCoinPouch(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Opening Coin Pouches") {
    override fun execute() {
        val coinPouch = Inventory.stream().name("Coin pouch").first()
        if (!coinPouch.interact("Open-all") || !Condition.wait({ !coinPouch.valid() }, 50, 60))
            script.info("Failed to drop the coin pouches.")
    }
}