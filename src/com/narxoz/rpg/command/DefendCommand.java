package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {
    private ArenaFighter fighter;
    private double boost;

    public DefendCommand(ArenaFighter fighter, double boost) {
        this.fighter = fighter;
        this.boost = boost;
    }

    @Override
    public void execute() {
        fighter.increaseDodge(boost);
    }

    @Override
    public void undo() {
        fighter.increaseDodge(-boost);
    }

    @Override
    public String getDescription() {
        return "Defend";
    }
}
