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

import java.net.Inet4Address;
import java.net.InetAddress;

public class InterfaceAddress {
    private InetAddress address = null;
    private Inet4Address broadcast = null;
    private short maskLength = 0;

    public InterfaceAddress() {
    }

    public InterfaceAddress(InetAddress address, Inet4Address broadcast, short maskLength) {
        this.address = address;
        this.broadcast = broadcast;
        this.maskLength = maskLength;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public Inet4Address getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Inet4Address broadcast) {
        this.broadcast = broadcast;
    }

    public short getMaskLength() {
        return maskLength;
    }

    public void setMaskLength(short maskLength) {
        this.maskLength = maskLength;
    }
}
