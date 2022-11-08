package mülakat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mülakat {
    public static void main(String[] args) {
        try {
          Trie node = new Trie(); // Trie classını çağırıyoruz.
          File myObj = new File("C:\\Users\\SAMET\\Desktop\\Mülakat\\src\\mülakat\\sozluk.txt"); // sozluk path.
          Scanner myReader = new Scanner(myObj); // scanner callası.
          System.out.println("Sözlük Yükleniyor. Lütfen Bekleyin...");
          
          // eğer txt yapısında alt satıra geçilmiş ise son satıra kadar işlemi tektar et.
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine(); // datayı oku
            node.insert(data); // noda kaydet
          }
          
          myReader.close(); // okumayı kapat.
          System.out.println("Sözlük Yüklendi.");
          
          // kullanıcıdan sürekli olarak alınması gereken yapı.
          while(true) {
              // kullanıcıdan bilgi alma.
              Scanner scn = new Scanner(System.in); // scanner classı.
              System.out.println("Bir Kelime Yazıp Enter Tuşuna Basınız");
              String word = scn.next(); // kullanıcıdan veri girişi sağlama.
              
              // olası kelimeleri ekrana basıyoruz.
              System.out.println("Olası Kelimeler");
              for (String recom: node.autocomplete(word) ) {
                  System.out.println(recom); // önerilen kelimeleri listeleme.
              }
          }

        } catch (FileNotFoundException e) { 
          // eğer dosya başarılı birşekilde sözlük yüklenmedi ise ilgli hata metnini ekrana basıyoruz.
          System.out.println("Dosya okunamadı lütfen dosya pathinizi kontrol edin.");
          e.printStackTrace();
        }
    }
}
