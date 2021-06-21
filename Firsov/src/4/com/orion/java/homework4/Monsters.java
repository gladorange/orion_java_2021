package com.orion.java.homework4;

public class Monsters extends Unit {

    MonstersBreed monstersBreed;

    public Monsters(MonstersBreed monstersBreed,int currentHealth, Grid grid, double x, double y, String name,Unit.Grid.FindUnit findUnitHandler){
        super(x,y,currentHealth,name,grid);
        if(monstersBreed == null){
            throw new IllegalArgumentException("Error:monstersBreed can't be null");
        }
        this.monstersBreed = monstersBreed;
        this.findUnitHandler = findUnitHandler;
    }
    private Unit.Grid.FindUnit findUnitHandler;
    public void attack(){
        Unit attackedUnit = findUnitHandler.findUnit((int)super.x/ Grid.CELL_SIZE,(int)super.y/ Grid.CELL_SIZE );
        if(attackedUnit == null){
            System.out.println("Can't find unit");
        }else{
            monstersBreed.attack(this,attackedUnit);
        }

    }
    public static class MonstersBreed{

        private int damage;
        private MonstersBreed parent;
        private Grid.Attackable attackHandler;

        public void attack(Unit mainUnit,Unit attackedUnit){

            attackHandler.execute(mainUnit,attackedUnit,this.damage);
        }

        public MonstersBreed(int damage, MonstersBreed parent, Grid.Attackable attackHandler){
            // род переопределяет урон монстра ненулевым значением
            this.damage = damage;
            this.attackHandler = attackHandler;
            //Делаем собственное наследование, у рода, у которого нет предков,будет NULL
            // Создано,что если будет 300 гоблинов не пришлось в ручную настраивать параметры их всех
            //     this.parent = parent;
            // Наследование непереопределенных атрибутов.
            if (parent != null) {
                if (damage == 0){
                    this.damage = parent.getDamage();
                }
                if(attackHandler == null){
                    this.attackHandler =  parent.getAttackHandler();
                }
            }
        }

        public int getDamage() {
            return this.damage;
        }
        public Grid.Attackable getAttackHandler(){
            return this.attackHandler;
        }

    }

    public static void main(String[] args) {
        Unit.Grid grid = new Grid();


        MonstersBreed attackedWithTenDamage = new MonstersBreed(10, null, new Grid.Attackable() {
            @Override
            public void execute(Unit mainUnit,Unit attackedUnit, int damage) {
                System.out.println("Монстр "+mainUnit.getName()+" атакует "+ attackedUnit.getName()+" на "+damage+" урона." );
                attackedUnit.currentHealth-=damage;
            }
        });
        Monsters monsterVasya = new Monsters(attackedWithTenDamage, 20, grid, 1, 1, "monsterVasya", new Grid.FindUnit() {
            @Override
            public Unit findUnit(int currentX,int currentY) {
              Unit attackedUnit = grid.getRandomUnit( currentX, currentY);
              return attackedUnit;
            }
        });


        MonstersBreed attackedWithTwelveDamage = new MonstersBreed(20, null, new Grid.Attackable() {
            @Override
            public void execute(Unit mainUnit,Unit attackedUnit, int damage) {
                System.out.println("Монстр "+mainUnit.getName()+" атакует "+ attackedUnit.getName()+" на "+damage+" урона." );
                attackedUnit.currentHealth-=damage;
            }
        });
        Monsters monsterPetya = new Monsters(attackedWithTwelveDamage, 20, grid, 2, 2, "monsterPetya", new Grid.FindUnit() {
            @Override
            public Unit findUnit(int currentX, int currentY) {
                Unit attackedUnit = grid.getRandomUnit( currentX, currentY);
                return attackedUnit;
            }
        });
        grid.add(monsterVasya);
        grid.add(monsterPetya);

        monsterVasya.attack();
        monsterPetya.attack();





    }
}
