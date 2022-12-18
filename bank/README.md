# bank

# 初期化

- Intellijのspring boot initializerを使用
- パッケージはgradle x kotlin
- 依存関係
  - Spring Boot DevTools
  - Spring Web
  - Spring Data JPA
  - H2 Database

# Gradle

- build.gradle.ktsの中に入っている
- plugins: 必要なプラグインや設定が記述されている
- dependencies: 依存パッケージ一覧がみられる

# Application File

- 今回の場合BankApplication.kt
- mainがエントリーポイント
- ＠SpringBootApplicationが結構重要
- 自動でクラスを見つけて初期化してくれる？
  - アプリケーションパッケージと同じもしくはそれより下に配置

# Controller

- アプリケーションパッケージにcontrollerフォルダを作成してその中でコントローラーを記述
- クラス内にコントローラーを記述していく
- 入力を受け付けるボディにもアノテーションをつけて型を宣言(nestに似ている)

# Model

- データのみメソッドなしのクラスをモデルとして定義
- 今回はリクエスト時に入ってくる型と表示に使う時の型、DBを触る時の型が異なるので変換用の関数を作成する必要がある
  - extensionという形でモデルの外で関数を実装しても良いが変わりはない気がするのでクラス内で実装
- DB用のモデルに関してビデオではvalueと言うカラム名を使っていたがそれはH2では予約語として使われているためマイグレーションが通らない
  - DB上ではamountと言うカラム名で通す

# Repository

- 依存物の中に入れたH2がインメモリーデータベース
- 今回は簡単なCRUDを作成してみる
- CrudRepositoryを使って入ってくるモデルとプライマリーキーを引数として渡してやるとインターフェースが生成される
- 実装もそのインターフェースがやってくれている

# H2コンソール

- アドミンパネルのようなものを出すことができる
- `resources/application.properties`内で設定を変更して再起動
  - アプリケーション全体の設定を色々変えることができる？
- デフォルトでアプリケーション`/h2-console`でページが確認できる
- アクセスについてDBのURLを変更する必要がある
  - コンソールでDatabase available at 〇〇があるのでそのurlをページに貼り付ける

# Testing

- mock用のライブラリを使用`springmockk`
  - 依存物をインストールするときはdependenciesの中にライブラリを追加する
- テストなのでテストディレクトリにテストをファイルを作って記述
- ファイル名はテスト`対象ファイル名+Test`
