/*
 * Copyright (c) 2017 Peter Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright (c) 2017 Peter Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.intellij.tasks.PublishTask

plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.intellij") version "0.4.21"
}
group = "cn.bestwu"
version = "0.1.5"

val ideaVersion = property("ideaVersion")

intellij {
    updateSinceUntilBuild = false
//    downloadSources = false
    version = ideaVersion as String
    setPlugins("java","Groovy", "gradle", "Kotlin", "maven", "properties", "junit")
}

tasks.withType(PublishTask::class.java) {
    username(project.findProperty("intellij.publish.username"))
    password(project.findProperty("intellij.publish.password"))
    channels("stable")
}

repositories {
    jcenter()
}

dependencies {
//    compileOnly("com.intellij:openapi:7.0.3")
    implementation("org.jsoup:jsoup:1.13.1")

}

