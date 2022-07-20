// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class HeavenPiercingSwordToolInHandTickProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure HeavenPiercingSwordToolInHandTick!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76420_g, 60, 1));
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76443_y, 60, 3));
        }
    }
}
