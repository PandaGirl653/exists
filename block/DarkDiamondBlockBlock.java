// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.block;

import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class DarkDiamondBlockBlock extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:dark_diamond_block")
    public static final Block block;
    
    public DarkDiamondBlockBlock(final SwordcraftonlineModElements instance) {
        super(instance, 67);
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(DarkDiamondBlockBlock.block, new Item.Properties().func_200916_a(ItemGroup.field_78030_b));
            return (Item)blockItem.setRegistryName(DarkDiamondBlockBlock.block.getRegistryName());
        });
    }
    
    static {
        block = null;
    }
    
    public static class CustomBlock extends Block
    {
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151573_f).func_200947_a(SoundType.field_185852_e).func_200948_a(30.0f, 30.0f).func_235838_a_(s -> 0).harvestLevel(1).harvestTool(ToolType.PICKAXE).func_235861_h_());
            this.setRegistryName("dark_diamond_block");
        }
        
        public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
            return 15;
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
