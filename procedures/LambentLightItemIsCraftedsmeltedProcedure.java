// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class LambentLightItemIsCraftedsmeltedProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("itemstack") == null) {
            if (!dependencies.containsKey("itemstack")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency itemstack for procedure LambentLightItemIsCraftedsmelted!");
            }
            return;
        }
        final ItemStack itemstack = dependencies.get("itemstack");
        itemstack.func_77966_a(Enchantments.field_180313_o, 5);
    }
}
