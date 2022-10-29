# OOP

# クラス定義
コンストラクタを作成せずにクラスの関数宣言時にvarやvalをつけることによってその値をプロパティとして定義することができる
コンストラクタは2種類存在する
- Primary Constructor → 与えられた値を元に初期化する
- Secondary Constructor → 与えられなかった値に対して初期化する？

## Primary Constructor
- クラス定義時に引数として入れるものもPrimary Constructor?
initializer blocks→コンストラクタのようなもの？初期化時に1行以上実行することができるようになる
- init関数を使ってその中で初期化していく

クラスの中で要素にアクセするには"this"を使用する
- printの中でアクセスする時は従来通り"$"でアクセス

## Secondary Constructor
constructor関数を使って初期化
引数としてどの値を取るかによってどのように初期化するかを決定することができる
複数定義可能
役割としてはPrimary Constructorを受け取って初期化する
