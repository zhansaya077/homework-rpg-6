package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private ArenaFighter fighter;
    private int healAmount;
    private int actualHeal;

    public HealCommand(ArenaFighter fighter, int healAmount) {
        this.fighter = fighter;
        this.healAmount = healAmount;
    }

    @Override
    public void execute() {
        actualHeal = fighter.heal(healAmount);
    }

    @Override
    public void undo() {
        fighter.takeDamage(actualHeal);
    }

    @Override
    public String getDescription() {
        return "Heal";
    }
}
