package ProjectF099735;

public class PrintingMachineIsEmpty extends Exception{
    public double maxNumberOfPaper;
    public PrintingMachineIsEmpty(double maxNumberOfPages){
        this.maxNumberOfPaper = maxNumberOfPages;
    }

    @Override
    public String toString(){
        return "The printing machine is empty!!! The max number of paper it can be loaded whit is: " + this.maxNumberOfPaper;
    }

}
