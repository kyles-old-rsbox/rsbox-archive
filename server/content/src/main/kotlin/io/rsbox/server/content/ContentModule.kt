/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.rsbox.server.content

import io.github.classgraph.ClassGraph
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException
import java.net.URLClassLoader
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class ContentModule(val name: String) {

    private val file = File("data/content/$name.jar")
    internal lateinit var classloader: URLClassLoader
    private val scripts = hashSetOf<ContentScript>()

    @Suppress("UNCHECKED_CAST")
    fun load() {
        if(!file.exists()) throw FileNotFoundException()
        classloader = URLClassLoader(arrayOf(file.toURI().toURL()), ClassLoader.getSystemClassLoader())
        ClassGraph()
            .enableClassInfo()
            .addClassLoader(classloader)
            .acceptPackages("content")
            .scan().use {
                it.getSubclasses(ContentScript::class.qualifiedName).forEach { classInfo ->
                    val cls = classInfo.loadClass().kotlin as KClass<ContentScript>
                    val script = cls.createInstance()
                    scripts.add(script)
                }
            }
        classloader.close()
    }

    fun reload() {
        scripts.clear()
        load()
        Logger.info("Content module: $name has been reloaded.")
    }
}