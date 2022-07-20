// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.CookedRabbitRagoutFoodEatenProcedure;
import java.util.Map;
import java.util.stream.Stream;
import java.util.AbstractMap;
import java.util.HashMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Food;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class CookedRabbitRagoutItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:cooked_rabbit_ragout")
    public static final Item block;
    
    public CookedRabbitRagoutItem(final SwordcraftonlineModElements instance) {
        super(instance, 285);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new FoodItemCustom());
    }
    
    static {
        block = null;
    }
    
    public static class FoodItemCustom extends Item
    {
        public FoodItemCustom() {
            super(new Item.Properties().func_200916_a(ItemGroup.field_78039_h).func_200917_a(64).func_208103_a(Rarity.EPIC).func_221540_a(new Food.Builder().func_221456_a(20).func_221454_a(30.0f).func_221451_a().func_221453_d()));
            this.setRegistryName("cooked_rabbit_ragout");
        }
        
        public int func_77626_a(final ItemStack stack) {
            return 16;
        }
        
        public UseAction func_77661_b(final ItemStack itemstack) {
            return UseAction.EAT;
        }
        
        public ItemStack func_77654_b(final ItemStack itemstack, final World world, final LivingEntity entity) {
            final ItemStack retval = super.func_77654_b(itemstack, world, entity);
            final double x = entity.func_226277_ct_();
            final double y = entity.func_226278_cu_();
            final double z = entity.func_226281_cx_();
            CookedRabbitRagoutFoodEatenProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<String, LivingEntity>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            return retval;
        }
    }
}
