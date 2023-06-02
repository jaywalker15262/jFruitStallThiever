package com.jay.fruitstallthiever.branch

import CloseBank
import com.jay.fruitstallthiever.FruitStallThiever
import com.jay.fruitstallthiever.leaf.geopened.CloseGrandExchange
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.GrandExchange
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class IsGrandExchangeOpened(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Grand Exchange open?") {
    override val successComponent: TreeComponent<FruitStallThiever> = CloseGrandExchange(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = IsBankOpened(script)

    override fun validate(): Boolean {
        return GrandExchange.opened()
    }
}

class IsBankOpened(script: FruitStallThiever) : Branch<FruitStallThiever>(script, "Bank open?") {
    override val successComponent: TreeComponent<FruitStallThiever> = CloseBank(script)
    override val failedComponent: TreeComponent<FruitStallThiever> = TravelCheck(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}