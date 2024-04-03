package eu.decentsoftware.holograms.api.utils.scheduler;

import eu.decentsoftware.holograms.api.DecentHolograms;
import eu.decentsoftware.holograms.api.DecentHologramsAPI;
import eu.decentsoftware.holograms.api.utils.DExecutor;
import eu.decentsoftware.holograms.plugin.DecentHologramsPlugin;
import fr.euphyllia.energie.model.SchedulerTaskInter;
import fr.euphyllia.energie.model.SchedulerType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.scheduler.BukkitTask;

public class S {

    private static final DecentHolograms DECENT_HOLOGRAMS = DecentHologramsAPI.get();

    public static void stopTask(int id) {
        Bukkit.getScheduler().cancelTask(id);
    }

    public static void async(Runnable runnable) {
        try {
            DecentHologramsPlugin.getScheduler().runTask(SchedulerType.ASYNC, schedulerTaskInter -> runnable.run());
        } catch (IllegalPluginAccessException e) {
            DExecutor.execute(runnable);
        }
    }

    public static void async(Runnable runnable, long delay) {
        try {
            DecentHologramsPlugin.getScheduler().runDelayed(SchedulerType.ASYNC, schedulerTaskInter -> runnable.run(), delay);
        } catch (IllegalPluginAccessException e) {
            DExecutor.execute(runnable);
        }
    }

    public static SchedulerTaskInter asyncTask(Runnable runnable, long interval) {
        return DecentHologramsPlugin.getScheduler().runAtFixedRate(SchedulerType.ASYNC, schedulerTaskInter -> runnable.run(), 0, interval);
    }

    public static SchedulerTaskInter asyncTask(Runnable runnable, long interval, long delay) {
        return DecentHologramsPlugin.getScheduler().runAtFixedRate(SchedulerType.ASYNC, schedulerTaskInter -> runnable.run(), delay, interval);
    }

}
