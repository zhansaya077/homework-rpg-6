package com.narxoz.rpg.command;

import java.util.*;

public class ActionQueue {
    private List<ActionCommand> queue = new ArrayList<>();

    public void enqueue(ActionCommand cmd) {
        queue.add(cmd);
    }

    public void undoLast() {
        if (!queue.isEmpty()) {
            queue.remove(queue.size() - 1);
        }
    }

    public void executeAll() {
        for (ActionCommand cmd : queue) {
            cmd.execute();
        }
        queue.clear();
    }

    public List<String> getCommandDescriptions() {
        List<String> list = new ArrayList<>();
        for (ActionCommand c : queue) {
            list.add(c.getDescription());
        }
        return list;
    }
}
