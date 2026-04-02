package com.narxoz.rpg.tournament;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;

public class TournamentEngine {

    public TournamentResult runTournament(ArenaFighter hero, ArenaOpponent enemy) {

        DefenseHandler chain = new DodgeHandler(hero.getDodgeChance());
        chain.setNext(new BlockHandler(hero.getBlockRating() / 100.0))
             .setNext(new ArmorHandler(hero.getArmor()))
             .setNext(new HpHandler());

        ActionQueue queue = new ActionQueue();
        int rounds = 0;
        StringBuilder log = new StringBuilder();

        while (hero.isAlive() && enemy.isAlive() && rounds < 50) {
            rounds++;

            queue.enqueue(new AttackCommand(hero, enemy));
            queue.enqueue(new HealCommand(hero, 10));
            queue.enqueue(new DefendCommand(hero, 0.1));

            queue.executeAll();

            if (enemy.isAlive()) {
                chain.handle(enemy.getAttackPower(), hero);
            }

            log.append("Round ").append(rounds)
               .append(" Hero HP: ").append(hero.getHp())
               .append(" Enemy HP: ").append(enemy.getHp())
               .append("\n");
        }

        String winner = hero.isAlive() ? "Hero" : "Enemy";
        return new TournamentResult(winner, rounds, log.toString());
    }
}
