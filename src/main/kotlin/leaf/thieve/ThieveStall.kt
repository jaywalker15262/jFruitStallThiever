package com.jay.fruitstallthiever.leaf.thieve

import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import org.powbot.api.Condition
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Objects
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class ThieveStall(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Thieving stall") {
    override fun execute() {
        val stall = Objects.stream(2).action("Steal-from").first()
        if (!stall.valid()) {
            return
        }

        if (!stall.inViewport()) {
            Camera.turnTo(stall)
            Condition.wait({ stall.inViewport() }, 50, 50)
        }

        val emptySlots = Inventory.emptySlotCount()
        stall.bounds(-16, 16, -48, -16, -16, 16)
        if (!stall.interact("Steal-from")) {
            script.info("Failed to attempt to thieve from the stall.")
            return
        }

        if (!Condition.wait({ emptySlots != Inventory.emptySlotCount() }, 50, 120)) {
            script.info("Failed to find that we successfully thieved the stall.")
            return
        }

        Variables.timeSinceLastThieft = ScriptManager.getRuntime(true) + 3000
    }
}