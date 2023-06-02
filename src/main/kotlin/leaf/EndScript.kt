package com.jay.fruitstallthiever.leaf

import com.jay.fruitstallthiever.FruitStallThiever
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class EndScript(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Ending Script") {
    override fun execute() {
        ScriptManager.stop()
    }
}