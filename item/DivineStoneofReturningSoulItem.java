// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.DivineStoneofReturningSoulItemInHandTickProcedure;
import java.util.Map;
import java.util.stream.Stream;
import java.util.AbstractMap;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class DivineStoneofReturningSoulItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:divine_stoneof_returning_soul")
    public static final Item block;
    
    public DivineStoneofReturningSoulItem(final SwordcraftonlineModElements instance) {
        super(instance, 43);
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
            super(new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_200917_a(1).func_234689_a_().func_208103_a(Rarity.EPIC));
            this.setRegistryName("divine_stoneof_returning_soul");
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
        
        @OnlyIn(Dist.CLIENT)
        public boolean func_77636_d(final ItemStack itemstack) {
            return true;
        }
        
        public void func_77624_a(final ItemStack itemstack, final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
            super.func_77624_a(itemstack, world, (List)list, flag);
            list.add((ITextComponent)new StringTextComponent("This Stone can save you in difficult times. (Doesn't work like the totem) (only works on the main-hand)."));
        }
        
        public void func_77663_a(final ItemStack itemstack, final World world, final Entity entity, final int slot, final boolean selected) {
            super.func_77663_a(itemstack, world, entity, slot, selected);
            final double x = entity.func_226277_ct_();
            final double y = entity.func_226278_cu_();
            final double z = entity.func_226281_cx_();
            if (selected) {
                DivineStoneofReturningSoulItemInHandTickProcedure.executeProcedure(Stream.of((AbstractMap.SimpleEntry[])new AbstractMap.SimpleEntry[] { new AbstractMap.SimpleEntry((K)"world", (V)world), new AbstractMap.SimpleEntry((K)"x", (V)x), new AbstractMap.SimpleEntry((K)"y", (V)y), new AbstractMap.SimpleEntry((K)"z", (V)z), new AbstractMap.SimpleEntry((K)"entity", (V)entity) }).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
        }
    }
}
