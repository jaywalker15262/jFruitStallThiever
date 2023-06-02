package com.jay.fruitstallthiever.leaf.geopened

import com.jay.fruitstallthiever.FruitStallThiever
import org.powbot.api.Condition
import org.powbot.api.Random
import org.powbot.api.rt4.GrandExchange
import org.powbot.api.script.tree.Leaf

class CloseGrandExchange (script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Closing Grand Exchange") {
    override fun execute() {
        if (GrandExchange.close())
            Condition.wait({ !GrandExchange.opened() }, Random.nextGaussian(170, 250, 200, 20.0), 13)
    }
}