import java.io.File;
import java.util.Arrays;

/**
 * Created by Pavlik on 10/7/15.
 */

import java.io.*;
import java.util.*;

public class DirList {
    public void list(String [] args) {

        File path = new File(".");
        String[] list;
        if (args.length == 0) {
        System.out.println("Содержимое локальной директории");
        list = path.list();
    }
        else
            list = path.list(new DirFilter(args[0]));
        for(int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}
