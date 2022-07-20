// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class FuryItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:fury")
    public static final Item block;
    
    public FuryItem(final SwordcraftonlineModElements instance) {
        super(instance, 304);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            super(new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_200917_a(16).func_234689_a_().func_208103_a(Rarity.EPIC));
            this.setRegistryName("fury");
        }
        
        public int func_77619_b() {
            return 0;
        }
        
        public int func_77626_a(final ItemStack itemstack) {
            return 0;
        }
        
        public float func_150893_a(final ItemStack par1ItemStack, final BlockState par2Block) {
            return 1.0f;
        }
        
        public void func_77624_a(final ItemStack itemstack, final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
            super.func_77624_a(itemstack, world, (List)list, flag);
            list.add((ITextComponent)new StringTextComponent("§eAbsolutely Rare Item"));
        }
    }
}
