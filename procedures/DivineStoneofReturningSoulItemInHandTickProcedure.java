// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.block.Blocks;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.mcreator.swordcraftonline.item.DivineStoneofReturningSoulItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.IWorld;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class DivineStoneofReturningSoulItemInHandTickProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency world for procedure DivineStoneofReturningSoulItemInHandTick!");
            }
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency x for procedure DivineStoneofReturningSoulItemInHandTick!");
            }
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency y for procedure DivineStoneofReturningSoulItemInHandTick!");
            }
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency z for procedure DivineStoneofReturningSoulItemInHandTick!");
            }
            return;
        }
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure DivineStoneofReturningSoulItemInHandTick!");
            }
            return;
        }
        final IWorld world = dependencies.get("world");
        final double x = (dependencies.get("x") instanceof Integer) ? dependencies.get("x") : dependencies.get("x");
        final double y = (dependencies.get("y") instanceof Integer) ? dependencies.get("y") : dependencies.get("y");
        final double z = (dependencies.get("z") instanceof Integer) ? dependencies.get("z") : dependencies.get("z");
        final Entity entity = dependencies.get("entity");
        if (((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0f) <= 6.0f && ((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_184614_ca() : ItemStack.field_190927_a).func_77973_b() == DivineStoneofReturningSoulItem.block) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_70606_j(4.0f);
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76444_x, 3600, 6, false, false));
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76426_n, 3600, 1, false, false));
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76429_m, 3600, 5, false, false));
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76428_l, 400, 9, false, false));
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76420_g, 600, 1, false, false));
            }
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76432_h, 20, 254, false, false));
            }
            if (entity instanceof LivingEntity) {
                final ItemStack _setstack = new ItemStack((IItemProvider)Blocks.field_150350_a);
                _setstack.func_190920_e(1);
                ((LivingEntity)entity).func_184611_a(Hand.MAIN_HAND, _setstack);
                if (entity instanceof ServerPlayerEntity) {
                    ((ServerPlayerEntity)entity).field_71071_by.func_70296_d();
                }
            }
            if (world.func_201670_d()) {
                Minecraft.func_71410_x().field_71460_t.func_190565_a(new ItemStack((IItemProvider)DivineStoneofReturningSoulItem.block));
            }
            world.func_195594_a((IParticleData)ParticleTypes.field_197604_O, x * 1.0, y * 1.0, z * 1.0, 1.0, 1.0, 1.0);
            if (world instanceof World && !world.func_201670_d()) {
                ((World)world).func_184133_a((PlayerEntity)null, new BlockPos((int)x, (int)y, (int)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundCategory.NEUTRAL, 1.0f, 1.0f);
            }
            else {
                ((World)world).func_184134_a(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundCategory.NEUTRAL, 1.0f, 1.0f, false);
            }
        }
    }
}
