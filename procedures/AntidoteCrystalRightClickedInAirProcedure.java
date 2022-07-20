// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.inventory.IInventory;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.mcreator.swordcraftonline.item.AntidoteCrystalItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class AntidoteCrystalRightClickedInAirProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure AntidoteCrystalRightClickedInAir!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76419_f);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76421_d);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76431_k);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76440_q);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76438_s);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76437_t);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76436_u);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_82731_v);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_220309_E);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_189112_A);
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195063_d(Effects.field_76433_i);
        }
        if (entity instanceof PlayerEntity) {
            final ItemStack _stktoremove = new ItemStack((IItemProvider)AntidoteCrystalItem.block);
            ((PlayerEntity)entity).field_71071_by.func_234564_a_(p -> _stktoremove.func_77973_b() == p.func_77973_b(), 1, (IInventory)((PlayerEntity)entity).field_71069_bz.func_234641_j_());
        }
    }
}
