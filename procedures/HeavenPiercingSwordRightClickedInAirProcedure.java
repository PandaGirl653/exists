// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.command.ICommandSource;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.world.IWorld;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class HeavenPiercingSwordRightClickedInAirProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency world for procedure HeavenPiercingSwordRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency x for procedure HeavenPiercingSwordRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency y for procedure HeavenPiercingSwordRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency z for procedure HeavenPiercingSwordRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure HeavenPiercingSwordRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("itemstack") == null) {
            if (!dependencies.containsKey("itemstack")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency itemstack for procedure HeavenPiercingSwordRightClickedInAir!");
            }
            return;
        }
        final IWorld world = dependencies.get("world");
        final double x = (dependencies.get("x") instanceof Integer) ? dependencies.get("x") : dependencies.get("x");
        final double y = (dependencies.get("y") instanceof Integer) ? dependencies.get("y") : dependencies.get("y");
        final double z = (dependencies.get("z") instanceof Integer) ? dependencies.get("z") : dependencies.get("z");
        final Entity entity = dependencies.get("entity");
        final ItemStack itemstack = dependencies.get("itemstack");
        if (world instanceof ServerWorld) {
            ((ServerWorld)world).func_241114_a_(1000L);
        }
        if (world instanceof ServerWorld) {
            ((World)world).func_73046_m().func_195571_aL().func_197059_a(new CommandSource(ICommandSource.field_213139_a_, new Vector3d(x, y, z), Vector2f.field_189974_a, (ServerWorld)world, 4, "", (ITextComponent)new StringTextComponent(""), ((World)world).func_73046_m(), (Entity)null).func_197031_a(), "weather clear");
        }
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity)entity).func_184811_cZ().func_185145_a(itemstack.func_77973_b(), 3600);
        }
    }
}
