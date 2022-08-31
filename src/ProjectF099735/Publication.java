package ProjectF099735;

public class Publication {
    private String Title;
    private int numberOfPages;
    private PaperSizeType paperSizeType;
    private PaperType paperType;

    public Publication(){};
    public Publication(String Title, int numberOfPages, PaperSizeType paperSizeType, PaperType paperType){
        this.Title = Title;
        this.numberOfPages = numberOfPages;
        this.paperSizeType = paperSizeType;
        this.paperType = paperType;
    }

    public String getTitle() {
        return Title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public PaperSizeType getPaperSizeType() {
        return paperSizeType;
    }

    public PaperType getPaperType() {
        return paperType;
    }

    @Override
    public String toString(){
        return "Publication: " + this.Title + ", number of pages: " + this.numberOfPages + ", paper size: " + this.paperSizeType + ".";
    }
}
