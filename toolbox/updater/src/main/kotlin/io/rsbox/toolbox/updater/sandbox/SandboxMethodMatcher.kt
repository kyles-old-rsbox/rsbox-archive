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

package io.rsbox.toolbox.updater.sandbox

import io.rsbox.toolbox.updater.NodeMappings
import io.rsbox.toolbox.updater.util.ConsoleProgressBar
import org.objectweb.asm.tree.MethodNode

class SandboxMethodMatcher {

    fun match(toMethod: MethodNode, fromMethods: Collection<MethodNode>): NodeMappings? {
        var highest: NodeMappings? = null
        var multiple = false

        fromMethods.forEach { fromMethod ->
            val mapping = Execution.match(fromMethod, toMethod)

            if(highest == null || mapping.score > highest!!.score) {
                highest = mapping
                multiple = false
            } else if(mapping.score == highest!!.score) {
                multiple = true
            }

            ConsoleProgressBar.step()
        }

        return if(multiple) null else highest
    }

}