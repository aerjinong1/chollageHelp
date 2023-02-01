package method;

import java.io.File;
import java.io.IOException;

public class TreeToJson {
    File file = new File("../resources/static/map/map.json");

    public TreeToJson() throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
    }
    public void transformation(Tree tree){
        String json = "[";
        if (tree!=null){

        }

    }

}
