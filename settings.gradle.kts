rootProject.name = "micronaut-ddd-example"

files("common").forEach { dir ->
    dir?.listFiles()?.forEach {
        if (it.isDirectory) {
            include(it.name)
            project(":${it.name}").projectDir = it
        }
    }
}