package com.jay.fruitstallthiever.leaf

import com.jay.fruitstallthiever.FruitStallThiever
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.SettingsManager
import org.powbot.mobile.ToggleId

class LogIn(script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Logging In") {
    override fun execute() {
        if (!SettingsManager.enabled(ToggleId.AutoLogin))
            SettingsManager.set(ToggleId.AutoLogin, true)
    }
}