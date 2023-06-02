package com.jay.fruitstallthiever.branch

import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import com.jay.fruitstallthiever.leaf.Chill
import com.jay.fruitstallthiever.leaf.WorldHop
import com.jay.fruitstallthiever.leaf.favour.hosidius.Plough
import com.jay.fruitstallthiever.leaf.thieve.Drop
import com.jay.fruitstallthiever.leaf.thieve.OpeningCoinPouch
import com.jay.fruitstallthiever.leaf.thieve.ThieveStall
import com.jay.fruitstallthiever.leaf.thieve.Pickpocket
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Skills
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent
import org.powbot.mobile.script.ScriptManager

class ThievingCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Thieve stalls?") {
    override val successComponent: TreeComponent<FruitStallThiever> = PloughCheck(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = PickpocketCheck(script)

    override fun validate(): Boolean {
        return Variables.thievingArea < 2
    }
}

class PloughCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Plough?") {
    override val successComponent: TreeComponent<FruitStallThiever> = Plough(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = StallCheck(script)

    override fun validate(): Boolean {
        return Variables.favour  < 150
    }
}

class StallCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Drop items?") {
    override val successComponent: TreeComponent<FruitStallThiever> = Drop(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = WorldHopCheck(script)

    override fun validate(): Boolean {
        return Variables.invItemCount >= Variables.dropAtcount
    }
}

class PickpocketCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Already pickpocketing?") {
    override val successComponent: TreeComponent<FruitStallThiever> = Chill(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = CoinPouchCheck(script)

    override fun validate(): Boolean {
        return Variables.lastKnownThievingXp == Skills.experience(Skill.Thieving)
                && (Variables.timeSinceLastThievingXp > ScriptManager.getRuntime(true)
                || Players.local().animation() == 881)
    }
}

class CoinPouchCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Open coing pouch?") {
    override val successComponent: TreeComponent<FruitStallThiever> = OpeningCoinPouch(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = Pickpocket(script)

    override fun validate(): Boolean {
        val coinPouch = Inventory.stream().name("Coin pouch").first()
        return coinPouch.valid() && coinPouch.stackSize() == 28
    }
}

class WorldHopCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "World-hop?") {
    override val successComponent: TreeComponent<FruitStallThiever> = WorldHop(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = ThieveStall(script)

    override fun validate(): Boolean {
        return Players.stream().notLocalPlayer().within(3).isNotEmpty() &&
                ScriptManager.getRuntime(true) > Variables.timeSinceLastThieft
    }
}