package com.orion.java.homework4;



import java.util.ArrayList;
import java.util.Arrays;


public class Magician extends Unit {
    private ArrayList<Unit.Grid.Cast> casts;
    public static int CASTS_NUMBER = 3;
    public Magician(double x, double y, int currentHealth, String name, Grid grid,ArrayList<Unit.Grid.Cast> casts) {
        super(x, y, currentHealth, name, grid);
        if(casts == null){
            throw new IllegalArgumentException("Casts can't be null!");
        }
        if(casts.size() !=CASTS_NUMBER){
            throw new IllegalArgumentException("Casts number must be equal "+CASTS_NUMBER);
        }
        this.casts = casts;
    }
    public void cast(int i){
        Grid.Cast cast = casts.get(i);
        System.out.println("Маг "+this.name+" читает заклинание "+cast.getName());
        cast.cast(this);
    }

    public static void main(String[] args) {
        Unit.Grid grid = new Grid();
        ArrayList<Grid.Cast> casts1 = new ArrayList<>(Arrays.asList(
                new Grid.KickingMonsters(20,grid,"Изгнание монстров"),
                new Grid.Thunder(40,grid,"Молния "),
                new Grid.FireTouching(30,grid,"Огненное касание" )
        ));
        Magician mag1 = new Magician(1,0,100,"MagVasya",grid,casts1);
        ArrayList<Grid.Cast> casts2 = new ArrayList<>(Arrays.asList(
                new Grid.Healing(20 ,"Исцеление"),
                new Grid.Migraine(40,grid,"Мигрень"),
                new Grid.FireWall(30,grid,"Огненная стена" )
        ));
        ArrayList<Grid.Cast> casts3 = new ArrayList<>(Arrays.asList(
                new Grid.Healing(20 ,"Исцеление"),
                new Grid.Migraine(40,grid,"Мигрень"),
                new Grid.ChainThunder(30,grid,"Цепная молния" )
        ));
        Magician mag2 = new Magician(0,1,100,"MagPetya",grid,casts2);
        Magician mag3 = new Magician(0,3,100,"MagVanya",grid,casts3);
        grid.add(mag1);
        grid.add(mag2);
        grid.add(mag3);



        Monsters sashaMnstr = new Monsters(new Monsters.MonstersBreed(20, null, new Grid.Attackable() {
            @Override
            public void execute(Unit mainUnit, Unit attackedUnit, int damage) {
                System.out.println("do nothing");
            }
        }), 20, grid, 5, 5, "MonstrSaha", new Grid.FindUnit() {
            @Override
            public Unit findUnit(int currentX, int currentY) {
                return null;
            }
        });
        grid.add(sashaMnstr);

        for (int i = 0; i < casts1.size(); i++) {
            mag1.cast(i);
            mag2.cast(i);
            mag3.cast(i);
        }





    }
}
