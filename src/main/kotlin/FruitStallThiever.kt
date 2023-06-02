package com.jay.fruitstallthiever

import com.jay.fruitstallthiever.branch.IsLoggedIn
import org.powbot.api.Color
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.*
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.mobile.service.ScriptUploader

@ScriptManifest(
    name = "jFruitStallThiever",
    description = "Does fruit stall thieving and the pre-requisites for it.",
    version = "1.0.0",
    category = ScriptCategory.Thieving,
)
@ScriptConfiguration.List(
    [
        ScriptConfiguration(
            name = "notice",
            description = "ATTENTION: Make sure to have a charged skills necklace equipped, " +
                    "and a charged amulet of glory(at least 2 charges), lumbridge tablet and a hammer in your inventory!",
            optionType = OptionType.INFO
        ),
        ScriptConfiguration(
            "stopAtLvl", "Stop at lvl(values >99 or <1 means it will not stop based on lvl):",
            optionType = OptionType.INTEGER, defaultValue = "99"
        ),
        ScriptConfiguration(
            "stopAfterMinutes", "Stop after X minutes(0, for the bot to not stop based on time):",
            optionType = OptionType.INTEGER, defaultValue = "0"
        ),
    ]
)

class FruitStallThiever : TreeScript() {
    @ValueChanged("stopAtLvl")
    fun stopAtLevelChanged(newValue: Int) {
        Variables.stopAtLvl = newValue
    }

    @ValueChanged("stopAfterMinutes")
    fun stopAfterMinutesChanged(newValue: Int) {
        Variables.stopAfterMinutes = if (newValue > 0)
            newValue else 0
    }

    override val rootComponent: TreeComponent<*> by lazy {
        IsLoggedIn(this)
    }

    override fun onStart() {
        val p = PaintBuilder.newBuilder()
            .addString("Last Leaf:") { lastLeaf.name }
            .addString("Stop At Level: ") { Variables.stopAtLvl.toString() }
            .addString("Favour: ") { Variables.favourPercent.toString() + "%"}
            .trackSkill(Skill.Thieving)
            .backgroundColor(Color.argb(255, 35,25,30))
            .build()

        addPaint(p)
    }

    fun info(message: String) {
        log.info("JayLOGS: $message")
    }

    /*
    fun severe(message: String) {
        log.severe("JayLOGS: $message")
    }*/
}

fun main(args: Array<String>)
{
    ScriptUploader().uploadAndStart("jFruitStallThiever", "", "127.0.0.1:5595", true, false)
}