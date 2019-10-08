package net.xmeter;

import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.security.SecureRandom;
import java.util.UUID;

public class Util implements Constants {

    private static SecureRandom random = new SecureRandom();
    private static char[] seeds = "abcdefghijklmnopqrstuvwxmy0123456789".toCharArray();
    private transient static Logger logger = LoggingManager.getLoggerForClass();

    public static String generateClientId(String prefix) {
        int leng = prefix.length();
        int postLeng = MAX_CLIENT_ID_LENGTH - leng;
        UUID uuid = UUID.randomUUID();
        String string = uuid.toString().replace("-", "");
        String post = string.substring(0, postLeng);
        return prefix + post;
    }

    public static String generatePayload(int size) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < size; i++) {
            res.append(seeds[random.nextInt(seeds.length - 1)]);
        }
        return res.toString();
    }

}
