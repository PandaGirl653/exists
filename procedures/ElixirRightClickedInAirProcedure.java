// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.mcreator.swordcraftonline.item.EmptyVialItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.mcreator.swordcraftonline.item.ElixirItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class ElixirRightClickedInAirProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure ElixirRightClickedInAir!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76428_l, 1200, 2));
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76429_m, 600, 0));
        }
        if (entity instanceof PlayerEntity) {
            final ItemStack _stktoremove = new ItemStack((IItemProvider)ElixirItem.block);
            ((PlayerEntity)entity).field_71071_by.func_234564_a_(p -> _stktoremove.func_77973_b() == p.func_77973_b(), 1, (IInventory)((PlayerEntity)entity).field_71069_bz.func_234641_j_());
        }
        if (entity instanceof PlayerEntity) {
            final ItemStack _setstack = new ItemStack((IItemProvider)EmptyVialItem.block);
            _setstack.func_190920_e(1);
            ItemHandlerHelper.giveItemToPlayer((PlayerEntity)entity, _setstack);
        }
    }
}
