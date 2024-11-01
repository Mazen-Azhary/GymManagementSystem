    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import java.util.ArrayList;

/**
 *
 * @author Mazen
 */
public class ClassDatabase extends DataBases {

    public ClassDatabase() {
        super("src/gymproject/Class.txt");
    }

    public Users createRecordFrom(String Line) {
        return new Class(Line.split(", "));
    }
    
}
