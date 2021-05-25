package lesson4.character;

public class Monster extends Charm {

    private static final int DAMAGE = 5;
    private static final int HITPOINT = 8;

    public Monster(String name) {
        super("Монстр №" + name, HITPOINT);
    }

    public void setDamage(int damage) {
        this.setHitPoint(this.getHitPoint() - damage);
    }

    @Override
    public void action(Charm[] targets) {

        if(this.getHitPoint() > 0){

            int damage = rand.nextInt(DAMAGE);

            for (Charm target: targets) {
                if(target != null && !this.equals(target)){
                    System.out.println(this.getName() + " атакует " + target.getName() + " на " + damage + " единиц " +
                            "урона");
                    target.setDamage(damage);
                    break;
                }
            }
        }
    }
}
