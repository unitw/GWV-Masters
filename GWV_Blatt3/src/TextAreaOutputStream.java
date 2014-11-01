
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream {
    private final JTextArea textControl;

    
    public TextAreaOutputStream( JTextArea control ) {
        textControl = control;
         textControl.setFont(new Font("Arial", Font.BOLD, 20));

    }

    
    @Override
    public void write( int b ) throws IOException {
        // append the data as characters to the JTextArea control
        textControl.append( String.valueOf( ( char )b ) );
    }  
}