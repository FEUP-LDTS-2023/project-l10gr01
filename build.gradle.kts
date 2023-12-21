plugins {
    id("java")
    id("info.solidsoft.pitest") version "1.15.0"
}

group = "com.ldts.steven.*"
version = "1.0-SNAPSHOT"
pitest {
    junit5PluginVersion = "1.1.2x"
    verbose = true
}
repositories {
    mavenCentral()
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.googlecode.lanterna", "lanterna", "3.1.1")
    testImplementation("org.mockito:mockito-core:3.12.4")
}

tasks.test {
    useJUnitPlatform()
}