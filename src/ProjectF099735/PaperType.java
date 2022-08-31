package ProjectF099735;

public enum PaperType {
    NORMAL_PAPER(1), NEWSPAPER_PAPER(2), GLOSSY_PAPER(3);

    public final double price;

    private PaperType(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "The possible paper types are Normal paper, Newspaper paper and Glossy paper!";
    }
}
