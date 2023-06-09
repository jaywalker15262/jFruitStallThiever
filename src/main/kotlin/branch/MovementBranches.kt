package com.jay.fruitstallthiever.branch

import com.jay.fruitstallthiever.Constants
import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.Variables
import com.jay.fruitstallthiever.leaf.traveling.*
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Skills
import org.powbot.api.rt4.Varpbits
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class AtThievingArea(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Inside the thieving area?") {
    override val successComponent: TreeComponent<FruitStallThiever> = ThievingCheck(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = IsGrandExchangeOpened(script)

    override fun validate(): Boolean {
        Variables.favour = Varpbits.value(4895, false)
        val currThievingLvl = Skills.realLevel(Skill.Thieving)
        Variables.thievingArea = when {
            currThievingLvl > 24 -> 0
            currThievingLvl > 4 -> 1
            else -> 2
        }

        Variables.favourPercent = Variables.favour.toFloat() / 10.0f

        if (Variables.thievingArea < 2) {
            if (Variables.favour < 150)
                return Constants.AREA_PLOUGHING.contains(Players.local())

            if (Variables.thievingArea == 0)
                return Constants.TILE_FRUIT_STALL.distanceTo(Players.local()).toInt() == 0

            return Constants.TILE_ARDOUNGE.distanceTo(Players.local()).toInt() == 0
        }

        return Constants.AREA_LUMBY.contains(Players.local())
    }
}

class TravelCheck(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Travel to hosidius?") {
    override val successComponent: TreeComponent<FruitStallThiever> = TravelCheckTwo(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = TravelCheckFour(script)

    override fun validate(): Boolean {
        return Variables.thievingArea == 0 || Variables.favour < 150
    }
}

class TravelCheckTwo(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Travel to kourend?") {
    override val successComponent: TreeComponent<FruitStallThiever> = TravelToKourend(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = TravelCheckThree(script)

    override fun validate(): Boolean {
        return Game.floor() == 1 || Players.local().distanceTo(Constants.TILE_HOSIDIUS).toInt() > 100
            || Constants.AREA_PLOUGHING.contains(Players.local())
    }
}

class TravelCheckThree(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Travel to fruit stalls?") {
    override val successComponent: TreeComponent<FruitStallThiever> = TravelToFruitStall(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = TravelToPlough(script)

    override fun validate(): Boolean {
        return Variables.favour  >= 150
    }
}

class TravelCheckFour(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Travel to ardounge?") {
    override val successComponent: TreeComponent<FruitStallThiever> = TravelToBakeryStall(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = TravelToLumby(script)

    override fun validate(): Boolean {
        return Variables.thievingArea == 1
    }
}