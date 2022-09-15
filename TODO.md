# やること
- book1, book2 はやめたい
- sameTitle, sameAuthorで分けておいたほうが変更しやすそう
- propertyもなく,staticメソッドにしても変わらないのでどうにかしたい。
- 追加先のbooksはせめてインスタンス変数にしたい。引数で受け取るたびに、booksが、toBeAddedがそれぞれすでに重複のある内容だったら...?


## 考えていることずらずらMemo
- Bookクラスがあり、一度出版されてから著者タイトルが変わることはまず無いと考えて値オブジェクトとして扱う。
- その上で、蔵書管理システムと考えるなら以下

- List<Book>が複数出てくる↓ので、```class Books```を定義してファーストクラスコレクションとしてそれぞれで自分の中で重複がないことは担保したい。
  - マージされる側：books
  - マージする側：toBeAdded
- 重複排除すること前提だし、コンストラクタから重複排除メソッドを呼んで、返されるリストに重複がないことは担保したい。

- リストのマージ自体はサービスで切り出すべきか。重複無く足すのが目的？なのでドメインサービスくらいに捉えて。
- BooksApp.めーじ(Books 追加先, Books 追加するやつ)とか

- タイトルと著者逆に入れられるので、登録ミスから同じ本の登録の流れが出来てしまう
- class Author は作ってもいい? ✗ テストは残すみたいだから、動かなくなるし止め よって以下ボツ案









```java
// ts風味でこんなのが有るとして
class  Author {
    // 以下プロパティ
    id: number,
    name: string
}

class Book {

    private final String title;
    private final String author;

    public Book (String: title, Author: author) {
        this.init(title, author); // なんかしら処理があるならコンストラクタはinit呼ぶ1行にするのは趣味
    }

    private void init(String: title, Author: author) {
        this.setTitle(title);
        this.setAuthor(author)
    }

    private void setTitle(String: title) {
        // 要件外だから触れないけどバリデーションとかするならここだよね
        this.title = title;
    }

    private void setAuthor(String: author) {
        this.author = author.name;
    }
}

class Books {
    private final List<Book> books;

    // 追加したい1冊はこっちで初期化される
    public Books(Book book) {
        this.books = List.of(book);
    }

    // DB(想定)から取ってきた登録済みのリストはこっちで初期化される
    public Books(List<Book> books) {
        this.init(List<Books>);
    }

    private void init(List<Books> books) {
        this.重複弾くメソッド(books);
    }

    public void 重複弾くメソッド(List<Books> books) {
        /**
         * 引数のbooksから重複弾く処理して
         */

        this.books = books;
    }

    /**
     * 必要になったら sort(String key, Int order)とかのメソッド生やせばきれいかな？
     */
}

class BooksService {
    // 名前はJavaのList結合メソッド名に倣う
    public Books merge(Books 追加先, Books 追加する方) {
        // TSのArray.merge()的なことをして受け取ったものを結合する式 addAll()がそんな気がする
        Books 出来上がったやつ = new Books(結合したけど重複が有るかもしれないBooks);

        return 出来上がったやつ;
    }
}
```

candidate:
候補者
https://howtodoinjava.com/java8/java-stream-distinct-examples/
