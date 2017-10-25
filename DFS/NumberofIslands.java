package DFS;
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//11110
//11010
//11000
//00000
//Answer: 1
//
//Example 2:
//
//11000
//11000
//00100
//00011
//Answer: 3

public class NumberofIslands {
	public int numIslands(char[][] grid) {
        if (grid.length==0 || grid[0].length==0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (visited[i][j]==false && grid[i][j]=='1'){
                    helper(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void helper(char[][] grid, int i, int j, boolean[][] visited){
        if (i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || visited[i][j]==true || grid[i][j]=='0') return;
        visited[i][j]=true;
        helper(grid, i+1, j, visited);
        helper(grid, i-1, j, visited);
        helper(grid, i, j+1, visited);
        helper(grid, i, j-1, visited);
    }
}
