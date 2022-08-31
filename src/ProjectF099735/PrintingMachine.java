package ProjectF099735;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PrintingMachine implements Runnable {
    private int maxNumberOfPaper;
    private int numberOfPaper = 0;
    private boolean isColored;
    private int pagesPerMinute;
    private PrintingHouse printingHouse;


    public PrintingMachine(int maxNumberOfPaper, boolean isColored, int pagesPerMinute, PrintingHouse printingHouse){
        this.maxNumberOfPaper = maxNumberOfPaper;
        this.isColored = isColored;
        this.pagesPerMinute = pagesPerMinute;
        this.printingHouse = printingHouse;
    }

    public void isPrintingMachineLoaded() throws PrintingMachineIsEmpty{
        if(numberOfPaper == 0){
            throw new PrintingMachineIsEmpty(maxNumberOfPaper);
        }
    }

    public int getMaxNumberOfPaper() {
        return maxNumberOfPaper;
    }

    public int getPagesPerMinute() {
        return pagesPerMinute;
    }

    public int getNumberOfPaper() {
        return numberOfPaper;
    }

    public boolean isColored() {
        return isColored;
    }

    public void loadWithMaxPaper() {
        this.numberOfPaper = this.maxNumberOfPaper;
    }


    @Override
    public void run() {
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File("PrintResult.txt"), true);

            for (int i = 0; i < this.printingHouse.getPublications().size(); i++) {
                fout.append(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() +
                        " " + "Printing: " + this.printingHouse.getPublications().get(i).toString()+ System.lineSeparator());
            }

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
        return "Printing machine max number of paper: " + this.maxNumberOfPaper + ", number of paper: " + this.numberOfPaper + ", is it colored: " +
                this.isColored + ", pages per min: " + this.pagesPerMinute + ".";
    }



}

