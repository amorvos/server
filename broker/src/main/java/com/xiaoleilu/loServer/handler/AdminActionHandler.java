/*
 * This file is part of the Wildfire Chat package.
 * (c) Heavyrain2012 <heavyrain.lee@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.xiaoleilu.loServer.handler;

import io.moquette.spi.IMessagesStore;
import io.moquette.spi.ISessionsStore;

/**
 * Action处理单元
 *
 * @author Looly
 */
public class AdminActionHandler extends ActionHandler {

    public AdminActionHandler(IMessagesStore messagesStore, ISessionsStore sessionsStore) {
        super(messagesStore, sessionsStore);
    }

    @Override
    boolean isValidPath(String path) {
        return path.startsWith("/admin");
    }
}
