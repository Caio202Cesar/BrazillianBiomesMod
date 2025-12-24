package com.brbiomesmod.Seasons;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;

public class SetSeasonCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
                Commands.literal("season")
                        .requires(source -> source.hasPermissionLevel(2)) // OP only
                        .then(Commands.argument("season", StringArgumentType.word())
                                .executes(ctx -> {
                                    String season = StringArgumentType.getString(ctx, "season").toUpperCase();
                                    ServerWorld world = ctx.getSource().getWorld();

                                    long seasonDay;

                                    switch (season) {
                                        case "SPRING":
                                            seasonDay = 0;
                                            break;
                                        case "SUMMER":
                                            seasonDay = 24;
                                            break;
                                        case "FALL":
                                            seasonDay = 48;
                                            break;
                                        case "WINTER":
                                            seasonDay = 72;
                                            break;
                                        default:
                                            ctx.getSource().sendErrorMessage(
                                                    new StringTextComponent("Invalid season! Use: spring, summer, autumn, winter")
                                            );
                                            return 0;
                                    }

                                    long ticks = seasonDay * 24000L;
                                    world.setDayTime(ticks);

                                    ctx.getSource().sendFeedback(
                                            new StringTextComponent("Season set to " + season),
                                            true
                                    );

                                    return 1;
                                })
                        )
        );
    }
}