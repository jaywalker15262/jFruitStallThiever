import com.jay.fruitstallthiever.FruitStallThiever
import org.powbot.api.Condition
import org.powbot.api.Random
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Leaf

class CloseBank (script: FruitStallThiever) : Leaf<FruitStallThiever>(script, "Closing Bank") {
    override fun execute() {
        if (Bank.close())
            Condition.wait({ !Bank.opened() }, Random.nextGaussian(170, 250, 200, 20.0), 13)
    }
}