// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.SoundEvent;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class SlayerArmorItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:slayer_armor_helmet")
    public static final Item helmet;
    @ObjectHolder("swordcraftonline:slayer_armor_chestplate")
    public static final Item body;
    @ObjectHolder("swordcraftonline:slayer_armor_leggings")
    public static final Item legs;
    @ObjectHolder("swordcraftonline:slayer_armor_boots")
    public static final Item boots;
    
    public SlayerArmorItem(final SwordcraftonlineModElements instance) {
        super(instance, 199);
    }
    
    @Override
    public void initElements() {
        final IArmorMaterial armormaterial = (IArmorMaterial)new IArmorMaterial() {
            public int func_200896_a(final EquipmentSlotType slot) {
                return (new int[] { 13, 15, 16, 11 })[slot.func_188454_b()] * 35;
            }
            
            public int func_200902_b(final EquipmentSlotType slot) {
                return (new int[] { 3, 7, 9, 3 })[slot.func_188454_b()];
            }
            
            public int func_200900_a() {
                return 18;
            }
            
            public SoundEvent func_200899_b() {
                return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
            }
            
            public Ingredient func_200898_c() {
                return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)RefinedSteelItem.block) });
            }
            
            @OnlyIn(Dist.CLIENT)
            public String func_200897_d() {
                return "slayer_armor";
            }
            
            public float func_200901_e() {
                return 2.5f;
            }
            
            public float func_230304_f_() {
                return 0.0f;
            }
        };
        final ArmorItem armorItem;
        final IArmorMaterial x0;
        this.elements.items.add(() -> {
            new ArmorItem(x0, EquipmentSlotType.HEAD, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "swordcraftonline:textures/models/armor/slayer__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem.setRegistryName("slayer_armor_helmet");
        });
        final ArmorItem armorItem2;
        final IArmorMaterial x2;
        this.elements.items.add(() -> {
            new ArmorItem(x2, EquipmentSlotType.CHEST, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "swordcraftonline:textures/models/armor/slayer__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem2.setRegistryName("slayer_armor_chestplate");
        });
        final ArmorItem armorItem3;
        final IArmorMaterial x3;
        this.elements.items.add(() -> {
            new ArmorItem(x3, EquipmentSlotType.LEGS, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "swordcraftonline:textures/models/armor/slayer__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem3.setRegistryName("slayer_armor_leggings");
        });
        final ArmorItem armorItem4;
        final IArmorMaterial x4;
        this.elements.items.add(() -> {
            new ArmorItem(x4, EquipmentSlotType.FEET, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab)) {
                public String getArmorTexture(final ItemStack stack, final Entity entity, final EquipmentSlotType slot, final String type) {
                    return "swordcraftonline:textures/models/armor/slayer__layer_" + ((slot == EquipmentSlotType.LEGS) ? "2" : "1") + ".png";
                }
            };
            return (Item)armorItem4.setRegistryName("slayer_armor_boots");
        });
    }
    
    static {
        helmet = null;
        body = null;
        legs = null;
        boots = null;
    }
}
