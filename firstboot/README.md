# First boot

## 依存関係
- Spring Web → Webアプリケーション・REST APIを書くためのパッケージ
- Spring Boot DevTools → アプリケーション再起の高速化やホットリロードを提供
デフォルトで入るパッケージについて
- spring-boo-starter-* から始まるものは公式のスターター
  - 一覧 [Spring Boot での開発 - リファレンスドキュメント](https://spring.pleiades.io/spring-boot/docs/current/reference/html/using.html#using.build-systems.starters)
- JPA → Java Persistence API の略で永続化周りのものを定義している

## ホットリロード
- ビルドボタンを押すとビルドされた上で自動的にサーバーも更新される

## Controller
- Controllerにはアノテーション`RestController`を付ける
  - そのほかにもリポジトリやサービス用がある
- アノテーション`RequestMapping`を付けるとそのクラス内のルートは指定されたルートから始まる
- それぞれのメソッド+Mappingでルートを作成していく
  - ルートを`/`にするとトレイリングスラッシュも必須になる
  - 必要ない場合は空白の文字列にする

## Configuration
- 設定はresources/application.propertiesに配置
  - 一覧 https://spring.pleiades.io/spring-boot/docs/current/reference/html/application-properties.html
- 独自のプロパティ設定もできる
  - プロパティを独自に記述
  - `value`アノテーションを使って取得できる
- 開発時と本番時でログレベルやDBの接続先などを変えたい時がある
  - 環境に応じたプロパティを記述
- プロパティファイルの名前は`application-環境.properties`とする
  - そこに記述されていないがデフォルトのプロパティファイル(application.properties)にある場合はそれが適用される
  - ある場合は上書きされる
- プロパティファイルを有効にするにはビルドの実行構成を変更する
- yamlを使って定義することもできる
  - 一つのファイルに複数の構成を記述することができるようになる

## Logging
### 概要
- 現状でログに使えるライブラリー
1. Logback SpringBootのデフォルトロガー パフォーマンスを気にする時以外はこれで十分
2. Log4j2 Logbackの問題を解決 パフォーマンスはより良い SpringBootで使うには多少設定が必要
3. java.util.Logging SpringBootでは非推奨

- Logging interfaceライブラリー
1. SLF4J 基本これで問題ない
2. Log4j2をそのまま使う 機能が増える代わりに他のロガーへの切り替えコストが高くなる
3. Apache commons logging クラス周りで問題がある

デフォルト構成はLogback * SLF4J

### 使い方
- loggerfactory.getloggerによりログのインスタンスを取得
  - この時必要な引数はクラス名にしておく`this::class.java`
- ログレベル
  1. trace
  2. debug
  3. info
  4. warn
  5. error
- デフォルトのログレベルはinfo
  - 設定は`logging.level.root`で変えることができる
  - このroot部は変更することによって自分のアプリケーションにのみと言ったこともできる
- もちろんログに対して引数を与えることもできる
