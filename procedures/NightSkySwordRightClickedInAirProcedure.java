// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class NightSkySwordRightClickedInAirProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure NightSkySwordRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("itemstack") == null) {
            if (!dependencies.containsKey("itemstack")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency itemstack for procedure NightSkySwordRightClickedInAir!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        final ItemStack itemstack = dependencies.get("itemstack");
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76420_g, 300, 2));
        }
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity)entity).func_184811_cZ().func_185145_a(itemstack.func_77973_b(), 1000);
        }
    }
}
