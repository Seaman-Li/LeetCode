package Graph.DFS;

import java.util.*;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class LC0427_ConstructQuadTree {



    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }

    //row,col is where the divided grid starts
    Node buildTree(int[][] grid, int row, int col, int size) {
        // Return a leaf node if the subgrid is uniform
        if(isUniform(grid, row, col, size)){
            return new Node(grid[row][col]==1,true);
        }
        // Divide the grid into four quadrants
        int halfSize = size / 2;
        Node topLeft = buildTree(grid, row, col, halfSize);
        Node topRight = buildTree(grid, row , col + halfSize, halfSize);
        Node bottomLeft = buildTree(grid, row + halfSize, col, halfSize);
        Node bottomRight = buildTree(grid, row + halfSize, col + halfSize, halfSize);
        //Return an internal node linking the four quadrants(it is a parent node)
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight );
    }

    //check if a region is uniform (all 0s or all 1s)
    boolean isUniform(int[][] grid, int row, int col, int size){
        int val = grid[row][col];
        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(grid[i][j] != val){
                    return false;
                }
            }
        }
        return true;
    }

    public void printStructure(Node node, String indent) {
        if (node == null) return;

        if (node.isLeaf) {
            System.out.println(indent + "Leaf Node: val=" + node.val);
        } else {
            System.out.println(indent + "Internal Node:");
            System.out.println(indent + "├── TopLeft:");
            printStructure(node.topLeft, indent + "│   ");
            System.out.println(indent + "├── TopRight:");
            printStructure(node.topRight, indent + "│   ");
            System.out.println(indent + "├── BottomLeft:");
            printStructure(node.bottomLeft, indent + "│   ");
            System.out.println(indent + "└── BottomRight:");
            printStructure(node.bottomRight, indent + "    ");
        }
    }

    // BFS to convert Quad Tree to List (including null values)
    public List<Object> quadTreeToList(Node root) {
        if (root == null) return Collections.emptyList();

        List<Object> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == null) {
                result.add(null);
                continue;
            }

            if (node.isLeaf) {
                result.add(Arrays.asList(node.val ? 1 : 0, 1)); // Leaf: [val, 1]
            } else {
                result.add(Arrays.asList(1, 0)); // Internal Node: [1, 0]
                queue.add(node.topLeft);
                queue.add(node.topRight);
                queue.add(node.bottomLeft);
                queue.add(node.bottomRight);
            }
        }

        // Keep trailing nulls only if necessary (for correct output formatting)
        return result;
    }


    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0},
                        {1,1,1,1,0,0,0,0}};
        LC0427_ConstructQuadTree sol = new LC0427_ConstructQuadTree();
        Node root = sol.construct(grid);
        System.out.println(sol.quadTreeToList(root));

    }
}
