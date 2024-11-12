public class pathsInGrid {

    public static void printGrid(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            System.out.println("");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void findMinPath(int[][] grid){
        int i=0;
            while(i+1<grid.length){
                grid[i+1][0]+=grid[i][0];
                grid[0][i+1]+=grid[0][i];
                i++;
            }
            printGrid(grid);

        for(i=1;i<grid.length;i++){
            for (int j=1;j<grid.length;j++){
                if(grid[i-1][j]<grid[i][j-1]){
                    grid[i][j]+=grid[i-1][j];
                }
                else{grid[i][j]+=grid[i][j-1];}
            }
        }
        printGrid(grid);

    System.out.println(grid[grid.length-1][grid.length-1]);
    }

    public static void main(String[] argc){
    int[][] grid= {{1,3,1},{1,5,1},{4,2,1}};
    findMinPath(grid);

    }

}
