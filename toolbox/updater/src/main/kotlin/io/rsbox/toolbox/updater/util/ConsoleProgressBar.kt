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

package io.rsbox.toolbox.updater.util

import me.tongfei.progressbar.ProgressBar
import me.tongfei.progressbar.ProgressBarBuilder
import me.tongfei.progressbar.ProgressBarStyle
import me.tongfei.progressbar.TerminalUtils
import java.time.Duration
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.*

object ConsoleProgressBar {

    private lateinit var progressBar: ProgressBar

    fun start(taskName: String, unitName: String, initialMax: Long) {
        progressBar = ProgressBarBuilder()
            .setTaskName(taskName)
            .setInitialMax(initialMax)
            .setSpeedUnit(ChronoUnit.SECONDS)
            .setStyle(ProgressBarStyle.COLORFUL_UNICODE_BAR)
            .showSpeed()
            .setMaxRenderedLength(175)
            .setUpdateIntervalMillis(1)
            .build()
    }

    fun stop() {
        progressBar.close()
    }

    fun step() {
        progressBar.step()
    }

    fun stepTo(value: Long) {
        progressBar.stepTo(value)
    }
}