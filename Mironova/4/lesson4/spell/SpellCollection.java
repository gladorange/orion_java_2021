package lesson4.spell;


public enum SpellCollection {

    HEALING {
        public Healing action() {
            return new Healing("Лечение");
        }
    },
    LIGHTING {
        public Lighting action(){
            return new Lighting("Молния");
        }
    },
    CHAIN_LIGHTING {
        public ChainLighting action(){
            return new ChainLighting("Цепная молния");
        }
    },
    WALL_OF_FIRE {
        public ChainLighting action(){
            return new ChainLighting("Цепная молния");
        }
    },
    FIRE_TOUCH {
        public FireTouch action(){
            return new FireTouch("Огненное касание");
        }
    },
    MIGRAINE {
        public Migraine action(){
            return new Migraine("Мигрень");
        }
    },
    MONSTER_EXPELL {
        public MonsterExpell action(){
            return new MonsterExpell("Изгнание монстров");
        }
    }
    ;

    public abstract Spell action();


}
