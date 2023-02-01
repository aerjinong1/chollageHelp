package method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class KDTree {
    private static final Boolean X = true;//默认以x为首个查找，构建树的层

    public static void main(String[] args) throws IOException {
        int[][] list = {{7, 6}, {6, 1}, {8, 6}, {5, 3}, {2, 2}, {3, 6}, {4, 5}};

        Tree tree = new Tree();

        tree = tree.creat_tree(list, tree, X);
        TreeToJson treeToJson = new TreeToJson();
        tree.show(tree);
        int[] goal = new int[]{4, 4};


        ArrayList<int[]> list1 = new ArrayList();


        list1 = tree.search(goal, tree, X, list1);
        int[] lately = list1.get(0);
        int distent = (int) Math.pow(Math.abs(goal[0] - list1.get(0)[0]), Math.abs(goal[1] - list1.get(0)[1]));
        for (int i = 0; i < list1.size(); i++) {
            int[] temp = list1.get(i);
            int distent_temp = (int) Math.pow(Math.abs(goal[0] - temp[0]), Math.abs(goal[1] - temp[1]));
            if (distent_temp < distent) {
                lately = temp;
            }
        }
        System.out.println(Arrays.toString(lately));


    }
}
