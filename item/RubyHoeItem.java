// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.item.HoeItem;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class RubyHoeItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:ruby_hoe")
    public static final Item block;
    
    public RubyHoeItem(final SwordcraftonlineModElements instance) {
        super(instance, 85);
    }
    
    @Override
    public void initElements() {
        final HoeItem hoeItem;
        this.elements.items.add(() -> {
            new HoeItem(new IItemTier() {
                public int func_200926_a() {
                    return 300;
                }
                
                public float func_200928_b() {
                    return 7.0f;
                }
                
                public float func_200929_c() {
                    return 0.0f;
                }
                
                public int func_200925_d() {
                    return 2;
                }
                
                public int func_200927_e() {
                    return 15;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)RubyItem.block) });
                }
            }, 0, -1.0f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {};
            return (Item)hoeItem.setRegistryName("ruby_hoe");
        });
    }
    
    static {
        block = null;
    }
}
