package com.jay.fruitstallthiever.branch

import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import com.jay.fruitstallthiever.leaf.EndScript
import com.jay.fruitstallthiever.leaf.LogIn
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Skills
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent
import org.powbot.mobile.script.ScriptManager

/**
 *  The root node which is executed by the script
 */
class IsLoggedIn(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Logged In?") {
    override val successComponent: TreeComponent<FruitStallThiever> = IsEnding(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = LogIn(script)

    override fun validate(): Boolean {
        return Game.loggedIn()
    }
}

class IsEnding(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Ending script?") {
    override val successComponent: TreeComponent<FruitStallThiever> = EndScript(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = AtThievingArea(script)

    override fun validate(): Boolean {
        if (Variables.stopAfterMinutes > 0) {
            val minutes: Int = (ScriptManager.getRuntime(true) / 60000).toInt()
            if (minutes >= Variables.stopAfterMinutes) {
                script.info("Script stopping due to runtime goal reached.")
                return true
            }
        }

        if (Skills.realLevel(Skill.Thieving) >= Variables.stopAtLvl) {
            script.info("Script stopping due to thieving level goal reached.")
            return true
        }

        return false
    }
}