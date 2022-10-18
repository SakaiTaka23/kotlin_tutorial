# Knowledge is key

# if周り
- 特に癖なく普通
- else if, elseも通常通り
- 特徴としてifを変数に格納することができる
  - この時elseは必須
```kotlin
val max = if (a > b) {
    println("Choose a")
    a
} else {
    println("Choose b")
    b
}
```

# ループ
- 特殊
- repeatを使うことによってループ
  - itを使うことによってループ番号を取得することができる
```kotlin
repeat(3){
    // ループ内容
    println(it)
}
```

# オプジェクト
- プロパティ：そのオブジェクトの中の値
- メンバーファンクション・メソッド：そのオブジェクトに対する関数
- 全ての変数はオブジェクトを指しているよ
  - 変更可能な変数を他の変数に入れ他時その他の変数を編集すると元の変数も変更されてしまうよ

# オブジェクト比較
- 同じオブジェクトを指しているかを判断するためにイコール3つで比較することができる(tsと一緒)

# 範囲
- 通常の比較(kotlin上でも文法的には間違っていない)
```kotlin
val within = a <= c && c <= b
```
- inを使うことによって効率よく書くことができる
```kotlin
val within = c in a..b
```

# 配列
- 複数の宣言方法がある 
mutable list of
```kotlin
val mutableList = mutableListOf(1,2,3,4)
```
mutable list
```kotlin
// 初期値0
val list = MutableList(5) { 0 }
```
- 配列操作の関数は結構充実してそう

# forループ
- inで取り出していく系
```kotlin
for (i in list){
    println(i)
}
```
- downToやuntilを使うと下限・上限を決めることができる
- stepで間隔を変えることもできる
- ループ対象の後にindicesをつけることによってインデックスごとに取得することもできる

