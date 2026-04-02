package com.narxoz.rpg;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.tournament.*;

public class Main {
    public static void main(String[] args) {

        ArenaFighter hero = new ArenaFighter();
        ArenaOpponent enemy = new ArenaOpponent();

        
        ActionQueue queue = new ActionQueue();
        queue.enqueue(new AttackCommand(hero, enemy));
        queue.enqueue(new HealCommand(hero, 10));
        queue.enqueue(new DefendCommand(hero, 0.2));

        System.out.println(queue.getCommandDescriptions());
        queue.undoLast();
        System.out.println(queue.getCommandDescriptions());
        queue.executeAll();

        
        DefenseHandler chain = new DodgeHandler(0.3);
        chain.setNext(new BlockHandler(0.2))
             .setNext(new ArmorHandler(5))
             .setNext(new HpHandler());

        System.out.println("Before HP: " + hero.getHp());
        chain.handle(30, hero);
        System.out.println("After HP: " + hero.getHp());

    
        TournamentEngine engine = new TournamentEngine();
        TournamentResult result = engine.runTournament(hero, enemy);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println(result.getLog());
    }
}
