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
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * Resolves hosts using the system's DNS resolver
 */
public class SystemDNSResolver implements DNSResolver {
    @Override
    public boolean resolve(String host, List<InetAddress> result) {
        try {
            InetAddress[] resolved = InetAddress.getAllByName(host);
            result.addAll(Arrays.asList(resolved));
        } catch (UnknownHostException e) {
        }
        return true;
    }
}
