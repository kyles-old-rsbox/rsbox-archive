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

import java.util.List;

public class NetworkInterface {
    private String name;
    private String displayName;
    private List<InterfaceAddress> bindings;

    public NetworkInterface() {

    }

    public NetworkInterface(String name, String displayName, List<InterfaceAddress> bindings) {
        this.name = name;
        this.displayName = displayName;
        this.bindings = bindings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<InterfaceAddress> getBindings() {
        return bindings;
    }

    public void setBindings(List<InterfaceAddress> bindings) {
        this.bindings = bindings;
    }
}
