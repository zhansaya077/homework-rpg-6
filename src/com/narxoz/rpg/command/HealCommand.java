package com.narxoz.rpg.command;
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
        int before = fighter.getHealth();

        if (fighter.getHealPotions() > 0) {
            fighter.heal(healAmount);
        }

        int after = fighter.getHealth();
        actualHeal = after - before;
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
