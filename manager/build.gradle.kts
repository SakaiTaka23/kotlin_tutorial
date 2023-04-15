import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.qqviaja.gradle.MybatisGenerator") version "2.5"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.book"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
    implementation("mysql:mysql-connector-java:8.0.28")
    mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")

    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.springframework.session:spring-session-data-redis")
    implementation("redis.clients:jedis")

    implementation("org.springframework.boot:spring-boot-starter-aop")

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.1")
    testImplementation("org.assertj:assertj-core:3.19.0")
    testImplementation("org.mockito:mockito-core:3.8.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

mybatisGenerator {
    verbose = true
    configFile = "$projectDir/src/main/resources/generatorConfig.xml"
}

detekt {
    source = files(".")
    autoCorrect = true
    buildUponDefaultConfig = true
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    exclude("**/infrastructure/database/mapper/**")
    exclude("**/infrastructure/database/record/**")
    include("**/infrastructure/database/mapper/BookWithRentalMapperExtentions.kt")
    include("**/infrastructure/database/record/BookWithRentalRecord.kt")
}
