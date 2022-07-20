// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.item.PickaxeItem;
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
public class CrystallitePickaxeItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:crystallite_pickaxe")
    public static final Item block;
    
    public CrystallitePickaxeItem(final SwordcraftonlineModElements instance) {
        super(instance, 152);
    }
    
    @Override
    public void initElements() {
        final PickaxeItem pickaxeItem;
        this.elements.items.add(() -> {
            new PickaxeItem(new IItemTier() {
                public int func_200926_a() {
                    return 3000;
                }
                
                public float func_200928_b() {
                    return 30.0f;
                }
                
                public float func_200929_c() {
                    return 10.0f;
                }
                
                public int func_200925_d() {
                    return 5;
                }
                
                public int func_200927_e() {
                    return 25;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)CrystalliteItem.block) });
                }
            }, 1, -2.8f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_234689_a_()) {};
            return (Item)pickaxeItem.setRegistryName("crystallite_pickaxe");
        });
    }
    
    static {
        block = null;
    }
}
