class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        char c = board[row][col];

        if (c == '#' || !node.children.containsKey(c)) {
            return;
        }

        node = node.children.get(c);

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        if (row > 0) {
            dfs(board, row - 1, col, node, result);
        }
        if (col > 0) {
            dfs(board, row, col - 1, node, result);
        }
        if (row < board.length - 1) {
            dfs(board, row + 1, col, node, result);
        }
        if (col < board[0].length - 1) {
            dfs(board, row, col + 1, node, result);
        }

        board[row][col] = c;

        if (node.children.isEmpty()) {
            node.word = null;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }
}