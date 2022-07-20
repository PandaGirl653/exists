// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.entity.renderer;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.mcreator.swordcraftonline.entity.GoldKnightEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoldKnightRenderer
{
    public static class ModelRegisterHandler
    {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public void registerModels(final ModelRegistryEvent event) {
            RenderingRegistry.registerEntityRenderingHandler(GoldKnightEntity.entity, renderManager -> {
                final BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0.0f), 0.5f) {
                    public ResourceLocation func_110775_a(final Entity entity) {
                        return new ResourceLocation("swordcraftonline:textures/goldknight.png");
                    }
                };
                customRender.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)customRender, new BipedModel(0.5f), new BipedModel(1.0f)));
                return (EntityRenderer)customRender;
            });
        }
    }
}
