package net.uniform.uniformsoulsmod.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class KindnessSoul extends Item {

    public KindnessSoul(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){

        // playerEntity.setVelocity(playerEntity.getVelocity().x,playerEntity.getVelocity().y,2);
        // playerEntity.setVelocity(playerEntity.getVelocity().x,2,playerEntity.getVelocity().z);

        playerEntity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_HARP, 2.0F, 1.0F);
        playerEntity.getItemCooldownManager().set(this, 10);
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        //Basic Info
        tooltip.add(new TranslatableText("You Are Filled With Kindness").formatted(Formatting.GREEN));

    }


}
