# Collections Operations
- collectionに対していくつかの操作をすることができる
- 最初にtransformationをみていく

# Mapping
- collectionに対して実行できる操作のtransformationの一つ
- 基本的にラムダ関数をもとに実行される
- collection.mapで実行
- 関数の中でifを入れるなど中でコードを実行することができる
    - mapに対して実行する場合キーとバリュー両方に対して影響を与えることができる

# Zipping and Association
## Zipping
- 2つのコレクションで同じポジションのものを結合する
- 配列内にリストを作って返される
- mapに対してunzip関数を使うことによってキーバリューを分けることもできる
## Association
- コレクション同志を関連付けてマップを作ることができる

# Flatten
- 2次元配列を一次元にする
- flatten関数を利用

# String Representation
- 配列の出力を任意の区切りで作成したり文字と結合したりできる

# Filtering
- コレクション操作の中で最も使われている操作の一つ
- 与えられたコレクションに対してラムダ関数を実行して当てはまるかどうかに応じてboolを返す
- 当てはまるもののみを取得するような動作を実装できる
