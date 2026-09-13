package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitHeroic extends AbstractTrait {

    public TraitHeroic() {
        super("heroic", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int durabilityMax = ToolHelper.getMaxDurability(tool);

        int durabilityDelta = durabilityMax - durability;
        int safeDenominator = Math.max(durabilityDelta - 1, 1);

        float calc = newDamage + (newDamage / 2) / (durability * durabilityMax / (float) safeDenominator);

        if ((durability * durabilityMax / (Math.max(durabilityDelta - 1, 1) / safeDenominator)) == 0) {
            calc++;
        }

        if (durability < (0.10 * durabilityMax)
            || player.getHealth() < player.getMaxHealth() / 8
            || (target.getHealth() == target.getMaxHealth()
            && random.nextFloat() > 0.8)) {
            return super.damage(tool, player, target, damage, calc, isCritical);
        }
        
        return super.damage(tool, player, target, damage, newDamage * 0.9f, isCritical);
    }
}
