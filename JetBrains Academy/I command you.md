# I command you

# 配列
- intArrayOfやcharArrayOfでも宣言できる
- あまり違いがわからない
  **メモ：ArrayとListの違い**
- arrayは変更可能・Listは変更不可
- Listでは生成時にジェネリクスが使えるがArrayは使えない

- <型名>ArrayOfの他にarrayOf<型>でも宣言できる
- 空の配列も宣言可能
```kotlin
val charList = charArrayOf('a', 'b')
// Stringは必ずしも宣言する必要はない
val stringArray = arrayOf<String>("array")
// から配列の場合型の宣言が必須
val newEmptyArray = emptyArray<String>()
```
- 2つの配列が等しいかどうかはイコールではなく専用の関数(contentEquals)を使う
- 配列の変更は値がval, varどちらであってもできる
  - 変更が生じる場合はListを使えってこと？
- 配列の要素追加に関してはvarは通常通りできるがvalの場合は変更できない

# 実行
- jarで実行
```shell
java -jar ファイル名.jar
```