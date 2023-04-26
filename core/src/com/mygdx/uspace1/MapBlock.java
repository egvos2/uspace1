package com.mygdx.uspace1;

import java.util.LinkedList;

public class MapBlock {
    int x, y;

    public LinkedList<Player> players = new LinkedList<Player>();
    public LinkedList<Monster> monsters = new LinkedList<Monster>();
    public LinkedList<Item> items = new LinkedList<Item>();
}
