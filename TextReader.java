import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class TextReader {
    private String path;

    private static Logger logger = Logger.getLogger(TextReader.class.getName());

    //列挙方に修正
    //リテラル（文字列）だと実行エラーになるため避ける　変数使った方がいい、もし間違えてもコンパイルエラーになるだけ
    private enum a { START, END };

    private TextReader(String path) {
        this.path = path;
    }
    //arrayListの中は総称型使うように　クラスの定義宣言を厳格にした方が安全だが、ジェネリクス使って少し緩くできる、型を省略できた方が良い　
    private void execute() {
        List<Integer> valueList = new ObjectList<>();
        //object.java作っておけばint入れるものもstring入れるものも汎用性が高いよ　複数のいろんな場合のメソッドを使えるようになった

        // FileReader fr = null;
        // BufferedReader br = null;
        //try　catchでトライの中でエラー起きたらキャッチ　faianlly（例外があっても例がなくてもやってね文）はリソース付きTRY文使って省略できる fr,br,インターネットにコネクトするものをリソースという
    
        try(FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
            // fr = new FileReader(path);//ファイル読み込み用のストリームを作成して　ストリームを渡して　ちまちま全部読む
            // br = new BufferedReader(fr);//上で作ったものをbuffer付きの読み込みストリームを作る　buffer＝ボコっとファイルから読み込む
            String line;
            while ((line = br.readLine()) != null) {
                //３１で文字列を整数に変換するのをオートボクシングにしたら楽だよ
                //valueList.add(new Integer(line));古い書き方で推奨されてない　警告でたが実行上問題なし
                valueList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        // } finally {
            //if (br != null) {
                //try {
                    //br.close();
                //} catch (IOException e) {
                //}
            //}
            //if (fr != null) {
                //try {
                    //fr.close();
                //} catch (IOException e) {
                //}
            //}
        }
        //拡張for使える　配列の中　valueは要素数とってきているvalueList.size();　箱の中に整数がいくつか入っていて　iの増やし方、i番目表示してね
        //LISTの中入ってる分、箱ある分ループしなくていい省略できる　PHPのforeach構文取り入れたのも　eachはjavaで書かないよ　イテレーターやカウンターのカウントアップを使わない分処理が早くなる
        //int size = valueList.size();
        //for (int i = 0; i < size; i++) {
        for (Integer value : valueList) {
            System.out.println(value);
        //}
            //System.out.println(valueList.get(i));
        }
    }
    //可変長引数　２、３個わからない時に引数の数わからない時に使える main(String[] args) {可変長引数にする、enum
    public static void main(String... args) {
        logger.info(a.START.name());//enum作ったもの　文字列の方がデータ重い　定数を作っておいて検索しやすくするのがenum　１が検討中、２が確認中、３確認済み　２’に差し戻しも追加できる
        new TextReader(args[0]).execute();
        logger.info(a.END.name());
    }
    ////松田睦_メンター  20:55 文字列の、置換文字を変換するメソッドhttps://techacademy.jp/magazine/19033
    //public static void main(String[] args) {　
        //logger.info(a.START.getName()); 
        //new TextReader(args[0]).execute();
        //logger.info(END);
    //}

}