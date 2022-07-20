// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class RubyItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:ruby")
    public static final Item block;
    
    public RubyItem(final SwordcraftonlineModElements instance) {
        super(instance, 10);
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
            super(new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_200917_a(64).func_208103_a(Rarity.COMMON));
            this.setRegistryName("ruby");
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
    }
}
