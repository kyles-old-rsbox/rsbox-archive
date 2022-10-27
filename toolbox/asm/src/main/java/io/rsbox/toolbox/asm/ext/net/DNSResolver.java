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

import java.net.InetAddress;
import java.util.List;

/**
 * Represents a DNS resolver
 */
public interface DNSResolver {
    /**
     * Resolve the given {@param host} into one or more {@link InetAddress}. The resolved InetAddress-es should be
     * added into the {@param result} list
     *
     * @return true to continue resolving with remaining resolvers, or false to continue resolving
     */
    boolean resolve(String host, List<InetAddress> result);
}
