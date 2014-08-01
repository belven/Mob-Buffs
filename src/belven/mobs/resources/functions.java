package belven.mobs.resources;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Slime;
import org.bukkit.potion.PotionEffectType;

public class functions
{
    public static boolean IsAMob(EntityType currentEntityType)
    {
        if (currentEntityType == EntityType.BLAZE
                || currentEntityType == EntityType.CAVE_SPIDER
                || currentEntityType == EntityType.CREEPER
                || currentEntityType == EntityType.ENDER_DRAGON
                || currentEntityType == EntityType.ENDERMAN
                || currentEntityType == EntityType.GHAST
                || currentEntityType == EntityType.MAGMA_CUBE
                || currentEntityType == EntityType.PIG_ZOMBIE
                || currentEntityType == EntityType.SKELETON
                || currentEntityType == EntityType.SPIDER
                || currentEntityType == EntityType.SLIME
                || currentEntityType == EntityType.WITCH
                || currentEntityType == EntityType.WITHER
                || currentEntityType == EntityType.ZOMBIE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // public static void Temp()
    // {
    // int[][] locations = new int[10][10];
    //
    // }
    //
    // public static int[][] randomLocation(int[][] lastLocation)
    // {
    // Random randGen = new Random();
    // int rand = randGen.nextInt(1);
    // int[] x = lastLocation[0];
    // int y = lastLocation[0][0];
    //
    // Map<Integer, Integer> tempLocation;
    //
    // if (rand == 0)
    // {
    //
    // }
    // else
    // {
    //
    // }
    //
    // return tempLocation;
    // }

    public static boolean IsUndeadMob(EntityType currentEntityType)
    {
        if (currentEntityType == EntityType.PIG_ZOMBIE
                || currentEntityType == EntityType.SKELETON
                || currentEntityType == EntityType.WITHER
                || currentEntityType == EntityType.ZOMBIE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static List<PotionEffectType> negativeEffects()
    {
        List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
        tempEffects.add(PotionEffectType.BLINDNESS);
        tempEffects.add(PotionEffectType.CONFUSION);
        tempEffects.add(PotionEffectType.HARM);
        tempEffects.add(PotionEffectType.HUNGER);
        tempEffects.add(PotionEffectType.POISON);
        tempEffects.add(PotionEffectType.SLOW);
        tempEffects.add(PotionEffectType.SLOW_DIGGING);
        tempEffects.add(PotionEffectType.WEAKNESS);
        tempEffects.add(PotionEffectType.WITHER);
        return tempEffects;
    }

    public static List<PotionEffectType> undeadImmuneEffects()
    {
        List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
        tempEffects.add(PotionEffectType.REGENERATION);
        tempEffects.add(PotionEffectType.POISON);
        return tempEffects;
    }

    public static int getPotionEffectMaxAmp(PotionEffectType pet)
    {
        if (pet == PotionEffectType.ABSORPTION)
        {
            return 2;
        }
        else if (pet == PotionEffectType.DAMAGE_RESISTANCE)
        {
            return 3;
        }
        else if (pet == PotionEffectType.FIRE_RESISTANCE)
        {
            return 3;
        }
        else if (pet == PotionEffectType.HEALTH_BOOST)
        {
            return 4;
        }
        else if (pet == PotionEffectType.REGENERATION)
        {
            return 3;
        }
        else if (pet == PotionEffectType.INVISIBILITY)
        {
            return 1;
        }
        else if (pet == PotionEffectType.SPEED)
        {
            return 6;
        }
        else if (pet == PotionEffectType.POISON)
        {
            return 6;
        }
        else if (pet == PotionEffectType.SLOW)
        {
            return 2;
        }
        else if (pet == PotionEffectType.WEAKNESS)
        {
            return 2;
        }
        else if (pet == PotionEffectType.WITHER)
        {
            return 2;
        }

        return 1;
    }

    public static int getPotionEffectMaxDuration(PotionEffectType pet)
    {
        int dur = 30;

        if (pet == PotionEffectType.ABSORPTION)
        {
            dur = 60;
        }
        else if (pet == PotionEffectType.DAMAGE_RESISTANCE)
        {
            dur = 60;
        }
        else if (pet == PotionEffectType.FIRE_RESISTANCE)
        {
            dur = 300;
        }
        else if (pet == PotionEffectType.HEALTH_BOOST)
        {
            dur = 300;
        }
        else if (pet == PotionEffectType.REGENERATION)
        {
            dur = 30;
        }
        else if (pet == PotionEffectType.INVISIBILITY)
        {
            dur = 30;
        }
        else if (pet == PotionEffectType.SPEED)
        {
            dur = 60;
        }
        else if (pet == PotionEffectType.POISON)
        {
            dur = 60;
        }
        else if (pet == PotionEffectType.SLOW)
        {
            dur = 60;
        }
        else if (pet == PotionEffectType.WEAKNESS)
        {
            dur = 60;
        }
        else if (pet == PotionEffectType.WITHER)
        {
            dur = 20;
        }

        return SecondsToTicks(dur);
    }

    public static PotionEffectType undeadReveseEffects(PotionEffectType pet)
    {
        if (pet == PotionEffectType.HEAL)
        {
            return PotionEffectType.HARM;
        }

        return pet;
    }

    public static List<PotionEffectType> negativeEffectsForMobs()
    {
        List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
        tempEffects.add(PotionEffectType.POISON);
        tempEffects.add(PotionEffectType.SLOW);
        // tempEffects.add(PotionEffectType.HARM);
        tempEffects.add(PotionEffectType.WEAKNESS);
        // tempEffects.add(PotionEffectType.WITHER);
        return tempEffects;
    }

    public static List<PotionEffectType> positiveEffectsForMobs()
    {
        List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
        tempEffects.add(PotionEffectType.ABSORPTION);
        tempEffects.add(PotionEffectType.DAMAGE_RESISTANCE);
        tempEffects.add(PotionEffectType.FIRE_RESISTANCE);
        // tempEffects.add(PotionEffectType.HEALTH_BOOST);
        tempEffects.add(PotionEffectType.REGENERATION);
        // tempEffects.add(PotionEffectType.HEAL);
        tempEffects.add(PotionEffectType.INVISIBILITY);
        tempEffects.add(PotionEffectType.SPEED);
        return tempEffects;
    }

    public static List<PotionEffectType> positiveEffects()
    {
        List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
        tempEffects.add(PotionEffectType.ABSORPTION);
        tempEffects.add(PotionEffectType.DAMAGE_RESISTANCE);
        tempEffects.add(PotionEffectType.FAST_DIGGING);
        tempEffects.add(PotionEffectType.FIRE_RESISTANCE);
        tempEffects.add(PotionEffectType.HEAL);
        tempEffects.add(PotionEffectType.HEALTH_BOOST);
        tempEffects.add(PotionEffectType.INVISIBILITY);
        tempEffects.add(PotionEffectType.JUMP);
        tempEffects.add(PotionEffectType.NIGHT_VISION);
        tempEffects.add(PotionEffectType.REGENERATION);
        tempEffects.add(PotionEffectType.SPEED);
        tempEffects.add(PotionEffectType.WATER_BREATHING);
        return tempEffects;
    }

    public static int SecondsToTicks(int seconds)
    {
        return (seconds * 20);
    }

    public static int MobMaxHealth(LivingEntity entity)
    {
        if (entity.getType() == EntityType.ZOMBIE)
        {
            return 20;
        }
        else if (entity.getType() == EntityType.SKELETON)
        {
            return 20;
        }
        else if (entity.getType() == EntityType.SPIDER)
        {
            return 16;
        }
        else if (entity.getType() == EntityType.CREEPER)
        {
            return 20;
        }
        else if (entity.getType() == EntityType.WITHER)
        {
            return 300;
        }
        else if (entity.getType() == EntityType.BLAZE)
        {
            return 20;
        }
        else if (entity.getType() == EntityType.ENDERMAN)
        {
            return 40;
        }
        else if (entity.getType() == EntityType.CAVE_SPIDER)
        {
            return 12;
        }
        else if (entity.getType() == EntityType.GHAST)
        {
            return 10;
        }
        else if (entity.getType() == EntityType.MAGMA_CUBE)
        {
            MagmaCube MagmaCube = (MagmaCube) entity;

            if (MagmaCube.getSize() == 4)

            {
                return 16;
            }
            else if (MagmaCube.getSize() == 2)
            {
                return 4;
            }
            else
            {
                return 1;
            }
        }
        else if (entity.getType() == EntityType.PIG_ZOMBIE)
        {
            return 20;
        }
        else if (entity.getType() == EntityType.SLIME)
        {
            Slime slime = (Slime) entity;

            if (slime.getSize() == 4)
            {
                return 16;
            }
            else if (slime.getSize() == 2)
            {
                return 4;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            return 20;
        }
    }
}
