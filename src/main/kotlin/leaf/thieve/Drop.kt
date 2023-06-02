package com.jay.fruitstallthiever.leaf.thieve

import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Random
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class Drop(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Dropping") {
    override fun execute() {
        val itemsToDrop = Inventory.stream().name("Cake", "Bread", "Chocolate slice", "Cooking apple", "Banana", "Strawberry",
            "Jangerberries", "Lemon", "Redberries", "Pineapple", "Lime", "Strange fruit", "Golovanova fruit top",
            "Papaya fruit").toList()
        if (itemsToDrop.isEmpty()) {
            script.info("We were unable to find any items to drop.")
            return
        }

        if (!Inventory.drop(itemsToDrop)) {
            script.info("Failed to drop items.")
            return
        }

        Variables.dropAtcount = Random.nextGaussian(1, 4, 4, 1.0)
    }
}