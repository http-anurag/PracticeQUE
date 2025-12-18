class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                explore(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }

    private void explore(int[][] g, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < g.length; j++) {
            if (g[i][j] == 1 && !visited[j]) {
                explore(g, visited, j);
            }
        }
    }
}
