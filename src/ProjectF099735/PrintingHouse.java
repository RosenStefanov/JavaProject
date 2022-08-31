package ProjectF099735;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintingHouse {
    private ArrayList<Publication> publications = new ArrayList<>();
    private ArrayList<Operator> operators = new ArrayList<>();
    private ArrayList<Manager> managers = new ArrayList<>();
    private int profitRate;
    private double minimalIncomeForBonus;
    private double discountPercentage = 10;
    private int minimalPublicationsForDiscount;

    public PrintingHouse(double minimalIncomeForBonus, int profitRate, int minimalPublicationsForDiscount){
        this.minimalIncomeForBonus = minimalIncomeForBonus;
        this.profitRate = profitRate;
        this.minimalPublicationsForDiscount = minimalPublicationsForDiscount;
    }

    public void addPublication(Publication publication){
        this.publications.add(publication);
    }

    public void addOperator(Operator operator){
        this.operators.add(operator);
    }

    public void addManager(Manager manager){
        this.managers.add(manager);
    }

    public double operatorsSalaries(){
        double sumOfSalaries = 0;
        for(int i = 0; i < this.operators.size(); i++ ){
            sumOfSalaries += this.operators.get(i).getBaseSalary();
        }
        return sumOfSalaries ;
    }

    public double managersSalaries(){
        double sumOfSalaries = 0;
        if(income() < this.minimalIncomeForBonus) {
            for (int i = 0; i < this.managers.size(); i++) {
                sumOfSalaries += this.managers.get(i).getBaseSalary();
            }
            return sumOfSalaries;
        }
        else {
            for (int i = 0; i < this.managers.size(); i++) {
                sumOfSalaries += this.managers.get(i).getBaseSalary() + (this.managers.get(i).getBaseSalary() * this.managers.get(i).getBonus()) / 100;
            }
            return sumOfSalaries;

        }
    }

    public ArrayList getPublications(){
        return publications;
    }

    public double expensesOnSalaries(){
        double expenses;
        expenses = this.operatorsSalaries() + this.managersSalaries();
        return expenses;

    }

    public double paperExpenses(Publication publication){
        double expense;
        expense = (publication.getPaperSizeType().price + publication.getPaperType().price) * publication.getNumberOfPages();
        return expense;
    }

    public double totalPaperExpenses(){
        double expense =0;
        for(int i =0; i< this.publications.size(); i++){
            expense += paperExpenses(this.publications.get(i));
        }
        return expense ;
    }

    public double income(){
        double income=0;
        for(int i = 0; i< this.publications.size(); i++){
            income += (paperExpenses(this.publications.get(i)) * this.profitRate);
        }
        if(this.publications.size() < this.minimalPublicationsForDiscount)
        {return income;}
        else {
            return income * ((100-this.discountPercentage)/100);
        }
    }

    public void printToFileExpensesAndIncome(){
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File("PrintResult.txt"), true);
            fout.append("The expenses of the printing house are: " + (totalPaperExpenses() + expensesOnSalaries()) + ", and the income of the printing house is: " + income() + "!!!" + System.lineSeparator());

        } catch(FileNotFoundException e){
            System.out.println("File not found. " + e);
        } catch (IOException e){
            System.out.println("IOException " + e);
        } finally {
            try{
                if(fout != null){
                    fout.close();
                }
            } catch (IOException e){
                System.out.println(e);
            }
        }

    }

    @Override
    public String toString(){
        return "Printing house profit rate: " + this.profitRate + ", minimal income for bonus: " + this.minimalIncomeForBonus +
                ", discount percentage: " + this.discountPercentage + ", minimal publications for discount: " + this.minimalIncomeForBonus + ".";
    }

}
