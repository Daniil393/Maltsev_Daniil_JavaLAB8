public class Pistol {

    private int bullets;

    public Pistol(int bullets) {
        if (bullets < 0) {
            System.out.println("Нельзя создать пистолет с отрицательным количеством патронов. Устанавливается 0.");
            this.bullets = 0;
        }

        else
            this.bullets = bullets;
    }

    public Pistol() {
        this.bullets = 5;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        }

        else
            System.out.println("Клац!");
    }

    public int getBullets() {
        return bullets;
    }

    @Override
    public String toString() {
        return "Пистолет [патроны: " + bullets + "]";
    }
}