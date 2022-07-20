// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class ElixirItemIsCraftedsmeltedProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure ElixirItemIsCraftedsmelted!");
            }
            return;
        }
        final Entity entity = dependencies.get("entity");
        if (entity instanceof PlayerEntity) {
            final ItemStack _setstack = new ItemStack((IItemProvider)Items.field_151069_bo);
            _setstack.func_190920_e(1);
            ItemHandlerHelper.giveItemToPlayer((PlayerEntity)entity, _setstack);
        }
    }
}
