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

public class OrdinalScaleLivingEntityIsHitWithToolProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure OrdinalScaleLivingEntityIsHitWithTool!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76437_t, 100, 4));
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76436_u, 100, 7));
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_82731_v, 100, 7));
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76421_d, 100, 1));
        }
    }
}
