package com.orion.java.homework4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Unit.Grid grid= new Unit.Grid();
        Monsters.MonstersBreed attackedWithTenDamage = new Monsters.MonstersBreed(10, null, new Unit.Grid.Attackable() {
            @Override
            public void execute(Unit mainUnit,Unit attackedUnit, int damage) {
                System.out.println("Монстр "+mainUnit.getName()+" атакует "+ attackedUnit.getName()+" на "+damage+" урона." );
                attackedUnit.currentHealth-=damage;
            }
        });
        Monsters monsterVasya = new Monsters(attackedWithTenDamage, 20, grid, 0, 0, "monsterVasya", new Unit.Grid.FindUnit() {
            @Override
            public Unit findUnit(int currentX,int currentY) {
                Unit attackedUnit = grid.getRandomUnit( currentX, currentY);
                return attackedUnit;
            }
        });


        Monsters.MonstersBreed attackedWithTwelveDamage = new Monsters.MonstersBreed(20, null, new Unit.Grid.Attackable() {
            @Override
            public void execute(Unit mainUnit,Unit attackedUnit, int damage) {
                System.out.println("Монстр "+mainUnit.getName()+" атакует "+ attackedUnit.getName()+" на "+damage+" урона." );
                attackedUnit.currentHealth-=damage;
            }
        });
        Monsters monsterPetya = new Monsters(attackedWithTwelveDamage, 20, grid, 2, 2, "monsterPetya", new Unit.Grid.FindUnit() {
            @Override
            public Unit findUnit(int currentX, int currentY) {
                Unit attackedUnit = grid.getRandomUnit( currentX, currentY);
                return attackedUnit;
            }
        });
        grid.add(monsterVasya);
        grid.add(monsterPetya);

        ArrayList<Unit.Grid.Cast> casts1 = new ArrayList<>(Arrays.asList(
                new Unit.Grid.KickingMonsters(20,grid,"Изгнание монстров"),
                new Unit.Grid.Thunder(40,grid,"Молния "),
                new Unit.Grid.FireTouching(30,grid,"Огненное касание" )
        ));
        Magician mag1 = new Magician(1,0,100,"MagVasya",grid,casts1);
        ArrayList<Unit.Grid.Cast> casts2 = new ArrayList<>(Arrays.asList(
                new Unit.Grid.Healing(20 ,"Исцеление"),
                new Unit.Grid.Migraine(40,grid,"Мигрень"),
                new Unit.Grid.FireWall(30,grid,"Огненная стена" )
        ));
        ArrayList<Unit.Grid.Cast> casts3 = new ArrayList<>(Arrays.asList(
                new Unit.Grid.Healing(20 ,"Исцеление"),
                new Unit.Grid.Migraine(40,grid,"Мигрень"),
                new Unit.Grid.ChainThunder(30,grid,"Цепная молния" )
        ));
        Magician mag2 = new Magician(0,8,100,"MagPetya",grid,casts2);
        Magician mag3 = new Magician(0,3,100,"MagVanya",grid,casts3);
        grid.add(mag1);
        grid.add(mag2);
        grid.add(mag3);

        Unit.Grid.GameLoop gameLoop = new Unit.Grid.GameLoop();
        gameLoop.loop(grid);
    }
}
