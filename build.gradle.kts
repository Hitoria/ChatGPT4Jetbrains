plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.12.0"
}

group = "com.liuyan2022"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
// From GPT-4 but not used. If cancel the comment, maybe the build will fail.
//dependencies {
//    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
//    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
//}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.1.4")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
        options.encoding = "UTF-8"
    }

    patchPluginXml {
        sinceBuild.set("221")
        untilBuild.set("231.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

// From GPT-4 but not used. If cancel the comment, maybe the build will fail.
//test {
//    useJUnitPlatform()
//}z
