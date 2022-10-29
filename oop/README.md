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

## デフォルト値
Primary Constructorにてデフォルト値の定義をすることもできる
  - Secondary Constructorでデフォルト値の代入がしたいだけならこれで良いかも
処理がしたいのであればinitializer blocksで良い気がする

## 名前付き引数
インスタンス時に名前指定して引数として渡すこともできる
プライマリーコンストラクターでのみ有効

# Getter and Setters
- 値を取得・変更する時はgetter, setterを使ってね
  - 何もしなくてもドットでアクセスすることによって自動的に呼ばれる
  - setterについてもその値に対して代入するだけで作ることができる
- 値をvalとして定義している場合getterしかできない
- 上書きしたい場合は自分で初期化した上で上書き
