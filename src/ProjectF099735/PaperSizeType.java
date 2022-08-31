package ProjectF099735;

public enum PaperSizeType {
    A1(1), A2(2), A3(3), A4(4), A5(5);

    public final double price;

    private PaperSizeType(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "The possible paper sizes are A1, A2, A3, A4, A5!";
    }

}
