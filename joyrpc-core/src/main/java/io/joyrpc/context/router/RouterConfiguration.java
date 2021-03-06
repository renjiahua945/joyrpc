package io.joyrpc.context.router;

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

import io.joyrpc.cluster.Shard;
import io.joyrpc.context.AbstractInterfaceConfiguration;
import io.joyrpc.protocol.message.Invocation;
import io.joyrpc.protocol.message.RequestMessage;

import java.util.function.BiPredicate;

/**
 * 方法条件路由配置信息
 */
public class RouterConfiguration extends AbstractInterfaceConfiguration<String, BiPredicate<Shard, RequestMessage<Invocation>>> {

    /**
     * 结果缓存
     */
    public static final RouterConfiguration ROUTER = new RouterConfiguration();


}
