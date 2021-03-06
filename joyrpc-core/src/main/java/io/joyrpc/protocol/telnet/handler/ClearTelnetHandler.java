package io.joyrpc.protocol.telnet.handler;

/*-
 * #%L
 * joyrpc
 * %%
 * Copyright (C) 2019 joyrpc.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import io.joyrpc.transport.channel.Channel;
import io.joyrpc.transport.telnet.TelnetEscape;
import io.joyrpc.transport.telnet.TelnetHandler;
import io.joyrpc.transport.telnet.TelnetResponse;

/**
 * 清屏
 *
 * @date: 2019/1/22
 */
public class ClearTelnetHandler implements TelnetHandler {

    @Override
    public String type() {
        return "clear";
    }

    @Override
    public String help() {
        return "Usage:\tclear" + LINE + "Clear the screen. ";
    }

    @Override
    public String description() {
        return "Clear the screen.";
    }

    @Override
    public boolean newLine() {
        return false;
    }

    @Override
    public TelnetResponse telnet(final Channel channel, final String[] args) {
        return new TelnetResponse(TelnetEscape.clear());
    }
}
