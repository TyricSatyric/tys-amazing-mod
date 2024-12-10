package io.github.gggamesxdlol.tys_amazing_mod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.w3c.dom.Entity;

public class BestestItemEntity extends ThrownItemEntity {
	int ticksUntilNextThing = 0;
	int multiplier = 10;
	int explosionPower = 10;
	boolean destroy = false;
	public BestestItemEntity(EntityType<? extends BestestItemEntity> entityType, World world) {
        super(entityType, world);
    }

	public BestestItemEntity(World world, LivingEntity owner) {
		super(TysAmazingModEntities.BESTEST_ITEM_ENTITY, owner, world);
	}

	@Override
	protected Item getDefaultItem() { return TysAmazingModItems.BESTEST_ITEM; }

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		ticksUntilNextThing = 100*multiplier;
		destroy = true;
	}

	@Override
	public void tick() {
		super.tick();
		if (ticksUntilNextThing % multiplier == 0)
		{
			this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), explosionPower, World.ExplosionSourceType.BLOCK );
		}

		if (ticksUntilNextThing == 0 && destroy)
		{
			this.remove(RemovalReason.DISCARDED);
		}

		ticksUntilNextThing--;
		explosionPower++;
	}
}
