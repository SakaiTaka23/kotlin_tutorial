# O/Rマッパーを使用してデータベースへ接続する

## ORM
- MyBatis, JPAあたりがメジャー

## 導入
- mybatis, mysql-connector-javaがmybatis, mysqlを繋げるライブラリ
- dynamic-sql, mybatis-generator-coreがコード生成を行うもの

- `com.arenagod.gradle.MybatisGenerator`は`com.qqviaja.gradle.MybatisGenerator`に修正
- 設定ファイル`generatorConfig.xml`を作成
- gradleのコマンド`mbGenerator`を実行するとファイルが生成される

ファイル生成は`MybatisGenerator`の機能で`Mybatis`の機能ではない
実行すると各テーブルを表したモデルやマッパーが生成される
enum型は文字列として認識されてしまうのでカラムのオーバーライドを行うことによって書き換えるようにする

## 生成されるファイル
全てテーブル名が先に付いている
- Record → テーブルを表したモデル
- DynamicSqlSupport → Mapperを使用するクエリのカラム指定のパラメーターが記述されている
- Mapper → 基本的なクエリ発行の関数が定義されたインターフェース
- MapperExtensions → Mapperの関数の定義

## アプリケーション設定
- 設定はapplication.propertiesで行うことができるが最近はymlを使うことが多いので`application.yml`という名前に変更して記述する
