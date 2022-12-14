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
