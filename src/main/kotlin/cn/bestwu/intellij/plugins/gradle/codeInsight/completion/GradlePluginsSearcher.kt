package cn.bestwu.intellij.plugins.gradle.codeInsight.completion

import org.jsoup.Jsoup

class GradlePluginsSearcher {
    companion object {
        private val pluginsCaches = HashMap<String, List<String>>()
        private val pluginVersionsCaches = HashMap<String, List<String>>()
    }

    fun searchPlugins(text: String): List<String> {
        var result = pluginsCaches[text]
        if (result != null) {
            return result
        }
        val elements = Jsoup.connect("https://plugins.gradle.org/search?term=${text.trim()}").get().select("#search-results tbody tr")
        result = elements.map { it.select(".plugin-id a").text() }
        pluginsCaches.put(text, result)
        return result
    }

    fun searchPluginVersions(text: String): List<String> {
        var result = pluginVersionsCaches[text]
        if (result == null) {
            result = ArrayList<String>()
        } else {
            return result
        }
        val plugin = Jsoup.connect("https://plugins.gradle.org/plugin/${text.trim()}").get()
        result.add(plugin.select(".version-info h3").text().replace("^Version (.*) \\(latest\\)$".toRegex(), "$1"))
        val elements = plugin.select(".other-versions li")
        elements.mapTo(result) { it.select("a").text() }
        pluginVersionsCaches.put(text, result)
        return result
    }

}

