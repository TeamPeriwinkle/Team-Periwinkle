import java.awt.FileDialog;

public class NotesClass {
    
    Notespage gui;
    public NotesClass(Notespage gui){

        this.gui = gui;
    }
    public void newFile (){
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }
    public void Open(){
        FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
        fd.setVisible(true);

        
    }
}
