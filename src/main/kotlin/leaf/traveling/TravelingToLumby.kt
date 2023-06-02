package com.jay.fruitstallthiever.leaf.traveling

import com.jay.fruitstallthiever.Constants
import com.jay.fruitstallthiever.FruitStallThiever
import org.powbot.api.Condition
import org.powbot.api.Random
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class TravelToLumby(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Traveling To Lumbridge") {
    override fun execute() {
        val lumbyTablet = Inventory.stream().name("Lumbridge teleport").first()
        if (!lumbyTablet.valid()) {
            script.info("Failed to find a lumbridge tablet in our inventory.")
            return
        }

        if (!lumbyTablet.interact("Break")) {
            script.info("Failed to find teleport to lumbridge.")
            return
        }

        if (!Condition.wait({ Constants.AREA_LUMBY.contains(Players.local()) },
                Condition.sleep(Random.nextGaussian(170, 250, 200, 20.0)), 35)) {
            script.info("Failed to find that we teleported to lumbridge.")
            return
        }
    }
}