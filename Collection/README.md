# Collection

# Collectionとは
- 配列に似ている
- 種類
  1. list
  2. set
  3. map

## List
- 同じ名前の要素を入れることもできる
- listOfで作成した配列は型が必須で変更不可
- mutableListOfの場合型は必要ない・変更可能
  - add, removeなどを使用

## Set
- 同じ名前の要素は入れることができるが表示はされない(エラーは出ない)
- 作成はListと似ている`setOf, mutableSetOf`
- オブジェクトの場合は重複していても二重で保存できる
  - 内部でイコール2つで比較している
  - dataクラスとして取り扱うことで解決(equalsを自動生成)

## Map
- キーバリューで値を保存
- 作成はListと似ている
- 
