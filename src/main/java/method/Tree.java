package method;

import java.util.ArrayList;
import java.util.Arrays;

public class Tree {

        method.Tree root;
        method.Tree left;
        method.Tree right;
        int[] value;


        public ArrayList search(int[] target, method.Tree root, boolean bool, ArrayList list) {//遍历最近的分支，，返回所有点
            if (root == null) {
                return list;
            }
            int distent;
            int[] node = root.getValue();
            if (Arrays.equals(target, root.getValue())) {
                list.add(node);
                return list;
            }
            if (bool) {
                if (target[0] < root.getValue()[0]) {//X轴对比
                    list.add(node);
                    root = root.left;
                    search(target, root, false, list);
                } else {
                    list.add(node);
                    root = root.right;
                    search(target, root, false, list);
                }
            } else if (target[1] < root.getValue()[1]) {//y轴对比
                list.add(node);
                root = root.left;
                search(target, root, true, list);
            } else {
                list.add(node);
                root = root.right;
                search(target, root, true, list);
            }
            return list;
        }
//    public  contrast

        public int[][] insertSort_x(int[][] arr) {
            for (int i = 1; i < arr.length; i++) {
                int[] temp = arr[i];
                int j = i - 1;
                while (temp[0] < arr[j][0]) {
                    arr[j + 1] = arr[j];
                    j--;
                    if (j == -1) {
                        break;
                    }
                }
                arr[j + 1] = temp;
            }
            return arr;
        }

        public int[][] insertSort_y(int[][] arr) {
            for (int i = 1; i < arr.length; i++) {
                int[] temp = arr[i];
                int j = i - 1;
                while (temp[1] < arr[j][1]) {
                    arr[j + 1] = arr[j];
                    j--;
                    if (j == -1) {
                        break;
                    }
                }
                arr[j + 1] = temp;
            }
            return arr;
        }

//    public int[][] insert(int [][] arr,int[] node){
//
//    }

        /**
         * @param arr
         * @param node
         * @param bool 判定是以x分还是y分 X：0，y：1
         * @return
         */
        public method.Tree creat_tree(int[][] arr, method.Tree node, Boolean bool) {
            if (bool) {
                insertSort_x(arr);
                bool = false;
            } else {
                insertSort_y(arr);
                bool = true;
            }

            int[] breaks = arr[arr.length / 2];

            node.setValue(breaks);

            int[][] min = copy(0, arr.length / 2 - 1, arr);
            if (min.length >= 1) {
                node.left = new method.Tree();
                method.Tree tree = creat_tree(min, node.left, bool);
            }

            int[][] large = copy(arr.length / 2 + 1, arr.length - 1, arr);
            if (large.length >= 1) {
                node.right = new method.Tree();
                creat_tree(large, node.right, bool);
            }
            return node;
        }

        /**
         * 首位号定为0 从begin位开始，到end位结束
         *
         * @param begin
         * @param end
         * @param arr
         * @return
         */
        public int[][] copy(int begin, int end, int[][] arr) {
            end += 1;
            int[][] res = new int[end - begin][];
            for (int i = begin; i < end; i++) {
                res[i - begin] = arr[i];
            }
            return res;
        }

        public int[][] split(int[][] root) {
            int[][] aaa = {{5, 6}};
            return aaa;
        }


        public Tree(int[] value) {
            this.value = value;
        }

        public Tree(method.Tree root) {
            this.root = root;
        }

        public Tree() {
        }

        public void show(method.Tree root) {
            if (root != null) {
                System.out.println((Arrays.toString(root.value)));
                show(root.left);
                show(root.right);
            }
        }

//    public void showByString(Tree root) {
//        if (root != null) {
////            System.out.println(Arrays.toString(root.value));
//            if (root.left != null) {
//                System.out.println(Arrays.toString(root.value)+"的左节点"+Arrays.toString(root.left.value));
//                showByString(root.left);
////                return true;
//            }
//            if (root.right!=null){
//                System.out.println(Arrays.toString(root.value)+"的右节点"+Arrays.toString(root.right.value));
//                showByString(root.right);
//            }
//        } else {
////            return false;
//        }
//
//
//    }


        public method.Tree getRoot() {
            return root;
        }

        public void setRoot(method.Tree root) {
            this.root = root;
        }

        public method.Tree getLeft() {
            return left;
        }

        public void setLeft(method.Tree left) {
            this.left = left;
        }

        public method.Tree getRight() {
            return right;
        }

        public void setRight(method.Tree right) {
            this.right = right;
        }

        public int[] getValue() {
            return value;
        }

        public void setValue(int[] value) {
            this.value = value;
        }

}
