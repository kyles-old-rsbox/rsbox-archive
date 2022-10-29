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

class TestClass
{
    private static int dummy(Object... args)
    {
        return 0;
    }

    private int field1051 = -1611704481;
    private int field2701;
    private int field2138, field2130;

    public int test()
    {
        TestClass tc = new TestClass(); // to trick executor to call the constructor
        int var = 42;

        if (-1 != this.field1051 * 1928543073)
        {
            dummy(this.field1051 * 1928543073);
            this.field1051 = dummy() * 1611704481;
        }

        if (field2701 * 1550405721 > 30000)
        {
            field2701 += -1868498967 * var;
        }

        field2138 = tc.dummy() * 1510226873;
        field2130 = 572701809 * tc.field2138;
        if (-1722291303 * field2130 >= var)
        {
            var = field2130 * -1722291303;
        }

        return var;
    }
}

