package com.orion.java.homework4;

import java.util.Random;

public class Unit{
     //Специально задается типом double.С расчетом на то,что в одной ячейке может находится больше юнитов.
    //Если это потребуется
    protected double   x;
    protected double   y;
    protected String name="";
    private Grid grid;
    private Unit prev;
    private Unit next;
    protected int currentHealth;



    public Unit(double x, double y, int currentHealth, String name, Grid grid) {
        if(x < 0 || y < 0 || currentHealth <=0 ||  grid == null) {
            throw new IllegalArgumentException("Error:Illegal argument.");
        }
        this.x = x;
        this.y = y;
        this.name = name;
        this.grid = grid;
        this.prev = null;
        this.next = null;
        this.currentHealth = currentHealth;
    }
    // Предположительно, он будет вызываться кодом AI для управляемых компьютером
    //юнитов и обработчиком пользовательского ввода для юнита игрока
    public void move(double   x1,double   y1 ){
        System.out.println("Юнит "+this.name+"идет на x1 "+x1 + " y1 "+ y1);
         grid.move(this,x1,y1);
    }

    public String getName() {
        return name;
    }

    public static class Grid{
        //Количество клеток
        public   static int NUM_CELLS = 10;
        //В одной клетке только один юнит
        public static int CELL_SIZE = 1;
        private Unit cells[][];
        Grid() {
            cells =  new Unit[NUM_CELLS][NUM_CELLS];
            // Очистка сетки.
            for (int x = 0; x < NUM_CELLS; x++) {
                for (int y = 0; y < NUM_CELLS; y++) {
                    cells[x][y] = null;
                }
            }
        }

        void checkCoordinats(double x1, double y1) throws IllegalArgumentException{

            int cellX = (int)(x1 / CELL_SIZE);
            int cellY = (int)(y1 / CELL_SIZE);

            if(cellX > NUM_CELLS || cellY > NUM_CELLS){
                throw new IllegalArgumentException("Error:Cell number can't be more than "+NUM_CELLS);
            }
            if( cells[cellX][cellY] != null){
                throw new IllegalArgumentException("Error:There is an unit!");
            }

        }

        void delete(Unit unit) throws IllegalArgumentException{
            // Смотрим в какой ячейке находимся.
            int oldCellX = (int)(unit.x / CELL_SIZE);
            int oldCellY = (int)(unit.y / CELL_SIZE);
            // Убираем юнит из списка старой ячейки.
            if (unit.prev != null) {
                unit.prev.next = unit.next;
            }
            if (unit.next != null) {
                unit.next.prev = unit.prev;
            }

            // Если это голова списка — удаляем ее.
            if (cells[oldCellX][oldCellY] == unit) {
                cells[oldCellX][oldCellY] = unit.next;
            }
        }
        void add(Unit unit) throws IllegalArgumentException{
            if(unit == null){
                throw new IllegalArgumentException("Unit can't be null");
            }

            checkCoordinats(unit.x,unit.y);

            // Определяем в какой ячейке сетки мы находимся.
            int cellX = (int)(unit.x / CELL_SIZE);
            int cellY = (int)(unit.y / CELL_SIZE);



            // Добавляем в начало списка найденной ячейки.
            unit.prev = null;
            unit.next = cells[cellX][cellY];
            cells[cellX][cellY] = unit;

            if (unit.next != null) {
                System.out.println("name unit prev "+unit.next.name);
                unit.next.prev = unit;
            }

        }
        /**
         * Если он пересекает линии границ ячеек, нам нужно удалить его из одной
         * ячейки и перенести в другую.
         */
        void move(Unit unit, double x, double y) throws  IllegalArgumentException{
            System.out.println("Move |"+unit.name+"|");
            checkCoordinats(unit.x,unit.y);


            // Смотрим в какой ячейке находимся.
            int oldCellX = (int)(unit.x / CELL_SIZE);
            int oldCellY = (int)(unit.y / CELL_SIZE);

            // Смотрим в какую ячейку перемещаемся.
            int cellX = (int)(x / CELL_SIZE);
            int cellY = (int)(y / CELL_SIZE);

            // если ячейка не меняется =- мы закончили
            if (oldCellX == cellX && oldCellY == cellY) return;

            unit.x = x;
            unit.y = y;

            delete(unit);

            // Добавление обратно в сетку в новую ячейку.
            add(unit);
        }



        public  Unit getRandomUnit(int currentX,int currentY){
            for (int x = 0; x < NUM_CELLS; x++) {
                for (int y = 0; y < NUM_CELLS; y++) {
                    if(  cells[x][y]!= null &&    (new Random()).nextBoolean()     && !(currentX==x && currentY==y  )  ){
                        return cells[x][y];
                    }
                }
            }
            return null;
        }

        /**
         * Задает интерфейс для поиска юнита.Можно переопределять метод  и задавать различные алгоритмы поиска.
         */
        public interface FindUnit {
            public Unit findUnit(int currentX,int currentY);
        }

        public abstract static class Cast{
           protected   String name;
           public Cast(String name){
               if(name == null ||  name.equals("")){
                   throw new IllegalArgumentException("Name can't be null");
               }
               this.name = name;
           }
           abstract void cast(Unit mainMagician);

            public String getName() {
                return name;
            }
        }
        public static class Healing extends Cast{
            private int healthAdd;
            public Healing(int healthAdd,String name){
                super(name);
                this.healthAdd = healthAdd;
            }
            @Override
            void cast(Unit mainMagician) {
                mainMagician.currentHealth +=this.healthAdd;
                System.out.println("Маг "+ mainMagician.name +"исцелен на "+this.healthAdd+" .Теперь у него"+ mainMagician.currentHealth + "здоровья" );
            }
        }
        public static class Thunder extends Cast{
            private int damage;
            private  Grid grid;
            public Thunder(int damage,Grid grid,String name){
                super(name);
                if(damage < 0 || grid == null ){
                    throw new IllegalArgumentException();
                }
                this.damage = damage;
                this.grid = grid;
            }

            @Override
            void cast(Unit mainMagician) {
                Unit attackedUnit = grid.getRandomUnit((int)mainMagician.x/Grid.CELL_SIZE,(int)mainMagician.y/Grid.CELL_SIZE);
                if(attackedUnit == null){
                    System.out.println("Can't find unit");
                }else{
                    System.out.println("Заклинание "+ this.name + " нанесло урон "+damage+" "+ attackedUnit.name);
                    attackedUnit.currentHealth-=this.damage;
                }
            }
        }
        public static class ChainThunder extends Cast{
            private int damage;
            private  Grid grid;
            public ChainThunder(int damage,Grid grid,String name){
                super(name);
                if(damage < 0 || grid == null ){
                    throw new IllegalArgumentException();
                }
                this.damage = damage;
                this.grid = grid;
            }
            @Override
            void cast(Unit mainMagician) {
                for (int x = 0; x < NUM_CELLS; x++) {
                    for (int y = 0; y < NUM_CELLS; y++) {
                        if(  this.grid.cells[x][y]!= null && !( (int)mainMagician.x/ Grid.CELL_SIZE ==x &&  (int)mainMagician.y/ Grid.CELL_SIZE==y  ) ){
                            System.out.println("Заклинание "+ this.name + " нанесло урон "+damage +" "+  this.grid.cells[x][y].name);
                            this.grid.cells[x][y].currentHealth-=this.damage;
                        }
                    }
                }
            }
        }
        public static class FireTouching extends Cast{
            private int damage;
            private  Grid grid;
            public FireTouching(int damage,Grid grid,String name) {
                super(name);
                if(damage < 0 || grid == null ){
                    throw new IllegalArgumentException();
                }
                this.damage = damage;
                this.grid = grid;
            }
            private void handleUnit(Unit mainUnit,Unit attackedUnit ){
                if( attackedUnit!=null   ){
                    attackedUnit.currentHealth-=damage;
                    System.out.println("Заклинание "+ this.name + "задело "+attackedUnit.name + "с уроном " + damage);
                }
            }
            @Override
            void cast(Unit mainMagician) {

                int x = (int)mainMagician.x/ Grid.CELL_SIZE;
                int y = (int)mainMagician.y/ Grid.CELL_SIZE;


                // Теперь пробуем соседние ячейки.
                if (x > 0 && y > 0) handleUnit(mainMagician, this.grid.cells[x-1][y-1]);
                if (x > 0) handleUnit(mainMagician, this.grid.cells[x-1][y]);
                if (y > 0) handleUnit(mainMagician, this.grid.cells[x][y-1]);
                if (x > 0 && y < NUM_CELLS-1) {
                    handleUnit(mainMagician, this.grid.cells[x-1][y + 1]);
                }

            }
        }
        public static class FireWall extends Cast{
            private int damage;
            private  Grid grid;

            public FireWall( int damage, Grid grid,String name) {
                super(name);
                this.damage = damage;
                this.grid = grid;
            }

            @Override
            void cast(Unit mainMagician) {
                for (int x = 0; x < NUM_CELLS; x++) {
                    for (int y = 0; y < NUM_CELLS; y++) {
                        if(  this.grid.cells[x][y]!= null && (x%2==0 && y%2==0    )  ){
                            System.out.println("Маг получил урон "+damage + " от  заклинания "+ this.name  );
                            this.grid.cells[x][y].currentHealth-=damage;
                        }
                    }
                }
            }
        }
        public static class  KickingMonsters extends Cast{
            private int damage;
            private  Grid grid;

            public KickingMonsters( int damage, Grid grid,String name) {
                super(name);
                this.damage = damage;
                this.grid = grid;
            }

            @Override
            void cast(Unit mainMagician) {
                for (int x = 0; x < NUM_CELLS; x++) {
                    for (int y = 0; y < NUM_CELLS; y++) {
                        if(  this.grid.cells[x][y]!= null ){
                            if(  this.grid.cells[x][y] instanceof Monsters){
                                System.out.println("Заклинание "+ this.name + " нанесло урон "+damage +" "+  this.grid.cells[x][y].name);
                                this.grid.cells[x][y].currentHealth-=this.damage;
                            }

                        }
                    }
                }
            }
        }
        public static class Migraine extends Cast{
            private int damage;
            private  Grid grid;

            public Migraine( int damage, Grid grid,String name) {
                super(name);
                this.damage = damage;
                this.grid = grid;
            }

            @Override
            void cast(Unit mainMagician) {
                for (int x = 0; x < NUM_CELLS; x++) {
                    for (int y = 0; y < NUM_CELLS; y++) {
                        if(  this.grid.cells[x][y]!= null ){
                            if(  this.grid.cells[x][y] instanceof Magician){
                                System.out.println("Заклинание "+ this.name + " нанесло урон "+damage +" "+  this.grid.cells[x][y].name);
                                this.grid.cells[x][y].currentHealth-=this.damage;
                            }

                        }
                    }
                }
            }
        }

        /**
         * Задает интерфейс для атаки
         */
        public interface Attackable {
            public void execute(Unit mainUnit,Unit attackedUnit,int damage);
        }
        public static class GameLoop{
            private final int WINNERS_NUMBER = 1;


            void loop(Grid grid){

                while (true) {
                    int countUnit = 0;
                    //Произведем все действия
                    for (int x = 0; x < NUM_CELLS; x++) {
                        for (int y = 0; y < NUM_CELLS; y++) {
                            if (grid.cells[x][y] != null) {
                                countUnit++;
                                 if ((new Random()).nextBoolean()) {

                                    //Юнит передвигается
                                    try {
                                        grid.cells[x][y].move((double) new Random().nextInt(Grid.NUM_CELLS - 1), (double) new Random().nextInt(Grid.NUM_CELLS - 1));
                                    }catch (Exception e){

                                    }

                                } else {
                                    //Юнит аттакует
                                    if (grid.cells[x][y] instanceof Monsters) {
                                        ((Monsters) grid.cells[x][y]).attack();
                                    } else if (grid.cells[x][y] instanceof Magician) {
                                        ((Magician) grid.cells[x][y]).cast((new Random()).nextInt(Magician.CASTS_NUMBER - 1));
                                    } else {
                                        System.out.println("Can't indentify unit " + grid.cells[x][y].name);
                                    }

                                }

                            }

                        }
                    }
                    //Удалим умерших юнитов
                    for (int x = 0; x < NUM_CELLS; x++) {
                        for (int y = 0; y < NUM_CELLS; y++) {
                            if (grid.cells[x][y] != null && grid.cells[x][y].currentHealth <=0) {
                                System.out.println(grid.cells[x][y].name + "умер!");
                                grid.delete(grid.cells[x][y]);
                            }
                        }
                    }

                    if(countUnit<=WINNERS_NUMBER){
                        if(countUnit == 0){
                            System.out.println("No one won");
                        }else{
                            for (int x = 0; x < NUM_CELLS; x++) {
                                for (int y = 0; y < NUM_CELLS; y++) {
                                    if (grid.cells[x][y] != null){
                                        System.out.println(grid.cells[x][y] + "won");
                                    }
                                }
                            }
                        }
                        return;
                    }else{
                        System.out.println("countUnit "+countUnit);
                    }

                }
            }
        }


    }
}
