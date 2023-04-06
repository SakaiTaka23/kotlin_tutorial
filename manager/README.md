# O/Rマッパーを使用してデータベースへ接続する

## ORM
- MyBatis, JPAあたりがメジャー

## 導入
- mybatis, mysql-connector-javaがmybatis, mysqlを繋げるライブラリ
- dynamic-sql, mybatis-generator-coreがコード生成を行うもの

- `com.arenagod.gradle.MybatisGenerator`は`com.qqviaja.gradle.MybatisGenerator`に修正
- 設定ファイル`generatorConfig.xml`を作成
- gradleのコマンド`mbGenerator`を実行するとファイルが生成される
