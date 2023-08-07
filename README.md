# <center> Trie Data Structure </center>
Trie algoritması ilk olarak 1960 yılında Edward Fredkin, Axel Thue tarafından geliştirilen ve Tree yapısından esinlenerek sözcüklerin char karakterlerine ayırarak aramaları daha erişebilir ve dinamik bir hale getirme mantığıdır.

![alt text](./img/trie-data-structure.png "Title")

Resimde bir Trie Data Structer Ağaç yapısal bütününü görmekteyiz fark edildiği üzere normal bir Tree Algoritmasınında bir nodun en fazla 2 tabanlı bir node yapısı söz konusu iken Trie Data Structer yapısında n tabalı gerçekleştirlmektedir.
 
Yani diğer yapılarda $\log$<sub>2</sub> Tabanında iken Trie Yapısında $\log$<sub>n</sub> tabanlıdır.

Trie algoritması çok sık kullanılmaması ile birlikte. Büyük optimizasyon gerekmektedir. 

Optimizasyonu daha iyi yapılabilmesi açısından Array kullanılmalıdır. Kümeleme yapıları random id verilerek yerleştirildiği için Trie Data Structer yapısı optimizasyonu zorlaşacaktır.

#<center> Trie Data Structure Mantığı</center>

![alt text](./img/Trie%20Algorithm.png "Title")

Yukarıdaki yapıda abc stringini nodelara ayrılarak Tree yapısına nasıl işlendiğini adım adım anlatmaya çalışacağım.

her bir kutucuktaki char karakterinin altında F ve T işareti görebilirsiniz burada **false** ve **true** değerlerini belirtmektedir. bunu kullanmamızın sebebi Tree yapısındaki dallanmaların burada bittiğini göstermektedir.

Kullanıcı bir abc keliesini girdiğinde ilk olarak en üst root yapısından başlayarak dallara ayrılır. 

a char karakteri varmı ? birsonraki noda geçerek b char karakterini kontrol eder ve bir sonraki nodaa bakarak  ilgili yapıyı bitirir. Eğer root yapısında ilgili ilk karakteri bulamaz ise sözlükte yer alan karakteri bulamaz ve programı sonlandırır.

Olası tahmin kelimelerimizi de yine aynı şekilde kullanıcı ab olarak girdiğini varsayalım bu durumda ilgi a ve b nodlarına giderek bir sonraki nodların true yapısnı görene kadar tarama işlemini gerçekleştirir ve bizim belirttiğimiz ArrayListlere ekler böylece olası kelimelerimizide görmüş oluruz.
