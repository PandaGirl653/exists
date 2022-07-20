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
public class SapphireSwordItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:sapphire_sword")
    public static final Item block;
    
    public SapphireSwordItem(final SwordcraftonlineModElements instance) {
        super(instance, 89);
    }
    
    @Override
    public void initElements() {
        final SwordItem swordItem;
        this.elements.items.add(() -> {
            new SwordItem(new IItemTier() {
                public int func_200926_a() {
                    return 320;
                }
                
                public float func_200928_b() {
                    return 4.0f;
                }
                
                public float func_200929_c() {
                    return 2.5f;
                }
                
                public int func_200925_d() {
                    return 1;
                }
                
                public int func_200927_e() {
                    return 15;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)SapphireItem.block) });
                }
            }, 3, -2.5f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {};
            return (Item)swordItem.setRegistryName("sapphire_sword");
        });
    }
    
    static {
        block = null;
    }
}
