package ProjectF099735;

import java.io.*;


public class Main {

    public static void readFromFile(String inputFile){

        try(FileReader fis = new FileReader(new File(inputFile))){
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Publication publication = new Publication("Труд", 124, PaperSizeType.A3, PaperType.GLOSSY_PAPER);
        Publication publication1 = new Publication("24 часа", 140, PaperSizeType.A1, PaperType.NEWSPAPER_PAPER);
        Publication publication2= new Publication("Телеграф", 470, PaperSizeType.A4, PaperType.NORMAL_PAPER);
        Publication publication3= new Publication("Дневник", 261, PaperSizeType.A2, PaperType.NEWSPAPER_PAPER);
        Publication publication4= new Publication("Вести", 280, PaperSizeType.A5, PaperType.NEWSPAPER_PAPER);

        Worker.setBaseSalary(300);

        Operator operator = new Operator();
        Operator operator1 = new Operator();
        Operator operator2 = new Operator();
        Operator operator3 = new Operator();
        Operator operator4 = new Operator();
        Operator operator5 = new Operator();

        Manager manager = new Manager(5);
        Manager manager1 = new Manager(7);


        PrintingHouse printingHouse = new PrintingHouse(50, 3, 5);
        printingHouse.addOperator(operator);
        printingHouse.addOperator(operator1);
        printingHouse.addOperator(operator2);
        printingHouse.addOperator(operator3);
        printingHouse.addOperator(operator4);
        printingHouse.addOperator(operator5);

        printingHouse.addManager(manager);
        printingHouse.addManager(manager1);

        printingHouse.addPublication(publication1);
        printingHouse.addPublication(publication2);
        printingHouse.addPublication(publication);
        printingHouse.addPublication(publication3);
        printingHouse.addPublication(publication4);

        PrintingMachine printingMachine = new PrintingMachine(100, false, 10, printingHouse);
        PrintingMachine printingMachine1 = new PrintingMachine(150, true, 20, printingHouse);
        PrintingMachine printingMachine2 = new PrintingMachine(170, false, 15, printingHouse);

        printingMachine.loadWithMaxPaper();
        printingMachine1.loadWithMaxPaper();
        printingMachine2.loadWithMaxPaper();



        Thread thread1 = new Thread(printingMachine);
        Thread thread2 = new Thread(printingMachine1);
        Thread thread3 = new Thread(printingMachine2);

        try{
            printingMachine.isPrintingMachineLoaded();
            printingMachine1.isPrintingMachineLoaded();
            printingMachine2.isPrintingMachineLoaded();

        } catch(PrintingMachineIsEmpty e){
            System.out.println(e.toString());
        }

        printingHouse.printToFileExpensesAndIncome();

        thread1.start();
        thread2.start();
        thread3.start();

        readFromFile("PrintResult.txt");




    }
}
