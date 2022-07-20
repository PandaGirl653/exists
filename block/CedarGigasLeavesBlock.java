// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.block;

import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.LeavesBlock;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.block.BlockState;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class CedarGigasLeavesBlock extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:cedar_gigas_leaves")
    public static final Block block;
    
    public CedarGigasLeavesBlock(final SwordcraftonlineModElements instance) {
        super(instance, 216);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new BlockColorRegisterHandler());
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(CedarGigasLeavesBlock.block, new Item.Properties().func_200916_a(ItemGroup.field_78031_c));
            return (Item)blockItem.setRegistryName(CedarGigasLeavesBlock.block.getRegistryName());
        });
    }
    
    static {
        block = null;
    }
    
    private static class BlockColorRegisterHandler
    {
        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public void blockColorLoad(final ColorHandlerEvent.Block event) {
            event.getBlockColors().func_186722_a((bs, world, pos, index) -> (world != null && pos != null) ? BiomeColors.func_228361_b_(world, pos) : FoliageColors.func_77468_c(), new Block[] { CedarGigasLeavesBlock.block });
        }
    }
    
    public static class CustomBlock extends LeavesBlock
    {
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151584_j).func_200947_a(SoundType.field_185850_c).func_200948_a(50.0f, 100.0f).func_235838_a_(s -> 0).harvestLevel(5).harvestTool(ToolType.AXE).func_235861_h_().func_226896_b_());
            this.setRegistryName("cedar_gigas_leaves");
        }
        
        public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
            return 1;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
        }
    }
}
