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
  - 
