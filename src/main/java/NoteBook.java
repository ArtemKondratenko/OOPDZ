package main.java;

public class NoteBook extends Device implements  Marching{
    private  int charQuanti;
    private String firmNoteBook;

    public int getCharQuanti() {
        return charQuanti;
    }

    public void setCharQuanti(int charQuanti) {
        this.charQuanti = charQuanti;
    }

    public String getFirmNoteBook() {
        return firmNoteBook;
    }

    public void setFirmNoteBook(String firmNoteBook) {
        this.firmNoteBook = firmNoteBook;
    }
}
