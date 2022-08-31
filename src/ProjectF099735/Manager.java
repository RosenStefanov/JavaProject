package ProjectF099735;

public class Manager extends Worker {
    private double bonus;

    public Manager (double bonus){
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString(){
        return "The managers base salary is: " + this.getBaseSalary() + ", and the bonus % is: " + this.bonus + "!";
    }
}
