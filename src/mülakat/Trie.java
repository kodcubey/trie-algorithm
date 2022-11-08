package mülakat;

// kuyllandığım utiller.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Trie {
    static final int NUM_OF_CHARS = 128; // 128 bitlik || kelimelik yer açtım.
	
    
    static class TrieNode { // türetilmiş Trie düğüm classı başlangıcı
            char data;
            TrieNode[] children = new TrieNode[NUM_OF_CHARS]; 
            boolean isEnd = false;

            TrieNode(char c) { // yapıcı method başlangıcı
                    data = c;
            } // yapıcı method bitimi
            
    } // türetilmiş Trie düğüm classı sonu
    TrieNode root = new TrieNode(' ') ; // root adında yeni bir sınıf oluşturuldu

    
    void insert(String word) {// insert methodunun  başlangıcı
        TrieNode node = root;
        
        for (char ch: word.toCharArray()) { // inputtan gelen veriyi parçalıyoruz. ve her bir cahar karakteri için işlem yapıyoruz
            if (node.children[ch] == null) { // eğer düğümün en üst parentında 
                node.children[ch] = new TrieNode(ch); // tüm string yapısını parçalayarak Tree yapımıza aktrıyoruz.
            }
            
            node = node.children[ch]; // Eklelen Tree yapısını noda aktarıyoruz.
        }
        
        node.isEnd = true; // artk son node'da true diyerek Tree yapısını tamamlıyoruz. 
    } // insert methodunun  sonu
	
    // girilen kelimenin alt childları var ise tüm nodları gezip ekrana basıyoruz. bunun için list yapısı kullandım.
    List<String> autocomplete(String prefix) { // autocomplate methodunun başlangıcı.
        TrieNode node = root;
        List<String> res = new ArrayList<String>(); // önerilen kelimeler için yeni list objesi oluşturduk.
        for (char ch: prefix.toCharArray()) { // her bir tree yapısını geziyoruz.
            node = node.children[ch]; // eğer node yapımızda var ise node a aktrayıyoruz.
            if (node == null) { // eğer son node gelindi ise 
                return new ArrayList<String>(); // önerilen kelime listemizi return ediyoruz.
            }
        }
        
        helper(node, res,  prefix.substring(0, prefix.length()-1)); // list yapımızı helper yapımıza gönderip kontrolümüzü sağlıyoruz.
        return res; // ve listemizi geri gönderip print ediyoruz.
    } // autocomplate methodunun sonu.
    
    void helper(TrieNode node, List<String> res, String prefix) {
        // düğümde herhangi bir kelime yoksa kontrolü
        if (node == null ) { 
           return;
        }
        
        // düğmün sonuna gelinmiş ise Listemize kelimemizi ekliyoruz.
        if (node.isEnd) {
            res.add(prefix + node.data);
        }
        
        // helper fonksiyonumuzu birsonraki önerilen kelimeyi bulmak için yeniliyoruz.
        // işlem null olana kadar. listeye ekleme işlemini gerçekleştiriyoruz.
        for (TrieNode child: node.children) {
            helper(child, res, prefix + node.data);
        }
    }
}
