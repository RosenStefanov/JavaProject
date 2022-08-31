package ProjectF099735;

public abstract class Worker {
    private static int baseSalary;

    public static void setBaseSalary(int baseSalary) {
        Worker.baseSalary = baseSalary;
    }

    public int getBaseSalary(){
        return this.baseSalary;
    }

    @Override
    public String toString(){
        return "The workers base salary is: " + baseSalary + "!";
    }
}
