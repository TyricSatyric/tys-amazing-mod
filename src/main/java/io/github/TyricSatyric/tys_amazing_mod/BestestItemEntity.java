package io.github.TyricSatyric.tys_amazing_mod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BestestItemEntity extends ThrownItemEntity {
	int ticksUntilNextThing = -1;
	int multiplier = 10;
	int distance = 20;
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
		if (!destroy)
		{
			setNoGravity(true);
			setVelocity(0, 0, 0, 0, 0);
			ticksUntilNextThing = 5*multiplier;
			destroy = true;
		}
	}

	@Override
	public void tick() {
		super.tick();

		if (ticksUntilNextThing == 50)
		{
			this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 3, World.ExplosionSourceType.MOB );
		}

		if (ticksUntilNextThing == 40)
		{
			this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 6, World.ExplosionSourceType.MOB );
		}

		if (ticksUntilNextThing == 30)
		{
			this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 12, World.ExplosionSourceType.MOB );
		}

		if (ticksUntilNextThing == 20)
		{
			this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 25, World.ExplosionSourceType.MOB );
		}

		if (ticksUntilNextThing == 10)
		{
			this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 50, World.ExplosionSourceType.MOB );
			this.getWorld().createExplosion(this, this.getX()+distance, this.getY(), this.getZ()+distance, 50, World.ExplosionSourceType.MOB );
			this.getWorld().createExplosion(this, this.getX()+distance, this.getY(), this.getZ()-distance, 50, World.ExplosionSourceType.MOB );
			this.getWorld().createExplosion(this, this.getX()-distance, this.getY(), this.getZ()+distance, 50, World.ExplosionSourceType.MOB );
			this.getWorld().createExplosion(this, this.getX()-distance, this.getY(), this.getZ()-distance, 50, World.ExplosionSourceType.MOB );
		}

		if (ticksUntilNextThing == 0 && destroy)
		{
			this.remove(RemovalReason.KILLED);
		}

		if (ticksUntilNextThing > 0)
		{
			ticksUntilNextThing--;
		}
	}
}
