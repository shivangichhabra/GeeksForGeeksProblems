package Graph;

import java.util.*;

public class WordSearch {
    Set<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || board[0].length == 0 || board == null || words.length == 0 || words == null)
            return new ArrayList<String>(result);

        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                findWords(board, trie, "", i, j, visited);
            }
        }
        return new ArrayList<String>(result);
    }

    public void findWords(char[][] board, Trie trie, String prefix, int i, int j, boolean[][] visited) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;

        if(visited[i][j])
            return;

        prefix += board[i][j];

        if(!trie.startsWith(prefix))
            return;

        if(trie.search(prefix))
            result.add(prefix);

        visited[i][j] = true;

        findWords(board, trie, prefix, i-1, j, visited);
        findWords(board, trie, prefix, i+1, j, visited);
        findWords(board, trie, prefix, i, j-1, visited);
        findWords(board, trie, prefix, i, j+1, visited);

        visited[i][j] = false;
    }
}

//Trie Node
class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
}

//Trie
class Trie{
    public TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']= new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.item = word;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        if(node.item.equals(word)){
            return true;
        }else{
            return false;
        }
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}

/*
Time limit exceeds for this solution
class Test {
    Set<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0 || board[0].length == 0 || board == null || words.length == 0 || words == null)
            return new ArrayList<String>(result);

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                findWords(board, words, "", i, j, visited);
            }
        }
        return new ArrayList<String>(result);
    }

    public void findWords(char[][] board, String[] words, String prefix, int i, int j, boolean[][] visited) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;

        if(visited[i][j])
            return;

        prefix += board[i][j];

        if(prefix.length() > 0 && isWord(words, prefix))
            result.add(prefix);

        visited[i][j] = true;

        findWords(board, words, prefix, i-1, j, visited);
        findWords(board, words, prefix, i+1, j, visited);
        findWords(board, words, prefix, i, j-1, visited);
        findWords(board, words, prefix, i, j+1, visited);

        visited[i][j] = false;
    }

    public boolean isWord(String dictionary[], String word){
        for(int i=0; i< dictionary.length; i++){
            if(dictionary[i].equals(word))
                return true;
        }
        return false;
    }
}

 */