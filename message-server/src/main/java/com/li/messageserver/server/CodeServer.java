package com.li.messageserver.server;

import java.util.Map;

/**
 * @author lihaodong
 */
public interface CodeServer {


    Map<String, Object> registerCode(String phone);
}
