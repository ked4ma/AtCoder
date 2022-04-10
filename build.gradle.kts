import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("jvm") version "1.3.72"
    application
}

group = "com.github.ked4ma.atcoder"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    if (hasProperty("contest")) {
        getByName("main").java.setSrcDirs(
            setOf(
                "src/main/java/com/github/ked4ma/atcoder/${findProperty("contest")}",
                "src/main/java/com/github/ked4ma/atcoder/utils/"
            )
        )
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.4")
    testImplementation("io.ktor:ktor-client-core:1.3.1")
    testImplementation("io.ktor:ktor-client-cio:1.3.1")
    testImplementation("org.jsoup:jsoup:1.14.3")
}


tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.FAILED, TestLogEvent.PASSED)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = true
        showStackTraces = true
        showExceptions = true
    }

    systemProperty("task", System.getProperty("task"))
}

application {
    mainClass.set(
        project.properties.getOrDefault(
            "mainClass",
            "com.github.ked4ma.atcoder.template.simple.SampleKt"
        ) as String
    )
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = project.properties.getOrDefault(
            "mainClass",
            "com.github.ked4ma.atcoder.template.simple.SampleKt"
        )
    }

    // To add all of the dependencies otherwise a "NoClassDefFoundError" error
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

val run: JavaExec by tasks
run.standardInput = System.`in`

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}
