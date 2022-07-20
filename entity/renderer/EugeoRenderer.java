// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.entity.renderer;

import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.mcreator.swordcraftonline.entity.EugeoEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EugeoRenderer
{
    public static class ModelRegisterHandler
    {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public void registerModels(final ModelRegistryEvent event) {
            RenderingRegistry.registerEntityRenderingHandler(EugeoEntity.entity, renderManager -> new MobRenderer(renderManager, new ModelAlex_Modified(), 0.5f) {
                public ResourceLocation func_110775_a(final Entity entity) {
                    return new ResourceLocation("swordcraftonline:textures/eugeo.png");
                }
            });
        }
    }
    
    public static class ModelAlex_Modified extends EntityModel<Entity>
    {
        private final ModelRenderer Head;
        private final ModelRenderer Body;
        private final ModelRenderer RightArm;
        private final ModelRenderer LeftArm;
        private final ModelRenderer RightLeg;
        private final ModelRenderer LeftLeg;
        
        public ModelAlex_Modified() {
            this.field_78090_t = 64;
            this.field_78089_u = 64;
            (this.Head = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, 0.0f);
            this.setRotationAngle(this.Head, -0.1047f, 0.0873f, 0.0f);
            this.Head.func_78784_a(0, 0).func_228303_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
            this.Head.func_78784_a(32, 0).func_228303_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.5f, false);
            (this.Body = new ModelRenderer((Model)this)).func_78793_a(0.0f, 0.0f, 0.0f);
            this.Body.func_78784_a(16, 16).func_228303_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.0f, false);
            this.Body.func_78784_a(16, 32).func_228303_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.25f, false);
            (this.RightArm = new ModelRenderer((Model)this)).func_78793_a(-5.0f, 2.0f, 0.0f);
            this.setRotationAngle(this.RightArm, -0.1745f, 0.0f, 0.0f);
            this.RightArm.func_78784_a(40, 16).func_228303_a_(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, 0.0f, false);
            this.RightArm.func_78784_a(40, 32).func_228303_a_(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, 0.25f, false);
            (this.LeftArm = new ModelRenderer((Model)this)).func_78793_a(5.0f, 2.0f, 0.0f);
            this.setRotationAngle(this.LeftArm, 0.2094f, 0.0f, 0.0f);
            this.LeftArm.func_78784_a(32, 48).func_228303_a_(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, 0.0f, false);
            this.LeftArm.func_78784_a(48, 48).func_228303_a_(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, 0.25f, false);
            (this.RightLeg = new ModelRenderer((Model)this)).func_78793_a(-1.9f, 12.0f, 0.0f);
            this.setRotationAngle(this.RightLeg, 0.192f, 0.0f, 0.0349f);
            this.RightLeg.func_78784_a(0, 16).func_228303_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, false);
            this.RightLeg.func_78784_a(0, 32).func_228303_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.25f, false);
            (this.LeftLeg = new ModelRenderer((Model)this)).func_78793_a(1.9f, 12.0f, 0.0f);
            this.setRotationAngle(this.LeftLeg, -0.1745f, 0.0f, -0.0349f);
            this.LeftLeg.func_78784_a(16, 48).func_228303_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, false);
            this.LeftLeg.func_78784_a(0, 48).func_228303_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.25f, false);
        }
        
        public void func_225598_a_(final MatrixStack matrixStack, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
            this.Head.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
            this.Body.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
            this.RightArm.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
            this.LeftArm.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
            this.RightLeg.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
            this.LeftLeg.func_228308_a_(matrixStack, buffer, packedLight, packedOverlay);
        }
        
        public void setRotationAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
            modelRenderer.field_78795_f = x;
            modelRenderer.field_78796_g = y;
            modelRenderer.field_78808_h = z;
        }
        
        public void func_225597_a_(final Entity e, final float f, final float f1, final float f2, final float f3, final float f4) {
            this.RightArm.field_78795_f = MathHelper.func_76134_b(f * 0.6662f + 3.1415927f) * f1;
            this.LeftLeg.field_78795_f = MathHelper.func_76134_b(f * 1.0f) * -1.0f * f1;
            this.Head.field_78796_g = f3 / 57.295776f;
            this.Head.field_78795_f = f4 / 57.295776f;
            this.LeftArm.field_78795_f = MathHelper.func_76134_b(f * 0.6662f) * f1;
            this.RightLeg.field_78795_f = MathHelper.func_76134_b(f * 1.0f) * 1.0f * f1;
        }
    }
}
