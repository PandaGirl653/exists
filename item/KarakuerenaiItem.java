// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.item.SwordItem;
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
public class KarakuerenaiItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:karakuerenai")
    public static final Item block;
    
    public KarakuerenaiItem(final SwordcraftonlineModElements instance) {
        super(instance, 115);
    }
    
    @Override
    public void initElements() {
        final SwordItem swordItem;
        this.elements.items.add(() -> {
            new SwordItem(new IItemTier() {
                public int func_200926_a() {
                    return 1200;
                }
                
                public float func_200928_b() {
                    return 4.0f;
                }
                
                public float func_200929_c() {
                    return 7.0f;
                }
                
                public int func_200925_d() {
                    return 1;
                }
                
                public int func_200927_e() {
                    return 20;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)LightDiamondItem.block) });
                }
            }, 3, -2.1f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {};
            return (Item)swordItem.setRegistryName("karakuerenai");
        });
    }
    
    static {
        block = null;
    }
}
