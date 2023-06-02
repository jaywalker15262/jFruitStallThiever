package com.jay.fruitstallthiever.leaf

import com.jay.fruitstallthiever.FruitStallThiever
import org.powbot.api.script.tree.Leaf

class Chill(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Chillin") {
    override fun execute() {
        // No need to sleep here, poll() is on a 50ms delay loop.
    }
}