package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import org.quiltmc.quiltmappings.constants.MiningLevels;

import java.util.function.Supplier;

public enum TysMaterials implements ToolMaterial
{
	BESTEST_MATERIAL(MiningLevels.NETHERITE, -1, 100.0f, 2147000000, 50, () -> Ingredient.ofItems(TysAmazingModItems.BESTEST_ITEM));

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy<Ingredient> repairIngredient;

	TysMaterials(int miningLevel, int itemDurability, float miningSpeed, int attackDamage, int enchantability, Supplier<Ingredient> repairIngredient)
	{
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = new Lazy<>(repairIngredient);
	}

	@Override
	public int getDurability() {
		return itemDurability;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return miningSpeed;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getMiningLevel() {
		return miningLevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient.get();
	}
}
