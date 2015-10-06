import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Pavlik on 10/7/15.
 */
class DirFilter implements FilenameFilter {
    String afn;
    DirFilter(String afn) { this.afn = afn; }
    public boolean accept(File dir, String name) {
        // Получение информации о пути:
        String f = new File(name).getName();
        return f.indexOf(afn) != -1;
    }
}


