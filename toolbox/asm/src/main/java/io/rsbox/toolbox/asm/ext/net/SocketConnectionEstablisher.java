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

package io.rsbox.toolbox.asm.ext.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public interface SocketConnectionEstablisher {

    /**
     * Connect the provided socket to {@param target} by calling {@link JSocket#setInput(InputStream)} and {@link JSocket#setOutput(OutputStream)}
     * If the implementation cannot connect to the specified target, it should simply return
     */
    void connect(JSocket socket, InetSocketAddress target);
}
