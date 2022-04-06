import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class Lambda {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	public static void main(String[] args) {
		IntStream stream = IntStream.range(1, 10000);
        stream.forEach(s -> System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(LocalDateTime.now())+" "+s));
    //forEachの引数　①変数sを使おう ②アロ-のー>これを書こう ③15行目のformat現在時刻を出力するもの　＋（連結する）半角スペースと1 から 9999 の連番1<=s>1万までの値９行目に定義
    }

	//private static String currentTime() { ⇦ラムダ式にしたので１４行目からは要らない
		//return FORMATTER.format(LocalDateTime.now());
	//} 　書く量少なく省略できるとバグの確率減る　シンプルなプログラムが書ける　
    //数値から文字列に変換したい
}
